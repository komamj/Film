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

package com.koma.film

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class FilmFragmentAdapter(context: Context, fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    private val tabTitle = context.resources.getStringArray(R.array.film_tab_title)

    override fun getItem(position: Int): Fragment {
        return FilmCategoryFragment.newInstance(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return if (tabTitle.size > position) {
            tabTitle[position]
        } else {
            ""
        }
    }

    override fun getCount() = TAB_COUNT

    companion object {
        private const val TAB_COUNT = 4
    }
}
