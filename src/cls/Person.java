package cls;

public class Person {
    private String name;
    private String sex;

    public Person() {
    }

    public Person(String name, String sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    // 喂宠物
    public void feed(Pet pet){
        // 多态写法，获取父类对象，调用实例化对象实现的方法
        // 其实就相当于将多个Pet实例对象的重载方法进行合并了
        pet.feed();
    }

    void test1(){
        System.out.println("我就看看默认修饰方法能不能被继承，结果发现可以被继承");
        System.out.println("如果子类与我不在同一个包，就不能被继承");
    }

    public static void main(String[] args) {
        Person person = new Person();
        Cat cat = new Cat();
        Dog dog = new Dog();
        person.feed(cat);
        person.feed(dog);
    }
}
