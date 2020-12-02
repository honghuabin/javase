package lambda;

import java.util.function.Supplier;

/*
    获取
    Supplier
        T get()
 */
public class SupplierDemo {
    public static void main(String[] args) {
        // 常规lambda表达式
        Supplier<String> s1 = ()->{return "abc";};
        // 优化lambda表达式
        Supplier<String> s2 = ()->"abc";
        // 使用方法的lambda表达式
        Supplier<String> s3 = ()-> {return supplierStr();};
        // 优化使用方法的lambda表达式
        Supplier<String> s4 = ()->supplierStr();
        // 使用 类的静态方法(方法引用) 的lambda表达式
        Supplier<String> s5 = SupplierDemo::supplierStr;
        // 使用 实例化对象(方法引用) 表达式的lambda表达式
        Supplier<String> s6 = new SupplierDemo()::newSupplierStr;

        Supplier<Test1> s7 = () -> {return new Test1();};
        Supplier<Test1> s8 = () -> new Test1();
        Supplier<Test1> s9 = Test1::new;

        System.out.println(s1.get());
        System.out.println(s2.get());
        System.out.println(s3.get());
        System.out.println(s4.get());
        System.out.println(s5.get());
        System.out.println(s6.get());
    }

    public static String supplierStr(){
        return "abc";
    }

    public String newSupplierStr(){
        return "abc";
    }
}

class Test1{
    public String classSupplierStr(){
        return "abc";
    }
}