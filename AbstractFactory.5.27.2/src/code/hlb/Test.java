package code.hlb;

import code.hlb.dao.IDao;
import code.hlb.entity.Scores_inf;
import code.hlb.entity.Students_Inf;
import code.hlb.factory.MysqlHelpFactory;
import code.hlb.factory.SqliteHelpFactory;

import java.sql.SQLException;
import java.util.Scanner;

public class Test {

    static Scanner input = new Scanner(System.in);

    static MysqlHelpFactory mysqlHelpFactory = new MysqlHelpFactory();
    static SqliteHelpFactory sqliteHelpFactory = new SqliteHelpFactory();

    public static void main(String[] args) throws SQLException {

        boolean flag_menu = true;
        int choice = -1;

        while (flag_menu) {
            System.out.println("***********************************************");
            System.out.println("**********  请选择您要使用的数据库  ************");
            System.out.println("*************  1   mysql数据库    *************");
            System.out.println("*************  2   SqlLite数据库  *************");
            System.out.println("*************  0   退         出  *************");
            System.out.println("***********************************************");
            System.out.print("请选择：");
            choice = input.nextInt();

            switch (choice){
                case 1:
                    IDao mysql =  mysqlHelpFactory.createDateBase();
                    Students_Inf students_inf = new Students_Inf();

                    boolean mysql_flag = mysql.connect();

                    while (mysql_flag) {
                        System.out.println();
                        System.out.println("*************************************");
                        System.out.println("*******   正在使用Mysql数据库  *******");
                        System.out.println("*************  1   增加  ************");
                        System.out.println("*************  2   删除  ************");
                        System.out.println("*************  3   查询  ************");
                        System.out.println("*************  4   修改  ************");
                        System.out.println("*************  0   退出  ************");
                        System.out.println("*************************************");
                        System.out.print("请选择:");
                        int mysqlDataChoice = input.nextInt();

                        switch (mysqlDataChoice){
                            case 1:
                                students_inf.add(mysql);
                                break;
                            case 2:
                                students_inf.delete(mysql);
                                break;
                            case 3:
                                students_inf.select(mysql);
                                break;
                            case 4:
                                students_inf.update(mysql);
                                break;
                            case 0:
                                boolean flag = mysql.disconnect();
                                if (flag)
                                {
                                    System.out.println("退出成功~");
                                    mysql_flag = false;
                                    break;
                                }
                                System.out.println("退出异常，请稍后重试~");
                            default:
                                System.out.print("输入非法，请重新输入：");
                                break;
                        }
                    }
                    break;
                case 2:
                    IDao sqLite =  mysqlHelpFactory.createDateBase();
                    Scores_inf scores_inf = new Scores_inf();

                    boolean sqLite_flag = sqLite.connect();

                    while (sqLite_flag) {
                        System.out.println();
                        System.out.println("**************************************");
                        System.out.println("*******   正在使用SqlLite数据库  *******");
                        System.out.println("*************  1   增加  *************");
                        System.out.println("*************  2   删除  *************");
                        System.out.println("*************  3   查询  *************");
                        System.out.println("*************  4   修改  *************");
                        System.out.println("*************  0   退出  *************");
                        System.out.println("**************************************");
                        System.out.print("请选择");

                        int dataProcess = input.nextInt();
                        switch (dataProcess){
                            case 1:
                                scores_inf.add(sqLite);
                                break;
                            case 2:
                                scores_inf.delete(sqLite);
                                break;
                            case 3:
                                scores_inf.select(sqLite);
                                break;
                            case 4:
                                scores_inf.update(sqLite);
                                break;
                            case 0:
                                boolean flag = sqLite.disconnect();
                                if (flag)
                                {
                                    System.out.println("退出成功~");
                                    sqLite_flag = false;
                                    break;
                                }
                                System.out.println("退出异常，请稍后重试~");
                            default:
                                System.out.print("输入非法，请重新输入：");
                                break;
                        }
                    }
                    break;
                case 0:
                    flag_menu = false;
                    break;
                default:
                    System.out.println("选择错误，请重新输入-->");
                    break;
            }
        }
    }
}
