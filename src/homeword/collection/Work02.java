package homeword.collection;

import java.util.*;

/*
    假如有以下email数据
        aa@sohu.com bb@163.com  cc@sina.com ..
        现在需要吧email中的用户部分和邮件地址部分分离
        分离后以键值对的方式放入HashMap

 */
public class Work02 {
    public static void main(String[] args) {
        // 创建一个字符串数组存储需要转换的数据
        String[] str = {"aa@sohu.com", "bb@163.com", "cc@sina.com"};

        // 创建一个HashMap对象
        HashMap<String, String> hashMap = new HashMap<String, String>();

        // 循环数组
        for (String s:str){
            System.out.println(s);
            // 根据@拆分字符串
            String[] tmp = s.split("@");
//            System.out.println(Arrays.toString(tmp));
            // 将名称作为键，存放入HashMap
            hashMap.put(tmp[0],s);
        }

        // 循环输出hashMap存放的值
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        for (Iterator<Map.Entry<String, String>> iterator = entries.iterator(); iterator.hasNext();){
            Map.Entry<String, String> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }
}
