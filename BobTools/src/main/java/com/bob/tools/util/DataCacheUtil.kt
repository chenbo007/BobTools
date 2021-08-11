package com.bob.tools.util

import com.tencent.mmkv.MMKV

/**
 * author:cb
 * createTime: 2021/3/22 14:09
 **/
object DataCacheUtil {
    fun saveData(key: String, value: String) {
        val mmkv = MMKV.defaultMMKV()
        mmkv?.encode(key, value)
    }

    fun getData(key: String): String {
        val mmkv = MMKV.defaultMMKV()
        return mmkv?.decodeString(key) ?: ""
    }
}