package homeword;
import java.util.InputMismatchException;
import java.util.Scanner;

/*
    演示Exception的使用
 */
public class Exercise {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("请输入课程编号：");
        try{
            int num = sc.nextInt();
            switch (num){
                case 1:
                    System.out.println("java");
                    break;
                case 2:
                    System.out.println("php");
                    break;
                case 3:
                    System.out.println("python");
                    break;
                default:
                    throw new ClassNumNotFountException();
            }
        } catch (InputMismatchException e) {
            System.out.println("请输入编号");
            e.printStackTrace();
        } catch (ClassNumNotFountException e){
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            System.out.println("欢迎选课");
        }
    }
}
