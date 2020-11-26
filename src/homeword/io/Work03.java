package homeword.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/*
    将文件io_work.txt文件的内容读取到控制到进行输出
 */
public class Work03 {
    public static void main(String[] args){
        FileReader fr = null;
        try{
            fr = new FileReader("io_work.txt");
            char[] chars = new char[1024];
            int len = 0;
            while((len = fr.read(chars)) != -1){
                System.out.println(new String(chars, 0, len));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
