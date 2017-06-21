package com.zqq.mvpframe.ui.news;


import com.zqq.mvpframe.adapter.item.NewsInfo;
import com.zqq.mvpframe.data.remote.MyMvpFrameModel;
import com.zqq.mvpframe.ui.BasePresenter;

import java.util.List;

import javax.inject.Inject;

import rx.Subscriber;

/**
 * Created by zqq on 2017/6/20.
 */
public class MyMvpFramepresenter extends BasePresenter<MyMvpFrameModel,MyMvpFrameContract.View> {


    @Inject
    public MyMvpFramepresenter(MyMvpFrameModel model, MyMvpFrameContract.View view) {
        super(model, view);
    }

    @Override
    public void requestData(String param) {
        mModel.getData(param, new Subscriber<List<NewsInfo>>() {
            @Override
            public void onStart() {
                super.onStart();
                mView.showLoading();
            }

            @Override
            public void onCompleted() {
                mView.dismiss();
            }
            @Override
            public void onError(Throwable e) {
                mView.showError("loading fail");
            }
            @Override
            public void onNext(List<NewsInfo> infos) {
                mView.updateView(infos);
            }
        });
    }
}
