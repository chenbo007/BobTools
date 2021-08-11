package com.bob.tools.net

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bob.tools.net.bean.BaseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

/**
 * author:cb
 * createTime: 2021/7/27 10:03
 **/
fun <T> ViewModel.retrofit(dsl: RetrofitDSL<T>.() -> Unit) {
    //在主线程中开启协程
    viewModelScope.launch(Dispatchers.Main) {
        val coroutine = RetrofitDSL<T>().apply(dsl)
        coroutine.api?.let { call ->
            //async 并发执行 在IO线程中
            val deferred = viewModelScope.async(Dispatchers.IO) {
                try {
                    call.execute() //已经在io线程中了，所以调用Retrofit的同步方法
                } catch (e: Exception) {
                    null
                }
            }
            //当协程取消的时候，取消网络请求
            deferred.invokeOnCompletion {
                if (deferred.isCancelled) {
                    call.cancel()
                    coroutine.clean()
                }
            }
            //await 等待异步执行的结果
            val response = deferred.await()
            if (response == null) {
                coroutine.onFail?.invoke("请求错误", NetCode.ERROR_CODE_CONNECTION)
            } else {
                response.let {
                    if (response.isSuccessful) {
                        //访问接口成功
                        val data = response.body()
                        if (data != null) {
                            coroutine.onSuccess?.invoke(data)
                        } else {
                            coroutine.onFail?.invoke("返回数据为空", NetCode.ERROR_CODE_NO_BODY)
                        }
                    } else {
                        coroutine.onFail?.invoke(response.errorBody().toString(), response.code())
                    }
                }
            }
            coroutine.onComplete?.invoke()
        }
    }
}