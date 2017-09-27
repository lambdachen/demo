package com.example.demo.retrofit;

import org.junit.Test;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

/**
 * Created by ChenLY on 2017-09-21.
 */
public class Main {

    @Test
    public void test1() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<List<User>> call = service.listUser();
        Response<List<User>> response = call.execute();
        System.out.println(response);
        System.out.println(response.body());
    }

    @Test
    public void test2() throws Exception {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.baidu.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Service service = retrofit.create(Service.class);
        Call<String> call = service.search("hello");
        Response<String> response = call.execute();
        System.out.println(response.body());
    }
}
