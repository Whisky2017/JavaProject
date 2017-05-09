package com.test.P1_shoppingmanage.page;


import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import com.test.P1_shoppingmanage.dao.GoodsDao;
import com.test.P1_shoppingmanage.dao.GsalesDao;
import com.test.P1_shoppingmanage.dao.SalesManDao;
import com.test.P1_shoppingmanage.pojo.Goods;
import com.test.P1_shoppingmanage.pojo.Gsales;
import com.test.P1_shoppingmanage.pojo.SalesList;
import com.test.P1_shoppingmanage.pojo.SalesMan;
import com.test.P1_shoppingmanage.util.Arith;
import com.test.P1_shoppingmanage.util.ScannerUtil;

import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public class MainPage extends ScannerUtil {
    public static void main(String[] args) {
        mainPage();
    }

    /**
     * 主界面
     */
    public static void mainPage(){
        System.out.println("************************\n");
        System.out.println("\t 当前位置：首页\n");
        System.out.println("************************\n");
        System.out.println("\t 1、商品管理\n");
        System.out.println("\t 2、售货员管理\n");
        System.out.println("\t 3、前台收银\n");
        System.out.println("\t 4、当日销售情况\n");
        System.out.println("*************************\n");

        System.out.println("\n 请输入选项，或者按0退出系统.");

        do {
            String input = ScannerString();
            String regex = "[0-4]";
            if (input.matches(regex)){
                switch (input){
                    case "0":
                        System.out.println("--------------------------");
                        System.out.println("您已成功退出系统！");
                        System.exit(1);
                        break;
                    case "1":
                        commodityManagementPage();
                        break;
                    case "2":
                        salesManManagementPage();
                        break;
                    case "3":
                        checkstandLogPage();
                        break;
                    case "4":
                        gsalesPage();
                    default:
                        break;
                }
            }
            System.err.println("Error:输入有误！");
            System.out.println("重新选择或按0退出.");
        }while(true);
    }

    /**
     * 1、商品管理页面
     */
    public static void commodityManagementPage(){
        System.out.println("****************************\n");
        System.out.println("\t 当前位置：首页>>商品管理\n");
        System.out.println("****************************\n");
        System.out.println("\t 1、添加商品\n");
        System.out.println("\t 2、更改商品\n");
        System.out.println("\t 3、删除商品\n");
        System.out.println("\t 4、查询商品\n");
        System.out.println("\t 5、显示所有商品\n");
        System.out.println("****************************\n");

        System.out.println("\n 请输入选项，或者按0返回上一级菜单！.");
        do {
            String input = ScannerString();
            String regex = "[0-5]";
            if (input.matches(regex)){
                switch (input){
                    case "0"://只预留一个出口
                        mainPage();
                        break;
                    case "1":
                        GoodsPage.addGoodsPage();
                        break;
                    case "2":
                        GoodsPage.updateGoodsPage();
                        break;
                    case "3":
                        GoodsPage.deleteGoodsPage();
                        break;
                    case "4":
                        GoodsPage.queryGoodsPage();
                        break;
                    case "5":
                        GoodsPage.displayGoodsPage();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("Error:输入有误！");
            System.out.println("重新选择或按0返回上一级菜单.");
        }while (true);
    }

    /**
     * 2、售货员管理
     */
    public static void salesManManagementPage(){
        System.out.println("****************************\n");
        System.out.println("\t 当前位置：首页>>售货员管理\n");
        System.out.println("****************************\n");
        System.out.println("\t 1、添加售货员\n");
        System.out.println("\t 2、更改售货员\n");
        System.out.println("\t 3、删除售货员\n");
        System.out.println("\t 4、查询售货员\n");
        System.out.println("\t 5、显示所有售货员\n");
        System.out.println("****************************\n");

        System.out.println("\n 请输入选项，或者按0返回上一级菜单！.");

        do {
            String input = ScannerString();
            String regex = "[0-5]";
            if (input.matches(regex)) {
                switch (input) {
                    case "0"://只预留一个出口
                        mainPage();
                        break;
                    case "1":
                        SalesManPage.addSalesMan();
                        break;
                    case "2":
                        SalesManPage.updateSalesMan();
                        break;
                    case "3":
                        SalesManPage.deleteSalesMan();
                        break;
                    case "4":
                        SalesManPage.querySalesMan();
                        break;
                    case "5":
                        SalesManPage.displaySalesMan();
                        break;
                    default:
                        break;
                }
            }
            System.err.println("Error:输入有误！");
            System.out.println("重新选择或按0返回上一级菜单.");
        } while (true);
    }

    /**
     * 3、前台收银页面
     */
    public static void checkstandLogPage() {
        System.out.println("****************************\n");
        System.out.println("\t 当前位置：首页>>前台收银\n");
        System.out.println("****************************\n");
        System.out.println("\t 1、登录系统\n");
        System.out.println("\t 2、退出\n");
        System.out.println("****************************\n");

        System.out.println("\n 请输入选项，或者按0返回上一级菜单！.");

        do {
            String input = ScannerString();
            String regex = "[0-2]";
            if (input.matches(regex)) {
                switch (input) {
                    case "0"://只预留一个出口
                        mainPage();
                        break;
                    case "1":
                        salesManLoginPage();
                        break;
                    case "2":
                        System.out.println("-----------------------");
                        System.out.println("\t 您已退出系统！");
                        System.exit(1);
                        break;
                    default:
                        break;
                }
            }
            System.err.println("Error:输入有误！");
            System.out.println("重新选择或按0返回上一级菜单.");
        } while (true);
    }

    /**
     * 售货员登录系统
     */
    public static void salesManLoginPage(){
        System.out.println("****************************\n");
        System.out.println("\t 当前位置：首页>>前台收银>>登录\n");
        System.out.println("****************************\n");
        int loginTimes = 3;
        while(loginTimes > 0){
            loginTimes--;
            System.out.println("--用户名--");
            String input1 = ScannerString();
            System.out.println("--密码--");
            String input2 = ScannerString();

            ArrayList<SalesMan> list = new SalesManDao().getSalesManByName(input1);

            if (list == null || list.size() == 0){
                System.err.println("\t 用户名输入错误！\n");
                System.out.println("\t 剩余登录次数 "+ loginTimes+"\n");
            }else {
                for (SalesMan salesMan : list){
                    if (salesMan.getPassword().equals(input2)){
                        System.out.println("\t----用户登录成功！----\n");
                        //登录成功后进入购物结算页面
                        shoppingSettlementPage(salesMan.getSid());
                    }
                }
                System.err.println("\t密码输入错误！\n");
                System.out.println("\t剩余登录次数 "+ loginTimes+"\n");
            }
        }
        System.out.println("-------------------------");
        System.err.println("\t！！您已经被强制退出系统！");
        System.exit(1);
    }

    /**
     * 购物结算页面
         */
        public static void shoppingSettlementPage(int salesManid) {
            System.out.println("****************************\n");
            System.out.println("\t 当前位置：首页>>前台收银>>购物结算\n");
            System.out.println("****************************\n");
            int flag = 1;
            ArrayList<SalesList> salesLists = new ArrayList<>();
            do {
                System.out.println("按s或S开始购物结算，按0返回售货员登录页面");
                String input = ScannerString();
                if ("0".equals(input)) {
                    checkstandLogPage();
                } else if ("s".equals(input) || "S".equals(input)) {
                    do {
                        System.out.println("--按照商品名查找--");//可按照三种方式查找，这里使用key =3
                        ArrayList<Goods> list = new GoodsDao().queryGoods(3);
                        if (list == null || list.size() == 0) {
                            System.err.println("\t--无对应商品，请重新输入--");
                        } else {
                            System.out.println("\t\t\t 商品列表\n");
                            System.out.println("\t\t商品编号\t商品名\t商品单价\t库存数量\n");
                            for (Goods goods : list) {
                                System.out.println("\t\t" + goods.getGid() + "   \t" + goods.getGname() + "   \t" + goods.getGprice() + " $   \t" + goods.getGnum() + "   \n");
                            }
                            do {
                                System.out.println("--按列表中商品编号选择商品--");
//                                String inputStr = ScannerString();
//                                int inputInt = Integer.parseInt(inputStr);
                                int inputInt = ScannerNum();
                                Goods goods = new GoodsDao().queryGoodById(inputInt).get(0);

                                System.out.println("--请输入购买数量--");
                                do {
//                                    String inputStr2 = ScannerString();
//                                    int inputInt2 = Integer.parseInt(inputStr2);
                                    int inputInt2 = ScannerNum();
                                    if (inputInt2 > goods.getGnum()) {
                                        System.err.println("\t仓库储备不足！！");
                                        System.out.println("--请重新输入购买数量--");
                                        continue;
                                    } else {
                                        double allPrice = Arith.mul(inputInt2, goods.getGprice());
                                        SalesList salesList = new SalesList(inputInt, goods.getGname(), goods.getGprice(), inputInt2, allPrice, goods.getGnum() - inputInt2);
                                        salesLists.add(salesList);
                                        System.out.println("是否继续选择商品Y/N");
                                        String input2 = ScannerString();
                                        if ("Y".equals(input2) || "y".equals(input2)) {
                                            break;
                                        } else {
                                            flag = 0;
                                            break;
                                        }
                                    }
                                } while (true);
                            } while (flag == 1);
                            System.out.println("\t\t\t  购物车结算\n");
                            System.out.println("\t\t商品名称\t商品单价\t购买数量\t总价\n");
                            double all = 0;
                            for (SalesList salesList : salesLists) {
                                System.out.println("\t\t" + salesList.getGname() + "   \t" + salesList.getGprice() + " $   \t" + salesList.getGnum() + "   \t" + salesList.getAllprice() + " $   \n");
                                all = Arith.add(all, salesList.getAllprice());
                            }
                            do {
                                System.out.println("确认购买：Y/N");
                                String choShopping = ScannerString();
                                if ("y".equals(choShopping) || "Y".equals(choShopping)) {
                                    System.out.println("\n总价：" + all + " $");
                                    System.out.println("\n实际缴费金额");
                                    do {
//                                        String amountStr = ScannerString();
//                                        double amount = Double.parseDouble(amountStr);
                                        double amount = ScannerDouble();
                                        double balance = Arith.sub(amount, all);  //用户交钱与购买物品总价间的差额
                                        if (balance < 0) {
                                            System.err.println("\t！！缴纳金额不足！！");
                                            System.out.println("\n请重新输入缴纳金额($)");
                                        } else {
                                            //更新数据
                                            for (SalesList salesList : salesLists) {
                                                Gsales gsales = new Gsales(salesList.getGid(), salesManid, salesList.getGnum());
                                                boolean insert = new GsalesDao().shoppingSettlement(gsales);

                                                Goods newgoods = new Goods(salesList.getGid(), salesList.getNewnum());
                                                boolean update = new GoodsDao().updateGoods(3,newgoods);

                                                if (insert && update){
                                                    continue;
                                                }else {
                                                    System.err.println("！支付失败！");
                                                    shoppingSettlementPage(salesManid);
                                                }
                                            }
                                            System.out.println("找零："+balance);
                                            System.out.println("\n谢谢光临，欢迎下次惠顾");
                                            shoppingSettlementPage(salesManid);
                                        }
                                    } while (true);//缴纳金额循环
                                }else if ("N".equals(choShopping) || "n".equals(choShopping))
                                {
                                    shoppingSettlementPage(salesManid);
                                }
                                System.err.println("\t请确认购物意向！！");
                            } while (true);
                        }
                    } while (true);
                } else{
                    System.err.println("\t字符输入错误！请输入合法字符！\n");
                }
            }while(true);
        }


    /**
     * 4、当日销售情况页面
     */
    public static void gsalesPage(){
        System.out.println("****************************\n");
        System.out.println("\t 当前位置：首页>>当日销售情况页面\n");
        System.out.println("****************************\n");
        GsalesPage.displayGsales();
        do {
            String input = ScannerString();
            if (input.equals("0")){
                mainPage();
            }
            System.out.println("Error:输入有误！");
            System.out.println("按0返回上一级菜单.");
        }while(true);
    }
}

