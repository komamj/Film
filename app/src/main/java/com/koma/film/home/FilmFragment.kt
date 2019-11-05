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

package com.koma.film.home

import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.koma.commonlibrary.base.BaseFragment
import com.koma.commonlibrary.testing.OpenForTesting
import com.koma.film.R
import com.koma.film.databinding.FragmentBaseBinding
import com.koma.film.di.Injectable
import timber.log.Timber
import javax.inject.Inject

@OpenForTesting
class FilmFragment : BaseFragment<FragmentBaseBinding>(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: FilmViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var filmAdapter: FilmAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.d("onViewCreated")

        with(binding.swipeRefreshLayout) {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.color_primary_dark),
                ContextCompat.getColor(context, R.color.color_primary)
            )
            setOnRefreshListener {
                refresh()
            }
        }

        with(binding.recyclerView) {
            layoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            filmAdapter = FilmAdapter()
            adapter = filmAdapter
        }
    }

    private fun refresh() {
        arguments?.run {
            viewModel.loadFilms(this.getInt(FILM_CATEGORY))
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        refresh()

        startObserve()
    }

    private fun startObserve() {
        viewModel.isLoading.observe(viewLifecycleOwner, Observer {
            with(binding.swipeRefreshLayout) {
                post {
                    isRefreshing = it
                }
            }
        })
        viewModel.films.observe(viewLifecycleOwner, Observer {
            filmAdapter.submitList(it)
        })
    }

    override fun getLayoutId() = R.layout.fragment_base

    companion object {
        private const val FILM_CATEGORY = "film_category"

        fun newInstance(category: Int): FilmFragment {
            val fragment = FilmFragment()
            val bundle = Bundle().apply {
                putInt(FILM_CATEGORY, category)
            }
            fragment.arguments = bundle
            return fragment
        }
    }
}