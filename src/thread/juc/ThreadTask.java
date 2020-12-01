package thread.juc;

/*
    线程执行的任务
 */
public class ThreadTask implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " running");
    }
}
