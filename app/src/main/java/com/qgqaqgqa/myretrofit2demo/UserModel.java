package com.qgqaqgqa.myretrofit2demo;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * User: Created by 钱昱凯
 * Date: 2017/10/23 0023
 * Time: 10:44
 */
public class UserModel implements Serializable{

    @SerializedName("id")
    public long id;

    @SerializedName("date")
    public String date;

    @SerializedName("author")
    public String author;

    @SerializedName("title")
    public String title;

    @SerializedName("content")
    public String content;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
