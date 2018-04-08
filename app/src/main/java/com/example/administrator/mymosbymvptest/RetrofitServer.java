package com.example.administrator.mymosbymvptest;



import com.example.administrator.mymosbymvptest.server.entity.Book;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Administrator on 2018/4/8 0008.
 * 拼接URL进行网络请求
 */

public interface RetrofitServer {
    @GET("book/search")
    Observable<Book> getSearchBooks(@Query("q") String name,
                                    @Query("tag") String tag,
                                    @Query("start") int start,
                                    @Query("count") int count);
}
