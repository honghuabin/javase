package homeword;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

/*
    使用集合操作Dog
        把多个Dog的信息添加到集合中
            昵称      亲密度
            欧欧      90
            美美      100
            丽丽      89
            亚亚      99
        查看Dog的数量及所有Dog的信息
        删除集合中部分Dog的元素
            删除之后还剩两只狗狗
        判断集合中是否包含指定Dog
            集合中是否包含亚亚的信息
 */
public class CollectionDog {
    public static void main(String[] args){
        ArrayList<Dog> list = new ArrayList<>();
        // 添加狗
        Dog yaya = new Dog("亚亚", 99);
        list.add(new Dog("欧欧", 90));
        list.add(new Dog("美美", 100));
        list.add(new Dog("丽丽", 89));
        list.add(yaya);
        System.out.println("集合长度：" + list.size());
        System.out.println(list);

        // 查看狗的数量所有属性
        ListIterator<Dog> dogListIterator = list.listIterator();
        while(dogListIterator.hasNext()){
            Dog dog = dogListIterator.next();
            System.out.println(dog);

            // 删除美美
            if (dog.getName().equals("美美")){
                dogListIterator.remove();
            }
        }

        // 删除美美后的结果
        System.out.println("删除美美后的集合");
        // 循环打印，推荐这种方式
        for(Iterator iter = list.iterator(); iter.hasNext();){
            System.out.println(iter.next());
        }

        // 重新打印数据
        System.out.println("是否包含“亚亚”：" + list.contains(yaya));

    }
}
