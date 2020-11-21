
/*
    StringBuilder：创建字符串，线程不安全(异步操作)
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        sb.append("hhb").append("php").append(10).append(true);
        System.out.println(sb);
        String s = sb.toString();
        System.out.println(s);
    }
}
