package com.zqq.mvpframe.data.remote;


import com.zqq.mvpframe.adapter.item.NewsInfo;

import java.util.List;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zqq on 2017/6/20.
 */
public class MyMvpFrameModel {

    private ApiSevice mApiSevice;

    public MyMvpFrameModel(ApiSevice mApiSevice) {
        this.mApiSevice = mApiSevice;
    }

    public void getData(String param, Subscriber<List<NewsInfo>> subscriber) {
        mApiSevice.search(param)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }
}
