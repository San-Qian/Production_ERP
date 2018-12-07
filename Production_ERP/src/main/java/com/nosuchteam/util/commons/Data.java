package com.nosuchteam.util.commons;

/**
 * @Author: Evan
 * @Date: 2018/12/5 20:51
 * @Description:
 */
public class Data {
    private Integer status;
    private String msg;
    private Integer error;
    private String url;
    private String data;

    public Data(Integer status, String msg, String data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public Data(Integer error, String url) {
        this.error = error;
        this.url = url;
    }
    public Data(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Data{" +
                "status=" + status +
                ", msg='" + msg + '\'' +
                ", error='" + error + '\'' +
                ", url='" + url + '\'' +
                ", data='" + data + '\'' +
                '}';
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
