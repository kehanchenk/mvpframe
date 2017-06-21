package com.zqq.mvpframe.injector;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Administrator on 2017/6/20.
 */
@Scope
@Documented
@Retention(RUNTIME)
public @interface PerActivity {
}
