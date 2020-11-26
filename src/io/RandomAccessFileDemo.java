package io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
    可以用于切割文件
        主要用于切割的方法seek(int num)  指针偏移量
 */
public class RandomAccessFileDemo {
    public static void main(String[] args) {
        // 创建文件类，获取文件
        File file = new File("readsplit.txt");
        // 获取文件字节大小
        long fileSize = file.length();
        // 定义起始读取的指针位置
        int beginPos = 0;
        // 定义一次读取的字节数
        int readSize = 1024;
        // 获取文件可以被切分成多少分(向上取整)
        int size = (int)Math.ceil(fileSize*1.0/readSize);
        System.out.printf("文件大小为%d个字节，按照%d个字节进行切割，可以切割%d份\r\n", fileSize, readSize, size);
        // 定义实际读取长度
        int actualSize = 0;
        for (int i = 0; i < size; i++){
            // 定义本次读取数据的开始文职
            beginPos = i * readSize;
            // 获取实际可读长度
            actualSize = fileSize > (beginPos + readSize) ? readSize : (int)(fileSize - beginPos);
            System.out.printf("第%d份，%d -> %d \r\n", i, beginPos, actualSize);
            readSplit(beginPos, actualSize);
        }
    }

    private static void readSplit(int beginPos, int readSize){
        RandomAccessFile randomAccessFile = null;
        try{
            randomAccessFile = new RandomAccessFile(new File("readsplit.txt"), "r");
            byte[] bytes = new byte[readSize];
            while (randomAccessFile.read(bytes) != -1) {
                System.out.println(new String(bytes, 0, readSize));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                randomAccessFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("================================");
    }
}
