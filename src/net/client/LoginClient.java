package net.client;

import net.common.ApiResult;
import net.common.LoginUser;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

/*
    登录客户端
        实现在控制台输入账号密码
        将账号密码保存为序列化数据，然后传递给服务器进行验证
        如果账号密码错误，那么需要重新输入账号密码
        如果正好密码正确，则进程结束
 */
public class LoginClient {
    public static void main(String[] args) throws IOException {
        LoginUser loginUser = new LoginUser();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("请输入账号：");
            loginUser.setAccount(scanner.nextLine());

            System.out.print("请输入密码：");
            loginUser.setPassword(scanner.nextLine());

            // 连接服务器
            Socket client = new Socket("localhost", 10089);

            // 获取输出流，并封装成序列化
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(client.getOutputStream());

            // 获取输入流，并封装成序列化
            ObjectInputStream objectInputStream = new ObjectInputStream(client.getInputStream());

            // 向服务端发送登录请求 并告知服务端发送完毕
            objectOutputStream.writeObject(loginUser);
            client.shutdownOutput();

            // 接收服务端返回数据
            try {
                ApiResult apiResult = (ApiResult) objectInputStream.readObject();
                System.out.println(apiResult.getMsg());
                if (apiResult.getCode() == 200){
                    break;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } finally {
                // 释放资源
                objectOutputStream.close();
                objectInputStream.close();
                client.close();
            }
        }
        scanner.close();
    }
}
