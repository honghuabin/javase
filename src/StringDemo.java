/*
    字符串
 */
public class StringDemo {
    public static void main(String args[]){
        String a = "abc";
        String b = "def";
        String c = a + b;               // 使用了StringBuilder进行字符串相加，返回一个新的地址
        String f = a + b;               // 使用了StringBuilder进行字符串相加，返回一个新的地址
        String d = "abc" + "def";       // 两个字符串拼接的一个新字符串的地址
        String e = "abcdef";            // 字符串的地址
        System.out.println(c == d); // false    地址不一样
        System.out.println(e == d); // true     d的两个常量字符串相加，会自动合并成拼接后的常量字符串。
        System.out.println(c == f); // false    // 因为两个字符串变量相加，会使用StringBuilder组合成新的字符串对象返回。
    }
}
