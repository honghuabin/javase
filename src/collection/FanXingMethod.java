package collection;

public class FanXingMethod {

    private int no;

    // 定义泛型方法，需要在返回值void前面加上占位符<T>
    public <T> void show(T t){
        System.out.println(t);
    }

    public static void main(String[] args) {
        FanXingMethod fanXingMethod = new FanXingMethod();
        fanXingMethod.show(123);
        fanXingMethod.show("abc");
        fanXingMethod.show(new Person("张三", 20));
    }
}
