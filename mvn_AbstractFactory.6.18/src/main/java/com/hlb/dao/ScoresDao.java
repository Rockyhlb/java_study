package com.hlb.dao;

import com.hlb.entity.Students_score;
import com.hlb.factory.JdbcFactory;
import com.hlb.factory.LinuxHelpFactory;

import java.sql.SQLException;

import java.util.Scanner;

public class ScoresDao implements IDao {

    Students_score students_score = null;
    Scanner sc = null;

    @Override
    public void add(JdbcFactory jdbcFactory) {
        sc = new Scanner(System.in);
        Students_score students_score = new Students_score();

        try {
            System.out.print("请输入学生id：");
            students_score.setScore_id(sc.nextLine());
            System.out.print("请输入学生姓名：");
            students_score.setName(sc.nextLine());
            System.out.println("开始录入成绩....");
            System.out.print("请输入java课程成绩：");
            students_score.setJava(sc.nextInt());
            // 清空输入缓冲区中的换行符
            sc.nextLine();
            System.out.print("请输入C语言课程成绩：");
            students_score.setCLanguage(sc.nextInt());
            sc.nextLine();
            System.out.print("请输入数据库课程成绩：");
            students_score.setDataBase(sc.nextInt());
            sc.nextLine();
            System.out.print("请输入操作系统课程成绩：");
            students_score.setOS(sc.nextInt());
            sc.nextLine();

            Object[] args = {students_score.getScore_id(),students_score.getName(),students_score.getJava(),students_score.getCLanguage(),
                    students_score.getDataBase(),students_score.getOS()};

            try {
                int row = jdbcFactory.executeUpdate("insert into students_score value(?,?,?,?,?,?);",args);
                if (0 != row){
                    System.out.println("成功添加 " + row + " Line" + "数据");
                }
                else {
                    System.out.println("添加失败...请重新检查下输入的数据是否正确(例如ID是否重复)：");
                }
            }
            catch (SQLException e){
                System.out.println("操作失败..");
            }
        }
        catch (Exception e){
            System.out.println("输入错误...");
            e.printStackTrace();
        }
    }

    @Override
    public void delete(JdbcFactory jdbcFactory) {
        // 根据id删除信息
        students_score = new Students_score();
        sc = new Scanner(System.in);

        try {
            System.out.print("请输入待删除学生信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                LinuxHelpFactory linuxHelpFactory = (LinuxHelpFactory)jdbcFactory;
                flag = linuxHelpFactory.executeQuery("select * from students_score  where score_id = ?",id);
                students_score.setScore_id(id);
            }

            if (0 != flag) {
                System.out.print("确定删除？(Y or F)：");
                String sureStatemant = sc.nextLine();
                if (sureStatemant.equals("Y")) {
                    Object[] args = {students_score.getScore_id()};

                    try {
                        int row = jdbcFactory.executeUpdate("delete from students_score where score_id=?", args);
                        if (0 != row) {
                            System.out.println("成功删除 " + row + " Line" + "数据");
                        } else {
                            System.out.println("数据库中无可删除数据..");
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
        }
        catch (Exception e){
            System.out.print("输入错误，请重新输入：");
        }
    }

    @Override
    public void select(JdbcFactory jdbcFactory,String sql) throws SQLException {
        jdbcFactory.executeQuery(sql);
    }

    @Override
    public void update(JdbcFactory jdbcFactory) {
        // 根据id修改信息
        sc = new Scanner(System.in);
        students_score=new Students_score();

        try {
            System.out.print("请输入待修改学生成绩的学生ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                // 向下转型
                LinuxHelpFactory linuxHelpFactory = (LinuxHelpFactory)jdbcFactory;
                flag = linuxHelpFactory.executeQuery("select * from students_score where score_id = ?",id);
                students_score.setScore_id(id);
            }
            if (0 != flag) {
                System.out.print("请输入需要修改的Java课程成绩：");
                students_score.setJava(sc.nextInt());
                sc.nextLine();  // 清空缓冲区的回车键
                System.out.print("请输入需要修改的C语言课程成绩：");
                students_score.setCLanguage(sc.nextInt());
                sc.nextLine();
                System.out.print("请输入需要修改的数据库课程成绩：");
                students_score.setDataBase(sc.nextInt());
                sc.nextLine();
                System.out.print("请输入需要修改的操作系统课程成绩：");
                students_score.setOS(sc.nextInt());

                Object[] args = {students_score.getJava(), students_score.getCLanguage(), students_score.getDataBase(), students_score.getOS(),students_score.getScore_id()};

                try {
                    int row = jdbcFactory.executeUpdate("update students_score set Java=?,CLanguage=?,`DataBase`=?,OS=? where score_id=?", args);

                    if (0 != row) {
                        System.out.println("成功修改 " + row + " Line" + "数据");
                    } else {
                        System.out.println("数据库中无该数据...");
                    }
                }
                catch (SQLException e) {
                    System.out.println("修改数据失败...");
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
}
