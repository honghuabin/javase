import java.util.Arrays;

/*
    枚举类测试
        使用枚举类
            调用枚举类中定义的方法名称
                枚举类名称.方法名称  =>  会返回枚举类对象

    一般使用在需要定义   一组常量值   的时候，使用枚举类
 */
public class EnumDemoTest {
    public static void main(String[] args) {
        EnumDemo stop = EnumDemo.STOP;
        System.out.println(stop.name());
        System.out.println(EnumDemo.ON.name());
        System.out.println(Arrays.toString(EnumDemo.values()));
    }
}
