package com.basicdeb.calculadorares.viewModel.calculadoras

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import kotlin.math.pow
import kotlin.math.roundToInt

class ResistenciasViewModel : ViewModel() {

    val num1 = ObservableField<String>()
    val num2 = ObservableField<String>()
    val num3 = ObservableField<String>()
    val mul = ObservableField<String>()
    val tol = ObservableField<String>()
    val ppmK = ObservableField<String>()

    var banda = 3

    val resistencia = ObservableField<String>()
    val tolerancia = ObservableField<String>()
    val ppmkO = ObservableField<String>()

    fun setnum1(valor: Int) {
        num1.set(valor.toString())
        calRes()
    }

    fun setnum2(valor: Int) {
        num2.set(valor.toString())
        calRes()
    }

    fun setnum3(valor: Int) {
        num3.set(valor.toString())
        calRes()
    }

    fun setmul(valor: Int) {
        mul.set(valor.toString())
        calRes()
    }

    fun settol(valor: String) {
        tol.set(valor)
        calRes()
    }

    fun setppmK(valor: Int) {
        ppmK.set(valor.toString())
        calRes()
    }

    fun calRes() {
        val rS = when (banda) {
            3 -> {
                num1.get() + num2.get()
            }
            4 -> {
                num1.get() + num2.get()
            }
            else -> {
                num1.get() + num2.get() + num3.get()
            }
        }
        val base: Double = 10.0
        val r2 = rS.toInt().times(base.pow(mul.get()!!.toInt()))
        var r3 = ""
        if (r2.roundToInt().toString().length <= 3) {
            r3 = r2.roundToInt().toString() + "  \u2126"
        } else if (r2.roundToInt().toString().length in 4..6) {
            r3 = r2.div(1000).toString() + "  KΩ"
        } else if (r2.roundToInt().toString().length in 7..9) {
            r3 = r2.div(1000000).toString() + "  MΩ"
        } else if (r2.roundToInt().toString().length in 10..12) {
            r3 = r2.div(1000000000).toString() + "  GΩ"
        }

        resistencia.set(r3)
        tolerancia.set("±" + tol.get() + "%")
        ppmkO.set(ppmK.get() + "ppm/K")
    }

}
