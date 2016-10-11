package br.com.hussan.githubapi.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by hussan on 7/22/16.
 */

public class BindingUtils {
    @BindingAdapter({"bind:loadImage"})
    public static void loadImage(ImageView view, String imageUrl) {
        Picasso.with(view.getContext())
                .load(imageUrl)
                .into(view);
    }
}
