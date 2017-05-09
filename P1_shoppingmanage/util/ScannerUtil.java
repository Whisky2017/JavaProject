package com.test.P1_shoppingmanage.util;

import com.test.P1_shoppingmanage.page.GoodsPage;
import com.test.P1_shoppingmanage.page.MainPage;
import com.test.P1_shoppingmanage.page.SalesManPage;
import com.test.P1_shoppingmanage.pojo.SalesMan;

import java.util.Scanner;

/**
 * Created by hust on 2017/4/15.
 */
public class ScannerUtil {
    public static String ScannerString(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入：");
        return scanner.next();
    }

    /**
     * @return int 键盘获取商品数量
     */
    public static int ScannerNum()
    {
        int num = 0;
        String regex = "([1-9])|([1-9][0-9]+)";//商品数量
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("请输入：");
            String nums = sc.next();

            if (nums.matches(regex))
            {
                num = Integer.parseInt(nums);
            }else
            {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);
        return num;
    }

    /**
     * @return double 键盘获取商品价格,小数点后两位
     */
    public static double ScannerDouble()
    {
        double num = 0.00;
        do
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("保留小数点后两位,请输入：");
            String info = sc.next();

            String regex = "(([1-9][0-9]*)\\.([0-9]{2}))|[0]\\.([0-9]{2})";//保留小数点后2位小数
            if (info.matches(regex))
            {
                num = Double.parseDouble(info);
            }else
            {
                System.err.println("！输入有误！");
                continue;
            }
            break;
        } while (true);

        return num;
    }

    public static void changedInfoNext(String info){
        do {
            System.out.println("是否继续进行当前操作：（Y/N）");
            String input = ScannerString();
            if ("Y".equals(input) || "y".equals(input)){
                switch (info){
                    case "addGoodsPage":
                        GoodsPage.addGoodsPage();
                        break;
                    case "deleteGoodsPage":
                        GoodsPage.deleteGoodsPage();;
                        break;
                    case "updateGoodsPage":
                        GoodsPage.updateGoodsPage();
                        break;
                    case "queryGoodsPage":
                        GoodsPage.queryGoodsPage();
                        break;
                    case "displayGoodsPage":
                        GoodsPage.displayGoodsPage();
                        break;
                    case "addSalesManPage":
                        SalesManPage.addSalesMan();
                        break;
                    case "deleteSalesManPage":
                        SalesManPage.deleteSalesMan();
                        break;
                    case "updateSalesManPage":
                        SalesManPage.updateSalesMan();
                        break;
                    case "querySalesManPage":
                        SalesManPage.querySalesMan();
                        break;
                    case "displaySalesManPage":
                        SalesManPage.displaySalesMan();
                        break;
                    default:
                        break;
                }
            }else if ("N".equals(input) || "n".equals(input)){
                MainPage.mainPage();
            }
            System.err.println("输入有误，请重新输入！");
        }while (true);
    }
}
