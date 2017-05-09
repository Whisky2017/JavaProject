package com.test.P1_shoppingmanage.pojo;

/**
 * Created by wskyt on 2017/4/14.
 */
public class Gsales {

    private int gsid;
    private int gid;
    private int sid;
    private int snum;

    private String gname;
    private double gprice;
    private int gnum;
    private int allsellnum;

    public Gsales(int gid,int sid, int snum){
        this.gid = gid;
        this.sid = sid;
        this.snum = snum;
    }
    public Gsales(String gname,double gprice,int gnum,int allsellnum){
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
        this.allsellnum = allsellnum;
    }

    public int getGsid() {
        return gsid;
    }

    public void setGsid(int gsid) {
        this.gsid = gsid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public int getSnum() {
        return snum;
    }

    public void setSnum(int snum) {
        this.snum = snum;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public double getGprice() {
        return gprice;
    }

    public void setGprice(double gprice) {
        this.gprice = gprice;
    }

    public int getGnum() {
        return gnum;
    }

    public void setGnum(int gnum) {
        this.gnum = gnum;
    }

    public int getAllsellnum() {
        return allsellnum;
    }

    public void setAllsellnum(int allsellnum) {
        this.allsellnum = allsellnum;
    }
}
