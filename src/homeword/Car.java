package homeword;

/*
    轿车类
 */
public class Car extends MotoVehicle{
    private int type;    // 车型

    public Car(String no, String brand, int type){
        this.no = no;
        this.brand = brand;
        this.type = type;
        switch (this.type){
            case 1:     // 别克商务舱GL8
                this.price = 600;
                break;
            case 2:     // 宝马550i
                this.price = 500;
                break;
            case 3:     // 别克林荫大道
                this.price = 300;
                break;
        }
    }

    @Override
    public int calcRent(int days) {
        return price * days;
    }
}
