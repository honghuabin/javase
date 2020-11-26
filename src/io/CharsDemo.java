package io;

import java.io.*;

/*
    字符操作
 */
public class CharsDemo {
    public static void main(String[] args){
        //demoFileWriter01();
//        dmeoFileReader01();

//        demoOutputStreamWriter01();
        demoOutputStreamReader01();
    }

    /*
        指定编码读取文件内容
     */
    private static void demoOutputStreamReader01() {
        InputStreamReader isr = null;
        try{
            // 实例化对象，需要穿第一个输出流，并指定编码
            isr = new InputStreamReader(new FileInputStream("outputStreamWriter.txt"), "GBK");
            int len = 0;
            char[] chars = new char[1024];
            while ((len = isr.read(chars)) != -1) {
                System.out.println(new String(chars, 0, len));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                isr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("指定编码utf-8格式读取数据写入完毕");
    }

    /*
        指定编码向文件写入内容
     */
    private static void demoOutputStreamWriter01() {
        OutputStreamWriter osw = null;
        try{
            // 实例化对象，需要穿第一个输出流，并指定编码
            osw = new OutputStreamWriter(new FileOutputStream("outputStreamWriter.txt"), "GBK");
            osw.write(99);
            osw.write("输入中文\r\n");
            osw.write(380+"\r\n");
            osw.write("abcdefg+r+n", 0, 5);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                osw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("指定编码utf-8格式的数据写入完毕");
    }

    /*
        写入文件
     */
    private static void demoFileWriter01() {
        FileWriter fw = null;
        try {
            fw = new FileWriter("chars.txt");
            fw.write("我现在是在使用Writer\r\n");
            fw.write("换行写入测试");

            fw.flush();
        }catch(IOException e){
            e.printStackTrace();
        } finally{
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /*
        读取文件
     */
    private static void dmeoFileReader01() {
        FileReader fr = null;
        try{
            fr = new FileReader("chars.txt");
            char[] chars = new char[1024];
            int len = 0;
            while((len = fr.read(chars)) != -1){
                System.out.println(new String(chars,0,len));
            }
        } catch(IOException e){
            e.printStackTrace();
        }finally {
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("数据读取完毕");
    }
}
