package com.hlb.dao;

import com.hlb.entity.Students_score;
import com.hlb.factory.JdbcFactory;

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
            students_score.setId(sc.nextLine());
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

            Object[] args = {students_score.getId(),students_score.getName(),students_score.getJava(),students_score.getCLanguage(),
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
            if (!id.isEmpty()){
                students_score.setId(id);
            }

            Object[] args = {students_score.getId()};

            try {
                int row = jdbcFactory.executeUpdate("delete from students_inf where id=?",args);
                if (0 != row){
                    System.out.println("成功删除 " + row + " Line" + "数据");
                }
                else {
                    System.out.println("数据库中无可删除数据..");
                }
            }
            catch (SQLException e){
                System.out.println("删除数据失败..");
            }
//            // 此处关闭Scananer以后出现 java.util.NoSuchElementException 异常
//            finally {
//                if (sc != null) sc.close();
//            }
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
        try {
            System.out.print("请输入需要修改的Java课程成绩：");
            students_score.setJava(sc.nextInt());
            sc.nextLine();  // 清空缓冲区的回车键
            System.out.print("请输入需要修改的C语言课程成绩：");
            students_score.setCLanguage(sc.nextInt());
            System.out.print("请输入需要修改的数据库课程成绩：");
            students_score.setCLanguage(sc.nextInt());

            Object[] args = {students_score.getJava(),students_score.getCLanguage(),students_score.getDataBase(),students_score.getOS()};

            try {
                int row = jdbcFactory.executeUpdate("update students_inf set name=?,age=?,email=? where id=?",args);


                if (0 != row){
                    System.out.println("成功修改 " + row + " Line" + "数据");
                }
                else {
                    System.out.println("数据库中无该数据...");
                }

            }
            catch (SQLException e){
                System.out.println("修改数据失败...");
            }
        }
        catch (Exception e){
            System.out.print("输入错误，请重新输入：");
        }
    }
}
