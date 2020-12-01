package net.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

import net.common.LoginUser;
import net.common.ApiResult;

/*
    登录服务端
        服务器不间断接收用户登录请求
        对接收到的序列化数据进行反序列化，并验证
        提示验证结果，不结束进程
        1. 采用while(true)方法进行实现
        2. 采用多线程方法进行实现

 */
public class LoginServer {
    private ServerSocket serverSocket;

    public static void main(String[] args) throws IOException {
        new LoginServer().start();
    }

    public void start() throws IOException {
        // 创建服务器对象
        serverSocket = new ServerSocket(10089);
        System.out.println("服务器启动，监听端口：" + 10089);

        // 死循环保证不退出服务器服务
        while(true){
            // while true方法
//            whileTrue();

            // 多线程方法
            threadMethod();
        }
//        serverSocket.close();
    }

    /*
        采用whileTrue方法进行处理
     */
    private void whileTrue() throws IOException{
        // 获取客户端连接
        Socket client = serverSocket.accept();

        // 获取客户端输入流
        InputStream inputStream = client.getInputStream();
        // 获取客户端输出流
        OutputStream outputStream = client.getOutputStream();

        // 将获取的数据反序列化
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        // 将输出的数据序列化
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // 初始化登录结果
        ApiResult apiResult = new ApiResult(0,"登录失败");


        // 将读取的数据强转为指定对象
        try {
            LoginUser loginUser = (LoginUser)objectInputStream.readObject();

            // 对账号密码进行验证
            if (loginUser.getAccount().equals("msb") && loginUser.getPassword().equals("msb")) {
                System.out.println("欢迎用户：" + loginUser.getAccount());
                apiResult.setCode(200);
                apiResult.setMsg("登录成功");
            }

            // 告诉客户端登录结果
            objectOutputStream.writeObject(apiResult);
            // 通知客户端服务端 已经发送数据完毕
            client.shutdownOutput();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            apiResult.setMsg(e.getMessage());
        } finally {
            // 释放资源
            objectOutputStream.close();
            outputStream.close();
            objectInputStream.close();
            inputStream.close();
            client.close();
        }
    }

    /*
        采用多线程方法
     */
    private void threadMethod(){
        new Thread(new clientThread()).start();
    }

    /*
        内中类的方式来写多线程
     */
    class clientThread implements Runnable{
        @Override
        public void run(){
            // 获取客户端连接
            Socket client = null;
            InputStream inputStream = null;
            OutputStream outputStream = null;
            ObjectInputStream objectInputStream = null;
            ObjectOutputStream objectOutputStream = null;

            // 初始化登录结果
            ApiResult apiResult = new ApiResult(0,"登录失败");
            try {
                client = serverSocket.accept();
                // 获取客户端输入流
                inputStream = client.getInputStream();
                // 获取客户端输出流
                outputStream = client.getOutputStream();

                // 将获取的数据反序列化
                objectInputStream = new ObjectInputStream(inputStream);
                // 将输出的数据序列化
                objectOutputStream = new ObjectOutputStream(outputStream);

                // 读取数据
                LoginUser loginUser = (LoginUser)objectInputStream.readObject();

                // 对账号密码进行验证
                if (loginUser.getAccount().equals("msb") && loginUser.getPassword().equals("msb")) {
                    System.out.println("欢迎用户：" + loginUser.getAccount());
                    apiResult.setCode(200);
                    apiResult.setMsg("登录成功");
                }

                // 告诉客户端登录结果
                objectOutputStream.writeObject(apiResult);
                // 通知客户端服务端 已经发送数据完毕
                client.shutdownOutput();
            } catch (IOException e) {
                e.printStackTrace();
                apiResult.setMsg(e.getMessage());
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                apiResult.setMsg(e.getMessage());
            } finally {
                // 释放资源
                try {
                    objectOutputStream.close();
                    outputStream.close();
                    objectInputStream.close();
                    inputStream.close();
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
