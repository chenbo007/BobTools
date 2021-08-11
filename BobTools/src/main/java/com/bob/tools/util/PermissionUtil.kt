package com.bob.tools.util

import android.annotation.TargetApi
import android.app.Activity
import android.content.pm.PackageManager

/**
 * 动态权限工具类
 * author:cb
 * createTime: 2021/7/20 13:53
 **/
class PermissionUtil(val listener: OnPermissionListener? = null) {
    @TargetApi(23)
    fun getPermission(activity: Activity, requestCode: Int, permissions: Array<String>) {
        val realPermission = mutableListOf<String>()//验证后需要请求的权限
        for (permission in permissions) {
            if (activity.checkSelfPermission(permission) != PackageManager.PERMISSION_GRANTED) {
                realPermission.add(permission)
            }
        }
        activity.requestPermissions(realPermission.toTypedArray(), requestCode)
    }

    fun onRequestPermissionResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        for (index in permissions.indices) {
            val permission = permissions[index]
            val result = grantResults[index]
            if (result != PackageManager.PERMISSION_GRANTED) {
                listener?.onPermissionFail(requestCode, permission)
                return
            }
        }
        listener?.onPermissionSuccess(requestCode)

    }

    interface OnPermissionListener {
        fun onPermissionSuccess(requestCode: Int)
        fun onPermissionFail(requestCode: Int, failPermission: String?)
    }
}