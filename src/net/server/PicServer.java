package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/*
    上传图片服务端
 */
public class PicServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10088);

        // 监听客户端连接
        Socket client = serverSocket.accept();
        if (client.isConnected()){
            System.out.println("有新的客户端连接");
        }

        // 获取客户端输入流
        InputStream inputStream = client.getInputStream();

        File file = new File("source/pic/service_pic01.jpg");
        System.out.println("当前图片是否存在：" + file.exists());
        System.out.println("读取客户端上传的图片数据");

        // 创建本地输出流对象
        OutputStream outputStream = new FileOutputStream(file);
        // 定义读取图片数据的缓存变量
        byte[] buf = new byte[1024];
        // 定义读取数据长度变量
        int len = 0;
        // 读取客户端发送的图片数据
        while ((len = inputStream.read(buf)) != -1) {
            // 将图片信息写入本地
            outputStream.write(buf, 0, len);
        }
        client.shutdownInput();
        System.out.println("图片接收成功");
        System.out.println("当前图片是否存在：" + file.exists());

        // 关闭本地图片接收
        outputStream.close();

        // 关闭网络输入流
        inputStream.close();

        // 关闭客户端连接
        client.close();

        // 关闭服务器
        serverSocket.close();
    }
}
