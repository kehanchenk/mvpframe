// (c)2016 Flipboard Inc, All Rights Reserved.

package com.zqq.mvpframe.ui;

import android.app.Application;

import com.zqq.mvpframe.injector.component.ApplicationComponent;
import com.zqq.mvpframe.injector.component.DaggerApplicationComponent;
import com.zqq.mvpframe.injector.module.ApplicationModule;
import com.zqq.mvpframe.injector.module.HttpModule;


public class App extends Application {
    private static App INSTANCE;

//    private AppComponent mAppComponent;

    private ApplicationComponent mAppComponent;

    public static App getInstance() {
        return INSTANCE;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;

        mAppComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this))
                .httpModule(new HttpModule())
                .build();
//        mApplicationComponent.builder().applicationModule(new ApplicationModule(this))
//                .build();

//        mAppComponent = DaggerAppComponent.builder().build();
    }

    public ApplicationComponent getApplicationComponent() {
        return mAppComponent;
    }

    //    public AppComponent getAppComponent() {
//        return mAppComponent;
//    }
}
