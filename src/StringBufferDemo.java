
/*
    StringBuffer：字符串缓存类，线程安全(同步)
 */
public class StringBufferDemo {
    public static void main(String[] args) {
        StringBuffer bs = new StringBuffer();
        bs.append("hhm").append(28).append('\t').append(true);
        String s = bs.toString();
        System.out.println(s);

    }
}
