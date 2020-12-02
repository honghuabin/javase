package lambda;

import java.util.function.Function;

/*
    代表一个输入，一个输出(输入输出不同类型)
 */
public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> f1 = (str) -> {return str.length();};
        Function<String, Integer> f2 = str -> {return str.length();};
        Function<String, Integer> f3 = str -> str.length();
        Function<String, Integer> f4 = (str) -> {return functionStringToInt(str);};
        Function<String, Integer> f5 = str -> {return functionStringToInt(str);};
        Function<String, Integer> f6 = str -> functionStringToInt(str);
        Function<String, Integer> f7 = FunctionDemo::functionStringToInt;

        System.out.println(f1.apply("abcdefg"));
        System.out.println(f2.apply("abcdefg"));
        System.out.println(f3.apply("abcdefg"));
        System.out.println(f4.apply("abcdefg"));
        System.out.println(f5.apply("abcdefg"));
        System.out.println(f6.apply("abcdefg"));
        System.out.println(f7.apply("abcdefg"));
    }

    public static int functionStringToInt(String str){
        return str.length();
    }
}
