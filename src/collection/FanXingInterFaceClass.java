package collection;

/*
    指定了接口的类型为String，所以test()方法的返回对象比较清楚
 */
public class FanXingInterFaceClass implements FanXingInterFace<String>{

    @Override
    public String test() {
        return "123";
    }

    @Override
    public void show(Object o) {
        System.out.println(o);
    }
}
