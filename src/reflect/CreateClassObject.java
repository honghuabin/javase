package reflect;

/*
    创建类对象
 */
public class CreateClassObject {
    public static void main(String[] args) throws ClassNotFoundException {
        // 第一种：Class.forName() 来获取对象
        final Class<?> aClass = Class.forName("reflect.Person");
        System.out.println(aClass);

        // 第二种：通过Class.class的方式
        final Class<Person> personClass = Person.class;
        System.out.println(personClass);

        // 第三种：先new一个实例对象，然后实例对象.getClass()
        final Class<? extends Person> aClass1 = new Person().getClass();
        System.out.println(aClass1);

        // 第四种：如果是基本数据类型，可以使用基本数据类型.TYPE来进行获取
        final Class<Integer> type = Integer.TYPE;

        // 比较三种有没有区别
        System.out.println(aClass == aClass1);
        System.out.println(personClass == aClass1);
    }
}
