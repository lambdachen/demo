package com.example.demo.copy;

import org.springframework.util.Assert;
import org.springframework.util.StreamUtils;

import java.io.*;
import java.util.concurrent.ExecutorService;

/**
 * Created by ChenLY on 2017-09-08.
 */
public class Main {


    public static void main(String[] args) throws Exception {

        File file = new File("pom.xml");
        if(file.exists()) {
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream("d:/pox.xml");
            //int byteCount = StreamUtils.copy(inputStream, outputStream);
            int byteCount = copy(inputStream, outputStream, true);
            System.out.println("the copy is finished and the file size is " + byteCount);
            inputStream.close();
            outputStream.close();
        } else {
            System.out.println("file is not exist.");
        }
    }


    public static int copy(InputStream in, OutputStream out, boolean isCloseOutputstream) throws IOException {
        Assert.notNull(in, "no inputstream specified");
        Assert.notNull(out, "no outputstream specified");
        int byteCount = 0;
        int byteReads = -1;
        byte[] buffer = new byte[1024];
        while ((byteReads = in.read(buffer)) != -1) {
            out.write(buffer, 0, byteReads);
            byteCount += byteReads;
        }
        out.flush();
        if (isCloseOutputstream) {
            out.close();
        }
        return byteCount;
    }


}
