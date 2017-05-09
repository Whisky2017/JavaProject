package com.test.P1_shoppingmanage.pojo;

/**
 * Created by wskyt on 2017/4/24.
 */
public class SalesList {
    private int gid;
    private String gname;
    private double gprice;
    private int gnum;
    private double allprice;
    private int newnum;

    public SalesList(int gid, String gname, double gprice, int gnum, double allprice, int newnum){
        this.gid = gid;
        this.gname = gname;
        this.gprice = gprice;
        this.gnum = gnum;
        this.allprice = allprice;
        this.newnum = newnum;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
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

    public double getAllprice() {
        return allprice;
    }

    public void setAllprice(double allprice) {
        this.allprice = allprice;
    }

    public int getNewnum() {
        return newnum;
    }

    public void setNewnum(int newnum) {
        this.newnum = newnum;
    }
}
