package collection;

import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args) {
//        demo01();

        demo02();
    }

    private static void demo01(){
        HashSet hs = new HashSet();

        // 在没有对Person 编写hashCode() 和 equals() 方法的时候，是无法判断是否存在重复
        hs.add(new Person("张三", 20));
        hs.add(new Person("李四", 22));
        hs.add(new Person("王五", 23));
        // 编写hashCode和equals方法后，会被判断为重复
        // 在hashCode相同的情况下，会再去执行判断euqals
        boolean repeatRs = hs.add(new Person("李四", 22));
        System.out.println(repeatRs);
        System.out.println(hs);
    }

    private static void demo02(){
        HashSet<Staff> hs = new HashSet<>();

        // 添加数据
        hs.add(new Staff("李默文", 22,"1002"));
        Staff wxh = new Staff("王小华", 20, "1001");
        hs.add(wxh);
        hs.add(new Staff("张一慢", 24,"1003"));

        // 员工人数
        System.out.println("本单位共有员工人数为：" + hs.size());
        System.out.println("人员内容分别如下（增强for输出）");

        // 输出员工信息
        for (Staff h : hs) {
            System.out.println(h.getNo() + "\t" + h.getName() + "\t" + h.getAge());
        }
        System.out.println("人员内容分别如下（for循环迭代器输出)");
        for (Iterator<Staff> iterator = hs.iterator(); iterator.hasNext();){
            Staff tmp = iterator.next();
            System.out.println(tmp.getNo() + "\t" + tmp.getName() + "\t" + tmp.getAge());
        }
        System.out.println("=======================");
        hs.remove(wxh);
        System.out.println("删除离职员工王小华后");
        System.out.println("本单位共有员工人数：" + hs.size());
        System.out.println("人员内容分别如下（for循环迭代器输出)");
        for (Iterator<Staff> iterator = hs.iterator(); iterator.hasNext();){
            Staff tmp = iterator.next();
            System.out.println(tmp.getNo() + "\t" + tmp.getName() + "\t" + tmp.getAge());
        }
        System.out.println("=======================");
        System.out.println("判断张一慢是否存在");
        System.out.println(hs.contains(new Staff("张一慢",24,"1003")) ? "存在该员工" : "不存在该员工");
    }
}
