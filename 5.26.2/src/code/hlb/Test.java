package code.hlb;

import code.hlb.dao.StudentsDao;
import code.hlb.dao.ScoresDao;

import java.util.Scanner;

public class Test {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

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
                    boolean mysql_flag = true;
                    StudentsDao mysql = new StudentsDao();
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
                        int myDao_choice = input.nextInt();

                        switch (myDao_choice){
                            case 1:
                                mysql.add();
                                break;
                            case 2:
                                mysql.delete();
                                break;
                            case 3:
                                mysql.select();
                                break;
                            case 4:
                                mysql.update();
                                break;
                            case 0:
                                System.out.println("退出成功~");
                                mysql_flag = false;
                                break;
                            default:
                                System.out.print("输入非法，请重新输入：");
                                break;
                        }
                    }
                    break;
                case 2:
                    boolean sqlLite_flag = true;
                    ScoresDao sqlLite = new ScoresDao();
                    while (sqlLite_flag) {
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

                        int sqllLiteDao_choice = input.nextInt();
                        switch (sqllLiteDao_choice){
                            case 1:
                                sqlLite.add();
                                break;
                            case 2:
                                sqlLite.delete();
                                break;
                            case 3:
                                sqlLite.select();
                                break;
                            case 4:
                                sqlLite.update();
                                break;
                            case 0:
                                System.out.println("退出成功~");
                                sqlLite_flag = false;
                                break;
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
                    System.out.print("选择错误，请重新输入-->");
                    break;
            }
        }
    }
}
