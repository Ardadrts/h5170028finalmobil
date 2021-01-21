package com.medipol.h5170028_arda_demirtas_final_proje.util;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.medipol.h5170028_arda_demirtas_final_proje.R;

public class GlideUtil {
    public  static  void resmiIndiripGoster(Context context, String url, ImageView img)
    {//resmi indirir ve yaptığımız imageviewa göre ayarlar
        Glide.with(context)
                .load(url)
                .error(R.drawable.banner)
                .centerCrop()
                .into(img);
    }
}
