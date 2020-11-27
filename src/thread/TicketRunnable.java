package thread;

/*
    购票测试
        实现Runnable接口，重写run接口

        问题：
            会出现一票多卖的情况
 */
public class TicketRunnable implements Runnable{

    private int ticket =10;

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName() + "：当前正在出售倒数第" + ticket-- + "张票");
            }
        }
    }

    public static void main(String[] args) {
        TicketRunnable ticketRunnable = new TicketRunnable();

        Thread t1 = new Thread(ticketRunnable);
        Thread t2 = new Thread(ticketRunnable);
        Thread t3 = new Thread(ticketRunnable);
        Thread t4 = new Thread(ticketRunnable);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
