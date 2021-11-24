package com.android.bkd.ui.search

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load

object SearchBinding {

    @BindingAdapter("app:loadImage")
    @JvmStatic
    fun setImage(imageView: ImageView, img: Int) {
        imageView.load(img)
    }
}