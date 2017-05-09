package dao;

import com.sun.org.apache.regexp.internal.RE;
import db.DbClose;
import db.DbConn;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wskyt on 2017/5/5.
 */
public class UserDao {
    Connection connection = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    public boolean login(User user){
        boolean flag = false;
        connection = DbConn.getConn();

        String sql = "select * from user where username=? and password=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                flag = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeAll(preparedStatement,resultSet,connection);
        }
        return flag;
    }

    public boolean register(User user){
        boolean flag = false;
        connection = DbConn.getConn();

        String sql = "INSERT INTO user(username, password, telephone, realname) VALUES (?,?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,user.getUsername());
            preparedStatement.setString(2,user.getPassword());
            preparedStatement.setString(3,user.getTelephone());
            preparedStatement.setString(4,user.getRealname());

            if (preparedStatement.executeUpdate() > 0){
                flag = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeAll(preparedStatement,resultSet,connection);
        }
        return flag;
    }
}
