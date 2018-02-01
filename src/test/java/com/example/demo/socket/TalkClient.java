package com.example.demo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by ChenLY on 2017/12/13.
 */
public class TalkClient {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost", 10001);
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        while (true) {
            String data = sin.readLine();
            out.write(data + "\n");
            out.flush();
            System.out.println("Client: " + data);
            System.out.println("Server: " + in.readLine());
            if (data.equals("exit")) {
                break;
            }
        }
        out.close();
        in.close();
        socket.close();
    }
}
