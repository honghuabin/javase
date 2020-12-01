package thread.juc;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
    创建一个线程
        用完就消失
 */
public class NewSingleThreadExecutorDemo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 10; i++){
            executorService.submit(new ThreadTask());
        }

        executorService.shutdown();
    }
}
