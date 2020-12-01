package net.common;

import java.io.Serializable;

/*
    登录用户模型
 */
public class LoginUser implements Serializable {
    // 生产序列号，保证对象前后唯一
    private static final long serialVersionUID = -4293004745870686653L;

    private String account;
    private String password;

    public LoginUser(){

    }

    public LoginUser(String account, String password){
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
}
