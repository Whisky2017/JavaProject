package com.test.P1_shoppingmanage.page;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import com.test.P1_shoppingmanage.dao.GsalesDao;
import com.test.P1_shoppingmanage.dao.SalesManDao;
import com.test.P1_shoppingmanage.pojo.SalesMan;
import com.test.P1_shoppingmanage.util.ScannerUtil;

import java.util.ArrayList;

/**
 * Created by wskyt on 2017/4/14.
 */
public class SalesManPage extends ScannerUtil {
    public static void addSalesMan(){
        System.out.println("\t正在执行添加售货员操作\n");

        System.out.println("\n添加售货员-姓名");
        String sName = ScannerString();

        System.out.println("\n添加售货员-密码");
        String sPssswd = ScannerString();

        SalesMan salesMan = new SalesMan(sPssswd,sName);
        boolean bool = new SalesManDao().addSalesMan(salesMan);

        if (bool)
        {
            System.out.println("\n\t!您已成功添加售货员到数据库!");
        }else
        {
            System.out.println("添加售货员失败");
        }
        changedInfoNext("addSalesManPage");
    }
    public static void deleteSalesMan(){
        System.out.println("\t正在执行 删除售货员 操作\n");
        System.out.println("请输入想要删除的售货员名字");
        String sName = ScannerString();

        boolean delete = new SalesManDao().deleteSalesManByName(sName);

        if (delete)
        {
            System.out.println("\n\t!您已成功删除售货员!");
        }else
        {
            System.out.println("删除售货员失败");
        }
        changedInfoNext("deleteSalesManPage");
    }
    public static void updateSalesMan(){
        System.out.println("\t正在执行更改售货员操作\n");
        System.out.println("请输入想要更改的售货员名字");
        String sName = ScannerString();

        ArrayList<SalesMan> list = new SalesManDao().querySalesManByName(sName);
        if (list == null || list.size() == 0){
            System.err.println("\t！！查无此人！！");
            changedInfoNext("updateSalesManPage");
        }else {
            //显示将要更改的售货员信息
            System.out.println("\t\t\t售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");

            SalesMan salesMan = list.get(0); //上面的精确查找中，只能返回一组数值。无需遍历！
            System.out.println("\t"+salesMan.getSid()+"\t\t\t"+salesMan.getSname()+"\t\t\t"+salesMan.getPassword());
            System.out.println();

            //选择更改售货员内容
            System.out.println("\n--------请选择您要更改的内容\n");
            System.out.println("\t1.更改售货员-姓名");
            System.out.println("\t2.更改售货员-密码");
            System.out.println("\n请输入选项,或者按 0 返回上一级菜单.");

            do
            {
                String choice = ScannerString();
                String regex  = "[0-2]";
                if (choice.matches(regex))
                {
                    int info = Integer.parseInt(choice);
                    switch (info)
                    {
                        case 0:
                            MainPage.salesManManagementPage();
                            break;
                        case 1:
                            System.out.println("更改售货员-新姓名");
                            String sNewName = ScannerString();

                            SalesMan salesManName = new SalesMan(salesMan.getSid(),null,sNewName);
                            boolean boolsName = new SalesManDao().updateSalesMan(1, salesManName);

                            if (boolsName)
                            {
                                System.out.println("\n\t！！成功更新售货员名字至数据库！！\n");
                            }else
                            {
                                System.err.println("\n\t！！更新售货员名字失敗！！");
                            }
                            changedInfoNext("updateSalesManPage");
                            break;
                        case 2:
                            System.out.println("更改售货员-新密码");
                            String sNewPasswd = ScannerString();

                            SalesMan salesManPasswd = new SalesMan(salesMan.getSid(),sNewPasswd,null);
                            boolean boolsPasswd = new SalesManDao().updateSalesMan(2, salesManPasswd);

                            if (boolsPasswd)
                            {
                                System.out.println("\n\t！！成功更新售货员密码至数据库！！\n");
                            }else
                            {
                                System.err.println("\n\t！！更新售货员密码失敗！！");
                            }
                            changedInfoNext("updateSalesManPage");
                            break;
                        default:
                            break;
                    }
                }
                System.out.println("\t!输入有误!");
                System.out.println("\n请选择选项.或者按 0 返回上一级菜单.");
            } while (true);
        }
    }
    public static void querySalesMan(){
        System.out.println("\t\t  正在执行查询售货员操作\n");
        System.out.println("要查询的售货员关键字");
        String sName = ScannerString();

        ArrayList<SalesMan> list = new SalesManDao().querySalesManByName(sName);
        if (list == null || list.size() == 0){
            System.err.println("\t！！查无此人！！");
            changedInfoNext("querySalesManPage");
        }else {
            //显示将要更改的售货员信息
            System.out.println("\t\t\t售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");

            SalesMan salesMan = list.get(0); //上面的精确查找中，只能返回一组数值。无需遍历！
            System.out.println("\t"+salesMan.getSid()+"\t\t\t"+salesMan.getSname()+"\t\t\t"+salesMan.getPassword());
            System.out.println();
        }
        changedInfoNext("querySalesManPage");
    }
    public static void  displaySalesMan(){
        ArrayList<SalesMan> list = new SalesManDao().displaySalesMan();
        if (list == null || list.size() == 0){
            System.err.println("\t！！查无此人！！");
            changedInfoNext("displaySalesManPage");
        }else {
            //显示将要更改的售货员信息
            System.out.println("\t\t\t售货员信息\n\n");
            System.out.println("\t售货员编号\t\t售货员姓名\t\t售货员密码");

            for (SalesMan salesMan : list){
                System.out.println("\t"+salesMan.getSid()+"\t\t\t"+salesMan.getSname()+"\t\t\t"+salesMan.getPassword());
                System.out.println();
            }
            changedInfoNext("displaySalesManPage");
        }
    }
}
