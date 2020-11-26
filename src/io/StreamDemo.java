package io;
import java.io.*;

/*
    字节输入流
 */
public class StreamDemo {
    public static void main(String[] args) {
//        demoOutputStream01();
//        demoInputStream01();
        
//        demoCopyContent01();

        demoByteArrayInputStream();
    }

    /*
        字节操作输入流
     */
    private static void demoByteArrayInputStream() {
        ByteArrayInputStream byteArrayInputStream = null;
        try {
            byteArrayInputStream = new ByteArrayInputStream(new FileInputStream("test.txt").readAllBytes());
            byte[] bytes = new byte[1024];
            int len = 0;
            while ((len = byteArrayInputStream.read(bytes)) != -1){
                System.out.println(new String(bytes, 0 , len));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                byteArrayInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        复制文件内容
     */
    private static void demoCopyContent01(){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try{
            fis = new FileInputStream("test.txt");
            fos = new FileOutputStream("copy.txt");
            // 输入流读取文件
            byte[] bytes = new byte[1024];
            for (int len = 0; (len = fis.read(bytes)) != -1;){
                fos.write(bytes, 0, len);
            }
            // 这里不用关闭文件，因为我这种将输入输出流对象创建try()里面的写法，会自动关闭
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("内容复制完毕");
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
        System.out.println("执行读取数据的方法");
        try {
            FileInputStream fis = new FileInputStream("test.txt");
            byte[] bytes = new byte[1024];
            for (int len = 0; (len = fis.read(bytes)) != -1;){
                System.out.println(new String(bytes,0,len));
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("数据读取完毕");
    }
}
