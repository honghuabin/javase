package homeword;

import org.junit.Assert;
import org.junit.Test;

/*
    客车类
 */
public class Bus extends MotoVehicle{
    private int searCount;  // 座位数

    public Bus(){

    }

    public Bus(String no,String brand, int searCount){
        this.no = no;
        this.brand = brand;
        this.searCount = searCount;
        if (this.searCount > 16) {
            this.price = 1500;
        } else {
            this.price = 800;
        }
    }

    @Override
    public int CalcRent(int days){
        return price * days;
    }
}
