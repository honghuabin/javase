package collection;

import java.util.ArrayList;
import java.util.LinkedList;

/*
    List
        ArrayList
        LinkedList
 */
public class ListDemo {
    public static void main(String[] args) {
//        demoArrayList();
        demoLinkedList();
    }

    /*
        Arraylist额外方法演示
            存在于Collection里面的方法不重复演示
            实现了长度可变的数组，在内存中分配连续的空间
            优点：
                遍历元素和随机访问元素的效率比较高
            缺点：
                添加和删除需要大量移动元素效率低，
                按照内容查询效率低
     */
    private static void demoArrayList() {
        ArrayList<Object> list = new ArrayList<>();

        list.add("abc");
        list.add(123);
        list.add(false);
        System.out.println(list);

        // 使用set修改值
        list.set(2, true);
        System.out.println(list);
    }

    /*
        LinkedList额外方法演示
            采用链表存储方式
            优点：插入、删除元素时效率比较高
            缺点：遍历和随机访问元素效率低下
     */
    private static void demoLinkedList(){
        LinkedList linkedList = new LinkedList();

        linkedList.add("abc");
        linkedList.add(456);
        linkedList.add('a');
        linkedList.add(false);
        System.out.println(linkedList);

        // 使用addFirst
        linkedList.addFirst("addFirst");
        System.out.println("addFirst(): " + linkedList);

        // 使用addLast
        linkedList.addLast("addLast");
        System.out.println("addLast(): " + linkedList);

        // getFirst() 和 getLast()：获取第一个和最后一个
        System.out.println("getFirst():" + linkedList.getFirst());
        System.out.println("getLast():" + linkedList.getLast());

        // offset()：将数据添加到最后
        System.out.println("offset('b'): " + linkedList.offer('b'));
        System.out.println(linkedList);

        // offerFirst() 和 offerLast()：添加到第一个和最后一个
        linkedList.offerFirst("offerFirst");
        System.out.println("offerFirst(): " + linkedList);
        linkedList.offerLast("offerLast(): " + "offerLast");
        System.out.println(linkedList);

        // peek()：获取第一个元素，不会从链表中山喊出
        System.out.println("peek(): " + linkedList.peek());
        System.out.println(linkedList);

        // poll()：获取第一个元素，并且从列表中删除
        System.out.println("poll(): " + linkedList.poll());
        System.out.println(linkedList);

        // pop()：返回并删除链表中第一个元素
        System.out.println(linkedList.pop());
        System.out.println(linkedList);

        // push(): 从头部加入元素
        linkedList.push("push");
        System.out.println(linkedList);

        // set()：修改指定位置的元素
        linkedList.set(2, "set");
        System.out.println(linkedList);

    }
}
