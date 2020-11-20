package interfaces;

/**
 * 基础手机类
 *      发短信
 *      打电话
 */
public abstract class Phone {
    // 品牌
    private String brand;
    // 型号
    private String type;

    public Phone(String brand, String type) {
        this.brand = brand;
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // 打电话
    public void call() {
        System.out.println("打电话");
    }

    // 发短信
    public void sendMessage() {
        System.out.println("发短息");
    }
}
