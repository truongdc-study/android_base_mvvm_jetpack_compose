package com.truongdc.android.base.utils.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.truongdc.android.base.utils.Constants

fun ImageView.loadImageCircleWithUrl(url: String) {
    Glide.with(this)
        .load(Constants.BASE_URL_IMAGE + url)
        .circleCrop()
        .into(this)
}

fun ImageView.loadImageWithUrl(url: String) {
    Glide.with(this)
        .load(Constants.BASE_URL_IMAGE + url)
        .into(this)
}
