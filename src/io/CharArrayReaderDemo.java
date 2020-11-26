package io;

import java.io.CharArrayReader;
import java.io.IOException;

public class CharArrayReaderDemo {
    public static void main(String[] args) {
        CharArrayReader charArrayReader = new CharArrayReader("马士兵教育".toCharArray());
        int read = 0;
        try {
            read = charArrayReader.read();
            if (read != -1 ) {
                System.out.println((char) read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayReader.close();
        }
    }
}
