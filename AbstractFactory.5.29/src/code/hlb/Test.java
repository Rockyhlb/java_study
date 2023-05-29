package code.hlb;

import code.hlb.dao.IDao;
import code.hlb.factory.JdbcFactory;
import code.hlb.factory.MysqlHelpFactory;
import code.hlb.factory.LinuxHelpFactory;

import java.sql.SQLException;

import java.util.Scanner;

public class Test {

    static Scanner input = new Scanner(System.in);

    static JdbcFactory mysqlHelpFactory = new MysqlHelpFactory();
    static JdbcFactory linuxHelpFactory = new LinuxHelpFactory();

    public static void main(String[] args) throws SQLException {

        boolean flag_menu = true;
        int choice = -1;

        while (flag_menu) {
            System.out.println("*********************************************************");
            System.out.println("*****************  请选择您要使用的数据库  ***************");
            System.out.println("*************  1  windows +  mysql数据库    *************");
            System.out.println("*************  2  Linux   +  mysql数据库    *************");
            System.out.println("*************  0    退         出           *************");
            System.out.println("*********************************************************");
            try {
                System.out.print("请选择：");
                choice = input.nextInt();
            }
            catch (Exception e){
                System.out.println("选择错误，请重新输入-->");
                input.nextLine();
            }

            switch (choice){
                case 1:
                    IDao mysql = mysqlHelpFactory.createDateBase();
                    boolean mysql_flag = true;

                    while (mysql_flag) {
                        System.out.println();
                        System.out.println("*************************************************");
                        System.out.println("********   正在使用Windows + mysql数据库  ********");
                        System.out.println("**************    1        增加    **************");
                        System.out.println("**************    2        删除    **************");
                        System.out.println("**************    3        查询    **************");
                        System.out.println("**************    4        修改    **************");
                        System.out.println("**************    0        退出    **************");
                        System.out.println("*************************************************");
                        int mysqlProcess = -1;
                        try {
                            System.out.print("请选择:");
                            mysqlProcess = input.nextInt();

                        }
                        catch (Exception e){
                            System.out.print("输入非法，请重新输入：");
                            input.nextLine();
                        }

                        switch (mysqlProcess){
                            case 1:
                                mysqlHelpFactory.connect();
                                mysql.add(mysqlHelpFactory);
                                mysqlHelpFactory.disconnect();
                                break;
                            case 2:
                                mysqlHelpFactory.connect();
                                mysql.delete(mysqlHelpFactory);
                                mysqlHelpFactory.disconnect();
                                break;
                            case 3:
                                mysqlHelpFactory.connect();
                                mysql.select(mysqlHelpFactory);
                                mysqlHelpFactory.disconnect();
                                break;
                            case 4:
                                mysqlHelpFactory.connect();
                                mysql.update(mysqlHelpFactory);
                                mysqlHelpFactory.disconnect();
                                break;
                            case 0:
                                boolean flag = mysqlHelpFactory.disconnect();
                                if (flag)
                                {
                                    System.out.println("正在断开连接....退出成功~");
                                    mysql_flag = false;
                                    choice = -1;
                                    break;
                                }
                                System.out.println("退出异常，请稍后重试~");
                            default:
                                break;
                        }
                    }
                    break;
                case 2:

                    IDao sqLite = linuxHelpFactory.createDateBase();

                    boolean sqLite_flag = linuxHelpFactory.connect();

                    while (sqLite_flag) {
                        System.out.println();
                        System.out.println("*************************************************");
                        System.out.println("*********   正在使用Linux + mysql数据库  *********");
                        System.out.println("**************    1        增加    **************");
                        System.out.println("**************    2        删除    **************");
                        System.out.println("**************    3        查询    **************");
                        System.out.println("**************    4        修改    **************");
                        System.out.println("**************    0        退出    **************");
                        System.out.println("*************************************************");
                        int dataProcess = -1;
                        try {
                            System.out.print("请选择: ");
                            dataProcess = input.nextInt();
                        }
                        catch (Exception e){
                            System.out.print("请重新输入：");
                            input.nextLine();
                        }

                        switch (dataProcess){
                            case 1:
                                linuxHelpFactory.connect();
                                sqLite.add(linuxHelpFactory);
                                linuxHelpFactory.disconnect();
                                break;
                            case 2:
                                linuxHelpFactory.connect();
                                sqLite.delete(linuxHelpFactory);
                                linuxHelpFactory.disconnect();
                                break;
                            case 3:
                                linuxHelpFactory.connect();
                                sqLite.select(linuxHelpFactory);
                                linuxHelpFactory.disconnect();
                                break;
                            case 4:
                                linuxHelpFactory.connect();
                                sqLite.update(linuxHelpFactory);
                                linuxHelpFactory.disconnect();
                                break;
                            case 0:
                                boolean flag = linuxHelpFactory.disconnect();
                                if (flag)
                                {
                                    System.out.println("正在断开连接....退出成功~");
                                    sqLite_flag = false;
                                    choice = -1;
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
                    break;
            }
        }
    }
}
