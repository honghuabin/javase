package lambda;

import java.util.function.BiConsumer;

/*
    两个输入
 */
public class BiConsumerDemo {
    public static void main(String[] args) {
        BiConsumer<String, String> bc1 = (str1, str2) -> {
            System.out.println(str1 + str2);
        };

        BiConsumer<String, String> bc2 = (str1, str2) -> System.out.println(str1 + str2);

        BiConsumer<String, String> bc3 = (str1, str2) -> {BiConsumerSout(str1, str2);};

        BiConsumer<String, String> bc4 = (str1, str2) -> BiConsumerSout(str1, str2);

        BiConsumer<String, String> bc5 = BiConsumerDemo::BiConsumerSout;

        bc1.accept("abc","123");
        bc2.accept("abc","123");
        bc3.accept("abc","123");
        bc4.accept("abc","123");
        bc5.accept("abc","123");
    }

    public static void BiConsumerSout(String str1, String str2){
        System.out.println(str1 + str2);
    }
}
