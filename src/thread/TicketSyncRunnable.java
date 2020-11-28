package thread;

/*
    购票测试
        实现Runnable接口，重写run接口

        问题：
            会出现一票多卖的情况
 */
public class TicketSyncRunnable implements Runnable{

    private int ticket =10;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 同步代码块
//            synchronized (this){
//                if (ticket > 0){
//                    System.out.println(Thread.currentThread().getName() + "：当前正在出售倒数第" + ticket-- + "张票");
//                }
//            }

            // 同步方法
            runInfo();
        }
    }

    /*
        同步方法，将同步执行的代码，放入一个方法中
            与同步代码块的区别，不需要在指定this了
     */
    public synchronized void runInfo(){
        if (ticket > 0){
            System.out.println(Thread.currentThread().getName() + "：当前正在出售倒数第" + ticket-- + "张票");
        }
    }

    public static void main(String[] args) {
        TicketSyncRunnable ticketRunnable = new TicketSyncRunnable();

        Thread t1 = new Thread(ticketRunnable, "A");
        Thread t2 = new Thread(ticketRunnable, "B");
        Thread t3 = new Thread(ticketRunnable, "C");
        Thread t4 = new Thread(ticketRunnable, "D");

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
