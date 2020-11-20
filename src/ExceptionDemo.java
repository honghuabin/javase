import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("这里来计算除法");
        try{
            System.out.println("请输入一个除数");
            int num1 = sc.nextInt();
            System.out.println("请输入被除数");
            int num2 = sc.nextInt();
            System.out.println(String.format("%d / %d = %d",
                    num1, num2, (num1/num2)));
        } catch(InputMismatchException e){
            System.out.println("输入数据错误，请输入一个数字");
            e.printStackTrace();
        } catch(ArithmeticException e){
            System.out.println("0不可以做被除数");
            e.printStackTrace();
        }catch(Exception e){   // 最大的异常放在最后，用来处理未考虑到的异常
            e.printStackTrace();
        } finally{
            System.out.println("感谢使用本程序");
        }

    }
}
