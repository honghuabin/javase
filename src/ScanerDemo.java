import java.util.Scanner;

public class ScanerDemo {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("请输入一个数字：");

        /**
        int num = 0;
        boolean isNum = false;
        while(!isNum){
            try{
                num = sc.nextInt(); // 获取下一个标记的整形数据
                isNum = true;
            } catch(Exception e){
                sc.nextLine();      // 注意这一行，为了确保可以继续接收数据
                System.out.println("你输入的不是数字！");
                System.out.print("请输入一个数字：");
            }
        }
         */

        while(!sc.hasNextInt()){
            sc.nextLine();      // 将游标下移，用于获取下一次输入
            System.out.println("你输入的不是数字");
            System.out.print("请输入一个数字：");
        }
        int num = sc.nextInt();
        sc.close();
        System.out.println("你输入的数字是：" + num);
    }
}
