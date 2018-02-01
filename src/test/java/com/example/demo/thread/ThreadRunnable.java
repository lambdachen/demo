package com.example.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by ChenLY on 2017/12/22.
 */
public class ThreadRunnable {

    public static void main(String[] args) throws Exception {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Result result = new Result();
        Result result1 = new Result();
        Future<Result> future = executorService.submit(() -> {
            result.setCode(100);
            result.setResult("success");
        }, result1);
        System.out.println(future.get().getCode());
        System.out.println(future.get().getResult());
        System.out.println(result.getResult());
    }

    static class Result{
        private int code;
        private String result;

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getResult() {
            return result;
        }

        public void setResult(String result) {
            this.result = result;
        }
    }
}
