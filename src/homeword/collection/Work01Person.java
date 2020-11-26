package homeword.collection;

import java.util.Objects;

public class Work01Person {
    private String name;    // 姓名
    private int age;        // 年龄
    private int weight;     // 体重
    private String addr;    // 地址

    public Work01Person() {
    }

    public Work01Person(String name, int age, int weight, String addr) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.addr = addr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Work01Person that = (Work01Person) o;
        return age == that.age &&
                weight == that.weight &&
                Objects.equals(name, that.name) &&
                Objects.equals(addr, that.addr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, weight, addr);
    }

    @Override
    public String toString() {
        return "Work01Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", addr='" + addr + '\'' +
                '}';
    }
}
