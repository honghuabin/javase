package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    创建一个简单的服务器
 */
public class SimpleServer {
    public static void main(String[] args) throws IOException {
        // 创建服务器socket服务
        ServerSocket server = new ServerSocket(9999);   // 端口范围是 0- 65535

        // 监听客户端连接
        Socket client = server.accept();

        // 获取输入流
        InputStream inputStream = client.getInputStream();

        // 获取客户端传输的数据
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // 输出客户端发送过来的数据
        System.out.println(dataInputStream.readUTF());

        // 获取输出流
        OutputStream outputStream = client.getOutputStream();

        // 将输出流进行转化
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // 向客户端返回数据
        dataOutputStream.writeUTF("你好，我是服务端，我接收到了你的请求");

        // 释放资源
        dataOutputStream.close();
        outputStream.close();
        dataInputStream.close();
        inputStream.close();
        client.close();
        server.close();
    }
}
