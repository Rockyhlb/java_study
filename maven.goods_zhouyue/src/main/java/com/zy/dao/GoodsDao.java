package com.zy.dao;

import com.zy.entity.goods_zhouyue;
import com.zy.factory.JdbcFactory;
import com.zy.factory.MysqlFactory;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;

public class GoodsDao implements IDao {

    goods_zhouyue goods_zhouyue = null;
    Scanner sc = null;

    @Override
    public void add(JdbcFactory jdbcFactory) {
        sc = new Scanner(System.in);
        goods_zhouyue = new goods_zhouyue();
        try {
            System.out.print("请输入商品id：");
            goods_zhouyue.setGoods_id(sc.nextLine());
            System.out.print("请输入商品类别：");
            goods_zhouyue.setType(sc.nextLine());
            System.out.print("请输入商品名称：");
            goods_zhouyue.setName(sc.nextLine());
            System.out.print("请输入商品价格：");
            goods_zhouyue.setPrice(sc.nextFloat());
            sc.nextLine();
            System.out.print("请输入商品数量：");
            goods_zhouyue.setNum(sc.nextInt());
            sc.nextLine();

            goods_zhouyue.setAdd_time(LocalDate.now());

            Object[] args = {goods_zhouyue.getGoods_id(),goods_zhouyue.getType(),goods_zhouyue.getName(),goods_zhouyue.getPrice(),
                            goods_zhouyue.getNum(),goods_zhouyue.getAdd_time()};

            Date date = new Date();

            try {
                int row = jdbcFactory.executeUpdate("insert into goods_zhouyue values(?,?,?,?,?,?);",args);
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
        goods_zhouyue = new goods_zhouyue();
        sc = new Scanner(System.in);

        try {
            System.out.print("请输入待删除商品信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                MysqlFactory mysqlFactory = (MysqlFactory)jdbcFactory;
                flag = mysqlFactory.executeQuery("select * from goods_zhouyue  where id = ?",id);
                goods_zhouyue.setGoods_id(id);
            }

            if (0 != flag){
                System.out.print("确定删除？(Y or F)：");
                String sureStatemant = sc.nextLine();
                if (sureStatemant.equals("Y")){
                    Object[] args = {goods_zhouyue.getGoods_id()};
                    try {
                        int row = jdbcFactory.executeUpdate("delete from goods_zhouyue where id=?",args);
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
        goods_zhouyue = new goods_zhouyue();
        try {
            System.out.print("请输入待修改商品信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                goods_zhouyue.setGoods_id(id);
                // 向下转型
                MysqlFactory mysqlFactory = (MysqlFactory)jdbcFactory;
                flag = mysqlFactory.executeQuery("select * from goods_zhouyue where id = ?",id);
            }
            if (0 != flag)
            {
                System.out.print("请输入需要修改的商品名称：");
                goods_zhouyue.setName(sc.nextLine());
                System.out.print("请输入需要修改的价格：");
                goods_zhouyue.setPrice(sc.nextFloat());
                sc.nextLine();
                System.out.print("请输入需要修改的数量：");
                goods_zhouyue.setNum(sc.nextInt());

                Object[] args = {goods_zhouyue.getName(),goods_zhouyue.getPrice(),goods_zhouyue.getNum(),goods_zhouyue.getGoods_id()};

                try {
                    int row = jdbcFactory.executeUpdate("update goods_zhouyue set name=?,price=?,num=? where id=?",args);

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
