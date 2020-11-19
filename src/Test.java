import homeword.Student;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        System.out.println("hello world");

        int a = 1;
        System.out.println(++a + a++);

        System.out.println(~4);

        int[] arr = {1,2,3,4};
        System.out.println(Arrays.toString(arr));
        testArr(arr);
        System.out.println(Arrays.toString(arr));

        Student stu = new Student("张三", 28);
        System.out.println(stu.toString());
        testObj(stu);
        System.out.println(stu.toString());
    }

    // 测试传递的是值还是引用
    // 传递的是数组，那么修改会影响数组的值
    // 传递的是对象，那么修改也会对象的属性
    // 因为引用作为参数传递，传递过来的是地址值
    // 基本类型作为参数传递，传递的是值
    public static void testArr(int[] arr){
        arr[0] = 11;
    }

    public static void testObj(Student stu){
        stu.setName("李四");
        stu.setAge(30);
    }

    // 测试重载
    public void reload(){
        System.out.println("测试重载原始方法");
    }

    public void reload(int a){
        System.out.println("带参数重载" + a);
    }

    public void reload(String a){
        System.out.println("不同类型参数重载" + a);
    }

    public void reload(int a, String b){
        System.out.println("参数个数不同重载" + a + b);
    }

    public void reload(String b, int a){
        System.out.println("参数个数相同，类型顺序不同重载" + a + b);
    }
}
