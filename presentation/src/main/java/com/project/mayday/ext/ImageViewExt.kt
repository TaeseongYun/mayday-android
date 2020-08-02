package com.project.mayday.ext

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.project.mayday.R
import com.project.mayday.component.Constants.NO_IMAGE_URL
import com.squareup.picasso.Picasso


@BindingAdapter("setImgUrl")
fun ImageView.setImgUrl(imgUrl: String?) {
    imgUrl?.let {
        Picasso.get()
            .load(it.ifEmpty { NO_IMAGE_URL })
//            .placeholder(R.drawable.place_holder)
//            .centerCrop()
//            .error(R.drawable.error)
            .fit()
            .into(this)
    }
}

