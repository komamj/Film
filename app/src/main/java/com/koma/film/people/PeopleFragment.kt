package com.koma.film.people

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
import com.koma.film.databinding.FragmentPeopleBinding
import com.koma.film.di.Injectable
import javax.inject.Inject

@OpenForTesting
class PeopleFragment : BaseFragment<FragmentPeopleBinding>(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel: PeopleViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var characterAdapter: PeopleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding.swipeRefreshLayout) {
            setColorSchemeColors(
                ContextCompat.getColor(context, R.color.color_primary_dark),
                ContextCompat.getColor(context, R.color.color_primary)
            )
            setOnRefreshListener {
                refresh()
            }
        }

        with(binding.rvCharacter) {
            layoutManager =
                StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            itemAnimator = DefaultItemAnimator()
            characterAdapter = PeopleAdapter()
            adapter = characterAdapter
        }
    }

    private fun refresh() {
        viewModel.loadPopularPeople()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.viewModel = viewModel

        refresh()

        startObserve()
    }

    private fun startObserve() {
        viewModel.people.observe(viewLifecycleOwner, Observer {
            characterAdapter.submitList(it)
        })
    }

    override fun getLayoutId() = R.layout.fragment_people
}