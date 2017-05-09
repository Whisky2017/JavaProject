package com.test.P1_shoppingmanage.test;

import org.junit.Test;
import com.test.P1_shoppingmanage.db.*;

import java.sql.Connection;

/**
 * Created by wskyt on 2017/4/14.
 */
public class DbTest {

    @Test
    public void DbConnTest(){
        Connection connection = DbConn.getConn();
        System.out.println(connection.toString());
    }



}
