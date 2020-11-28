package thread.pc;
/*
    消费者
        负责消费商品
 */
public class Consumer implements Runnable{

    private Goods goods;

    public Consumer() {
    }

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            goods.consume();
        }
    }
}
