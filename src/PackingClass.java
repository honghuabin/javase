/*
    包装类
        范围：
            针对于基本数据类型
        使用场景：
            适用于多态的情况
            集合中，我们存储数据的时候，参数的类型是一个类，或者一个对象
                此时，对于基本数据类型的存储，是无法存储的。
                这个时候，当我们传递基本数据类型的时候，实际上就向上转型
                成了对应的包装类，将基本类型包装为包装类，调用的是 类型.valueOf()方法
                当我们在使用的时候，就直接使用了存储的值，这个时候，就是
                自动拆箱，调用的方法是 值.类型Value()
 */
public class PackingClass {
    public static void main(String[] args) {
        // 基本数据包装类
        // demoBaseDataType();

        //字符串
        demoString();
    }

    /*
        字符串
            创建
                String str = "abc";
                String str = new String("abc");
            字符串的本质
                存储在堆中的常量池
                字符串的本质是字符数组或者叫做字符序列
            常用方法
                equals()：比较两个字符串内容
                charAt()：获取第N个字符
                indexOf()：获取指定字符的下标
                concat()：字符串拼接
                lengh()：字符串长度
     */
    private static void demoString() {
        String str = "abc";
        String str2 = new String("abc");
        System.out.println(str2);
        System.out.println(str == str2);    // false，因为一个是"abc"地址，一个是String对象地址
        System.out.println(str.equals(str2));   // true

        /*
            该方法调用的时候，会先根据字符串的内容去常量池里面去找有没有内容相同的常亮
            如果有，那么将会把常量池中的地址返回，如果没有这还是返回自己的地址
         */
        str2 = str2.intern();

        System.out.println(str == str2);    //
    }

    /**
     * 包装类 与 基本类型的转换
     *
     * 将包装类直接赋值实际上是执行了该包装类的valueOf()方法
     *      Integer i = 100;        => Integer i = Integer.valueOf(100);
     *      Integer.valueOf(100) 里面会判断参数100 是否在low和high的范围内，
     *              如果在就直接返回该值，
     *              如果不在就new Integer(100)，然后返回new的对象
     */
    private static void demoBaseDataType() {
        int i = 100;

        Integer i1 = 100;      // 装箱 valueOf        拆箱 intValue()
        Integer i2 = 100;
        Integer i3 = 200;
        Integer i4 = 200;
        System.out.println(i1 == i2);   // true     这里比较的值
        System.out.println(i3 == i4);   // false    这里比较的对象地址

        Double d1 = 1.0;
        Double d2 = 1.0;
        System.out.println(d1 == d2);   // false    看valueOf方法
    }
}
