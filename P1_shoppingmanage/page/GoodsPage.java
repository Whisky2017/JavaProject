package com.test.P1_shoppingmanage.page;

import com.test.P1_shoppingmanage.dao.GoodsDao;
import com.test.P1_shoppingmanage.pojo.Goods;
import com.test.P1_shoppingmanage.util.ScannerUtil;

import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public class GoodsPage extends ScannerUtil {
    public static void addGoodsPage(){
        System.out.println("\t正在执行添加商品操作\n");

        System.out.println("\n请输入添加商品-名称");
        String goodsName = ScannerString();

        System.out.println("\n请输入添加商品-价格");
        double goodsPrice = ScannerDouble();

        System.out.println("\n请输入添加商品-数量");
        int goodsNumber = ScannerNum();

        Goods goods = new Goods(goodsName,goodsPrice,goodsNumber);
        boolean insert = new GoodsDao().addGoods(goods);

        if (insert){
            System.out.println("添加商品成功！");
        }else {
            System.err.println("添加商品失败！");
        }
        changedInfoNext("addGoodsPage");
    }
    public static void deleteGoodsPage(){
        System.out.println("\t正在执行删除商品操作\n");

        System.out.println("\n请输入删除商品-编号");
        int gid = ScannerNum();

        boolean delete = new GoodsDao().deleteGoodsById(gid);

        if (delete){
            System.out.println("删除商品成功！");
        }else {
            System.err.println("删除商品失败！");
        }
        changedInfoNext("deleteGoodsPage");
    }
    public static void queryGoodsPage(){
        System.out.println("\t正在执行查询商品操作\n");

        System.out.println("\t 1、按照商品编号查询\n");
        System.out.println("\t 2、按照商品关键字查询\n");
        System.out.println("\n请输入选项,或者按0返回上一级菜单.");

        ArrayList<Goods> list = new ArrayList<>();

        do {
            String input = ScannerString();
            String regex = "[0-2]";
            if (input.matches(regex)){
                switch (input){
                    case "0":
                        MainPage.mainPage();
                        break;
                    case "1":
                    case "2":
                        if ("1".equals(input)){
                            System.out.println("您选择方式1.");
                            int gid = ScannerNum();
                            list = new GoodsDao().queryGoodById(gid);
                        }else if ("2".equals(input)){
                            System.out.println("您选择方式2.");
                            list = new GoodsDao().queryGoods(3);
                        }
                        if (list == null || list.size() <= 0)
                        {
                            System.err.println("\n\t!!您查询的商品不存在!!\n");
                            queryGoodsPage();
                        }else {
                            System.out.println("\t\t\t\t\t您所查找的商品如下\n\n");
                            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
                            for (Goods goods : list) {
                                System.out.print("\t" + goods.getGid() + "\t\t" + goods.getGname() + "\t\t" + goods.getGprice() + "\t\t" + goods.getGnum());
                                int gnum = goods.getGnum();
                                if (gnum == 0) {
                                    System.out.println("\t\t该商品已售空！");
                                } else if (gnum < 10) {
                                    System.out.println("\t\t该商品已不足10件");
                                } else {
                                    System.out.println("\t\t-");
                                }
                                System.out.println("\t");
                            }
                            System.out.println("---------------------");
                        }
                        changedInfoNext("queryGoodsPage");
                        break;
                    default:
                        break;
                }
            }
            System.err.println("输入有误！");
            System.out.println("请重新选择,或者按0返回上一级菜单.");
        }while(true);
    }
    public static void displayGoodsPage(){
        System.out.println("\t正在执行查看商品列表操作\n");

        System.out.println("\t 1、按照商品数量升序排列\n");
        System.out.println("\t 2、按照商品价格升序排列\n");
        System.out.println("\t 3、按照数据库默认排序\n");
        System.out.println("\n请输入选项,或者按0返回上一级菜单.");

        ArrayList<Goods> list = new ArrayList<>();

        do {
            String input = ScannerString();
            String regex = "[0-3]";
            if (input.matches(regex)){
                switch (input){
                    case "0":
                        MainPage.mainPage();
                        break;
                    case "1":
                    case "2":
                    case "3":
                        if ("1".equals(input)){
                            System.out.println("您选择方式1.");
                            int gid = ScannerNum();
                            list = new GoodsDao().queryGoods(1);
                        }else if ("2".equals(input)){
                            System.out.println("您选择方式2.");
                            list = new GoodsDao().queryGoods(2);
                        }
                        else if ("3".equals(input)){
                            System.out.println("您选择方式3.");
                            list = new GoodsDao().displayGoods();
                        }
                        if (list == null || list.size() <= 0)
                        {
                            System.err.println("\n\t!!您查询的商品不存在!!\n");
                            queryGoodsPage();
                        }else {
                            System.out.println("\t\t\t\t\t您所查找的商品如下\n\n");
                            System.out.println("\t商品编号\t\t商品名称\t\t商品价格\t\t商品数量\t\t备注\n");
                            for (Goods goods : list) {
                                System.out.print("\t" + goods.getGid() + "\t\t" + goods.getGname() + "\t\t" + goods.getGprice() + "\t\t" + goods.getGnum());
                                int gnum = goods.getGnum();
                                if (gnum == 0) {
                                    System.out.println("\t\t该商品已售空！");
                                } else if (gnum < 10) {
                                    System.out.println("\t\t该商品已不足10件");
                                } else {
                                    System.out.println("\t\t-");
                                }
                                System.out.println("\t");
                            }
                            System.out.println("---------------------");
                        }
                        changedInfoNext("displayGoodsPage");
                        break;
                    default:
                        break;
                }
            }
            System.err.println("输入有误！");
            System.out.println("请重新选择,或者按0返回上一级菜单.");
        }while(true);

    }
    public static void updateGoodsPage(){
        System.out.println("\t正在执行更改商品操作\n");
        System.out.println("请输入想要更改的商品编号");

        int gid = ScannerNum();

        System.out.println("\n--------请选择您要更改的内容\n");
        System.out.println("\t1.更改商品-名称");
        System.out.println("\t2.更改商品-价格");
        System.out.println("\t3.更改商品-数量");
        System.out.println("\n请输入选项,或者按0返回上一级菜单.");
        do
        {
            String input = ScannerString();
            String regex = "[0-3]";
            if (input.matches(regex))
            {
                switch (input)
                {
                    case "0":
                        MainPage.mainPage();
                        break;
                    case "1":
                        System.out.println("请输入商品-新名称");
                        String gname = ScannerString();
                        Goods goods1 = new Goods(gid,gname);
                        boolean update1 = new GoodsDao().updateGoods(1, goods1);
                        if (update1)
                        {
                            System.out.println("\n\t！！成功更新商品名至数据库！！\n");
                        }else
                        {
                            System.err.println("\n\t！！更新商品名失败！！");
                        }
                        changedInfoNext("updateGoodsPage");
                        break;
                    case "2":
                        System.out.println("请输入商品-新价格 ");
                        double gprice = ScannerDouble();
                        Goods  goods2 = new Goods(gid,gprice);
                        boolean update2 = new GoodsDao().updateGoods(2,goods2);

                        if (update2)
                        {
                            System.out.println("\n\t！！成功更新商品价格至数据库！！\n");
                        }else
                        {
                            System.err.println("\n\t！！更新商品价格失败！！");
                        }
                        changedInfoNext("updateGoodsPage");
                        break;
                    case "3":
                        System.out.println("请输入商品-新数量 ");
                        int gNum = ScannerNum();
                        Goods  goods3 = new Goods(gid,gNum);
                        boolean update3 = new GoodsDao().updateGoods(3,goods3);
                        if (update3)
                        {
                            System.out.println("\n\t！！成功更新商品数量至数据库！！\n");
                        }else
                        {
                            System.err.println("\n\t！！更新商品数量失败！！");
                        }
                        changedInfoNext("updateGoodsPage");
                        break;
                    default:
                        System.out.println("请输入正确的选择！");
                        break;
                }
            }
            System.err.println("！输入有误！");
            System.out.println("请重新选择,或者按0返回上一级菜单.");
        } while (true);
    }
}
