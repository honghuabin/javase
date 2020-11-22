package homeword;

/**
 * Dog
 */
public class Dog {

    private String name;        // 昵称
    private int intimacy;       // 亲密度

    public Dog() {
    }

    public Dog(String name, int intimacy) {
        this.name = name;
        this.intimacy = intimacy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntimacy() {
        return intimacy;
    }

    public void setIntimacy(int intimacy) {
        this.intimacy = intimacy;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "name='" + name + '\'' +
                ", intimacy=" + intimacy +
                '}';
    }
}
