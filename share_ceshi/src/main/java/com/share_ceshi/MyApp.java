package com.share_ceshi;

import android.app.Application;

import com.umeng.socialize.PlatformConfig;

/**
 * Created by DELL on 2017/11/16.
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        {
            //AppID必须填对
            PlatformConfig.setWeixin("wx93af82bd3e1f9f3b", "39a5650f538d59931ec487d76ec47657");
        }
    }
}
