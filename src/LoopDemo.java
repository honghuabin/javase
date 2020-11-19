import java.util.Scanner;

public class LoopDemo {
    public static void main(String[] args){
        //modeFive();
//        tenToTwo();
//        randEightyEight();
        sum(10);
//        subTable();
//        buyChicken();
//        fibonacci(10);
    }

    // 无限生成随机数，直到生成88就停止
    public static void randEightyEight(){
        while (true){
            int randomNum = (int)(Math.random() * 101); // 随机数范围[0, 100)，左闭右开
            System.out.println(randomNum);
            if (randomNum == 88){
                break;
            }
        }
    }

    // 打印0-1000中能被5整除的数， 一行打印三个
    public static void modeFive(){
        int count = 0;
        for(int i = 0; i < 1000; i++){
            if (i % 5 == 0){
                System.out.print(i + "\t");
                count++;
                if (count >= 3) {
                    System.out.println("");
                    count = 0;
                }
            }
        }
    }

    // 十进制转二进制
    public static void tenToTwo(){
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个整数：");
        int num = sc.nextInt();
        String result = "";
        System.out.print(num + "转化为二进制是：");
        while(num != 0) {
            result = (num % 2) + result;
            num /= 2;
        }
        System.out.print(result);
    }

    // 求从1到N的各个数字阶乘的和
    public static void sum(int num){
        int sum = 0;
        for(int i = 1; i <= num; i++){
            sum += factorial(i);
        }
        System.out.println(sum);
    }

    // 阶乘
    private static int factorial(int num){
        if (num == 1){
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    // 九九乘法表
    public static void subTable(){
        for(int i = 1; i < 10; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(i + " * " + j + " = " + (i * j) + "\t");
            }
            System.out.println();
        }
    }

    // 斐波那契数列
    public static void fibonacci(int num){
        /*
        int begin = 1;
        int last = 0;
        int result = 0;
        System.out.println(last);
        System.out.println(begin);
        for(int i = 0; i < num - 2; i++){
            result = last + begin;
            System.out.println(result);
            last = begin;
            begin = result;
        }
         */

        // 使用递归
        for (int i = 1; i <= num; i++){
            System.out.println(fibonacci1(i));
        }
    }

    // 斐波那契数列递归程序
    private static int fibonacci1(int num){
        if (num == 1){
            return 0;
        } else if (num == 2){
            return 1;
        }else{
            return fibonacci1(num - 1) + fibonacci1(num - 2);
        }
    }

    // 百钱买百鸡
    public static void buyChicken(){
        int a = 5;      // 攻击价格
        int b = 3;      // 母鸡价格
        int total = 100;
        int maxA = total / a;
        int maxB = total / b;
        for (int i = 0; i < maxA; i++) {
            for (int j = 0; j < maxB; j++){
                int moneyA = i * a;
                int moneyB = j * b;
                int numC = total - i - j;
                int moneyC = numC / 3;
                if (moneyA + moneyB + moneyC == 100 && numC % 3 == 0){
                    System.out.println("公鸡：" + i + "; 母鸡：" + j + "; 小鸡：" + numC);
                }
            }
        }
    }
}
