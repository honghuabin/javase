package collection;

/*
    指定父类是字符串类型，那么本类就只能是字符串类型了
 */
public class FanXingSubClass extends FanXingClass<String>{
    public static void main(String[] args) {
        FanXingSubClass fanXingSubClass = new FanXingSubClass();
//        fanXingSubClass.setT(123);        // 会报错
        fanXingSubClass.setT("abcdefghijklmnopqrstuvwxyz");
        fanXingSubClass.show();
    }
}
