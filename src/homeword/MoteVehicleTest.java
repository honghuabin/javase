package homeword;

import org.junit.Assert;
import org.junit.Test;

public class MoteVehicleTest {
    @Test
    public void testBusCalcRent(){
        int price = new Bus("456","客车",8).calcRent(10);
        System.out.println(price);
        Assert.assertEquals(8000, price);
    }

    @Test
    public void testCarCalcRent(){
        int price = new Car(".gitignore","轿车",2).calcRent(10);
        System.out.println(price);
        Assert.assertEquals(5000, price);
    }

    @Test
    public void testTotalCalcRent(){
        // 2个宝马、1个别克、1个16座客车、1个34座客车，租用5天
        MotoVehicle[] motoVehicles = new MotoVehicle[5];
        motoVehicles[0] = new Car("1","宝马",2);  // 2500
        motoVehicles[1] = new Car("2","宝马",2);  // 2500
        motoVehicles[2] = new Car("3","别克GLT",1);   // 3000
        motoVehicles[3] = new Bus("4","客车",16); // 4000
        motoVehicles[4] = new Bus("5","客车",34); // 7500

        int totalRent = 0;
        for (int i = 0; i < motoVehicles.length; i++){
            totalRent += motoVehicles[i].calcRent(5);
        }
        System.out.println(totalRent);

        Assert.assertEquals(19500, totalRent);
    }
}
