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

package com.koma.tv

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.koma.tv.data.entities.TVShow
import com.koma.tv.databinding.ItemTvShowBinding

class TVShowAdapter : ListAdapter<TVShow, TVShowAdapter.TVShowVH>(
    TVShowDiffCallback()
) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TVShowVH {
        return TVShowVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_tv_show,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: TVShowVH, position: Int) {
        bind(holder, position)
    }

    private fun bind(viewHolder: TVShowVH, position: Int) {
        viewHolder.binding.tvShow = getItem(position)
        viewHolder.binding.clickListener = createOnClickListener()
        viewHolder.binding.executePendingBindings()
    }

    private fun createOnClickListener(): View.OnClickListener {
        return View.OnClickListener {
        }
    }

    class TVShowVH(val binding: ItemTvShowBinding) : RecyclerView.ViewHolder(binding.root)

    private class TVShowDiffCallback : DiffUtil.ItemCallback<TVShow>() {
        override fun areItemsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: TVShow, newItem: TVShow): Boolean {
            return oldItem == newItem
        }
    }
}
