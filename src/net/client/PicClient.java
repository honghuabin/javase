package net.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/*
    上传图片客户端
 */
public class PicClient {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("localhost", 10088);

        if (client.isConnected()) {
            System.out.println("服务器连接成功");
        }

        // 读取本地图片文件
        // 创建打开本地文件的流
        FileInputStream fis = new FileInputStream(new File("source/pic/upload_pic01.jpg"));
        // 打开输出流
        OutputStream os = client.getOutputStream();
        System.out.println("开始上传图片");

        // 读取图片数据，然后通过网络输出流发送给服务器
        // 定义读取文件的数据缓存变量
        byte[] buf = new byte[1024];
        // 定义读取文件的长度
        int len = 0;
        while ((len = fis.read(buf)) != -1) {
            os.write(buf,0,len);
        }
        client.shutdownOutput();
        System.out.println("图片上传成功!");

        // 关闭图片读取流
        fis.close();

        // 关闭网络输出流
        os.close();

        // 关闭客户端连接
        client.close();
    }
}
