package com.test.P1_shoppingmanage.dao;

import com.test.P1_shoppingmanage.db.DbClose;
import com.test.P1_shoppingmanage.db.DbConn;
import com.test.P1_shoppingmanage.pojo.Gsales;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public final class GsalesDao {
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    private Connection connection = null;

    public ArrayList<Gsales> dailyGsales(){
        ArrayList<Gsales> list = new ArrayList<>();
        connection = DbConn.getConn();
        String sql = "SELECT goods.gid,gname,gprice,gnum,snum\n" +
                "FROM goods,gsales\n" +
                "WHERE goods.gid = gsales.gid and TO_DAYS(sdate) = TO_DAYS(NOW())";
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                String gname = resultSet.getString(2);
                double gprice = resultSet.getDouble(3);
                int gnum = resultSet.getInt(4);
                int allsellnum = resultSet.getInt(5);

                Gsales gsales = new Gsales(gname,gprice,gnum,allsellnum);
                list.add(gsales);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
    }

    public boolean shoppingSettlement(Gsales gsales){
        boolean flag = false;
        connection = DbConn.getConn();
        String sql = "INSERT INTO gsales(gid, sid, snum) VALUES(?,?,?)";
        try {
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,gsales.getGid());
            preparedStatement.setInt(2,gsales.getSid());
            preparedStatement.setInt(3,gsales.getSnum());

            if (preparedStatement.executeUpdate() > 0){
                flag = true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return flag;
    }
}
