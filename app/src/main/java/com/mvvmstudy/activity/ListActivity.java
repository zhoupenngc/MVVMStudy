package com.mvvmstudy.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.mvvmstudy.R;
import com.mvvmstudy.adapter.MyAdapter;
import com.mvvmstudy.bean.BaseBean;
import com.mvvmstudy.bean.Data;
import com.mvvmstudy.utils.Api;
import com.mvvmstudy.utils.ApiService;
import com.mvvmstudy.utils.RetrofitUtil;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class ListActivity extends AppCompatActivity {

    private ListView lv;
    private List<Data> list;
    private Subscription subscribe;
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            MyAdapter<Data> adapter = new MyAdapter<>(ListActivity.this, R.layout.lv_item, 1, list);
            lv.setAdapter(adapter);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        lv = findViewById(R.id.lv);
        getData();
    }
    public void getData(){
        new Thread(){
            @Override
            public void run() {
                super.run();

                ApiService apiService = RetrofitUtil.getInstance().getApiService(Api.devIP, ApiService.class);
                Call<BaseBean> data = apiService.getData("index", "index");
                data.enqueue(new Callback<BaseBean>() {
                    @Override
                    public void onResponse(Call<BaseBean> call, Response<BaseBean> response) {
                        BaseBean baseBean = response.body();
                        List<BaseBean.DataBean.AdlistBean> adlist = baseBean.getData().getAdlist();
                        list = new ArrayList<>();
                        for (int i = 0; i < adlist.size(); i++) {
                            String img = adlist.get(i).getImg();
                            String title = adlist.get(i).getTitle();
                            list.add(new Data(img, title));
                        }

                        handler.sendEmptyMessage(0);
                    }

                    @Override
                    public void onFailure(Call<BaseBean> call, Throwable t) {

                    }
                });
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (!(subscribe==null)&&subscribe.isUnsubscribed()){
            subscribe.unsubscribe();
        }

    }
}
