package jdbc.dao.impl;

import jdbc.dao.UserDao;
import jdbc.entity.User;
import jdbc.util.DBUtil;
import java.util.Date;

import java.sql.*;

public class UserDaoImpl implements UserDao {
    @Override
    public void insert(User user) {
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            conn = DBUtil.getConnection();
            /*
            String sql = "INSERT INTO user(name,age,create_time,account,password,balance) VALUE('" + user.getName() + "'" +
                    ", " + user.getAge() + "" +
                    ", " + user.getCreate_time() + "" +
                    ", '" + user.getAccount() + "'" +
                    ", '" + user.getPassword() + "'" +
                    ", " + user.getBalance() + "" +
                    ");";
            statement = conn.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            */

            String sql = "INSERT INTO user(name,age,create_time,account,password,balance) VALUE(?,?,?,?,?,?);";
            statement = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            statement.setString(1,user.getName());
            statement.setByte(2,user.getAge());
            statement.setInt(3,user.getCreate_time());
            statement.setString(4,user.getAccount());
            statement.setString(5,user.getPassword());
            statement.setInt(6,user.getBalance());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                user.setId(id);
                System.out.println("添加成功：" + id);
            } else {
                System.out.println("添加失败");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, statement,resultSet);
        }
    }

    /*
        批量插入
            在对一个sql值进行拼接后，使用addBatch();
     */
    @Override
    public void insertBatch(){
        Connection conn = null;
        PreparedStatement pstmt = null;
        try {
            conn = DBUtil.getConnection();
            String sql = "INSERT INTO user(name,age) values(?,?)";
            pstmt = conn.prepareStatement(sql);
            for (int i = 1; i < 4; i++) {
                pstmt.setString(1,"batch_name" + i);
                pstmt.setByte(2,(byte)(i << 1));

                // 提交到缓存
                pstmt.addBatch();
            }

            // 执行sql
            int[] res = pstmt.executeBatch();
            for (int i : res) {
                System.out.println(i);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            DBUtil.closeConnection(conn, pstmt);
        }
    }

    @Override
    public void delete(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User select(User user) {
        return null;
    }

    @Override
    public User selectById(Integer id){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            conn = DBUtil.getConnection();
            // 不建议使用这种 - 直接将参数拼接到sql语句
//            String sql = "SELECT * FROM user WHERE id = " + id +" LIMIT 1;";
//            statement = conn.createStatement();
//            resultSet = statement.executeQuery(sql);

            // 下面这种写法比较安全
            String sql = "SELECT * FROM user WHERE id = ?";
            statement = conn.prepareStatement(sql);
            statement.setInt(1,id);
            resultSet = statement.executeQuery();

            if (resultSet.next()){
                user = new User(resultSet.getInt("id")
                        , resultSet.getString("name")
                        , resultSet.getByte("age")
                        , resultSet.getInt("create_time")
                        , resultSet.getString("account")
                        , resultSet.getString("password")
                        , resultSet.getInt("balance")
                );
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.closeConnection(conn, statement,resultSet);
        }
        return user;
    }

    public static void main(String[] args) {
        // 新增
//        final User user = new User("马士兵03", (byte) 29, (int) (new Date().getTime() / 1000), "mashibing01", "123456", 0);
//        new UserDaoImpl().insert(user);

        // 批量插入
        new UserDaoImpl().insertBatch();

        // 查找
//        final User user = new UserDaoImpl().selectById(1);
//        System.out.println(user);
    }
}
