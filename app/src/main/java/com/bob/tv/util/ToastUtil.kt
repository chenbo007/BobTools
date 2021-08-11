package com.bob.tv.util

import android.content.Context
import android.widget.Toast

/**
 * author:cb
 * createTime: 2021/3/29 13:29
 **/
object ToastUtil {
    var applicationContext: Context? = null

    fun show(msg: String) {
        applicationContext?.let {
            Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
        }

    }

}