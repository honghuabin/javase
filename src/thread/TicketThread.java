package thread;

/*
    购票测试
        继承Thread，重写run接口

        问题：
            会出现一票多卖的情况
            需要将公共变量定义为static属性
 */
public class TicketThread extends Thread{

    private static int ticket =10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "：当前正在出售倒数第" + ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketThread t1 = new TicketThread();
        TicketThread t2 = new TicketThread();
        TicketThread t3 = new TicketThread();
        TicketThread t4 = new TicketThread();

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
