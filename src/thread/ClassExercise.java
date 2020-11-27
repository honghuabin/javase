package thread;

/*
    课堂练习
        1. 创建线程输出1~100之间的偶数，要求使用两种方式创建线程
        2. 两个线程，一个线程输出1-10，一个线程输出10-1，轮流输出
 */
public class ClassExercise{
    public static void main(String[] args) {
//        exerciseOne();

        execriseTwo();
    }

    // 课堂练习一
    private static void exerciseOne(){
        ClassExercise.PrintDouble01 printDouble01 = new ClassExercise().new PrintDouble01();
        printDouble01.start();

        ClassExercise.PrintDouble02 printDouble02 = new ClassExercise().new PrintDouble02();
        Thread thread = new Thread(printDouble02);
        thread.start();
    }

    // 课堂练习二
    private static void execriseTwo(){
        ClassExercise.OneToTen oneToTen = new ClassExercise().new OneToTen();
        new Thread(oneToTen).start();

        ClassExercise.TenToOne tenToOne = new ClassExercise().new TenToOne();
        new Thread(tenToOne).start();
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

    // 1 - 10
    class OneToTen implements Runnable{
        @Override
        public void run() {
            for (int i = 1; i < 11; i++) {
                System.out.println(Thread.currentThread().getName() + "=======" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 10 - 1
    class TenToOne implements Runnable{
        @Override
        public void run() {
            for (int i = 10; i > 0; i--) {
                System.out.println(Thread.currentThread().getName() + "=======" + i);
                try {
                    Thread.sleep(1010);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
