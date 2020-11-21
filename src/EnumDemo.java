
/*
    枚举类
 */
public enum EnumDemo {

    // 定义枚举类里面调用方法，方法名称(传递参数)
    LAUNCH("launch"),
    PAGEVIEW("pageview"),
    EVENT("event"),
    ON("on"),
    STOP("stop");

    // 配合上面的枚举调用方法
    private String name;
    EnumDemo(String name){
        this.name = name;
    }

    public void show(){
        System.out.println(this.name);

        // 获取枚举的数据
        EnumDemo[] values = values();
        for (EnumDemo value : values) {
            System.out.println(value);
        }
    }
}
