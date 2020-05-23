package com.basicdeb.calculadorares.ui.calculadoras

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import com.basicdeb.calculadorares.R
import com.basicdeb.calculadorares.databinding.PerdidasFragmentBinding
import com.basicdeb.calculadorares.viewModel.calculadoras.PerdidasViewModel
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class PerdidasFragment : Fragment() {

    private lateinit var binding: PerdidasFragmentBinding
    private lateinit var viewModel: PerdidasViewModel
    private lateinit var mAdView: AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProvider(this).get(PerdidasViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.perdidas_fragment, container, false)
        binding.viewModel = viewModel

        mAdView = binding.adView

        MobileAds.initialize(this.context) {}

        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        listener()

        return binding.root
    }

    private fun listener() {
        binding.btnPerdidasCalcular.setOnClickListener {
            viewModel.frecU = binding.spinner.selectedItem.toString()
            viewModel.distU = binding.spinner2.selectedItem.toString()

            viewModel.checkCampos()
        }
    }


}
