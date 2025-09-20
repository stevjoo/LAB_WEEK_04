package com.example.lab_week_04

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.lab_week_04.CafeDetailFragment
import com.example.lab_week_04.R


class CafeAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val tabContents: List<String>
) : FragmentStateAdapter(fragmentManager, lifecycle) {

    override fun getItemCount(): Int {
        return tabContents.size
    }

    override fun createFragment(position: Int): Fragment {
        return CafeDetailFragment.newInstance(tabContents[position])
    }
}