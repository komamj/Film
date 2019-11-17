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

package com.koma.film.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.koma.film.R
import com.koma.film.data.entities.People
import com.koma.film.databinding.ItemPeopleBinding

class PeopleAdapter : ListAdapter<People, PeopleAdapter.CharacterVH>(CharacterDiffCallback()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterVH {
        return CharacterVH(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_people,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: CharacterVH, position: Int) {
        bind(holder, position)
    }

    private fun bind(viewHolder: CharacterVH, position: Int) {
        viewHolder.binding.people = getItem(position)
        viewHolder.binding.executePendingBindings()
    }

    class CharacterVH(val binding: ItemPeopleBinding) : RecyclerView.ViewHolder(binding.root)

    private class CharacterDiffCallback : DiffUtil.ItemCallback<People>() {
        override fun areItemsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: People, newItem: People): Boolean {
            return oldItem == newItem
        }
    }
}
