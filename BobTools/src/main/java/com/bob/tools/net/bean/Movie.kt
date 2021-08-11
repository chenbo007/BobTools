package com.bob.tools.net.bean

import java.io.Serializable


class Movie : Serializable {
    var id: Long? = null
    var cover: String? = null
    var description: String? = null
    var name: String? = null
    var score: Float? = null

    var videos: MutableList<Video>? = null
    var create_user_id: Long? = null
    var create_time: Long? = null
    var category_id: Long? = null
}