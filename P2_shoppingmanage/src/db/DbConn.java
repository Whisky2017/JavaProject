package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by wskyt on 2017/5/5.
 */
public class DbConn {
    public static Connection getConn(){
        Connection connection = null;
        String driver = "com.mysql.jdbc.Driver";
        String username = "wskyt";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/p2_shop";
        try{
            Class.forName(driver);
            connection = DriverManager.getConnection(url,username,password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }
}
