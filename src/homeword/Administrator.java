package homeword;

import java.util.Scanner;

/*
    管理员
    方法，修改密码
 */
public class Administrator {
    String account = "admin";       // 帐号
    String password = "admin";      // 密码

    public Administrator() {
    }

    public Administrator(String account, String password) {
        this.account = account;
        this.password = password;
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

    // 验证帐号密码
    public boolean checkAccountAndPassword(String account, String password){
        return getAccount().equals(account) && getPassword().equals(password);
    }

    @Override
    public String toString() {
        return "Administrator{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String args[]){
        Administrator admin = new Administrator();

        // 修改密码
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("请输入帐号");
            String account = sc.nextLine();
            System.out.println("请输入密码");
            String password = sc.nextLine();

            if (admin.checkAccountAndPassword(account, password)){
                System.out.println("请输入新密码");
                String newPassword = sc.nextLine();
                admin.setPassword(newPassword);
                break;
            } else {
                System.out.println("你输入的帐号密码不正确");
            }
        }

        System.out.println("密码修改成功");
        System.out.println(admin.toString());
    }
}
