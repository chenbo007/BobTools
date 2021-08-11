package com.bob.tools.util.glidetransforms

import android.graphics.Bitmap
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import java.security.MessageDigest

class CircleTransform : BitmapTransformation() {
    private val ID = "com.bob.util.CircleTransform"
    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap,
        outWidth: Int,
        outHeight: Int
    ): Bitmap = TransformationUtils.circleCrop(pool, toTransform, outWidth, outHeight)

    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID.toByteArray(Key.CHARSET))
    }
    override fun equals(other: Any?): Boolean {
        return other is CircleTransform
    }

    override fun hashCode(): Int {
        return ID.hashCode()
    }
}