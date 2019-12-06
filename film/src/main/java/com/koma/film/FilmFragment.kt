package com.koma.film

import android.os.Bundle
import android.view.View
import com.koma.commonlibrary.base.BaseFragment
import com.koma.film.databinding.FragmentFilmBinding

class FilmFragment : BaseFragment<FragmentFilmBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            viewPagerHome.offscreenPageLimit = 3
            viewPagerHome.adapter = FilmFragmentAdapter(context!!, fragmentManager!!)
            tabLayoutHome.setupWithViewPager(viewPagerHome)
        }
    }

    override fun getLayoutId() = R.layout.fragment_film
}
