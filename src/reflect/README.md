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