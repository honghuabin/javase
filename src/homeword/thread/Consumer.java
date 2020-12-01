package homeword.thread;

import java.util.LinkedList;

/*
    消费者一天只买一个
 */
public class Consumer implements Runnable{
    LinkedList<Integer> goodsList;

    Consumer(LinkedList<Integer> goodsList){
        this.goodsList = goodsList;
    }

    @Override
    public void run(){
        synchronized (goodsList){
            // 如果没有商品了 - 注意这个循环判断，如果不循环判断，那么就会出现问题
            // 问题：被其它线程唤醒的时候，会往下执行，那么就会报错了，下标越界
            while (goodsList.isEmpty()){
                // 自己等待
                try {
                    goodsList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            goodsList.remove(0);
            System.out.println(Thread.currentThread().getName() + " -- 购买商品 -- 商品剩余数量：" + goodsList.size());
            // 唤醒其它等待的进程
            goodsList.notifyAll();
        }
    }
}
