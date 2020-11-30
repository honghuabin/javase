package homeword.thread;

import java.util.ArrayList;

/*
    生产者一天生产10个，最多库存200个
    消费者一天买一个，可以多个消费者
    保证运行正产
 */
public class PorductorConsumerTest {
    public static void main(String[] args) {
        // 第一种方法
        method01();
    }

    private static void method01() {
        // 创建商品
        ArrayList<Integer> goodsList = new ArrayList<Integer>();
        // 生产者开始运行
        new Thread(new Productor(goodsList),"生产者").start();
//        new Thread(new Productor(goodsList),"生产者").start();
        // 500个消费者开始购买
        for (int i = 0; i < 500 ; i++){
//            new Thread(new Consumer(goodsList),"消费者 - " + i).start();
            new Thread(new Consumer(goodsList),"消费者 - " + i).start();
        }

    }

}
