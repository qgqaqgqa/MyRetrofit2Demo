package com.qgqaqgqa.myretrofit2demo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * User: Created by 钱昱凯
 * Date: 2017/10/20 0020
 * Time: 17:57
 */
public interface SearchService {
    @GET("{wd}")
    Call<ResponseBody> getSearch(@Query("wd") String wd);
}
