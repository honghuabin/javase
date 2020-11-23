package collection;

/**
 * 没有指定接口的类型，所有返回对象不清楚是什么类型
 */
public class FanXingInterFaceClass02 implements FanXingInterFace{

    @Override
    public Object test() {
        return null;
    }

    @Override
    public void show(Object o) {
        System.out.println(o);
    }
}
