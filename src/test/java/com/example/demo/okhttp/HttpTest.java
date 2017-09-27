package com.example.demo.okhttp;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.junit.Test;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class HttpTest {

    @Test
    public void test() throws Exception {

    }

    @Test
    public void test1() throws Exception {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url("http://localhost:8080/user").build();
        Response response = client.newCall(request).execute();
        String result = response.body().string();
        System.out.println(result);
        System.out.println(response.code());
        System.out.println(result.length());
    }

}
