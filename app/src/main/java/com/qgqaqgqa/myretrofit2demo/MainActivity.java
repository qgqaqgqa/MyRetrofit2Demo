package com.qgqaqgqa.myretrofit2demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private TextView tv_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_content=(TextView)findViewById(R.id.tv_content);


        Gson gson = new GsonBuilder()
                //配置你的Gson
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
//        创建Retrofit实例时需要通过Retrofit.Builder, 并调用baseUrl方法设置URL。
//        注：Retrofit2 的baseUlr 必须以 /（斜线）结束，不然会抛出一个IllegalArgumentException,
//                所以如果你看到别的教程没有以 / 结束
        Retrofit retrofit = new Retrofit.Builder()
//        "https://www.baidu.com/s?wd=%E5%9C%A8%E7%BA%BF&ie=UTF-8"
                .baseUrl("http://apidev.ezdaka.com/yg_testv3/api/public/index.php/index/")
                //可以接收自定义的Gson，当然也可以不传
                .addConverterFactory(GsonConverterFactory.create())//converter
                .build();
        SearchService service = retrofit.create(SearchService.class);
        LoginService loginService = retrofit.create(LoginService.class);

//        Call<ResponseBody> call = service.getSearch("wd");
//        Call<ResponseBody> call = loginService.login("311111","880808");

        Call<Result<UserModel>> call = loginService.login1("311111","880808");
// 用法和OkHttp的call如出一辙,
// 不同的是如果是Android系统回调方法执行在主线程
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                try {
//                    System.out.println(response.body().string());
//                    tv_content.setText(response.toString()+"\n\n"+response.body().string());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                t.printStackTrace();
//            }
//        });

        call.enqueue(new Callback<Result<UserModel>>() {
            @Override
            public void onResponse(Call<Result<UserModel>> call, Response<Result<UserModel>> response) {
                try {
                    System.out.println(response.body().toString());
                    tv_content.setText(response.body().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Result<UserModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
