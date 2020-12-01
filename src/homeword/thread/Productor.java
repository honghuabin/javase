package homeword.thread;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

/*
    生产者每天生产10个，库存最大存量为200个
 */
public class Productor implements Runnable{
    // 最大库存量
    private int max_num = 200;
    // 商品库存
    LinkedList<Integer> goodsList;

    Productor(LinkedList<Integer> goodsList){
        this.goodsList = goodsList;
    }

    @Override
    public void run(){
        while (true) {
            synchronized (goodsList) {
                // 每次被唤醒的时候，都需要判断库存情况
                // 判断是否超过库存了
                if (goodsList.size() >= max_num) {
                    try {
                        goodsList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 被唤醒");
                }

                // 库存不够，生产者生产
                // 定义一天生产的个数
                int num = max_num - goodsList.size() > 10 ? 10 : (max_num - goodsList.size());
                for (int i = 0; i < num; i++) {
                    goodsList.add(1);
                }
                System.out.println(Thread.currentThread().getName() + " 生产商品" + num + "个，商品当前库存：" + goodsList.size());

                // 通知消费者进行购买
                goodsList.notifyAll();
            }

            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
