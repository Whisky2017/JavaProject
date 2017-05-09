package pojo;

/**
 * Created by wskyt on 2017/5/5.
 */
public class User{
    private int userid;
    private String username;
    private String password;
    private String telephone;
    private String realname;
    private String backNews = "请注册";

    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    public User(){

    }
    public User(String username,String password,String telephone,String realname){
        this.username = username;
        this.password = password;
        this.telephone = telephone;
        this.realname = realname;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getBackNews() {
        return backNews;
    }

    public void setBackNews(String backNews) {
        this.backNews = backNews;
    }

    public String toString(){
        return "username="+username+" ,password="+password;
    }
}
