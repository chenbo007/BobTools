package com.bob.tv.net

import com.bob.tools.net.bean.BaseResult
import com.bob.tools.net.bean.Movie
import com.bob.tools.net.bean.MovieCategory
import com.bob.tools.net.bean.Video
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * author:cb
 * createTime: 2021/3/22 14:45
 **/
interface NetApi {
    /**
     * 登录
     * phone
     * password
     */
    @POST("/user/login")
    suspend fun login(@Body params: @JvmSuppressWildcards HashMap<String, Any>): Call<String>

    /**
     * 注册
     * phone
     * password
     * nickName
     * headUrl
     */
    @POST("/user/register")
    suspend fun register(@Body params: @JvmSuppressWildcards Map<String, Any>): Call<String>

    /**
     * 获取列表
     */
    @POST("/movie/getMovieList")
    fun getMovieList(): Call<BaseResult<MutableList<Movie>>>

    /**
     * 获取分类
     */
    @POST("/category/getCategoryList")
    fun getCategory(): Call<BaseResult<MutableList<MovieCategory>>>

    /**
     * 根据分类获取数据
     */
    @POST("/movie/getMovieListByCategory")
    fun getMovieListByCategory(@Body params: @JvmSuppressWildcards Map<String, Any>): Call<BaseResult<MutableList<Movie>>>

    /**
     * 获取视频
     */
    @POST("/movie/getVideoList")
    fun getVideos(@Body params: @JvmSuppressWildcards Map<String, Any>): Call<BaseResult<MutableList<Video>>>

}