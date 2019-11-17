/*
 * Copyright 2019 JUN MAO
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.koma.film.tv

import android.os.Bundle
import android.view.View
import com.koma.commonlibrary.base.BaseFragment
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.R
import com.koma.film.databinding.FragmentTvBinding
import timber.log.Timber

@OpenForTesting
class TVFragment : BaseFragment<FragmentTvBinding>() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("onViewCreated")

        with(binding) {
            viewPagerTv.offscreenPageLimit = 3
            viewPagerTv.adapter = TVFragmentAdapter(context!!, fragmentManager!!)
            tabLayoutTv.setupWithViewPager(viewPagerTv)
        }
    }

    override fun getLayoutId() = R.layout.fragment_tv

    companion object {
        fun newInstance(): TVFragment {
            return TVFragment()
        }
    }
}
