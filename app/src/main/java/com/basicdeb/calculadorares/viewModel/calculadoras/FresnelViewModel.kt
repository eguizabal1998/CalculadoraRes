package com.basicdeb.calculadorares.viewModel.calculadoras

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basicdeb.calculadorares.vo.Resource
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.atan2
import kotlin.math.sqrt
import kotlin.math.tan
import kotlin.math.tanh

class FresnelViewModel : ViewModel() {

    val frec = ObservableField<String>()
    val d1 = ObservableField<String>()
    val d2 = ObservableField<String>()
    val d3 = ObservableField<String>()
    val d4 = ObservableField<String>()
    val d5 = ObservableField<String>()

    var nfresnel = "1"
    var frecU = "Hz"
    var d1U = "m"
    var d2U = "m"
    var d3U = "m"
    var d4U = "m"

    val radio = ObservableField<String>()
    val obstruccion = ObservableField<String>()

    val eventoCalculo: MutableLiveData<Resource<String>> by lazy {
        MutableLiveData<Resource<String>>()
    }

    fun checkCampos() {
        if (frec.get().isNullOrEmpty() || d1.get().isNullOrEmpty() ||
            d2.get().isNullOrEmpty()
        ) {
            eventoCalculo.value = Resource.Failure(Exception("Complete Los campos"))
            radio.set("Faltan Datos")
        } else {
            calculo()
        }
    }

    private fun calculo() {
        val fHz = when (frecU) {
            "Hz" -> {
                frec.get()!!.toDouble()
            }
            "KHz" -> {
                frec.get()!!.toDouble().times(1000)
            }
            "MHz" -> {
                frec.get()!!.toDouble().times(1000000)
            }
            "GHz" -> {
                frec.get()!!.toDouble().times(1000000000)
            }
            "THz" -> {
                frec.get()!!.toDouble().times(1000000000000)
            }
            else -> {
                frec.get()!!.toDouble()
            }
        }

        val d1m = when (d1U) {
            "m" -> {
                d1.get()!!.toDouble()
            }
            "Km" -> {
                d1.get()!!.toDouble().times(1000)
            }
            else -> {
                d1.get()!!.toDouble()
            }
        }

        val d2m = when (d2U) {
            "m" -> {
                d2.get()!!.toDouble()
            }
            "Km" -> {
                d2.get()!!.toDouble().times(1000)
            }
            else -> {
                d2.get()!!.toDouble()
            }
        }

        val longOnd = (300000000).div(fHz)

        val miembro1 = (nfresnel.toDouble()).times(longOnd).times(d1m).times(d2m)
        val miembro2 = (d1m).plus(d2m)

        val df = DecimalFormat("###.###")
        df.roundingMode = RoundingMode.CEILING

        val radioFrs = sqrt(miembro1.div(miembro2))

        val rFresel = df.format(radioFrs)

        if (d3.get().isNullOrEmpty() || d4.get().isNullOrEmpty()) {
            obstruccion.set("Faltan Datos")
        } else {
            val d3m = when (d3U) {
                "m" -> {
                    d3.get()!!.toDouble()
                }
                "Km" -> {
                    d3.get()!!.toDouble().times(1000)
                }
                else -> {
                    d3.get()!!.toDouble()
                }
            }

            val d4m = when (d4U) {
                "m" -> {
                    d4.get()!!.toDouble()
                }
                "Km" -> {
                    d4.get()!!.toDouble().times(1000)
                }
                else -> {
                    d4.get()!!.toDouble()
                }
            }

            val d5m = when (d4U) {
                "m" -> {
                    d5.get()!!.toDouble()
                }
                "Km" -> {
                    d5.get()!!.toDouble().times(1000)
                }
                else -> {
                    d5.get()!!.toDouble()
                }
            }

            var gap = 0.0

            if (d5m == d4m) {
                gap = d4m.minus(d3m)
            } else if (d5m > d4m) {
                val h = d5m.minus(d4m)
                val d = d1m.plus(d2m)
                val alfa = atan2(h, d)
                val h2 = d1m.times(tan(alfa))
                gap = (d4m.plus(h2)).minus(d3m)
            } else if (d5m < d4m) {
                val h = d4m.minus(d5m)
                val d = d1m.plus(d2m)
                val alfa = atan2(h, d)
                val h2 = d2m.times(tan(alfa))
                gap = (d5m.plus(h2)).minus(d3m)
            }

            Log.i("gap", gap.toString())


            val obs: Double
            when {
                gap <= 0 -> {
                    obstruccion.set("100%")
                }
                radioFrs > d4m -> {
                    obs = (100).minus((gap.times(100)).div(radioFrs))
                    obstruccion.set("${df.format(obs)}%")
                }
                radioFrs > gap -> {
                    obs = ((radioFrs.minus(gap)).times(100)).div(radioFrs)
                    obstruccion.set("${df.format(obs)}%")
                }
                else -> {
                    obs = 0.0
                    obstruccion.set("$obs%")
                }
            }
        }


        radio.set("${rFresel}m")


    }
}
