package com.zqq.mvpframe.injector.component;


import com.zqq.mvpframe.data.remote.ApiSevice;
import com.zqq.mvpframe.injector.module.ApplicationModule;
import com.zqq.mvpframe.injector.module.HttpModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by zqq on 2017/6/20.
 *
 * @Singleton 因为HttpModule 模块中提供的方法是 Singleton ，所以此处必须添加单例 否则无法对外提供单例 报错
 */
@Singleton
@Component(modules = {ApplicationModule.class, HttpModule.class})
public interface ApplicationComponent {

    ApiSevice getApiSevice();


}
