package io;

import java.io.CharArrayWriter;
import java.io.IOException;

public class CharArrayWriterDemo {
    public static void main(String[] args) {
        CharArrayWriter charArrayWriter = new CharArrayWriter();
        try {
            charArrayWriter.write("abc");
            charArrayWriter.write("def");
            charArrayWriter.append('g');
            System.out.println(charArrayWriter);;
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            charArrayWriter.close();
        }
    }
}
