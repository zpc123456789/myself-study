package com.zpc.myself.study.test.example;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * UDP 方式交流
 */
public class SocketDemoTest {
    @Test
    public void client() {
        Socket socket = new Socket();
        OutputStream outputStream = null;
        try {
            InetAddress byName = InetAddress.getByName("172.28.80.1");
            String hostAddress = byName.getHostAddress();
            socket = new Socket(hostAddress, 8099);
            outputStream = socket.getOutputStream();
            outputStream.write("你好，我是客户端".getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Test
    public void serve() {
        Socket accept = null;
        ServerSocket serverSocket;
        ByteArrayOutputStream byteArrayOutputStream = null;
        InputStream inputStream = null;
        try {
            serverSocket = new ServerSocket(8099);
            accept = serverSocket.accept();
            inputStream = accept.getInputStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bt = new byte[5];
            int len;
            while ((len = inputStream.read(bt)) != -1) {
                byteArrayOutputStream.write(bt, 0, len);
            }
            System.out.println(byteArrayOutputStream.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                if (accept != null) {
                    accept.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
