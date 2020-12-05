package cls;

public class Man extends Person{
    public static void main(String[] args) {
        Man man = new Man();
        man.test1();

        // 看看能不能使用父类私有变量
//        man.name;     // 报错不能
        // 看看默认变量可不可以访问
        man.age = 123;  // 可以
    }
}
