package thread.pcqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/*
    执行主方法
 */
public class Main {
    public static void main(String[] args){

        // 创建队列对象，给予缓存空间5个
        BlockingQueue blockingQueue = new ArrayBlockingQueue(5);

        // 创建生产者
        Producer producer = new Producer(blockingQueue);

        // 创建消费者
        Consumer consumer = new Consumer(blockingQueue);

        // 创建生产者线程并开始运行
        new Thread(producer).start();

        // 创建消费者线程并开始运行
        new Thread(consumer).start();
        
    }
}
