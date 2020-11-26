package homeword.io;

import java.io.File;
import java.io.IOException;

/*
    使用File类的方法去创建一个文本文件，先进行判断，如果没有则创建，如果有则先删除在创建
 */
public class Work01 {
    public static void main(String[] args) {
        File file = new File("io_work.txt");
        if (file.exists()) {
            file.delete();
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
