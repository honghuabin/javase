package thread;

/*
    基本多线程
 */
public class SimpleThreadDemo extends Thread{
    public static void main(String[] args) {

        // 启动一个线程
        SimpleThreadDemo simpleThreadDemo = new SimpleThreadDemo();
        simpleThreadDemo.start();

        // 主线程继续运行
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "-----------" + i);
        }
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "==========" + i);
        }
    }
}
