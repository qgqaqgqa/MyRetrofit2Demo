package com.qgqaqgqa.myretrofit2demo;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * User: Created by 钱昱凯
 * Date: 2017/10/23 0023
 * Time: 10:26
 */
public interface LoginService {

    @FormUrlEncoded
    @POST("user/login/")
    Call<ResponseBody> login(@Field("username") String username, @Field("password") String password);
    @FormUrlEncoded
    @POST("user/login/")
    Call<Result<UserModel>> login1(@Field("username") String username,@Field("password") String password);
}
