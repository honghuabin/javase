package thread.pcqueue;

import java.util.concurrent.BlockingQueue;

/*
    消费者
        负责消费商品
 */
public class Consumer implements Runnable{

    private BlockingQueue<Goods> blockingQueue;

    public Consumer() {
    }

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Goods goods = blockingQueue.take();
                System.out.println("消费者消费商品：" + goods.getBrand() + " -- " + goods.getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
