package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

/*
    IP 操作类测试
 */
public class InetDemo {
    public static void main(String[] args) throws UnknownHostException {
        // 获取本机地址
        final InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);  //DESKTOP-7KFV87A/192.168.46.81     计算机名称/局域网类的ip地址

        // 获取本机地址 - IP地址
        System.out.println(localHost.getHostAddress()); // 192.168.46.81
        // 获取本机地址 - 计算机名称
        System.out.println(localHost.getHostName()); // DESKTOP-7KFV87A

        // 根据主机名称获取对应地址（如果不在同一个网关(同一个局域内)无法访问）
        System.out.println(InetAddress.getByName("DESKTOP-7KFV87A"));   // DESKTOP-7KFV87A/192.168.46.81
    }
}
