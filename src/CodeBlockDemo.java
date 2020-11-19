/*
    代码块
        普通代码块：
            定义在方法中，使用{}括起来的代码叫做普通代码块
        构造代码块
            定义在类中，使用{}括起来的代码叫做构造代码块
            注意：每次代码运行的时候，会将构造代码块中的所有代码添加到构造方法的前面
        静态代码块
            使用static{}括起来的代码块叫做静态代码块
            在类载入的时候优先执行
        同步代码块
            在多线程的时候使用，用来给共享空间进行加锁操作
 */
public class CodeBlockDemo {
    String name = "代码块";
    boolean add = true;

    static {
        System.out.println("这里是静态代码块，在类载入的时候，被执行");
    }

    {
        System.out.println("这里是构造代码块，会在new的时候执行" +
                "编译的时候，这里的所有代码都会在自动加入到每个构造方法的最前面");
        this.name=".gitignore";
        System.out.println("当构造方法里面进行嵌套构造方法(使用了this())，" +
                "那么使用this()的这个构造方法不会添加构造代码块的代码");
    }

    public CodeBlockDemo(){
        System.out.println("这里是空参构造的第一行代码");
    }

    public CodeBlockDemo(String name){
        System.out.println("这里是有参构造的第一行代码");
        this.name = name;
    }

    public CodeBlockDemo(String name, boolean add){
        this(name);
        this.add = add;
        System.out.println("我这里使用了this()，调用了其它构造方法，所以不会添加构造代码块代码");
    }

    @Override
    public String toString(){
        return this.name;
    }

    public static void main(String[] args) {
        System.out.println("我写在普通代码块之前");
        {
            System.out.println("这里是普通代码块，和普通方法一下，从上到下执行个，执行到我了就运行我");
        }
        System.out.println("我写在普通代码块之后");

        CodeBlockDemo c = new CodeBlockDemo();
        System.out.println(c.toString());
        System.out.println("===============");
        CodeBlockDemo c1 = new CodeBlockDemo("456", false);
        System.out.println(c1.toString());
    }
}
