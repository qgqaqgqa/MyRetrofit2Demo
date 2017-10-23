package com.qgqaqgqa.myretrofit2demo;

/**
 * User: Created by 钱昱凯
 * Date: 2017/10/23 0023
 * Time: 10:46
 */
public class Result<T> {
    public int code;
    public String msg;
    public T data;
    public long count;
    public long page;
    public String result;
    public T Response;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public long getPage() {
        return page;
    }

    public void setPage(long page) {
        this.page = page;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public T getResponse() {
        return Response;
    }

    public void setResponse(T response) {
        Response = response;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                ", count=" + count +
                ", page=" + page +
                ", result=" + result +
                ", Response=" + Response +
                '}';
    }
}