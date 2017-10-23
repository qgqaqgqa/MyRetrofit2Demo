package com.qgqaqgqa.myretrofit2demo;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 封装公共参数（Key和密码）
 * User: Created by 钱昱凯
 * Date: 2017/10/23 0023
 * Time: 12:58
 */
public class CommonInterceptor implements Interceptor {
    private final String mApiKey;
    private final String mApiSecret;

    public CommonInterceptor(String apiKey, String apiSecret) {
        mApiKey = apiKey;
        mApiSecret = apiSecret;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request oldRequest = chain.request();

        // 添加新的参数
        HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                .newBuilder()
                .scheme(oldRequest.url().scheme())
                .host(oldRequest.url().host())

                //get
                .addQueryParameter("Key", mApiKey)
                .addQueryParameter("Secret", mApiSecret)
                .addQueryParameter("password", "880808")
                //post
                .addEncodedQueryParameter("Key1", mApiKey)
                .addEncodedQueryParameter("Secret1", mApiSecret)
                .addEncodedQueryParameter("password", "880809");

        // 新的请求
        Request newRequest = oldRequest.newBuilder()
                .method(oldRequest.method(), oldRequest.body())
                .url(authorizedUrlBuilder.build())
                .build();

        return chain.proceed(newRequest);
    }
}
