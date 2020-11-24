package io;
import java.io.*;

/*
    字节输入流
 */
public class InputStreamDemo {
    public static void main(String[] args) {
        demoOutputStream01();
        demoInputStream01();
    }

    /*
        输出流
            向文件中输入数据
     */
    private static void demoOutputStream01() {
        try {
            FileOutputStream fos = new FileOutputStream("test.txt");

            fos.write("这是使用demoOutputStream01输入的文字".getBytes());

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
        输入流测试demo01
     */
    public static void demoInputStream01(){
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            byte[] bytes = new byte[1024];
            for (int len = 0; (len = fis.read(bytes)) != -1;){
                System.out.println(bytes);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
