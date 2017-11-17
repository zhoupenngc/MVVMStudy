package com.mvvmstudy.bean;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by DELL on 2017/11/14.
 */

public class Data {
    private String img;
    private String title;

    public Data() {
    }

    public Data(String img, String title) {
        this.img = img;
        this.title = title;
    }
    @BindingAdapter("bind:img")
    public static void loadImage(ImageView iv,String img){
        Picasso.with(iv.getContext()).load(img).into(iv);
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
