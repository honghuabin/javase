package homeword;

/*
    测试一下，如果父类实现类抽象类的方法，那么子类是否还需要再去实现
        结果发现不需要了，会直接使用父类的实现方法
 */
public class CarChild extends Car{

    public CarChild(String no, String brand, int type) {
        super(no, brand, type);
    }

    public static void main(String[] args) {
        System.out.println(new CarChild("1","宝马",1).calcRent(5));
    }
}
