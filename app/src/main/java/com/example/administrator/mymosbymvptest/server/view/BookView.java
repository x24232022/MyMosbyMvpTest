package com.example.administrator.mymosbymvptest.server.view;

import com.example.administrator.mymosbymvptest.server.entity.Book;
import com.hannesdorfmann.mosby.mvp.MvpView;

/**
 * Created by Administrator on 2018/4/8 0008.
 */

public interface BookView extends MvpView {
    //请求成功返回实体类
    void onSuccess(Book book);
    //返回失败Toast信息
    void onErrod(String result);
}
