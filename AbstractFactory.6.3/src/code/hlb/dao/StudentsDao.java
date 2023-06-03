package code.hlb.dao;

import code.hlb.entity.Students_Inf;
import code.hlb.factory.JdbcFactory;
import code.hlb.factory.MysqlHelpFactory;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class StudentsDao implements IDao {

    Students_Inf students_inf = null;
    Scanner sc = null;

    @Override
    public void add(JdbcFactory jdbcFactory) {
        sc = new Scanner(System.in);
        students_inf = new Students_Inf();
        try {
            System.out.print("请输入学生id：");
            students_inf.setId(sc.nextLine());
            System.out.print("请输入学生姓名：");
            students_inf.setName(sc.nextLine());
            System.out.print("请输入学生性别：");
            students_inf.setSex(sc.nextLine());
            System.out.print("请输入学生年龄：");
            students_inf.setAge(sc.nextInt());
            sc.nextLine(); // 清空输入缓冲区中的换行符

            /*
                第一个 nextLine() 方法读取了学生年龄，但是接下来的 nextInt()方法并没有将输入缓冲区中的换行符读取掉，
                导致下一个 nextLine() 方法直接读取到了一个空字符串。
                因此，在尝试将日期字符串转换为日期类型时，enter_time 实际上是一个空字符串，无法被正确地解析为日期类型，
                从而导致了 ParseException 异常的发生。
                需要在读取完学生年龄后使用 sc.nextLine() 读取掉输入缓冲区中的换行符，然后再读取学生入校时间。
             */

            System.out.print("请输入学生入校时间(yyyy-MM-dd)：");
            String enter_time  = sc.nextLine();
            // 将String类型转换为Date类型
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(enter_time);
            students_inf.setEnter_time(date);

            System.out.print("请输入学生邮箱：");
            students_inf.setEmail(sc.nextLine());

            Object[] args = {students_inf.getId(),students_inf.getName(),students_inf.getSex(),students_inf.getAge(),
                            students_inf.getEnter_time(),students_inf.getEmail()};

            try {
                int row = jdbcFactory.executeUpdate("insert into students_inf value(?,?,?,?,?,?);",args);
                if (0 != row){
                    System.out.println("成功添加 " + row + " Line" + "数据");
                }
                else {
                    System.out.println("添加失败...请重新检查下输入的数据是否正确(例如ID是否重复)：");
                }
//                dataBase.executeUpdate("insert into students_inf values('" + aEntity.id + "','" + aEntity.name +"','" + sex + "'," + age + ",'" +
//                        dateStr + "','" + email + "');");
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
        students_inf = new Students_Inf();
        sc = new Scanner(System.in);

        try {
            System.out.print("请输入待删除学生信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                students_inf.setId(id);
                MysqlHelpFactory mysqlHelpFactory = (MysqlHelpFactory)jdbcFactory;
                flag = mysqlHelpFactory.executeQuery("select * from students_inf  where id = ?",id);
                students_inf.setId(id);
            }

            if (0 != flag){
                System.out.print("确定删除？(Y or F)：");
                String sureStatemant = sc.nextLine();
                if (sureStatemant.equals("Y")){
                    Object[] args = {students_inf.getId()};

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
                else {
                    System.out.println("取消成功....");
                }
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
        students_inf = new Students_Inf();
        try {
            System.out.print("请输入待修改学生信息的ID：");
            String id = sc.nextLine();
            int flag = 0;  // 接收ID查询到的数据数量
            if (id!=null){
                students_inf.setId(id);
                MysqlHelpFactory mysqlHelpFactory = (MysqlHelpFactory)jdbcFactory;
                flag = mysqlHelpFactory.executeQuery("select * from students_inf  where id = ?",id);
            }
            if (0 != flag)
            {
                System.out.print("请输入需要修改的姓名：");
                students_inf.setName(sc.nextLine());
                System.out.print("请输入需要修改的年龄：");
                students_inf.setAge(sc.nextInt());
                sc.nextLine();  // 清空缓冲区的回车键
                System.out.print("请输入需要修改的邮箱：");
                students_inf.setEmail(sc.nextLine());

                Object[] args = {students_inf.getName(),students_inf.getAge(),students_inf.getEmail(),students_inf.getId()};

                try {
                    int row = jdbcFactory.executeUpdate("update students_inf set name=?,age=?,email=? where id=?",args);

                    if (0 != row){
                        System.out.println("成功修改 " + row + " Line" + "数据");
                    }
                }
                catch (SQLException e){
                    System.out.println("修改数据失败...");
                    e.printStackTrace();
                }
            }
            else {
                System.out.println("数据库中无该数据...");
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.print("输入错误，请重新输入：");
        }
    }
}
