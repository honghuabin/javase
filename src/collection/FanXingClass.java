package collection;

public class FanXingClass<T> {
    private T t;

    public T getT(){
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public void show(){
        System.out.println(t);
    }

    public static void main(String[] args) {
        FanXingClass<String> stringFanXingClass = new FanXingClass<>();
        stringFanXingClass.setT("将泛型类型定义成字符串类型");
        stringFanXingClass.show();

        FanXingClass<Integer> integerListFanXingClass = new FanXingClass<>();
        integerListFanXingClass.setT(258);
        integerListFanXingClass.show();
    }
}
