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

package com.koma.film.binding

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.text.HtmlCompat
import androidx.databinding.BindingAdapter
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.koma.film.util.GlideApp

private const val IMAGE_URL = "http://image.tmdb.org/t/p/w342"

@BindingAdapter(value = ["imageUrl"])
fun bindImageUrl(view: ImageView, imageUrl: String?) {
    GlideApp.with(view.context)
        .load("$IMAGE_URL$imageUrl")
        .placeholder(ColorDrawable(Color.GRAY))
        .transition(DrawableTransitionOptions.withCrossFade())
        .thumbnail(0.1f)
        .into(view)
}

@BindingAdapter(value = ["circleImageUrl"])
fun bindCircleImageUrl(view: ImageView, imageUrl: String?) {
    GlideApp.with(view.context)
        .asBitmap()
        .load("$IMAGE_URL$imageUrl")
        .placeholder(ColorDrawable(Color.GRAY))
        .circleCrop()
        .thumbnail(0.1f)
        .into(view)
}

@BindingAdapter("isRefreshing")
fun bindIsRefreshing(view: SwipeRefreshLayout, isActive: Boolean) {
    view.post {
        view.isRefreshing = isActive
    }
}

@BindingAdapter("isGone")
fun bindIsGone(view: View, isGone: Boolean) {
    view.visibility = if (isGone) {
        View.GONE
    } else {
        View.VISIBLE
    }
}

@BindingAdapter("fabVisibility")
fun fabVisibility(fab: FloatingActionButton, visible: Boolean) {
    if (visible) fab.show() else fab.hide()
}

@BindingAdapter("renderHtml")
fun bindRenderHtml(view: TextView, description: String?) {
    if (description != null) {
        view.text = HtmlCompat.fromHtml(description, HtmlCompat.FROM_HTML_MODE_COMPACT)
        view.movementMethod = LinkMovementMethod.getInstance()
    } else {
        view.text = ""
    }
}