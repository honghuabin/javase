package thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    创建固定数量的线程池
 */
public class NewFixedThreadPoolDemo {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 10; i++) {
            executorService.submit(new ThreadTask());
        }

        executorService.shutdown();
    }
}
