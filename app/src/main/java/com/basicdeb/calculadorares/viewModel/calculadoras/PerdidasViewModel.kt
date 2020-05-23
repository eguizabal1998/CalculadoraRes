package com.basicdeb.calculadorares.viewModel.calculadoras

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import java.math.RoundingMode
import java.text.DecimalFormat
import kotlin.math.PI
import kotlin.math.log10

class PerdidasViewModel() : ViewModel() {

    val frec = ObservableField<String>()
    val potencia = ObservableField<String>()
    val distancia = ObservableField<String>()
    val perdCable = ObservableField<String>()
    val longTx = ObservableField<String>()
    val longRx = ObservableField<String>()
    val ganaTx = ObservableField<String>()
    val ganaRx = ObservableField<String>()
    val umbral = ObservableField<String>()
    val perdidaAdd = ObservableField<String>()


    val potenciaTx = ObservableField<String>()
    val perdidaTx = ObservableField<String>()
    val perdidaEspa = ObservableField<String>()
    val perdidaRx = ObservableField<String>()
    val potenciaf = ObservableField<String>()

    var frecU = "Hz"
    var distU = "m"

    var espacio = 0.0

    val df = DecimalFormat("###.###")

    fun checkCampos() {
        if (frec.get().isNullOrEmpty() || potencia.get().isNullOrEmpty() ||
            distancia.get().isNullOrEmpty()
        ) {
            perdidaEspa.set("Faltan Datos")
        } else {
            calculoEspacio()
        }

        if (perdCable.get().isNullOrEmpty() || longTx.get().isNullOrEmpty() ||
            longRx.get().isNullOrEmpty()
        ) {
            perdidaTx.set("Faltan Datos")
            perdidaRx.set("Faltan Datos")
        } else {
            calculoLinea()
        }

        if (ganaRx.get().isNullOrEmpty() || ganaTx.get().isNullOrEmpty() ||
            umbral.get().isNullOrEmpty()
        ) {
            potenciaf.set("Faltan Datos")
        }


    }

    private fun potenciaF() {
        df.roundingMode = RoundingMode.CEILING

        val potTx = if (potencia.get().isNullOrEmpty()) {
            0.0
        } else {
            10.times(log10(1000.times(potencia.get()!!.toDouble())))
        }

        val perdM = (perdCable.get()!!.toDouble()).div(100)
        val tx = perdM.times(longTx.get()!!.toDouble())
        val rx = perdM.times(longRx.get()!!.toDouble())

        val perL1 = if (longTx.get().isNullOrEmpty()) {
            0.0
        } else {
            tx
        }

        val perL2 = if (longRx.get().isNullOrEmpty()) {
            0.0
        } else {
            rx
        }

        val a1 = if (ganaTx.get().isNullOrEmpty()) {
            0.0
        } else {
            ganaTx.get()!!.toDouble()
        }

        val a2 = if (ganaRx.get().isNullOrEmpty()) {
            0.0
        } else {
            ganaRx.get()!!.toDouble()
        }

        val p = if (distancia.get().isNullOrEmpty()) {
            0.0
        } else {
            espacio
        }

        val add = if (perdidaAdd.get().isNullOrEmpty()) {
            0.0
        } else {
            perdidaAdd.get()!!.toDouble()
        }

        val perdidaF = potTx.minus(perL1).plus(a1).minus(p).plus(a2).minus(perL2).minus(add)

        potenciaf.set("${df.format(perdidaF)} dB")
    }

    private fun calculoLinea() {
        df.roundingMode = RoundingMode.CEILING

        val perdM = (perdCable.get()!!.toDouble()).div(100)
        val tx = perdM.times(longTx.get()!!.toDouble())
        val rx = perdM.times(longRx.get()!!.toDouble())

        perdidaTx.set("${df.format(tx)} dB")
        perdidaRx.set("${df.format(rx)} dB")
    }

    private fun calculoEspacio() {
        df.roundingMode = RoundingMode.CEILING

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

        val distm = when (distU) {
            "m" -> {
                distancia.get()!!.toDouble()
            }
            "Km" -> {
                distancia.get()!!.toDouble().times(1000)
            }
            else -> {
                distancia.get()!!.toDouble()
            }
        }

        val miembro1 = (PI.times(distm)).times(4).times(fHz)
        val miembro2 = (300000000.0)
        val lbf = (20).times(log10((miembro1.div(miembro2))))

        espacio = lbf

        perdidaEspa.set("${df.format(lbf)} dB")

        val potDB = 10.times(log10(1000.times(potencia.get()!!.toDouble())))

        potenciaTx.set("${df.format(potDB)} dB")

        Log.i("perdidas", lbf.toString())

        potenciaF()
    }
}
