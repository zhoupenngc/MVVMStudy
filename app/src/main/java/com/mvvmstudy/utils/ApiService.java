package com.mvvmstudy.utils;

import com.mvvmstudy.bean.BaseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by DELL on 2017/11/3.
 */

public interface ApiService {
    @GET("api.php")
    Call<BaseBean> getData(@Query("c") String c, @Query("a") String a);

}
