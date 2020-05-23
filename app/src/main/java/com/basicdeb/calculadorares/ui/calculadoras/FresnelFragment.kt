package com.basicdeb.calculadorares.ui.calculadoras

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.basicdeb.calculadorares.R
import com.basicdeb.calculadorares.databinding.FresnelFragmentBinding
import com.basicdeb.calculadorares.viewModel.calculadoras.FresnelViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class FresnelFragment : Fragment() {

    companion object {
        fun newInstance() = FresnelFragment()
    }

    private lateinit var binding: FresnelFragmentBinding
    private lateinit var viewModel: FresnelViewModel
    private lateinit var mAdView: AdView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fresnel_fragment, container, false)
        viewModel = ViewModelProvider(this).get(FresnelViewModel::class.java)

        binding.viewModel = viewModel
        mAdView = binding.adView

        MobileAds.initialize(this.context) {}

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        listeners()

        return binding.root
    }

    private fun listeners() {
        binding.btnFresnelCalcular.setOnClickListener {
            viewModel.nfresnel = binding.spinnerFresnelNum.selectedItem.toString()
            viewModel.frecU = binding.spinnerFresnelFrecU.selectedItem.toString()
            viewModel.d1U = binding.spinnerFresnelD1U.selectedItem.toString()
            viewModel.d2U = binding.spinnerFresnelD2U.selectedItem.toString()
            viewModel.d3U = binding.spinnerFresnelAltura.selectedItem.toString()

            viewModel.checkCampos()
        }
    }

}
