import homeword.Student;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionDemo {
    public static void main(String[] args) {
        // 常规使用
//        demo1();

        // 演示finally
//        System.out.println(demoFinally01());
//        System.out.println(demoFinally02());
        System.out.println(demoFinally03());

    }

    /*
        finally使用1
            finally中使用return，修改try中的返回值
            因为finally代码必然会被执行，虽然之前try中执行了return，但是会被暂时搁置
            然而在finally中执行了return，此时就返回了，
            可以理解为，try中的return代码在finally中return后执行
     */
    private static int demoFinally01() {
        // return 结果是 11
        int num = 10;
        try{
            return num;
        }catch(Exception e){
            e.printStackTrace();
        } finally {
            num++;
            return num;     // finally代码必定会被执行，在执行的时候，这里提前return了，所以try中的return就不会被执行了
        }
    }

    /*
        finally 使用2
            finally不使用return，修改try中return的变量
     */
    private static Student demoFinally02(){
        Student stu = new Student("zhansan", 13);
        try{
            return stu;
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            stu.setAge(15);
        }
        return stu;
    }

    /*
        finally 使用3
            finally不使用return，修改try中return的变量
            这里是返回13，而不是15
            原因是因为，try中先执行了getAge()的代码，拿到了结果值进行了存储，所以finally中的修改不生效
            如果返回的是应用，那么返回的是地址，修改的是地址里面的内容，所以在根据地址打印，打印的就是修改后的结果
     */
    private static int demoFinally03(){
        Student stu = new Student("zhansan", 13);
        try{
            return stu.getAge();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            stu.setAge(15);
        }
        return stu.getAge();
    }

    // 常规使用
    public static void demo1(){
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
