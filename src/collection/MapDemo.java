package collection;

import java.util.*;

/*
    Map例子
 */
public class MapDemo {
    public static void main(String[] args) {
        System.out.println(17 % 8);
        System.out.println(17 & 7);
//        demoHashMap01();

//        demoHashTable01();
    }

    /*
        HashMap
            JDK1.7 里面数据结构是 数组 + 链表
            JDK1.8 里面数据结构是 数组 + 链表 + 红黑树
            特点：
                key无序，唯一（Set）
                value无序，不唯一（Collection）
                允许null为键
                允许null为值
                线程不安全，效率高
                初始容量为：16（1 << 4） DEFAULT_INITIAL_CAPACITY
                最大容量为：2^30（1 << 30） MAXIMUM_CAPACITY
                动态扩容偏移量：0.75f 表示，当容量达到当前总容量的0.75的时候，进行扩容
                在创建HashMap的时候，并没有开辟空间，在put的时候，才开辟了空间
     */
    public static void demoHashMap01(){
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put("name", "huabin.hong");
        hashMap.put("sex","男");
        hashMap.put("age","29");
        System.out.println(hashMap);

        // containsKey, containsValue
        System.out.println("========containsKey/Value()=========");
        System.out.println("hashMap，containsKey(name):" + hashMap.containsKey("name"));
        System.out.println("hashMap，containsValue(huabin.hong):" + hashMap.containsValue("huabin.hong"));

        // entry直接得到全部结果，然后可以循环获取对应每行
        System.out.println("========entrySet()=========");
        Set<Map.Entry<String, String>> entries = hashMap.entrySet();
        System.out.println(entries);
        for (Iterator<Map.Entry<String, String>> iterator = entries.iterator(); iterator.hasNext();){
            Map.Entry<String, String> next = iterator.next();
            System.out.println(next.getKey() + " = " + next.getValue());
        }

//        for (Map.Entry<String, String> entry : entries) {
//            System.out.println(entry);
//        }

        System.out.println("=========clone()===========");
        Object clone = hashMap.clone();
        System.out.println(clone);

        System.out.println("=========equals(clone)==========");
        System.out.println(hashMap.equals(clone));
        Map<String,String> clone1 = (Map<String,String>)clone;

        System.out.println("========get(name)==========");
        System.out.println(hashMap.get("name"));

        System.out.println("========keySet()=============");
        Set<String> strings = hashMap.keySet();
        System.out.println(strings);
        for (Iterator<String> stringIterator = strings.iterator(); stringIterator.hasNext();){
            String key = stringIterator.next();
            System.out.println(key + " = " + hashMap.get(key));
        }

        System.out.println("=======remove(age)========");
        hashMap.remove("age");
        System.out.println(hashMap);

        System.out.println("========size()===========");
        System.out.println(hashMap.size());

        System.out.println("========values()==========");
        System.out.println(hashMap.values());

        System.out.println("=======设置null为键值======");
        hashMap.put(null, null);
        System.out.println(hashMap);
        hashMap.put(null, "123");
        System.out.println(hashMap);
        hashMap.put("null", "45");
        hashMap.put("null1", null);
        System.out.println(hashMap);

        System.out.println("========clear()==========");
        hashMap.clear();
        System.out.println("执行clear()之后：" + hashMap);
    }

    /*

     */
    public static void demoHashTable01(){
        Hashtable ht = new Hashtable();
        ht.put("one",1);
        ht.put(2,"two");
        ht.put("three",4);
        ht.put("isEmpty",false);
        ht.put("four",4);
//        ht.put(null,null);    // 编译不会报错，运行会报错，在运行的时候，做了相关检测
        System.out.println(ht);

        System.out.println("执行contains(1): " + ht.contains(1));
        System.out.println("执行containsKey(three)：" + ht.containsKey("three"));
        System.out.println("执行containsKey(three1)：" + ht.containsKey("three1"));

        System.out.println("== 执行 elements() 将返回的枚举类型进行打印=====");
        for (Enumeration elements = ht.elements();elements.hasMoreElements();){
            System.out.println(elements.nextElement());
        }

        System.out.println("== 执行 entrySet() ===========");
        Set set = ht.entrySet();        // 本身返回的是一个map
        System.out.println(set);
        for (Iterator iterator = set.iterator(); iterator.hasNext();){
            System.out.println(iterator.next());
        }
    }
}
