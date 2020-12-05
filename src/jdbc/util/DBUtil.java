package jdbc.util;

import java.sql.*;

/*
    数据库连接工具类
 */
public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost/test?characterEncoding=utf-8";
    private static final String USERNAME = "test";
    private static final String PASSWORD = "123456";

    // 使用静态代码块，在类被加载的时候自动执行，用来注册mysql驱动
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     */
    public static Connection getConnection(){
        try {
            return DriverManager.getConnection(URL,USERNAME,PASSWORD);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    /**
     * 关闭数据库连接
     * @param connection
     */
    public static void closeConnection(Connection connection){
        if (connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    /**
     * 关闭数据库连接
     * @param connection
     * @param statement
     */
    public static void closeConnection(Connection connection, Statement statement){
        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        closeConnection(connection);
    }

    /**
     * 关闭数据库连接
     * @param connection
     * @param statement
     * @param resultSet
     */
    public static void closeConnection(Connection connection, Statement statement, ResultSet resultSet){
        if (resultSet != null ){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        closeConnection(connection, statement);
    }
}
