package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
    Class类方法测试
 */
public class ClassApi {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        // 获取类
        Class aClass = Class.forName("reflect.Man");
//        fieldDemo(aClass);

//        methodDemo(aClass);

        constructDemo(aClass);

    }

    /*
        构造方法
     */
    private static void constructDemo(Class aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("========== 使用 getConstructors() 方法获取 本类所有public 修饰的构造方法 =========");
        Constructor[] constructors = aClass.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor.getName());
        }
        System.out.println("==============================");
        System.out.println();

        System.out.println("========== 使用 getDeclaredConstructors() 方法获取本类所有构造方法 ===============");
        Constructor[] declaredConstructors = aClass.getDeclaredConstructors();
        for (Constructor declaredConstructor : declaredConstructors) {
            System.out.println(declaredConstructor.getName());
        }
        System.out.println("================================");
        System.out.println();

        System.out.println("========== 使用 getDeclaredConstructor() 方法获取本类指定构造方法 ===============");
        Constructor declaredConstructor1 = aClass.getDeclaredConstructor(int.class, int.class, String.class);
        // 注意这里实例化的时候，要传递上面获取的实例化方法的参数，否则就会报错
        Object china = declaredConstructor1.newInstance(180, 160, "中国");
        System.out.println(china);
        System.out.println("================================");
        System.out.println();
    }

    /*
        成员方法
     */
    public static void methodDemo(Class aClass) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("========= 使用 getMethods() 获取public修饰的成员方法，无论是继承的还是自己的 =====================");
        Method[] methods = aClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        System.out.println("=========================");
        System.out.println("========= 使用 getDeclaredMethods() 获取 本类 所有成员方法 =====================");
        Method[] methods1 = aClass.getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method.getName());
        }
        System.out.println("===============================");
        System.out.println("========= 使用 getDeclaredMethod() 获取 本类 指定的成员方法 =====================");
        Method test = aClass.getMethod("test", int.class, int.class);
        // 创建该对象(先获取空参构造，然后再调用newInstance()方法创建对象)
        Object o = aClass.getDeclaredConstructor().newInstance();
        System.out.println("调用invoke()方法执行该方法，如果该方法是私有方法，则使用setAccessible(true)设置可以使用");
        test.setAccessible(true);
        test.invoke(o,1,2);
        System.out.println("==================");
    }

    /*
        成员变量相关方法
     */
    public static void fieldDemo(Class aClass) throws NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        System.out.println("========= 使用 getFileds() 获取public修饰的成员变量，无论是继承的还是自己的 =====================");
        Field[] fields = aClass.getFields();
        for (Field field : fields) {
            System.out.println(field.getName());
        }
        System.out.println("=====================");
        System.out.println();
        System.out.println("========= 使用 getDeclaredFields() 获取本类全部成员变量，获取不到父类的变量 =====================");
        // 使用getD
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println("=====================");
        System.out.println("========= 使用 getDeclaredField(String name) 获取本类指定成员变量，获取不到父类成员变量 =====================");
        Field country = aClass.getDeclaredField("country");
        System.out.println(country.getName());
        System.out.println("=====================");
        System.out.println("========= 使用 set(Object o, String value) 给属性设置值(如果属性是私有属性则可以赋值但默认无法访问，除非该属性使用方法setAccessible(true)) =====================");
        Object o = aClass.getDeclaredConstructor().newInstance();
        country.set(o,"中国");
        System.out.println(((Man) o).getCountry());
        System.out.println("=====================");
    }
}
