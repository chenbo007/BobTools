package com.bob.tools.util.glidetransforms

import android.graphics.Bitmap
import com.bumptech.glide.load.Key
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation
import com.bumptech.glide.load.resource.bitmap.TransformationUtils
import java.security.MessageDigest

/**
 *圆角
 */
class RoundedCornersTransformation(
    val radius: Int = 0
) : BitmapTransformation() {
    private val ID = "com.bob.util.RoundedCornersTransformation"
    override fun updateDiskCacheKey(messageDigest: MessageDigest) {
        messageDigest.update(ID.toByteArray(Key.CHARSET))
    }

    override fun transform(
        pool: BitmapPool,
        toTransform: Bitmap, outWidth:
        Int, outHeight: Int
    ): Bitmap = TransformationUtils.roundedCorners(
        pool, toTransform,
        radius
    )

    override fun equals(other: Any?): Boolean {
        return other is RoundedCornersTransformation
    }

    override fun hashCode(): Int {
        return ID.hashCode()
    }

}