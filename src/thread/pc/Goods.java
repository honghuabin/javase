package thread.pc;

/*
    商品
        自带生产和消费属性
 */
public class Goods {
    private String brand;
    private String name;
    private boolean state = false;

    public Goods() {
    }

    public Goods(String brand, String name) {
        this.brand = brand;
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 生产商品
    public synchronized void produce(String brand, String name){
        if (state){
            // 有商品，等待消费者先消费
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 没有商品了，开始生产
        setBrand(brand);
        setName(name);
        System.out.println("生产者生产商品：" + brand + " -- " + name);

        // 改变状态
        state = true;
        // 通知消费者
        notify();
    }

    // 消费商品
    public synchronized void consume(){
        if (!state){
            // 没有商品，等待生产者生产
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // 有商品，拿走商品
        System.out.println("消费者购买商品：" + brand + " -- " + name);
        // 改变状态
        state = false;
        // 通知生产者生产
        notify();
    }
}
