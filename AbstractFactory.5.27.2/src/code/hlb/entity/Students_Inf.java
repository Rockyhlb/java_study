package code.hlb.entity;

import code.hlb.dao.IDao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Students_Inf implements IVal {

    Scanner sc = null;

    @Override
    public void add(IDao dataBase) {

        sc = new Scanner(System.in);
        try {
            System.out.print("请输入学生id：");
            String id = sc.nextLine();
            System.out.print("请输入学生姓名：");
            String name = sc.nextLine();
            System.out.print("请输入学生性别：");
            String sex = sc.nextLine();
            System.out.print("请输入学生年龄：");
            int age = sc.nextInt();
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
            String dateStr = sdf.format(date); // 将Date类型转换为String类型
//            sc.nextLine();

            System.out.print("请输入学生邮箱：");
            String email = sc.nextLine();

            try {
                dataBase.executeUpdate("insert into students_inf values('" + id + "','" + name +"','" + sex + "'," + age + ",'" +
                        dateStr + "','" + email + "');");
            }
            catch (SQLException e){
                System.out.println("添加失败~请重新检查下输入的数据是否正确(例如ID是否重复)：");
            }
            finally {
                sc.close();
            }
        }
        catch (Exception e){
            System.out.println("输入错误~");
        }
    }

    @Override
    public void delete(IDao dataBase) {

        // 根据id删除信息
        sc = new Scanner(System.in);
        try {
            System.out.print("请输入待删除学生信息的ID：");
            String id = sc.nextLine();

            try {
                dataBase.executeUpdate("'delete from students_inf where id='"+id+"';");
                System.out.println("删除数据成功~");
            }
            catch (SQLException e){
                System.out.println("删除数据失败~");
            }
        }
        catch (Exception e){
            System.out.print("输入错误，请重新输入：");
        }
        finally {
            sc.close();
        }
    }

    @Override
    public void select(IDao dataBase) {

//        sc = new Scanner(System.in);
//        try {
//            // 根据ID查找信息
//            System.out.print("请输入待查询学生信息的ID：");
//            String id = sc.nextLine();
            try {
                ResultSet rs = dataBase.executeQuery("select * from students_inf;");
                System.out.println("学号" + "\t"+ " 姓名" + "\t" + "  性别" + "\t" + "年龄" + "\t" +"入校时间"+ "\t\t" + "   邮箱" + "\t");
                while (rs.next()) {
                    String id = rs.getString("id");
                    String name = rs.getString("name");
                    String sex = rs.getString("sex");
                    int age = rs.getInt("age");
                    // 此处getDate 和 getTime 返回不同的日期格式
                    Date enter_time = rs.getDate("enter_time");
                    String email = rs.getString("email");

                    System.out.println(id + "\t\t" + name + "\t   " + sex + " \t " + age + "\t\t" + enter_time + "\t  " + email);
                }
            }
            catch (SQLException e){
                System.out.println("查找数据失败~");
            }
//        }
//        catch (Exception e){
//            System.out.print("输入错误，请重新输入：");
//        }
//        finally {
//            sc.close();
//        }
    }

    @Override
    public void update(IDao dataBase) {
        // 根据id修改信息
        sc = new Scanner(System.in);
        try {
            System.out.print("请输入待修改学生信息的ID：");
            String id = sc.nextLine();
            System.out.println("请输入需要修改的姓名：");
            String name = sc.nextLine();
            System.out.println("请输入需要修改的姓名：");
            int age = sc.nextInt();

            try {
                dataBase.executeUpdate("update students_inf set name=" + name + ",age=" + age + " where id=" + id);
            }
            catch (SQLException e){
                System.out.println("删除数据失败~");
            }
        }
        catch (Exception e){
            System.out.print("输入错误，请重新输入：");
        }
    }
}
