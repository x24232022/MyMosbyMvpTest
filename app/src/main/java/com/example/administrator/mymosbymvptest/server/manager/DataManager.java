package com.example.administrator.mymosbymvptest.server.manager;

import android.content.Context;

import com.example.administrator.mymosbymvptest.RetrofitHelper;
import com.example.administrator.mymosbymvptest.RetrofitServer;

/**
 * Created by Administrator on 2018/4/8 0008.
 * 为了更方便的调用RetrofitServer中的方法再一次封装的类
 */

public class DataManager {
    private RetrofitServer mRetrofitServer;

    public DataManager(Context context) {
       this.mRetrofitServer = RetrofitHelper.getInstances().getServer();
    }
}
