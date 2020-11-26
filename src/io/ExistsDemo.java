package io;

import java.io.*;

/*
    接收命令行输入的信息，只要不是输入的“exit”就同样输出
 */
public class ExistsDemo {
    public static void main(String[] args) {
        try(
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(System.out);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        ){
            String str = null;
            while(!(str = bufferedReader.readLine()).equals("exit")){
                bufferedWriter.write(str);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
