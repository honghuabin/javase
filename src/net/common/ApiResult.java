package net.common;

import java.io.Serializable;

/*
    服务端和客户端通信的返回数据结构
 */
public class ApiResult implements Serializable {
    private static final long serialVersionUID = 1865205171163578314L;
    private int code;
    private String msg;

    public ApiResult() {
    }

    public ApiResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
