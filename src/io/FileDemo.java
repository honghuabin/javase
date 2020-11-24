package io;

import java.io.File;
import java.io.IOException;

/**
 * 文件类
 */
public class FileDemo {
    public static void main(String[] args) {
        demoFile01();
    }

    /*
        文件操作1
     */
    private static void demoFile01() {
        File file = new File("file01.txt");
        System.out.println("我只是new了一个文件对象");
        System.out.println("执行方法exists()：" + file.exists());
        try {
            // 创建文件
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("创建了文件file01.txt");
        System.out.println("执行方法exists()：" + file.exists());

        System.out.println("=====================");
        System.out.println("读取目录E:\\下的所有目录");
        readDirFiles(new File("E:\\"));

    }

    /*
        输出指定目录下面的所有文件和文件夹
     */
    private static void readDirFiles(File file){
        if (file.isDirectory()){
            File[] fileList = file.listFiles();
            for(File f:fileList){
                readDirFiles(f);
            }
        } else {
            System.out.println(file);
        }
    }
}
