## 获取反射类的三种方法
    * 第一种：
        Class.forName("类在项目中实际地址");
        eg：Class.forName("java.util.Date")
        
    * 第二种
        类.class;
        eg：java.util.Date.class
        
    * 第三种
        new 类().getClass();
        eg：new java.util.Date().getClass();
        
    * 第四种：？
        如果是基本数据类型，那么可以使用基本数据类型.TYPE的方式进行获取
        eg：Integer.TYPE
        
    注意：
        推荐使用 第一种 和 第二种
        
## 获取反射的类的构造方法的方法
    * getConstructor(args ...)
        * 获取空参构造方法
        * 获取传递指定参数的构造方法
            * 参数是指定参数的类型.class
            eg：public test(int a, String b)
            => getConstructor(int.class, String.class)
    * getConstructors()
        * 获取本类所有public修饰的构造方法
    * getDeclaredContructors()
        * 获取所有本类的构造方法
    
## 创建反射类的对象
    * getConstructor().newInstance();
        * 如果获取的构造方法有参数，那么需要向newInstance()里面传递参数
    * 如果要调用的是私有构造方法，需要设置私有构造方法的权限
        勾走方法.setAccessible(true);
        
## 获取反射的类的成员变量的方法
    * getField(String fieldName)
        * 获取指定名称public修饰的成员变量，包含父类中的成员变量
    * getFileds()
        * 获取所有public修饰的成员变量，包含父类中的成员变量
    * getDeclaredField(String fieldName)
        * 获取本类指定名称的成员变量
    * getDeclaredFields()
        * 获取所有本类的成员变量
    注意：
        其实父类什么的无所谓，我们反射一个类，也无法确定这个类是否有父类
        
## 给反射类的成员变量赋值
    * 首先创建反射类的对象，返回结果是Object o
    * 使用：成员变量.set(o, 变量值的方式进行设置)
        eg：name.set(o, "张三");
    * 如果要查看私有变量，需要设置私有变量的权限
        成员变量.setAccessible(true);
          
## 获取反射的类的成员方法的方法
    * getMethod(String methodName, 参数类)
        * 获取指定名称public修饰的成员方法，包含父类中的成员方法
    * getMethods()
        * 获取所有public修饰的成员方法，包含父类中的成员方法
    * getDeclaredMethod(String methodName, 参数类)
        * 获取本类指定名称的成员方法
    * getDeclaredMethods()
        * 获取所有本类的成员方法
    * 注意：因为方法可以重载，所以需要通过参数来确定具体方法
        * 参数类指的是参数类型对应的class
        * int => int.class
        * String => String.class
        * ... 
        
## 调用反射类的成员方法
    * 首先创建反射类的对象，返回结果是Object o
    * 使用：成员方法.invoke(o, args ...)
        eg：test.invoke(o, 123, 456);
    * 如果要调用私有方法，需要设置私有方法的权限
        成员方法.setAccessible(true);


# 注意：其实父类什么的无所谓，我们反射一个类，也无法确定这个类是否有父类
        

