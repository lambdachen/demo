package com.example.demo.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class HttpTest {

    public static void main(String[] args) throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://www.baidu.com").build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        System.out.println(result.length());
    }
}
