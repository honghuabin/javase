package homeword.collection;

import java.util.*;

/*
    使用list，map容器存放如下数据，并从map中取出“李四”
        姓名：张三   年龄：18   体重：90   地址：北京
        姓名：李四   年龄：28   体重：50   地址：上海

 */
public class Work01 {
    public static void main(String[] args) {
        // 创建数据
        Work01Person wp1 = new Work01Person("张三",18,90,"北京");
        Work01Person wp2 = new Work01Person("李四",28,50,"上海");

        System.out.println("===========ArrayList============");
        // 创建list集合
        ArrayList<Work01Person> arrayList = new ArrayList<Work01Person>();
        // list集合添加数据
        arrayList.add(wp1);
        arrayList.add(wp2);
        // list集合打印数据
        for (Iterator iterator = arrayList.iterator(); iterator.hasNext();){
            System.out.println((Work01Person)iterator.next());
        }

        System.out.println("===========HashMap============");
        // 创建map集合
        HashMap<String, Work01Person> hashMap = new HashMap<String, Work01Person>();
        // 以名称为键，添加对象数据
        hashMap.put(wp1.getName(), wp1);
        hashMap.put(wp2.getName(), wp2);
        // 打印数据
        Set<String> strings = hashMap.keySet();
        for (String str:strings){
            System.out.println(hashMap.get(str));
        }

        System.out.println("============从map中获取李四================");
        System.out.println(hashMap.get("李四"));
    }
}
