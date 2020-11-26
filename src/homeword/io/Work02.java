package homeword.io;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

/*
    使用BufferWriter将如下文字写入io_work.txt文件
    《虞美人》
    春花秋月何时了？
    往事知多少。
    小楼昨夜又东风，
    故国不堪回首月明中。
    雕栏玉彻应有在，
    只是朱颜改。
    问君能有几多愁，
    恰是一江春水向东流。
 */
public class Work02 {
    public static void main(String[] args) {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try{
            fw = new FileWriter("io_work.txt");
            bw = new BufferedWriter(fw);

            // 填写数据
            bw.write("《虞美人》\r\n");
            bw.write("春花秋月何时了？\r\n");
            bw.write("往事知多少。\r\n");
            bw.write("小楼昨夜又东风，\r\n");
            bw.write("故国不堪回首月明中。\r\n");
            bw.write("雕栏玉彻应有在，\r\n");
            bw.write("只是朱颜改。\r\n");
            bw.write("问君能有几多愁，\r\n");
            bw.write("恰是一江春水向东流。\r\n");

            bw.flush();
        } catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
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
