package com.basicdeb.calculadorares.ui.calculadoras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import com.basicdeb.calculadorares.R
import com.basicdeb.calculadorares.databinding.InductoresFragmentBinding
import com.basicdeb.calculadorares.viewModel.calculadoras.InductoresViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class InductoresFragment : Fragment() {

    private lateinit var viewModel: InductoresViewModel
    private lateinit var binding: InductoresFragmentBinding
    private lateinit var mAdView: AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.inductores_fragment, container, false)
        viewModel = ViewModelProvider(this).get(InductoresViewModel::class.java)

        binding.viewModel = viewModel
        mAdView = binding.adView

        MobileAds.initialize(this.context) {}

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        asignar()
        observers()

        return binding.root
    }

    private fun observers() {
        viewModel.b1.observe(this.viewLifecycleOwner, Observer {
            colorBand12(it, binding.inductoresB1, binding.inductoresColor1)
        })
        viewModel.b2.observe(this.viewLifecycleOwner, Observer {
            colorBand12(it, binding.inductoresB2, binding.inductoresColor2)
        })
        viewModel.b3.observe(this.viewLifecycleOwner, Observer {
            colorBand34(it, binding.inductoresB3, binding.inductoresColor3)
        })
        viewModel.b4.observe(this.viewLifecycleOwner, Observer {
            colorBand34(it, binding.inductoresB4, binding.inductoresColor4)
        })
    }

    private fun colorBand12(pos: Int, view: View, text: TextView) {
        when (pos) {
            0 -> {
                view.setBackgroundResource(R.color.negro)
                text.setText(R.string.negro)
            }
            1 -> {
                view.setBackgroundResource(R.color.cafe)
                text.setText(R.string.cafe)
            }
            2 -> {
                view.setBackgroundResource(R.color.rojo)
                text.setText(R.string.rojo)
            }
            3 -> {
                view.setBackgroundResource(R.color.naranja)
                text.setText(R.string.naranja)
            }
            4 -> {
                view.setBackgroundResource(R.color.amarillo)
                text.setText(R.string.amarillo)
            }
            5 -> {
                view.setBackgroundResource(R.color.verde)
                text.setText(R.string.verde)
            }
            6 -> {
                view.setBackgroundResource(R.color.azul)
                text.setText(R.string.azul)
            }
            7 -> {
                view.setBackgroundResource(R.color.violeta)
                text.setText(R.string.violeta)
            }
            8 -> {
                view.setBackgroundResource(R.color.gris)
                text.setText(R.string.gris)
            }
            9 -> {
                view.setBackgroundResource(R.color.blanco)
                text.setText(R.string.blanco)
            }
        }
        binding.view.background = binding.inductoresB1.background
        binding.view2.background = binding.inductoresB2.background
    }

    private fun colorBand34(pos: Int, view: View, text: TextView) {
        when (pos) {
            1 -> {
                view.setBackgroundResource(R.color.negro)
                text.setText(R.string.negro)
            }
            2 -> {
                view.setBackgroundResource(R.color.cafe)
                text.setText(R.string.cafe)
            }
            3 -> {
                view.setBackgroundResource(R.color.rojo)
                text.setText(R.string.rojo)
            }
            4 -> {
                view.setBackgroundResource(R.color.naranja)
                text.setText(R.string.naranja)
            }
            5 -> {
                view.setBackgroundResource(R.color.amarillo)
                text.setText(R.string.amarillo)
            }
            6 -> {
                view.setBackgroundResource(R.drawable.oro_fondo)
                text.setText(R.string.oro)
            }
            7 -> {
                view.setBackgroundResource(R.drawable.plata_fondo)
                text.setText(R.string.plata)
            }
        }
        binding.view3.background = binding.inductoresB3.background
        binding.view4.background = binding.inductoresB4.background
    }

    private fun asignar() {
        viewModel.b1.value = 0
        viewModel.b2.value = 0
        viewModel.b3.value = 1
        viewModel.multiplicador = 1.0
        viewModel.b4.value = 1
        viewModel.tolerancia = 20
        viewModel.calInduc()
    }


}
