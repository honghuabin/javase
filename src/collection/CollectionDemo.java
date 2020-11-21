package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/*
    集合最高父类接口：Collection (java.util.Collection)、Map(java.util.Map)
        Collection：存储的不唯一，无序的数据
            List：添加的数据是有序、不唯一的数据；即保留插入顺序，允许重复数据
                ArrayList：默认长度10
                LinkedList
            Set：添加的数据是无序的，唯一的数据
                HashSet
                TreeSet
                LinkedHashSet
        Map：存储的键值对数据，提供key到value的映射
            HashMap
            LinkedHashMap
            HashTable
            TreeMap
        方法：
            ... 见API文档

 */
public class CollectionDemo {
    public static void main(String[] args) {
        Collection c = new ArrayList<>();
        Collection c1 = new ArrayList();

        // add(E e)：添加数据
        c.add(1);   // 基本类型会自动装箱和拆箱
        c.add(1.1);
        c.add(true);
        c.add("abc");
        c.add('z');

        c1.add(11);
        c1.add(1.2);
        c1.add(false);
        c1.add("def");
        System.out.println("c与c1都执行add操作");
        System.out.println("c: " + c);
        System.out.println("c1: " + c1);
        System.out.println("================");

        // addAll(Collection<? extends E> c), 添加一个集合
        c.addAll(c1);
        System.out.println("c执行addAll(c1)操作");
        System.out.println("c: " + c);
        System.out.println("================");

        // clear()：清空操作
//        System.out.println("执行clear操作");
//        c.clear();
//        System.out.println(c);
//        System.out.println("================");

        // contains(Object o)：判断集合中是否包含某一个对象
        System.out.println("c集合中是否包含\"a\"：" + c.contains("a"));
        System.out.println("c集合中是否包含\"abc\"：" + c.contains("abc"));
        System.out.println("================");

        // containsAll(Collection<?> c)：判断集合是否全部包含另一个集合中的所有元素
        System.out.println("c是否包含全部c1的元素" + c.containsAll(c1));
        System.out.println("c1是否包含全部c的元素" + c1.containsAll(c));
        System.out.println("================");

        // equals(Object o)：
        System.out.println("c和c1执行equals：" + c.equals(c1));
        System.out.println("c和c执行equals：" + c.equals(c));
        System.out.println("================");

        // remove(Object o)：移除某一个元素
        c.remove("def");
        System.out.println("c执行remove(\"def\")：" + c);
        System.out.println("================");

        // removeAll(Collection<?> c)；移除指定集合中包含的元素
//        c.removeAll(c1);
//        System.out.println("c执行removeAll(c1): " + c);
//        System.out.println("================");

        // retainAll(Collection<?> c)：只保留与另一个集合中相同的元素
        c.retainAll(c1);
        System.out.println("c执行retainAll(c1)：" + c);
        System.out.println("================");

        // toArray()：集合转数组  -   这里会出现同一个数组中存放不同类型的元素
        Object[] objects = c.toArray();
        System.out.println("c执行toArray():" + Arrays.toString(objects));

    }
}
