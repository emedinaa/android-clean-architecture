package com.emedinaa.perutravel.presentation.utils.media;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.io.File;

/**
 * Created by emedinaa on 16/04/16.
 */
public class GlideILoader implements ImageLoader{

    @Override
    public void load(String url, ImageView imageView)
    {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    @Override
    public void loadLocal(String path, ImageView imageView) {
        Glide.with(imageView.getContext()).load(new File(path)).into(imageView);
    }
}
