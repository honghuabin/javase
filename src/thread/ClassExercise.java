package thread;

/*
    课堂练习
        1. 创建线程输出1~100之间的偶数，要求使用两种方式创建线程
 */
public class ClassExercise{
    public static void main(String[] args) {
        ClassExercise.PrintDouble01 printDouble01 = new ClassExercise().new PrintDouble01();
        printDouble01.start();

        ClassExercise.PrintDouble02 printDouble02 = new ClassExercise().new PrintDouble02();
        Thread thread = new Thread(printDouble02);
        thread.start();
    }

    public void printDouble(){
        for (int i = 2; i < 101; i += 2) {
            System.out.println(Thread.currentThread().getName() + "：" + i);
        }
    }

    /*
        采用继承Thread方式输出1~100中的偶数
     */
    class PrintDouble01 extends Thread{

        @Override
        public void run() {
            printDouble();
        }

    }

    class PrintDouble02 implements Runnable{

        @Override
        public void run() {
            printDouble();
        }
    }
}
