package homeword;

import org.junit.Assert;
import org.junit.Test;

public class MoteVehicleTest {
    @Test
    public void testBusCalcRent(){
        int price = new Bus("456","客车",8).CalcRent(10);
        System.out.println(price);
        Assert.assertEquals(8000, price);
    }

    @Test
    public void testCarCalcRent(){
        int price = new Car("123","轿车",2).CalcRent(10);
        System.out.println(price);
        Assert.assertEquals(5000, price);
    }
}
