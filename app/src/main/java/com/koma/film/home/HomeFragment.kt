package com.koma.film.home

import android.os.Bundle
import android.view.View
import com.koma.commonlibrary.base.BaseFragment
import com.koma.film.R
import com.koma.film.databinding.FragmentHomeBinding

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewPagerHome.offscreenPageLimit = 3
            viewPagerHome.adapter = HomeFragmentAdapter(context!!, fragmentManager!!)
            tabLayoutHome.setupWithViewPager(viewPagerHome)
        }
    }

    override fun getLayoutId() = R.layout.fragment_home
}