package com.basicdeb.calculadorares.viewModel.calculadoras

import androidx.core.content.res.TypedArrayUtils.getText
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.basicdeb.calculadorares.R
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.pow
import kotlin.math.roundToInt

class InductoresViewModel : ViewModel() {

    val b1: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val b2: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val b3: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }
    val b4: MutableLiveData<Int> by lazy {
        MutableLiveData<Int>()
    }

    val inductanciaS = ObservableField<String>()
    val toleranciaS = ObservableField<String>()

    var multiplicador = 1.0
    var tolerancia = 20

    fun disminuir(banda: Int) {
        when (banda) {
            1 -> {
                if (b1.value == 9) b1.value = 0
                else b1.value = b1.value!!.plus(1)
            }
            2 -> {
                if (b2.value == 9) b2.value = 0
                else b2.value = b2.value!!.plus(1)
            }
            3 -> {
                if (b3.value == 7) b3.value = 1
                else b3.value = b3.value!!.plus(1)
                when (b3.value) {
                    1 -> {
                        multiplicador = 1.0
                    }
                    2 -> {
                        multiplicador = 10.0
                    }
                    3 -> {
                        multiplicador = 100.0
                    }
                    4 -> {
                        multiplicador = 1000.0
                    }
                    5 -> {
                        multiplicador = 10000.0
                    }
                    6 -> {
                        multiplicador = 0.1
                    }
                    7 -> {
                        multiplicador = 0.01
                    }
                }
            }
            4 -> {
                if (b4.value == 7) b4.value = 1
                else b4.value = b4.value!!.plus(1)
                when (b4.value) {
                    1 -> {
                        tolerancia = 20
                    }
                    2 -> {
                        tolerancia = 1
                    }
                    3 -> {
                        tolerancia = 2
                    }
                    4 -> {
                        tolerancia = 3
                    }
                    5 -> {
                        tolerancia = 4
                    }
                    6 -> {
                        tolerancia = 5
                    }
                    7 -> {
                        tolerancia = 10
                    }
                }
            }
        }
        calInduc()
    }

    fun aumentar(banda: Int) {
        when (banda) {
            1 -> {
                if (b1.value == 0) b1.value = 9
                else b1.value = b1.value!!.minus(1)
            }
            2 -> {
                if (b2.value == 0) b2.value = 9
                else b2.value = b2.value!!.minus(1)
            }
            3 -> {
                if (b3.value == 1) b3.value = 7
                else b3.value = b3.value!!.minus(1)
                when (b3.value) {
                    1 -> {
                        multiplicador = 1.0
                    }
                    2 -> {
                        multiplicador = 10.0
                    }
                    3 -> {
                        multiplicador = 100.0
                    }
                    4 -> {
                        multiplicador = 1000.0
                    }
                    5 -> {
                        multiplicador = 10000.0
                    }
                    6 -> {
                        multiplicador = 0.1
                    }
                    7 -> {
                        multiplicador = 0.01
                    }
                }
            }
            4 -> {
                if (b4.value == 1) b4.value = 7
                else b4.value = b4.value!!.minus(1)
                when (b4.value) {
                    1 -> {
                        tolerancia = 20
                    }
                    2 -> {
                        tolerancia = 1
                    }
                    3 -> {
                        tolerancia = 2
                    }
                    4 -> {
                        tolerancia = 3
                    }
                    5 -> {
                        tolerancia = 4
                    }
                    6 -> {
                        tolerancia = 5
                    }
                    7 -> {
                        tolerancia = 10
                    }
                }
            }
        }
        calInduc()
    }


    fun calInduc() {

        val iS = "${b1.value}${b2.value}"
        val df = DecimalFormat("###.##")
        df.roundingMode = RoundingMode.CEILING

        val r2 = iS.toInt().times(multiplicador)
        var r3 = ""
        when {
            r2.roundToInt() == 0 -> {
                val r4 = df.format(r2.times(1000))
                r3 = "$r4  nH"
            }
            r2.roundToInt().toString().length in 1..3 -> {
                val r4 = df.format(r2)
                r3 = "$r4 µH"
            }
            r2.roundToInt().toString().length in 4..6 -> {
                r3 = df.format(r2.div(1000)) + "  mH"
            }
        }


        inductanciaS.set(r3)
        toleranciaS.set("±$tolerancia%")
    }

}
