package com.test.P1_shoppingmanage.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Created by wskyt on 2017/4/14.
 */
public final class DbConn {
    public static Connection getConn(){

        String driver = "com.mysql.jdbc.Driver";
        String username = "wskyt";
        String password = "1234";
        String url = "jdbc:mysql://localhost:3306/p1_shop";
        Connection conn = null;

        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url,username,password);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;

    }
}
