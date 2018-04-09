package com.example.administrator.mymosbymvptest;


import android.content.Context;

import com.google.gson.GsonBuilder;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2018/4/8 0008.
 * 初始化Retrofit进行网络请求
 */

public class RetrofitHelper {
    private static Context mContext;


    private Retrofit mRetrofit=null;
    OkHttpClient mClient=new OkHttpClient();
    //json数据转换使用的Gson转换工厂
    GsonConverterFactory mFactory=GsonConverterFactory.create(new GsonBuilder().create());

    private static  RetrofitHelper mHelper=null;
    public static synchronized RetrofitHelper getInstances(Context context){
        if(mHelper==null){
           mHelper= new RetrofitHelper(context);
        }

        return mHelper;
    }

    public RetrofitHelper(Context context) {
        mContext=context;
        init();
    }

    private void init() {
        resetApp();
    }

    private void resetApp() {
        mRetrofit =new Retrofit.Builder()
                .baseUrl("https://api.douban.com/v2/")
                .client(mClient)//okhttp拦截器
                .addConverterFactory(mFactory)//json数据转换器
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())//支持RXjava
                .build();
    }
    public RetrofitServer getServer(){
        return  mRetrofit.create(RetrofitServer.class);
    }
}
