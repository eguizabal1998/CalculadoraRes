package com.basicdeb.calculadorares.ui.calculadoras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.Observable
import androidx.lifecycle.ViewModelProvider

import com.basicdeb.calculadorares.R
import com.basicdeb.calculadorares.databinding.ResistenciasFragmentBinding
import com.basicdeb.calculadorares.viewModel.calculadoras.ResistenciasViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class ResistenciasFragment : Fragment() {

    private lateinit var binding: ResistenciasFragmentBinding
    private lateinit var viewModel: ResistenciasViewModel
    private lateinit var mAdView: AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.resistencias_fragment, container, false)
        viewModel = ViewModelProvider(this).get(ResistenciasViewModel::class.java)

        binding.viewModel = viewModel
        mAdView = binding.adView

        MobileAds.initialize(this.context) {}

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        asignar()

        listeners()
        observers()


        return binding.root
    }

    private fun observers() {
        viewModel.num1.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.num1.get()) {
                    "0" -> {
                        binding.imgB1.setBackgroundResource(R.color.negro)
                    }
                    "1" -> {
                        binding.imgB1.setBackgroundResource(R.color.cafe)
                    }
                    "2" -> {
                        binding.imgB1.setBackgroundResource(R.color.rojo)
                    }
                    "3" -> {
                        binding.imgB1.setBackgroundResource(R.color.naranja)
                    }
                    "4" -> {
                        binding.imgB1.setBackgroundResource(R.color.amarillo)
                    }
                    "5" -> {
                        binding.imgB1.setBackgroundResource(R.color.verde)
                    }
                    "6" -> {
                        binding.imgB1.setBackgroundResource(R.color.azul)
                    }
                    "7" -> {
                        binding.imgB1.setBackgroundResource(R.color.violeta)
                    }
                    "8" -> {
                        binding.imgB1.setBackgroundResource(R.color.gris)
                    }
                    "9" -> {
                        binding.imgB1.setBackgroundResource(R.color.blanco)
                    }
                }
            }
        })
        viewModel.num2.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.num2.get()) {
                    "0" -> {
                        binding.imgB2.setBackgroundResource(R.color.negro)
                    }
                    "1" -> {
                        binding.imgB2.setBackgroundResource(R.color.cafe)
                    }
                    "2" -> {
                        binding.imgB2.setBackgroundResource(R.color.rojo)
                    }
                    "3" -> {
                        binding.imgB2.setBackgroundResource(R.color.naranja)
                    }
                    "4" -> {
                        binding.imgB2.setBackgroundResource(R.color.amarillo)
                    }
                    "5" -> {
                        binding.imgB2.setBackgroundResource(R.color.verde)
                    }
                    "6" -> {
                        binding.imgB2.setBackgroundResource(R.color.azul)
                    }
                    "7" -> {
                        binding.imgB2.setBackgroundResource(R.color.violeta)
                    }
                    "8" -> {
                        binding.imgB2.setBackgroundResource(R.color.gris)
                    }
                    "9" -> {
                        binding.imgB2.setBackgroundResource(R.color.blanco)
                    }
                }
            }
        })
        viewModel.num3.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.num3.get()) {
                    "0" -> {
                        binding.imgB3.setBackgroundResource(R.color.negro)
                    }
                    "1" -> {
                        binding.imgB3.setBackgroundResource(R.color.cafe)
                    }
                    "2" -> {
                        binding.imgB3.setBackgroundResource(R.color.rojo)
                    }
                    "3" -> {
                        binding.imgB3.setBackgroundResource(R.color.naranja)
                    }
                    "4" -> {
                        binding.imgB3.setBackgroundResource(R.color.amarillo)
                    }
                    "5" -> {
                        binding.imgB3.setBackgroundResource(R.color.verde)
                    }
                    "6" -> {
                        binding.imgB3.setBackgroundResource(R.color.azul)
                    }
                    "7" -> {
                        binding.imgB3.setBackgroundResource(R.color.violeta)
                    }
                    "8" -> {
                        binding.imgB3.setBackgroundResource(R.color.gris)
                    }
                    "9" -> {
                        binding.imgB3.setBackgroundResource(R.color.blanco)
                    }
                }
            }
        })

        viewModel.mul.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.mul.get()) {
                    "0" -> {
                        binding.imgB4.setBackgroundResource(R.color.negro)
                    }
                    "1" -> {
                        binding.imgB4.setBackgroundResource(R.color.cafe)
                    }
                    "2" -> {
                        binding.imgB4.setBackgroundResource(R.color.rojo)
                    }
                    "3" -> {
                        binding.imgB4.setBackgroundResource(R.color.naranja)
                    }
                    "4" -> {
                        binding.imgB4.setBackgroundResource(R.color.amarillo)
                    }
                    "5" -> {
                        binding.imgB4.setBackgroundResource(R.color.verde)
                    }
                    "6" -> {
                        binding.imgB4.setBackgroundResource(R.color.azul)
                    }
                    "7" -> {
                        binding.imgB4.setBackgroundResource(R.color.violeta)
                    }
                    "8" -> {
                        binding.imgB4.setBackgroundResource(R.color.gris)
                    }
                    "9" -> {
                        binding.imgB4.setBackgroundResource(R.color.blanco)
                    }
                    "-1" -> {
                        binding.imgB4.setBackgroundResource(R.drawable.oro_fondo)
                    }
                    "-2" -> {
                        binding.imgB4.setBackgroundResource(R.drawable.plata_fondo)
                    }
                }
            }
        })

        viewModel.tol.addOnPropertyChangedCallback(object : Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.tol.get()) {
                    "1" -> {
                        binding.imgB5.setBackgroundResource(R.color.cafe)
                    }
                    "2" -> {
                        binding.imgB5.setBackgroundResource(R.color.rojo)
                    }
                    "3" -> {
                        binding.imgB5.setBackgroundResource(R.color.naranja)
                    }
                    "4" -> {
                        binding.imgB5.setBackgroundResource(R.color.amarillo)
                    }
                    "0.5" -> {
                        binding.imgB5.setBackgroundResource(R.color.verde)
                    }
                    "0.25" -> {
                        binding.imgB5.setBackgroundResource(R.color.azul)
                    }
                    "0.1" -> {
                        binding.imgB5.setBackgroundResource(R.color.violeta)
                    }
                    "0.05" -> {
                        binding.imgB5.setBackgroundResource(R.color.gris)
                    }
                    "5" -> {
                        binding.imgB5.setBackgroundResource(R.drawable.oro_fondo)
                    }
                    "10" -> {
                        binding.imgB5.setBackgroundResource(R.drawable.plata_fondo)
                    }
                }
            }
        })

        viewModel.ppmK.addOnPropertyChangedCallback(object :
            Observable.OnPropertyChangedCallback() {
            override fun onPropertyChanged(sender: Observable?, propertyId: Int) {
                when (viewModel.ppmK.get()) {
                    "250" -> {
                        binding.imgB6.setBackgroundResource(R.color.negro)
                    }
                    "100" -> {
                        binding.imgB6.setBackgroundResource(R.color.cafe)
                    }
                    "50" -> {
                        binding.imgB6.setBackgroundResource(R.color.rojo)
                    }
                    "15" -> {
                        binding.imgB6.setBackgroundResource(R.color.naranja)
                    }
                    "25" -> {
                        binding.imgB6.setBackgroundResource(R.color.amarillo)
                    }
                    "20" -> {
                        binding.imgB6.setBackgroundResource(R.color.verde)
                    }
                    "10" -> {
                        binding.imgB6.setBackgroundResource(R.color.azul)
                    }
                    "5" -> {
                        binding.imgB6.setBackgroundResource(R.color.violeta)
                    }
                    "1" -> {
                        binding.imgB6.setBackgroundResource(R.color.gris)
                    }
                }
            }
        })
    }

    private fun asignar() {
        viewModel.num1.set("0")
        viewModel.num2.set("0")
        viewModel.num3.set("0")
        viewModel.mul.set("0")
        viewModel.tol.set("20")
        viewModel.ppmK.set("250")
        ocultar3(View.GONE)
        ocultarTol(View.GONE)
        ocultarPPM(View.GONE)
        viewModel.calRes()
    }

    private fun listeners() {
        binding.btnResistencias3b.setOnClickListener {
            viewModel.banda = 3
            ocultar3(View.GONE)
            ocultarTol(View.GONE)
            ocultarPPM(View.GONE)
            binding.tvPPM.visibility = View.GONE
            binding.imgB1.visibility = View.VISIBLE
            binding.imgBs1.visibility = View.VISIBLE
            binding.imgB2.visibility = View.VISIBLE
            binding.imgBs2.visibility = View.VISIBLE
            binding.imgB3.visibility = View.GONE
            binding.imgBs3.visibility = View.GONE
            binding.imgB4.visibility = View.VISIBLE
            binding.imgBs4.visibility = View.GONE
            binding.imgB5.visibility = View.GONE
            binding.imgBs5.visibility = View.GONE
            binding.imgB6.visibility = View.GONE
        }
        binding.btnResistencias4b.setOnClickListener {
            viewModel.banda = 4
            ocultar3(View.GONE)
            ocultarTol(View.VISIBLE)
            ocultarPPM(View.GONE)
            binding.tvPPM.visibility = View.GONE
            binding.imgB1.visibility = View.VISIBLE
            binding.imgBs1.visibility = View.VISIBLE
            binding.imgB2.visibility = View.VISIBLE
            binding.imgBs2.visibility = View.VISIBLE
            binding.imgB3.visibility = View.GONE
            binding.imgBs3.visibility = View.GONE
            binding.imgB4.visibility = View.VISIBLE
            binding.imgBs4.visibility = View.VISIBLE
            binding.imgB5.visibility = View.VISIBLE
            binding.imgBs5.visibility = View.GONE
            binding.imgB6.visibility = View.GONE
        }
        binding.btnResistencias5b.setOnClickListener {
            viewModel.banda = 5
            ocultar3(View.VISIBLE)
            ocultarTol(View.VISIBLE)
            ocultarPPM(View.GONE)
            binding.tvPPM.visibility = View.GONE
            binding.imgB1.visibility = View.VISIBLE
            binding.imgBs1.visibility = View.VISIBLE
            binding.imgB2.visibility = View.VISIBLE
            binding.imgBs2.visibility = View.VISIBLE
            binding.imgB3.visibility = View.VISIBLE
            binding.imgBs3.visibility = View.VISIBLE
            binding.imgB4.visibility = View.VISIBLE
            binding.imgBs4.visibility = View.VISIBLE
            binding.imgB5.visibility = View.VISIBLE
            binding.imgBs5.visibility = View.GONE
            binding.imgB6.visibility = View.GONE
        }
        binding.btnResistencias6b.setOnClickListener {
            viewModel.banda = 6
            ocultar3(View.VISIBLE)
            ocultarTol(View.VISIBLE)
            ocultarPPM(View.VISIBLE)
            binding.tvPPM.visibility = View.VISIBLE
            binding.imgB1.visibility = View.VISIBLE
            binding.imgBs1.visibility = View.VISIBLE
            binding.imgB2.visibility = View.VISIBLE
            binding.imgBs2.visibility = View.VISIBLE
            binding.imgB3.visibility = View.VISIBLE
            binding.imgBs3.visibility = View.VISIBLE
            binding.imgB4.visibility = View.VISIBLE
            binding.imgBs4.visibility = View.VISIBLE
            binding.imgB5.visibility = View.VISIBLE
            binding.imgBs5.visibility = View.VISIBLE
            binding.imgB6.visibility = View.VISIBLE
        }
    }

    private fun ocultar3(view: Int) {
        binding.tv3.visibility = view
        binding.button3.visibility = view
        binding.button9.visibility = view
        binding.button15.visibility = view
        binding.button21.visibility = view
        binding.button27.visibility = view
        binding.button33.visibility = view
        binding.button39.visibility = view
        binding.button45.visibility = view
        binding.button51.visibility = view
        binding.button57.visibility = view
        binding.button63.visibility = view
        binding.button69.visibility = view
    }

    private fun ocultarTol(view: Int) {
        binding.tv5.visibility = view
        binding.button5.visibility = view
        binding.button11.visibility = view
        binding.button17.visibility = view
        binding.button23.visibility = view
        binding.button29.visibility = view
        binding.button35.visibility = view
        binding.button41.visibility = view
        binding.button47.visibility = view
        binding.button53.visibility = view
        binding.button59.visibility = view
        binding.button65.visibility = view
        binding.button71.visibility = view
    }

    private fun ocultarPPM(view: Int) {
        binding.tv6.visibility = view
        binding.button6.visibility = view
        binding.button12.visibility = view
        binding.button18.visibility = view
        binding.button24.visibility = view
        binding.button30.visibility = view
        binding.button36.visibility = view
        binding.button42.visibility = view
        binding.button48.visibility = view
        binding.button54.visibility = view
        binding.button60.visibility = view
        binding.button66.visibility = view
        binding.button72.visibility = view
    }


}
