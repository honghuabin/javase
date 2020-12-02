package lambda;
import java.util.function.BiFunction;

/*
    两个输入，一个输出(输入和输出不是同一个类型)
 */
public class BiFunctionDemo {
    public static void main(String[] args) {
        BiFunction<String ,String, Integer> bf1 = (String str1, String str2) -> {return str1.length() + str1.length();};
        BiFunction<String ,String, Integer> bf2 = (str1,str2) -> {return str1.length() + str1.length();};
        BiFunction<String ,String, Integer> bf3 = (str1,str2) -> str1.length() + str1.length();
        BiFunction<String ,String, Integer> bf4 = (str1,str2) -> {return BiFunctionStrToInt(str1, str2);};
        BiFunction<String ,String, Integer> bf5 = (str1,str2) -> BiFunctionStrToInt(str1, str2);
        BiFunction<String ,String, Integer> bf6 = BiFunctionDemo::BiFunctionStrToInt;

        System.out.println(bf1.apply("abc", "123"));
        System.out.println(bf2.apply("abc", "123"));
        System.out.println(bf3.apply("abc", "123"));
        System.out.println(bf4.apply("abc", "123"));
        System.out.println(bf5.apply("abc", "123"));
        System.out.println(bf6.apply("abc", "123"));
    }

    public static int BiFunctionStrToInt(String str1, String str2){
        return str1.length() + str2.length();
    }
}
