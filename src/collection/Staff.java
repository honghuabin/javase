package collection;

import java.util.Objects;

/*
    员工类
 */
public class Staff extends Person implements Comparable{
    private String no;      // 工号

    public Staff(String no) {
        this.no = no;
    }

    public Staff(String name, int age, String no) {
        super(name, age);
        this.no = no;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Staff staff = (Staff) o;
        return Objects.equals(no, staff.no);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), no);
    }

    @Override
    public String toString() {
        return "Staff{" +
                "no='" + no + '\'' +
                "name='" + getName() + '\'' +
                ", age=" + getAge() +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        System.out.println("----------staff------------");
        System.out.println(this);
        System.out.println(o);
        System.out.println("----------staff------------");
        Staff staff = (Staff)o;
        return this.getAge() - staff.getAge();  // 根据年龄升序，this在左为升序，this在右为降序
    }
}
