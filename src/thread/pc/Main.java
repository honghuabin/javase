package thread.pc;

/*
    执行主方法
 */
public class Main {
    public static void main(String[] args){

        // 创建商品
        Goods goods = new Goods();

        // 创建生产者
        Producer producer = new Producer(goods);

        // 创建消费者
        Consumer consumer = new Consumer(goods);

        // 创建生产者线程并开始运行
        new Thread(producer).start();

        // 创建消费者线程并开始运行
        new Thread(consumer).start();

    }
}
