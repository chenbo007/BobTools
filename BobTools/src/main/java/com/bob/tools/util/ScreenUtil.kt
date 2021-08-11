package com.bob.tools.util

import android.content.res.Resources

/**
 * author:cb
 * createTime: 2021/3/30 14:41
 **/
object ScreenUtil {
    private val displayMetrics by lazy {
        Resources.getSystem().displayMetrics
    }

    fun dpTopx(dp: Float): Int {

        return (dp * displayMetrics.density + 0.5).toInt()
    }

    fun pxTodp(px: Int): Float {
        return px / displayMetrics.density
    }
}