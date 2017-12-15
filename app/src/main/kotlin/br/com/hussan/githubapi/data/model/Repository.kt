package br.com.hussan.githubapi.data.model

import android.databinding.BaseObservable
import android.databinding.BindingAdapter
import android.widget.ImageView
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.squareup.picasso.Picasso

data class Repository(@Expose
                      var id: Int? = null,
                      @Expose
                      var name: String? = null,
                      @Expose
                      var owner: Owner? = null,
                      @SerializedName("forks_count")
                      @Expose
                      var forksCount    : Int? = null,
                      @SerializedName("full_name")
                      @Expose
                      var fullName: String? = null,
                      @SerializedName("description")
                      @Expose
                      var description: String? = null) : BaseObservable() {


    object CustomBindingAdapter{
        @BindingAdapter("bind:loadImage")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String) {
            Picasso.with(view.context).load(imageUrl).into(view)
        }
    }

}
