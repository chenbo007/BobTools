package com.bob.tools.util

import android.net.Uri
import android.view.View
import android.widget.ImageView
import com.bob.tools.util.glidetransforms.CircleTransform
import com.bob.tools.util.glidetransforms.RoundedCornersTransformation
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop


/**
 * 加载图片
 */

fun ImageView.loadImage(url: String, placeholderResId: Int = 0, errorResId: Int = 0) {
    Glide.with(this).load(url).placeholder(placeholderResId).error(errorResId).into(this)
}

/**
 * 加载圆角图片
 */
fun ImageView.loadRoundImage(
    url: String,
    radius: Int,
    placeholderResId: Int = 0,
    errorResId: Int = 0
) {
    Glide.with(this).load(url)
        .transform(CenterCrop(), RoundedCornersTransformation(radius))
        .placeholder(placeholderResId)
        .error(errorResId).into(this)
}

/**
 *加载圆形图片
 */
fun ImageView.loadCircleImage(
    url: String,
    placeholderResId: Int = 0,
    errorResId: Int = 0
) {
    Glide.with(this).load(url)
        .transform(CircleTransform()).placeholder(placeholderResId)
        .error(errorResId).into(this)
}

/**
 * 加载本地圆形图片
 */
fun ImageView.loadLocalCirCleImage(resId: Int) {
    Glide.with(this).load(resId)
        .transform(CircleTransform()).into(this)
}

/**
 * 加载本地圆角图片
 */
fun ImageView.loadLocalRoundImage(
    resId: Int,
    radius: Int
) {
    Glide.with(this).load(resId)
        .transform(RoundedCornersTransformation(radius)).into(this)
}

/**
 * 加载本地圆角图片
 */
fun ImageView.loadLocalRoundImage(
    uri: Uri,
    radius: Int = ScreenUtil.dpTopx(5f)
) {
    Glide.with(this).load(uri)
        .transform(RoundedCornersTransformation(radius)).into(this)
}

/**
 * 显示/隐藏
 */
fun View.visible(isShow: Boolean) {
    this.visibility = if (isShow) View.VISIBLE else View.GONE
}






