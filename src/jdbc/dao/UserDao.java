package jdbc.dao;

import jdbc.entity.User;

public interface UserDao {
    // 插入数据(增)
    public abstract void insert(User user);

    public abstract void insertBatch();

    // 删除数据(删)
    public abstract void delete(User user);

    // 修改数据(改)
    public abstract void update(User user);

    // 查找数据(查)
    public abstract User select(User user);

    // 根据id查找数据
    public abstract User selectById(Integer id);
}
