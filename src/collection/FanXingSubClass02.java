package collection;

/*
    不指定子类是什么类型
 */
public class FanXingSubClass02<T> extends FanXingClass<T>{
    public static void main(String[] args) {
        FanXingSubClass02<String> stringFanXingSubClass02 = new FanXingSubClass02<>();
        stringFanXingSubClass02.setT("qwett");
        stringFanXingSubClass02.show();

        FanXingSubClass02<Integer> integerFanXingSubClass02 = new FanXingSubClass02<>();
        integerFanXingSubClass02.setT(123456);
        integerFanXingSubClass02.show();
    }
}
