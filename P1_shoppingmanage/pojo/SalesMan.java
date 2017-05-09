package com.test.P1_shoppingmanage.pojo;

/**
 * Created by wskyt on 2017/4/14.
 */
public class SalesMan {

    private int sid;
    private String password;
    private String sname;

    public SalesMan(int sid, String password, String sname){
        this.sid = sid;
        this.password = password;
        this.sname = sname;
    }
    public SalesMan(String password, String sname){
        this.password = password;
        this.sname = sname;
    }


    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }
}
