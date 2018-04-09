package com.example.administrator.mymosbymvptest.server.presenter;

import android.content.Context;

import com.example.administrator.mymosbymvptest.server.entity.Book;
import com.example.administrator.mymosbymvptest.server.manager.DataManager;
import com.example.administrator.mymosbymvptest.server.view.BookView;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;


import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2018/4/9 0009.
 */

public class BookPresenter extends MvpBasePresenter<BookView> {
    private DataManager mManager;
    CompositeSubscription mCompositeSubscription;
    private Context mContext;
    private Book mBook;



    public BookPresenter(Context context) {
        mContext = context;
        mManager=new DataManager(mContext);
        mCompositeSubscription =new CompositeSubscription();//存放Rxjava中的订阅关系的
    }
    public void getSearchBooks(String name,String tag,int start,int count){
        mCompositeSubscription.add(mManager.getSearchBooks(name,tag,start,count)
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Book>() {
            @Override
            public void onCompleted() {
                //将内存中的book实体数据交给View
                getView().onSuccess(mBook);
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
                getView().onErrod("请求失败");
            }

            @Override
            public void onNext(Book book) {
                //将请求下来的Book实体存到内存中
                mBook=book;
            }
        })
        );

    }
    //销毁Rxjava的订阅关系
    public void destroySubscription(){
        if (mCompositeSubscription.hasSubscriptions()){
            mCompositeSubscription.unsubscribe();
        }
    }
}
