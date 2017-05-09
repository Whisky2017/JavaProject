package pojo;

import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by wskyt on 2017/5/2.
 */
public class Login implements Serializable {

    private static final long serialVersionUID = 3591141102826385512L;

    private String username = "";
    private String backNews = "未登录";
    private LinkedList<String> car = null;//购物车、订单

    public Login(){
        car = new LinkedList<>();
    }

    public String getUsername() {
        if (username.trim() == ""){
            return "userNull";
        }
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBackNews() {
        return backNews;
    }

    public void setBackNews(String backNews) {
        this.backNews = backNews;
    }

    public LinkedList<String> getCar() {
        return car;
    }

    public void setCar(LinkedList<String> car) {
        this.car = car;
    }
}
