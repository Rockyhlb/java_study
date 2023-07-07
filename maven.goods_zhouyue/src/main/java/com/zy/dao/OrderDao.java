package com.zy.dao;

import com.zy.entity.order_zhouyue;
import com.zy.factory.JdbcFactory;
import com.zy.factory.OrderHelpFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class OrderDao implements IDao{

    order_zhouyue order_zhouyue = null;
    Scanner sc = null;

    @Override
    public void add(JdbcFactory jdbcFactory) {
        sc = new Scanner(System.in);
        order_zhouyue = new order_zhouyue();
        try {
            System.out.print("请输入商品id：");
            order_zhouyue.setGoods_id(sc.nextLine());
            System.out.print("请输入商品类别：");
            order_zhouyue.setType(sc.nextLine());
            System.out.print("请输入商品名称：");
            order_zhouyue.setName(sc.nextLine());
            System.out.print("请输入商品价格：");
            order_zhouyue.setPrice(sc.nextFloat());
            sc.nextLine();
            System.out.print("请输入商品数量：");
            order_zhouyue.setNum(sc.nextInt());
            sc.nextLine();

            order_zhouyue.setSell_time(LocalDate.now());

            Object[] args = {order_zhouyue.getGoods_id(),order_zhouyue.getType(),order_zhouyue.getName(),order_zhouyue.getPrice(),
                    order_zhouyue.getNum(),order_zhouyue.getSell_time()};

            Date date = new Date();

            try {
                int row = jdbcFactory.executeUpdate("insert into order_zhouyue values(?,?,?,?,?,?);",args);
                if (0 != row){
                    System.out.println("添加成功！");
                }
                else {
                    System.out.println("添加失败！");
                }
            }
            catch (SQLException e){
                System.out.println("操作失败！");
            }
        }
        catch (Exception e){
            System.out.println("输入错误！");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(JdbcFactory jdbcFactory) {
        // 根据id删除信息
        order_zhouyue = new order_zhouyue();
        sc = new Scanner(System.in);

        try {
            System.out.print("请输入待删除商品信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                OrderHelpFactory OrderHelpFactory = (OrderHelpFactory)jdbcFactory;
                flag = OrderHelpFactory.executeQuery("select * from order_zhouyue  where id = ?",id);
                order_zhouyue.setGoods_id(id);
            }

            if (0 != flag){
                System.out.print("确定删除？(Y or F)：");
                String sureStatemant = sc.nextLine();
                if (sureStatemant.equals("Y")){
                    Object[] args = {order_zhouyue.getGoods_id()};
                    try {
                        int row = jdbcFactory.executeUpdate("delete from order_zhouyue where id=?",args);
                        if (0 != row){
                            System.out.println("删除成功");
                        }
                        else {
                            System.out.println("货架上无该商品...");
                        }
                    }
                    catch (SQLException e){
                        System.out.println("删除数据失败..");
                    }
                }
                else {
                    System.out.println("取消成功...");
                }
            }
            else {
                System.out.println("操作失误...");
            }
        }
        catch (Exception e){
            System.out.print("输入错误，请重新输入：");
        }
    }

    @Override
    public void select(JdbcFactory jdbcFactory,String select_sql) throws SQLException {
        jdbcFactory.executeQuery(select_sql);
    }

    @Override
    public void update(JdbcFactory jdbcFactory) {
        // 根据id修改信息
        sc = new Scanner(System.in);
        order_zhouyue = new order_zhouyue();
        try {
            System.out.print("请输入待修改商品信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                order_zhouyue.setGoods_id(id);
                // 向下转型
                OrderHelpFactory OrderHelpFactory = (OrderHelpFactory)jdbcFactory;
                flag = OrderHelpFactory.executeQuery("select * from order_zhouyue where id = ?",id);
            }
            if (0 != flag)
            {
                System.out.print("请输入需要修改的商品名称：");
                order_zhouyue.setName(sc.nextLine());
                System.out.print("请输入需要修改的价格：");
                order_zhouyue.setPrice(sc.nextFloat());
                sc.nextLine();
                System.out.print("请输入需要修改的数量：");
                order_zhouyue.setNum(sc.nextInt());

                Object[] args = {order_zhouyue.getName(),order_zhouyue.getPrice(),order_zhouyue.getNum(),order_zhouyue.getGoods_id()};

                try {
                    int row = jdbcFactory.executeUpdate("update order_zhouyue set name=?,price=?,num=? where id=?",args);

                    if (0 != row){
                        System.out.println("修改成功!");
                    }
                }
                catch (SQLException e){
                    System.out.println("修改数据失败!");
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("操作失误...");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.print("输入错误，请重新输入：");
        }
    }
}
