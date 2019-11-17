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

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.koma.film.R
import com.koma.film.data.entities.Film
import com.koma.film.databinding.ItemFilmBinding

class FilmAdapter : ListAdapter<Film, FilmAdapter.FilmVH>(FilmDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmVH {
        return FilmVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_film,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FilmVH, position: Int) {
        bind(holder, position)
    }

    private fun bind(viewHolder: FilmVH, position: Int) {
        val film = getItem(position)
        viewHolder.binding.film = film
        viewHolder.binding.clickListener = createOnClickListener(film)
        viewHolder.binding.executePendingBindings()
    }

    private fun createOnClickListener(film: Film): View.OnClickListener {
        return View.OnClickListener {
        }
    }

    class FilmVH(val binding: ItemFilmBinding) : RecyclerView.ViewHolder(binding.root)

    private class FilmDiffCallback : DiffUtil.ItemCallback<Film>() {
        override fun areItemsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Film, newItem: Film): Boolean {
            return oldItem == newItem
        }
    }
}
