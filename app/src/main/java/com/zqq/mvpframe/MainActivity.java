package com.zqq.mvpframe;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zqq.mvpframe.adapter.NewsAdapter;
import com.zqq.mvpframe.adapter.item.NewsInfo;
import com.zqq.mvpframe.injector.component.ApplicationComponent;
import com.zqq.mvpframe.injector.component.DaggerMyMvpFrameComponent;
import com.zqq.mvpframe.injector.module.MyMvpFrameModule;
import com.zqq.mvpframe.ui.BaseActivity;
import com.zqq.mvpframe.ui.news.MyMvpFrameContract;
import com.zqq.mvpframe.ui.news.MyMvpFramepresenter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

/**
 * 基于dagge2 rxjava retrofit 的 mvp 框架设计流程
 */
public class MainActivity extends BaseActivity<MyMvpFramepresenter> implements MyMvpFrameContract.View{

    @BindView(R.id.Rv_mvpframe)
    RecyclerView mRvMvpFrame;

    @Inject
    NewsAdapter mNewsAdapter;


    @Inject
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public int setLayoutRes() {
        return R.layout.activity_main;
    }

    @Override
    public void initInjector(ApplicationComponent component) {

        DaggerMyMvpFrameComponent.builder().applicationComponent(component)
                .myMvpFrameModule(new MyMvpFrameModule(this))
                .build().inject(this);

    }

    @Override
    public void initView() {
        mRvMvpFrame.setLayoutManager(new LinearLayoutManager(this));
        mRvMvpFrame.setItemAnimator(new DefaultItemAnimator());
        mRvMvpFrame.setAdapter(mNewsAdapter);
    }

    @Override
    public void updataView() {
        mPresenter.requestData("可爱");
    }



    @Override
    public void showLoading() {
        mProgressDialog.show();
    }

    @Override
    public void dismiss() {
        mProgressDialog.dismiss();
    }

    @Override
    public void showError(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void updateView(List<NewsInfo> infos) {
        mNewsAdapter.setData(infos);
    }
}
