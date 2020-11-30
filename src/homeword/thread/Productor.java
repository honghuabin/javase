package homeword.thread;

import java.util.ArrayList;

/*
    生产者每天生产10个，库存最大存量为200个
 */
public class Productor implements Runnable{
    // 最大库存量
    private int max_num = 200;
    // 商品库存
    ArrayList<Integer> goodsArrayList;
    // 商品数量
    Integer num;

    Productor(ArrayList<Integer> goodsArrayList){
        this.goodsArrayList = goodsArrayList;
    }

    Productor(Integer num){
        this.num = num;
    }

    @Override
    public void run(){
        while (true) {
            /*
            synchronized (goodsArrayList) {
                // 每次被唤醒的时候，都需要判断库存情况
                // 判断是否超过库存了
                if (goodsArrayList.size() >= max_num) {
                    try {
                        goodsArrayList.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 被唤醒");
                }

                // 库存不够，生产者生产
                // 定义一天生产的个数
                int num = max_num - goodsArrayList.size() > 10 ? 10 : (max_num - goodsArrayList.size());
                for (int i = 0; i < num; i++) {
                    goodsArrayList.add(1);
                }
                System.out.println(Thread.currentThread().getName() + " 生产商品" + num + "个，商品当前库存：" + goodsArrayList.size());

                // 通知消费者进行购买
                goodsArrayList.notifyAll();
            }
            */

            synchronized(num){
                if (num >= max_num) {
                    try {
                        num.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " 被唤醒");
                }

                // 库存不够，生产者生产
                // 定义一天生产的个数
                int add = max_num - num > 10 ? 10 : (max_num - num);
                num += add;
                System.out.println(Thread.currentThread().getName() + " 生产商品" + add + "个，商品当前库存：" + num);

                // 通知消费者进行购买
                num.notifyAll();
            }

            // 间隔一秒在生产
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
