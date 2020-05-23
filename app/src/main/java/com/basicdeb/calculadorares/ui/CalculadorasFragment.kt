package com.basicdeb.calculadorares.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController

import com.basicdeb.calculadorares.R
import com.basicdeb.calculadorares.databinding.FragmentCalculadorasBinding

class CalculadorasFragment : Fragment() {

    lateinit var binding: FragmentCalculadorasBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_calculadoras, container, false)

        listeners()

        return binding.root
    }

    private fun listeners() {
        binding.btnCalculadorasResistencias.setOnClickListener {
            binding.progressCalculadoras.visibility = View.VISIBLE
            this.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToResistenciasFragment())
            binding.progressCalculadoras.visibility = View.GONE
        }
        binding.btnCalculadorasInductores.setOnClickListener {
            binding.progressCalculadoras.visibility = View.VISIBLE
            this.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToInductoresFragment())
            binding.progressCalculadoras.visibility = View.GONE
        }
        binding.btnCalculadorasFresnel.setOnClickListener {
            binding.progressCalculadoras.visibility = View.VISIBLE
            this.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToFresnelFragment())
            binding.progressCalculadoras.visibility = View.GONE
        }
        binding.btnCalculadorasPerdidas.setOnClickListener {
            this.findNavController()
                .navigate(MainFragmentDirections.actionMainFragmentToPerdidasFragment())
        }
    }

}
