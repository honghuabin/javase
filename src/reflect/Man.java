package reflect;

public class Man extends Person{
    public int height;      // 身高
    private int weight;     // 体重
    String country;         // 国籍

    public Man(){
        super();
    }

    public Man(String name, int age, int sex, int height, int weight, String country) {
        super(name, age, sex);
        this.height = height;
        this.weight = weight;
        this.country = country;
    }

    public Man(int height, int weight, String country) {
        this.height = height;
        this.weight = weight;
        this.country = country;
    }

    public Man(String name, int age, int height, int weight, String country) {
        super(name, age);
        this.height = height;
        this.weight = weight;
        this.country = country;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Man(String name, int age, int sex, int height) {
        super(name, age, sex);
        this.height = height;
    }

    public Man(int height) {
        this.height = height;
    }

    public Man(String name, int age, int height) {
        super(name, age);
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void test(int a, int b){
        System.out.println(a + b);
    }
}
