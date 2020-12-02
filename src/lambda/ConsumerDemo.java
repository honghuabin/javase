package lambda;

import java.util.function.Consumer;

/*
    Consumer
        代表一个输入
 */
public class ConsumerDemo {
    public static void main(String[] args){
        Consumer<String> c1 = (str) -> {
            System.out.println(str);
        };

        Consumer<String> c2 = str -> {
            System.out.println(str);
        };

        Consumer<String> c3 = str -> System.out.println(str);

        Consumer<String> c4 = str -> consumerSout(str);

        Consumer<String> c5 = ConsumerDemo::consumerSout;

        Consumer<Test2> c6 = (Test2 t) -> {t.fun();};
        Consumer<Test2> c7 = (Test2 t) -> {new Test1().classSupplierStr();};    // 注意，可以不使用传递的参数
        Consumer<Test2> c8 = t -> new Test2().fun();
        Consumer<Test2> c9 = Test2::fun;

        c1.accept("abc");
        c2.accept("abc");
        c3.accept("abc");
        c4.accept("abc");
        c5.accept("abc");
    }

    public static void consumerSout(String str){
        System.out.println(str);
    }
}

class Test2{
    public void fun(){
        System.out.println("fun...");
    }
}
