package lambda;

import java.util.function.UnaryOperator;

/*
    一个输入一个输出(输入输出是相同类型)
 */
public class UnaryOperatorDemo {
    public static void main(String[] args) {
        UnaryOperator<Integer> u1 = (a) -> {return a << 2;};
        UnaryOperator<Integer> u2 = a -> {return a << 2;};
        UnaryOperator<Integer> u3 = (a) -> a << 2;
        UnaryOperator<Integer> u4 = a -> a << 2;
        UnaryOperator<Integer> u5 = (a) -> {return UnaryOperatorInt(a);};
        UnaryOperator<Integer> u6 = a -> {return UnaryOperatorInt(a);};
        UnaryOperator<Integer> u7 = (a) -> UnaryOperatorInt(a);
        UnaryOperator<Integer> u8 = a -> UnaryOperatorInt(a);
        UnaryOperator<Integer> u9 = UnaryOperatorDemo::UnaryOperatorInt;

        System.out.println(u1.apply(2));
        System.out.println(u2.apply(2));
        System.out.println(u3.apply(2));
        System.out.println(u4.apply(2));
        System.out.println(u5.apply(2));
        System.out.println(u6.apply(2));
        System.out.println(u7.apply(2));
        System.out.println(u8.apply(2));
        System.out.println(u9.apply(2));
    }

    public static int UnaryOperatorInt(int num){
        return num << 1;
    }
}
