package thread.pc;

/*
    生产者
        负责生产商品
 */
public class Producer implements Runnable{

    private Goods goods;

    public Producer() {
    }

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0){
                goods.produce("娃哈哈","矿泉水");
            } else {
                goods.produce("旺仔","小馒头");
            }
        }
    }
}
