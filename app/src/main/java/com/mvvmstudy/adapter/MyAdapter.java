package com.mvvmstudy.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by DELL on 2017/11/14.
 */

public class MyAdapter<T> extends BaseAdapter {
    private Context context;
    private int layoutId;
    private int variableId;
    private List<T> list;
    private LayoutInflater inflater;
    public MyAdapter(Context context, int layoutId, int variableId, List<T> list) {
        this.context = context;
        this.layoutId = layoutId;
        this.variableId = variableId;
        this.list = list;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewDataBinding dataBinding;
        if (convertView==null){
           dataBinding =  DataBindingUtil.inflate(inflater,layoutId,parent,false);
        }else {
            dataBinding =DataBindingUtil.getBinding(convertView);
        }
        dataBinding.setVariable(variableId,list.get(position));
        return dataBinding.getRoot();
    }
}
