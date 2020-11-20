package interfaces;

/*
    CPU 接口
 */
public interface Cpu {
    // 获取cpu厂商
    public abstract String getBrand();
    // 获取cpu主频
    public abstract String getHz();
}
