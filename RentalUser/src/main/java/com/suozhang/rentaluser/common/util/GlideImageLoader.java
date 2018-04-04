package com.suozhang.rentaluser.common.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.suozhang.rentaluser.R;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by LIJUWEN on 2017/3/27.
 */

public class GlideImageLoader extends ImageLoader {
    @Override
    public void displayImage(Context context, Object path, ImageView imageView) {
        Glide.with(context)
                .load(path)
                .apply(new RequestOptions().error(R.drawable.ic_error)
                        .diskCacheStrategy(DiskCacheStrategy.ALL))
                .into(imageView);

    }


}
