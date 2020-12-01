package thread.juc;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/*
    定时执行线程池
 */
public class ScheduledThreadPoolDemo {
    public static void main(String[] args) {
//        methodSchedule();

        methodScheduleAtFixedRate();;
    }

    private static void methodSchedule(){
        System.out.println(System.currentTimeMillis());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // 执行的任务，延迟多少单位执行，单位是什么
        for (int i = 0; i < 20; i ++)
            scheduledExecutorService.schedule(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis() + " --- 延迟1秒执行");
                }
            }, 1, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();
    }

    private static void methodScheduleAtFixedRate(){
        System.out.println(System.currentTimeMillis());
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

        // 执行的任务，延迟多少单位执行，然后每间隔多少单位再执行，单位是什么
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "===" + System.currentTimeMillis() + " --- 延迟1秒执行，然后每3秒执行一次");
            }
        }, 1,3, TimeUnit.SECONDS);

        // 不能shutdow。shutdown就直接关闭了
//        scheduledExecutorService.shutdown();
    }
}
