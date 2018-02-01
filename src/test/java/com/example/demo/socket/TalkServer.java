package com.example.demo.socket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by ChenLY on 2017/12/13.
 */
public class TalkServer {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(10001);
        Socket socket = serverSocket.accept();
        BufferedReader sin = new BufferedReader(new InputStreamReader(System.in, "UTF-8"));
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
        PrintWriter out = new PrintWriter(socket.getOutputStream());
        while (true) {
            System.out.println("Client: " + in.readLine());
            String data = sin.readLine();
            System.out.println("Server: " + data);
            out.write(data + "\n");
            out.flush();
            if (data.equals("exit")) {
                break;
            }
        }
        out.close();
        in.close();
        socket.close();
    }
}
