package com.test.P1_shoppingmanage.page;


import com.test.P1_shoppingmanage.dao.GsalesDao;
import com.test.P1_shoppingmanage.pojo.Gsales;
import com.test.P1_shoppingmanage.util.ScannerUtil;

import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public class GsalesPage extends ScannerUtil{
    public static void displayGsales(){
        System.out.println("\t正在执行列出当日售出商品列表操作\n");
        ArrayList<Gsales> list = new GsalesDao().dailyGsales();

        if (list == null || list.size() == 0){
            System.err.println("\t！！今日无商品售出！！");
            MainPage.mainPage();
        }else {
            System.out.println("\t\t\t\t今日售出商品列表\n");
            System.out.println("\t商品名称\t\t商品价格\t\t商品数量\t\t销量\t\t备注\n");

            for (Gsales gsales : list){
                System.out.print("\t"+gsales.getGname()+"\t\t"+gsales.getGprice()+" $\t\t"+gsales.getGnum()+"\t\t"+gsales.getAllsellnum());
                int gNUm = gsales.getGnum();
                if (gNUm==0)
                {
                    System.out.println("\t\t该商品已售空");
                }else if (gNUm<10)
                {
                    System.out.println("\t\t该商品已不足10件");
                }else
                {
                    System.out.println("\t\t-");
                }
                System.out.println("\t");
            }
            do
            {
                System.out.println("\n\n输入 0 返回上一级菜单");
                String input = ScannerString();
                if ("0".equals(input))
                {
                    MainPage.mainPage();
                }
                System.err.println("！输入有误！");
                System.out.println("请重新选择,或者按0返回上一级菜单.");
            } while (true);
        }
    }

}
