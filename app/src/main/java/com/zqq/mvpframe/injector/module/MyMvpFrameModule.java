package com.zqq.mvpframe.injector.module;

import android.app.ProgressDialog;

import com.zqq.mvpframe.MainActivity;
import com.zqq.mvpframe.adapter.NewsAdapter;
import com.zqq.mvpframe.data.remote.ApiSevice;
import com.zqq.mvpframe.data.remote.MyMvpFrameModel;
import com.zqq.mvpframe.ui.news.MyMvpFrameContract;
import com.zqq.mvpframe.ui.news.MyMvpFramepresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zqq on 2017/6/20.
 */

@Module
public class MyMvpFrameModule {

    private MyMvpFrameContract.View mView;

    public MyMvpFrameModule(MyMvpFrameContract.View view) {
        mView = view;
    }

    @Provides
    public MyMvpFrameContract.View providerView() {

        return mView;
    }


    @Provides
    public MyMvpFramepresenter providerPresenter(MyMvpFrameModel model, MyMvpFrameContract.View view) {

        return new MyMvpFramepresenter(model,view);
    }

    @Provides
    public MyMvpFrameModel providerMvpFrameModel(ApiSevice apiSevice) {

        return new MyMvpFrameModel(apiSevice);
    }

    @Provides
    public NewsAdapter providerNewsAdapter() {

        return new NewsAdapter();
    }

    @Provides
    public ProgressDialog providerProgressDialog(MyMvpFrameContract.View view) {

        return new ProgressDialog((MainActivity) view);

    }

}
