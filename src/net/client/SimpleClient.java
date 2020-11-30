package net.client;

import java.io.*;
import java.net.Socket;

/*
    简单客户端
 */
public class SimpleClient {
    public static void main(String[] args) throws IOException {
        // 创建与服务端的连接
        Socket client = new Socket("localhost", 9999);

        // 获取输出流对象
        OutputStream outputStream = client.getOutputStream();

        // 包装输出流
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);

        // 向服务端发送信息
        dataOutputStream.writeUTF("你好，我是客户端，向你请求连接");

        // 获取输入流对象
        InputStream inputStream = client.getInputStream();

        // 包装输入流
        DataInputStream dataInputStream = new DataInputStream(inputStream);

        // 获取服务端返回的数据
        System.out.println(dataInputStream.readUTF());

        // 关闭资源
        dataInputStream.close();
        inputStream.close();
        dataOutputStream.close();
        outputStream.close();
        client.close();
    }
}
