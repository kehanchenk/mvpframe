package com.zqq.mvpframe.injector.component;


import com.zqq.mvpframe.MainActivity;
import com.zqq.mvpframe.injector.PerActivity;
import com.zqq.mvpframe.injector.module.MyMvpFrameModule;

import dagger.Component;

/**
 * Created by Administrator on 2017/6/20.
 *
 * 此处因为 ApplicationComponent 被定义成 Singleton , MyMvpFrameComponent 依赖于它，
 * 被依赖对象 Scope 的 级别不能高于 Singleton 需要自定义 Scope
 */
@PerActivity
@Component(dependencies =ApplicationComponent.class,modules = MyMvpFrameModule.class)
public interface MyMvpFrameComponent {

    void inject(MainActivity activity);


}
