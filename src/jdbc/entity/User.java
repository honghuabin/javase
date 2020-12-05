package jdbc.entity;

/*
    用户类
    CREATE TABLE `user` (
      `id` int(10) NOT NULL AUTO_INCREMENT,
      `name` varchar(20) NOT NULL DEFAULT '',
      `age` smallint(2) NOT NULL DEFAULT '1' COMMENT '年龄',
      `create_time` int(10) DEFAULT NULL,
      `account` varchar(20) DEFAULT NULL COMMENT '账号',
      `password` char(32) DEFAULT NULL COMMENT '密码',
      `balance` int(11) NOT NULL DEFAULT '0' COMMENT '余额',
      PRIMARY KEY (`id`)
    ) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
 */
public class User {
    private Integer id;             // id
    private String name;            // 姓名
    private Byte age;               // 年龄
    private Integer create_time;    // 创建时间
    private String account;         // 账号
    private String password;        // 密码
    private Integer balance;         // 余额

    public User() {
    }

    public User(Integer id, String name, Byte age, Integer create_time, String account, String password, Integer balance) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.create_time = create_time;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public User(String name, Byte age, Integer create_time, String account, String password, Integer balance) {
        this.name = name;
        this.age = age;
        this.create_time = create_time;
        this.account = account;
        this.password = password;
        this.balance = balance;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    public Integer getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Integer create_time) {
        this.create_time = create_time;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", create_time=" + create_time +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", balance=" + balance +
                '}';
    }
}
