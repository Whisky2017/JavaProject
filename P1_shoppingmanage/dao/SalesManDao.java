package com.test.P1_shoppingmanage.dao;

import com.test.P1_shoppingmanage.db.DbClose;
import com.test.P1_shoppingmanage.db.DbConn;
import com.test.P1_shoppingmanage.pojo.SalesMan;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public final class SalesManDao {

    PreparedStatement preparedStatement = null;
    ResultSet resultSet  = null;
    Connection connection = null;

    public ArrayList<SalesMan> getSalesManByName(String name){
        ArrayList<SalesMan> list = new ArrayList<>();
        String sql = "SELECT * FROM salesman WHERE sname = ?";
        connection = DbConn.getConn();

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int sid = resultSet.getInt(1);
                String spassword = resultSet.getString(2);
                String sname = resultSet.getString(3);

                SalesMan salesMan = new SalesMan(sid,spassword,sname);
                list.add(salesMan);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
    }

    public boolean addSalesMan(SalesMan salesMan){
        boolean flag = false;
        String sql = "INSERT INTO salesman(sid,spassword,sname) VALUES(?,?,?)";
        connection = DbConn.getConn();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,salesMan.getSid());
            preparedStatement.setString(2,salesMan.getPassword());
            preparedStatement.setString(3,salesMan.getSname());

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

    public boolean updateSalesMan(int key,SalesMan salesMan){
        boolean flag = false;
        connection = DbConn.getConn();
        switch (key){
            case 1://update sname
                String sql1 = "UPDATE salesman SET sname = ? WHERE sid = ?";

                try{
                    preparedStatement = connection.prepareStatement(sql1);
                    preparedStatement.setString(1,salesMan.getSname());
                    preparedStatement.setInt(2,salesMan.getSid());

                    if (preparedStatement.executeUpdate() > 0){
                        flag = true;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn(preparedStatement,resultSet,connection);
                }
                break;
            case 2://update spassword
                String sql2 = "UPDATE salesman SET spassword = ? WHERE sid = ?";

                try{
                    preparedStatement = connection.prepareStatement(sql2);
                    preparedStatement.setString(1,salesMan.getPassword());
                    preparedStatement.setInt(2,salesMan.getSid());

                    if (preparedStatement.executeUpdate() > 0){
                        flag = true;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn(preparedStatement,resultSet,connection);
                }
                break;
            default:
                break;
        }
        return flag;
    }

    public boolean deleteSalesManByName(String name){
        boolean flag = false;
        connection = DbConn.getConn();
        String sql = "DELETE FROM salesman WHERE sname = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);

            if (preparedStatement.executeUpdate() > 0){
                flag =true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return flag;
    }

    public ArrayList<SalesMan> querySalesManByName(String name){
        ArrayList<SalesMan> list = new ArrayList<>();
        connection = DbConn.getConn();
        String sql = "SELECT * FROM salesman WHERE sname = ?";

        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,name);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int sid = resultSet.getInt(1);
                String spassword = resultSet.getString(2);
                String sname = resultSet.getString(3);

                SalesMan salesMan = new SalesMan(sid,spassword,sname);
                list.add(salesMan);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
    }

    public  ArrayList<SalesMan> displaySalesMan(){
        ArrayList<SalesMan> list = new ArrayList<>();
        connection = DbConn.getConn();
        String sql = "SELECT * FROM salesman";

        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int sid = resultSet.getInt(1);
                String spassword = resultSet.getString(2);
                String sname = resultSet.getString(3);

                SalesMan salesMan = new SalesMan(sid,spassword,sname);
                list.add(salesMan);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
    }
}
