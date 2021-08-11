package com.bob.tools.net.bean

class BaseResult<T>(val errorNo: Int, val errorMsg: String, val data: T? = null)