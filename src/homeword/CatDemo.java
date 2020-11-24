package homeword;

import java.util.Comparator;
import java.util.HashSet;
import java.util.TreeSet;

public class CatDemo{
    public static void main(String[] args) {
        HashSet<Cat> hs = new HashSet<Cat>();
        hs.add(new Cat("美美",3));
        hs.add(new Cat("丽丽",2));
        hs.add(new Cat("亚亚",4));
        hs.add(new Cat("美美",3));
        hs.add(new Cat("亚麻跌",5));

        System.out.println(hs);
        System.out.println("================");
        System.out.println("按照名称排序");
        TreeSet<Cat> treeSet = new TreeSet<>();
        treeSet.addAll(hs);
        System.out.println(treeSet);

        System.out.println("==================");
        System.out.println("先按名称长度，在按名称");
        TreeSet<Cat> cats = new TreeSet<Cat>(new Comparator<Cat>() {
            @Override
            public int compare(Cat o1, Cat o2) {
                if (o1.getName().length() == o2.getName().length()){
                    // 长度相同，比较名称
                    return o1.getName().compareTo(o2.getName());
                } else {
                    // 长度不同，根据长度
                    return o2.getName().length() - o1.getName().length();
                }
            }
        });
        cats.addAll(hs);
        System.out.println(cats);
    }
}
