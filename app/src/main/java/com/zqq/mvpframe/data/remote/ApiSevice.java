package com.zqq.mvpframe.data.remote;

import com.zqq.mvpframe.adapter.item.NewsInfo;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by HP on 2017/6/21.
 */

public interface ApiSevice {

    public static final String BASE_URL = "http://www.zhuangbi.info/";

    //    http://www.zhuangbi.info/search'

    @GET("search")
    Observable<List<NewsInfo>> search(@Query("q") String query);
}
