package thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
    缓存线程池
        根据需要创建线程数量，最多可以创建Integer.MAX_VALUE个
        适用于，生命周期比较短的场景，因为默认回收时间为1分钟
 */
public class NewCacheThreadPoolDemo {
    public static void main(String[] args) {
        // 创建一个线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 20; i++) {
            executorService.submit(new ThreadTask());
        }

        executorService.shutdown();
    }
}
