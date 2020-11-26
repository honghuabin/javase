package homeword.io;

import java.io.*;
import java.util.ArrayList;

/*
    1. 创建User类，包含以下属性，并重写toString方法显示对象信息
        name:String     age:int     gender enum
    2. 使用BufferedWriter写入文件以“，”分隔
    3. 使用BufferedReader读取信息并进行分隔，还原成对象，调用对象的toString方法进行输出
 */
public class Work04 {
    public static void main(String[] args) {
        write();
        
//        read();
    }

    private static void read() {
        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader("io_work04.txt");
            br = new BufferedReader(fr);

            char[] chars = new char[1024];
            int len = 0;
            while ((len = br.read(chars)) != -1) {
                String[] strs = new String(chars, 0, len).split(",");
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static void write(){
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter("io_work04.txt");
            bw = new BufferedWriter(fw);

            ArrayList<User> arrayList = new ArrayList<User>();

            arrayList.add(new User("张三", 20, Gender.GENDER_MAN));
            arrayList.add(new User("李四", 21, Gender.GENDER_MAN));
            arrayList.add(new User("王五", 22, Gender.GENDER_MAN));
            arrayList.add(new User("赵六", 23, Gender.GENDER_WOMAN));
            bw.write(arrayList.toString());

            bw.flush();

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally{
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
