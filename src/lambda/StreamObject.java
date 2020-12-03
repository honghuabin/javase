package lambda;

/*
    Stream测试类
 */
public class StreamObject {
    private String name;

    public static StreamObject build(String name){
        return new StreamObject(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StreamObject(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "StreamObject{" +
                "name='" + name + '\'' +
                '}';
    }
}
