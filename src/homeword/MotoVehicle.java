package homeword;

/*
    机动车 抽象类
 */
public abstract class MotoVehicle {
    String no;  // 车牌号
    String brand;   // 品牌
    int price;      // 价格

    // 根据天数计算价格
    abstract int CalcRent(int days);
}
