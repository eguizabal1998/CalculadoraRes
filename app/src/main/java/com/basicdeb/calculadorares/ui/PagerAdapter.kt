package com.basicdeb.calculadorares.ui

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(fa: Fragment) : FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = 1

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> {
                CalculadorasFragment()
            }
            else -> {
                CalculadorasFragment()
            }
        }
    }
}