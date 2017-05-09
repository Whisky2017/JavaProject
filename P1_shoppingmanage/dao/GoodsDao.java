package com.test.P1_shoppingmanage.dao;

import com.test.P1_shoppingmanage.db.DbClose;
import com.test.P1_shoppingmanage.db.DbConn;
import com.test.P1_shoppingmanage.pojo.Goods;
import com.test.P1_shoppingmanage.util.ScannerUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public final class GoodsDao {

    private Connection connection = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;

    public boolean addGoods(Goods goods){
        boolean flag = false;
        connection = DbConn.getConn();
        String sql = "INSERT INTO goods(gname, gprice, gnum) VALUES(?,?,?)";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,goods.getGname());
            preparedStatement.setDouble(2,goods.getGprice());
            preparedStatement.setInt(3,goods.getGnum());

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

    public boolean deleteGoodsById(int gid){
        boolean flag = false;
        connection = DbConn.getConn();
        String sql = "DELETE FROM goods WHERE gid=?";
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,gid);

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

    public boolean updateGoods(int key, Goods goods){
        boolean flag = false;
        connection = DbConn.getConn();

        switch (key){
            case 1://update gname
                String sql1 = "UPDATE goods SET gname = ? WHERE gid = ?";
                try{
                    preparedStatement = connection.prepareStatement(sql1);
                    preparedStatement.setString(1,goods.getGname());
                    preparedStatement.setInt(2,goods.getGid());

                    if (preparedStatement.executeUpdate() > 0){
                        flag = true;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn( preparedStatement,resultSet,connection);
                }
                break;
            case 2://update gprice
                String sql2 = "UPDATE goods SET gprice = ? WHERE gid = ?";
                try{
                    preparedStatement = connection.prepareStatement(sql2);
                    preparedStatement.setDouble(1,goods.getGprice());
                    preparedStatement.setInt(2,goods.getGid());

                    if (preparedStatement.executeUpdate() > 0){
                        flag = true;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn( preparedStatement,resultSet,connection);
                }
                break;
            case 3://update gnum
                String sql3 = "UPDATE goods SET gnum = ? WHERE gid = ?";
                try{
                    preparedStatement = connection.prepareStatement(sql3);
                    preparedStatement.setInt(1,goods.getGnum());
                    preparedStatement.setInt(2,goods.getGid());

                    if (preparedStatement.executeUpdate() > 0){
                        flag = true;
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn( preparedStatement,resultSet,connection);
                }
                break;
            default:
                break;
        }
        return flag;
    }

    public ArrayList<Goods> queryGoodById(int gid){
        String sql = "SELECT * FROM goods WHERE gid = ?";
        connection = DbConn.getConn();
        ArrayList<Goods> list = new ArrayList<>();
        try{
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,gid);
            resultSet = preparedStatement.executeQuery();
            resultSet.next();
            int ggid = resultSet.getInt(1);
            String gname = resultSet.getString(2);
            double gprice = resultSet.getDouble(3);
            int gnum = resultSet.getInt(4);
             Goods goods = new Goods(ggid,gname,gprice,gnum);
             list.add(goods);
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
    }

    public ArrayList<Goods> queryGoods(int key){
        ArrayList<Goods> list = new ArrayList<>();
        boolean flag = false;
        connection = DbConn.getConn();

        switch (key){
            case 1://query by gnum asc
                String sql1 = "SELECT * FROM goods ORDER BY gnum ASC";
                try{
                    preparedStatement = connection.prepareStatement(sql1);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int gid = resultSet.getInt(1);
                        String gname = resultSet.getString(2);
                        double gprice = resultSet.getDouble(3);
                        int gnum = resultSet.getInt(4);

                        Goods goods = new Goods(gid,gname,gprice,gnum);
                        list.add(goods);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn(preparedStatement,resultSet,connection);
                }
                break;
            case 2://query by gprice asc
                String sql2 = "SELECT * FROM goods ORDER BY gprice ASC";
                try{
                    preparedStatement = connection.prepareStatement(sql2);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int gid = resultSet.getInt(1);
                        String gname = resultSet.getString(2);
                        double gprice = resultSet.getDouble(3);
                        int gnum = resultSet.getInt(4);

                        Goods goods = new Goods(gid,gname,gprice,gnum);
                        list.add(goods);
                    }
                }catch (SQLException e){
                    e.printStackTrace();
                }finally {
                    DbClose.closeConn(preparedStatement,resultSet,connection);
                }
                break;
            case 3:// query by keyword
                String name = ScannerUtil.ScannerString();
                String sql3 = "SELECT * FROM goods WHERE gname LIKE '%"+ name+"%'";//模糊匹配
                try{
                    preparedStatement = connection.prepareStatement(sql3);
//                    preparedStatement.setString(1,name);
                    resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()){
                        int gid = resultSet.getInt(1);
                        String gname = resultSet.getString(2);
                        double gprice = resultSet.getDouble(3);
                        int gnum = resultSet.getInt(4);

                        Goods goods = new Goods(gid,gname,gprice,gnum);
                        list.add(goods);
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

        return list;
    }

public ArrayList<Goods> displayGoods(){
        ArrayList<Goods> list = new ArrayList<>();
        String sql = "SELECT * FROM goods";
        try{
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                int gid = resultSet.getInt(1);
                String gname = resultSet.getString(2);
                double gprice = resultSet.getDouble(3);
                int gnum = resultSet.getInt(4);

                Goods goods = new Goods(gid,gname,gprice,gnum);
                list.add(goods);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            DbClose.closeConn(preparedStatement,resultSet,connection);
        }
        return list;
}


}
