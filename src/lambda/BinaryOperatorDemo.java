package lambda;

import java.util.function.BinaryOperator;

public class BinaryOperatorDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> b1 = (num1, num2) -> {return num1 + num2;};
        BinaryOperator<Integer> b2 = (num1, num2) -> num1 + num2;
        BinaryOperator<Integer> b3 = (num1, num2) -> BinaryOperatorInt(num1, num2);
        BinaryOperator<Integer> b4 = BinaryOperatorDemo::BinaryOperatorInt;

        System.out.println(b1.apply(123, 123));
        System.out.println(b2.apply(123, 123));
        System.out.println(b3.apply(123, 123));
        System.out.println(b4.apply(123, 123));
    }

    public static int BinaryOperatorInt(int num1, int num2){
        return (num1 + num2) << 1;
    }
}
