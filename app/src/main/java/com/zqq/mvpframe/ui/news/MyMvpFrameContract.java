package com.zqq.mvpframe.ui.news;


import com.zqq.mvpframe.adapter.item.NewsInfo;
import com.zqq.mvpframe.ui.IBaseView;

import java.util.List;

/**
 * Created by zqq on 2017/6/20.
 */
public interface MyMvpFrameContract {

    interface View extends IBaseView {

        void updateView(List<NewsInfo> infos);
    }

//    interface PresenterI extends BasePresenter {
//
//        void requestData(String param);
//    }

}
