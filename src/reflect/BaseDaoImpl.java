package reflect;

import jdbc.util.DBUtil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*
    基本的增删查改的封装
 */
public class BaseDaoImpl {
    /*
        查询
            需要知道查询什么        (执行的sql)
            需要知道查询参数        (参数)
            需要知道返回数据类型     (哪个类)
     */
    public List<?> query(String sql, Object[] params, Class clazz){
        List list = new ArrayList();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet resultSet = null;
        try{
            // 获取数据库连接
            conn = DBUtil.getConnection();
            // 获取预处理sql
            pstmt = conn.prepareStatement(sql);
            // 绑定参数（因为不知道参数的类型，所以可以统一用Object类型来进行代替）
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject((i + 1), params[i]);
            }
            // 执行sql语句，得到结果集
            resultSet = pstmt.executeQuery();
            // 获取返回的数据列的数量、类型、和属性对象
            ResultSetMetaData metaData = resultSet.getMetaData();
            // 获取有多少列
            int columnCount = metaData.getColumnCount();
            // 如果有数据
            while (resultSet.next()) {
                // 创建对象
                Object o = clazz.getDeclaredConstructor().newInstance();
                // 循环给属性赋值
                for (int i = 0; i < columnCount; i++) {
                    // 根据索引获取值
                    Object objectValue = resultSet.getObject(i + 1);
                    /*
                        获取该属性的set方法
                            getMethod(String methodName, 参数类)
                            1. 需要获取方法名称
                                1.1 先获取列的名称
                                1.2 获取方法名称
                            2. 需要获取参数类型
                                2.1 获取列的名称
                                2.2 获取对应成员变量对象
                                2.3 通过成员变量对象获取成员变量类型
                     */
                    // 获取列的名称
                    String fieldName = metaData.getColumnName(i);
                    // 获取set方法名称
                    String setMethodName = getSetMethodNameByField(fieldName);
                    // 根据列的名称获取成员变量对象类
                    Field field = clazz.getDeclaredField(fieldName);
                    // 获取成员变量类型
                    String fieldTypeName = field.getType().getName();
                    // 获取set方法
                    Method declaredMethod = clazz.getDeclaredMethod(setMethodName, field.getType());
                    // 调用方法进行赋值
                    if (objectValue instanceof Number) {
                        Number number = (Number)objectValue;
                        // 如果是数据类型
                        if ("int".equals(fieldTypeName) || "java.lang.Integer".equals(fieldTypeName)){
                            declaredMethod.invoke(o, number.intValue());
                        } else if ("byte".equals(fieldTypeName) || "java.lang.Byte".equals(false)){
                            declaredMethod.invoke(o, number.byteValue());
                        } else if ("short".equals(fieldTypeName) || "java.lang.Short".equals(false)){
                            declaredMethod.invoke(o, number.shortValue());
                        } else if ("long".equals(fieldTypeName) || "java.lang.Long".equals(false)){
                            declaredMethod.invoke(o, number.longValue());
                        } else if ("float".equals(fieldTypeName) || "java.lang.Float".equals(false)){
                            declaredMethod.invoke(o, number.floatValue());
                        } else if ("double".equals(fieldTypeName) || "java.lang.Double".equals(false)){
                            declaredMethod.invoke(o, number.doubleValue());
                        }
                    } else {
                        declaredMethod.invoke(o, objectValue);
                    }

                    list.add(o);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, pstmt, resultSet);
        }

        return list;
    }

    /*
        新增
            获取到存储数据的对象
            根据对象获取对象的所有成员属性即是需要存储的值
     */
    public boolean add(Object object){
        boolean rs = false;
        Connection conn = null;
        PreparedStatement pmstat = null;
        ResultSet resultSet = null;
        try{
            // 获取连接
            conn = DBUtil.getConnection();
            // 获取类对象的所有属性
            Field[] fields = object.getClass().getDeclaredFields();
            for (Field field : fields) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rs;
    }

    /**
     * 根据字段字符串获取set方法
     * @param fieldStr
     * @return
     */
    public String getSetMethodNameByField(String fieldStr){
        // 先将所有的字母转化为小写
        String lowerFiledStr = fieldStr.toLowerCase();
        // 将首字母转化为大写
        return "set" + lowerFiledStr.substring(0,1).toUpperCase() + lowerFiledStr.substring(1);
    }

    /**
     * 根据类名称获取表名
     * @param className
     * @return
     */
    public String getTableName(String className){
        return className.substring(0,1).toLowerCase() + className.substring(1,className.length() -3);
    }

    /**
     * 根据字段名称获取get方法
     * @param fieldStr
     * @return
     */
    public String getGetMethodNameByField(String fieldStr){
        String lowerFieldStr = fieldStr.toLowerCase();
        return "get" + lowerFieldStr.substring(0,1).toUpperCase() + lowerFieldStr.substring(1);
    }

    public static void main(String[] args) {
        System.out.println(new BaseDaoImpl().getSetMethodNameByField("name"));
        System.out.println(new BaseDaoImpl().getTableName("TestDao"));
    }
}
