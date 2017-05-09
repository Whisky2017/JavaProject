package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by wskyt on 2017/5/5.
 */
public class DbClose {
    public static void closeAll(PreparedStatement preparedStatement, ResultSet resultSet, Connection connection){
        try{
            if (preparedStatement != null){
                preparedStatement.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if (resultSet != null){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        try{
            if (connection != null){
                connection.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
