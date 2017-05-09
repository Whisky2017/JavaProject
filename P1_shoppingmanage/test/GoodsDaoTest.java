package com.test.P1_shoppingmanage.test;

import com.test.P1_shoppingmanage.dao.GoodsDao;
import com.test.P1_shoppingmanage.pojo.Goods;
import org.junit.Test;

/**
 * Created by wskyt on 2017/4/24.
 */
public class GoodsDaoTest {

    @Test
    public void add(){
        Goods goods = new Goods("test",10.00,100);
        boolean add = new GoodsDao().addGoods(goods);
    }



}
