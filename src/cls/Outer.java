package cls;

/*
    内部类
        说明：
            一个java文件中可以包含多个class，但是只能有一个public class
        概念：
            如果一个类定义在另一个类的内部，此时可以称之为内部类
            可以理解为，内部类是类中的一个class类型的变量
        使用：
            创建内部类的时候，跟之前的方法不一样，需要在内部类的前面添加外部类来进行修饰
            外部类.内部类 变量名称 = new 外部类().new 内部类();
            Outer.Inner inner = new Outer().new Inner();
            或者
            Outer outer = new Outer();
            Outer.Inner inner = outer.new Inner();
        特点：
            1. 内部类可以方便的访问外部类的私有属性
            2. 外部内不能随便访问内部类的私有属性，
                但是可以通过new一个内部类对象来进行访问
            3. 内部类中不能定义静态属性
            4. 当内部类和外部类具有相同的私有属性的时候，
                在内部类中进行访问，可以直接访问内部类属性，
                    如果需要访问外部类的属性，其格式为：外部类.this.属性
        分类：
            匿名内部类：
                当定义了一个类，实现了某个接口的时候，在使用过程中只需要使用一次，没有其它用途
                不创建类的实例，直接new，然后使用，一般new的是一个接口
                new Thread(new Runnable(){
                    @Overide
                    public void run(){
                    }
                })
                这里new Runnable(){...}   这个就是匿名内部类，它实现了一个接口
            静态内部类：
                在内部内中定一个的一个用static修饰的内部类
                new的方法：
                    静态内部类 变量名称 = new 外部类.静态内部类()
            方法内部类（了解，基本不实用）：
                在外部类的方法中，也可以定义类。
                作用域仅仅局限于方法中
 */
public class Outer {
    private String name = "zhangsan";
    private static String test = "123";

    public Outer(){

    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void show(){
        System.out.println("this is Outer show()");
        System.out.println("Outer use name : " + name);
        System.out.println("Outer use this.name : " + this.name);
//        System.out.println("Outer use Inner.name : " + Inner.name);   // error
        Inner inner = new Inner();
        System.out.println("Out new Inner(), use inner.name: " + inner.name);
        System.out.println("======================");
    }

    public void method(){
        System.out.println("Outer 的 test 方法");

        // 方法内部类
        class methodClass{
            private int id = 1;

            public void method(){
                System.out.println("Outer类中method方法中的methodClass类里面的method方法");
            }
        }

        methodClass methodClass = new methodClass();
        methodClass.method();
    }

    // 内部类
    // new Outer().new Inner();
    class Inner{
        private String name = "lisi";

//        private static String test = "123";  // error

        public void setName(String name){
            this.name = name;
        }

        public String getName(){
            return this.name;
        }

        public void show(){
            System.out.println("this is inner show()");
            System.out.println("Inner use name: " + name);
            System.out.println("Inner use this.name: " + this.name);
//            System.out.println("Inner use super.name: " + super.name);    // error
//            System.out.println("Inner user Outer.this.name: " + Outer.name);    // error
            System.out.println("Inner user Outer.this.name: " + Outer.this.name);
            System.out.println("=====================");
        }
    }

    // 静态内部类
    // new Outer.InnerStatic()
    static class InnerStatic{
        private String name = "wangwu";
        public void show(){
            System.out.println("InnerStatic use name：" + name);
        }
    }
}
