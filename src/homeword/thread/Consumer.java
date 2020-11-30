package homeword.thread;

import java.util.ArrayList;

/*
    消费者一天只买一个
 */
public class Consumer implements Runnable{
    ArrayList<Integer> goodsArrayList;

    Consumer(ArrayList<Integer> goodsArrayList){
        this.goodsArrayList = goodsArrayList;
    }

    @Override
    public void run(){
        synchronized (goodsArrayList){
            // 如果没有商品了 - 注意这个循环判断，如果不循环判断，那么就会出现问题
            // 问题：被其它线程唤醒的时候，会往下执行，那么就会报错了，下标越界
            while (goodsArrayList.isEmpty()){
                // 自己等待
                try {
                    goodsArrayList.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            goodsArrayList.remove(0);
            System.out.println(Thread.currentThread().getName() + " -- 购买商品 -- 商品剩余数量：" + goodsArrayList.size());
            // 唤醒其它等待的进程
            goodsArrayList.notifyAll();
        }
    }
}
