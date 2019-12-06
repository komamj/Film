package com.koma.mobile.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.koma.commonlibrary.base.BaseActivity
import com.koma.film.FilmFragment
import com.koma.mobile.R
import com.koma.mobile.databinding.ActivityMainBinding
import com.koma.people.PeopleFragment
import com.koma.tv.TVFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val fragmentsHolder: Map<String, Fragment> by lazy {
        mapOf(
            HOME_TAG to FilmFragment(),
            TV_TAG to TVFragment(),
            PEOPLE_TAG to PeopleFragment()
        )
    }

    private var currentTag = HOME_TAG

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        init()
    }

    private fun init() {
        with(binding) {
            bottomNavigationView.setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.nav_home -> {
                        showFragment(HOME_TAG)
                        true
                    }
                    R.id.nav_tv -> {
                        showFragment(TV_TAG)
                        true
                    }
                    R.id.nav_people -> {
                        showFragment(PEOPLE_TAG)
                        true
                    }
                    else -> false
                }
            }
        }

        fragmentsHolder[HOME_TAG]?.run {
            supportFragmentManager.beginTransaction()
                .add(R.id.content_main, this, HOME_TAG)
                .commit()
        }
    }

    private fun showFragment(readyFragmentTag: String) {
        if (currentTag == readyFragmentTag) {
            return
        }
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        val currentFragment = supportFragmentManager.findFragmentByTag(currentTag)
        if (currentFragment != null) {
            fragmentTransaction.hide(currentFragment)
        }
        val readyFragment = supportFragmentManager.findFragmentByTag(readyFragmentTag)
        if (readyFragment != null) {
            fragmentTransaction.show(readyFragment)
        } else {
            fragmentsHolder[readyFragmentTag]?.run {
                fragmentTransaction.add(R.id.content_main, this, readyFragmentTag)
            }
        }
        fragmentTransaction.setCustomAnimations(
            android.R.anim.fade_in,
            android.R.anim.fade_out,
            android.R.anim.fade_in,
            android.R.anim.fade_out
        )
        fragmentTransaction.commit()
        currentTag = readyFragmentTag
    }

    override fun getLayoutId() = R.layout.activity_main

    companion object {
        private const val HOME_TAG = "home_tag"
        private const val TV_TAG = "tv_tag"
        private const val PEOPLE_TAG = "people_tag"
    }
}
