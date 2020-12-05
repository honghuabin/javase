package jdbc;

import java.sql.*;

public class SimpleDemo {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // 装在驱动(实际上是通过反射，将类加载到jvm的内存中，在加载后，类的静态方法会自动被调用，方法里面将该类注册到了DriverManage这个类中)
        // ClassNotFoundException
        Class.forName("com.mysql.jdbc.Driver");
        // 使用驱动管理器连接数据库
        // SQLException
        final Connection test = DriverManager.getConnection("jdbc:mysql://localhost/test?characterEncoding=utf-8", "test", "123456");
        // 定义sql语句
        String sql = "show tables;";
        // 获取执行sql的对象(可以理解为是软件的sql执行窗口)
        final Statement statement = test.createStatement();
        // 执行sql
        final ResultSet resultSet = statement.executeQuery(sql);
        // 打印结果集
        while (resultSet.next()){
            System.out.println(resultSet.getString("Tables_in_test"));
        }
        // 关闭资源
        resultSet.close();
        statement.close();
        test.close();
    }
}
