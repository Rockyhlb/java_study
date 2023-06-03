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
                    String host = null,userName = null,passWd=null,dataBase=null;
                    try {
                        input.nextLine();
                        System.out.print("host：");
                        host=input.nextLine();

                        System.out.print("userName：");
                        userName=input.nextLine();

                        System.out.print("passWd：");
                        passWd=input.nextLine();

                        System.out.print("dataBase：");
                        dataBase=input.nextLine();

                    }
                    catch (Exception e){
                        System.out.println("输入错误....");
                    }

                    IDao mysql = mysqlHelpFactory.createDateBase();
                    boolean mysql_flag = mysqlHelpFactory.connect(host,userName,passWd,dataBase);

                    while (mysql_flag) {
                        System.out.println();
                        System.out.println("*************************************************");
                        System.out.println("********   正在使用Windows + mysql数据库  ********");
                        System.out.println("**************    1        增加    **************");
                        System.out.println("**************    2        删除    **************");
                        System.out.println("**************    3        查询    **************");
                        System.out.println("**************    4        修改    **************");
                        System.out.println("**************    5        自定义查询(高级模式) **");
                        System.out.println("**************    0        退出    **************");
                        System.out.println("*************************************************");
                        int mysqlProcess = -1;
                        try {
                            System.out.print("请选择:");
                            mysqlProcess = input.nextInt();
                        }
                        catch (Exception e){
                            System.out.print("输入非法，请重新输入：");
                            input.nextLine();  // 清空缓冲区
                        }

                        switch (mysqlProcess){
                            case 1:
                                try {
                                    // 每次factory进行增删查改操作以后都会断开连接，因此要重新获取连接
                                    mysqlHelpFactory.connect(host,userName,passWd,dataBase);
                                    mysql.add(mysqlHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
                            case 2:
                                try {
                                    mysqlHelpFactory.connect(host,userName,passWd,dataBase);
                                    mysql.delete(mysqlHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
                            case 3:
                                try {
                                    mysqlHelpFactory.connect(host,userName,passWd,dataBase);
                                    String sql = "select * from students_inf;";
                                    mysql.select(mysqlHelpFactory,sql);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }

                            case 4:
                                try {
                                    mysqlHelpFactory.connect(host,userName,passWd,dataBase);
                                    mysql.update(mysqlHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }

                            case 5:
                                try {
                                    mysqlHelpFactory.connect(host,userName,passWd,dataBase);
                                    System.out.print("请输入sql查询语句：");
                                    input.nextLine();  // 清除缓冲区
                                    String select_sql = input.nextLine();
                                    mysql.select(mysqlHelpFactory,select_sql);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }

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

                    String linux_host = null,linux_userName = null,linux_passWd=null,linux_dataBase=null;
                    try {
                        input.nextLine();
                        System.out.print("host：");
                        linux_host=input.nextLine();

                        System.out.print("userName：");
                        linux_userName=input.nextLine();

                        System.out.print("passWd：");
                        linux_passWd=input.nextLine();

                        System.out.print("dataBase：");
                        linux_dataBase=input.nextLine();

                    }
                    catch (Exception e){
                        System.out.println("输入错误....");
                    }

                    boolean sqLite_flag = linuxHelpFactory.connect(linux_host,linux_userName,linux_passWd,linux_dataBase);

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
                                try {
                                    sqLite.add(linuxHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
                            case 2:
                                try {
                                    sqLite.delete(linuxHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
                            case 3:
                                try {
                                    String sql = "select * from students_inf;";
                                    sqLite.select(linuxHelpFactory,sql);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
                            case 4:
                                try {
                                    sqLite.update(linuxHelpFactory);
                                    break;
                                }
                                catch (SQLException e){
                                    e.printStackTrace();
                                }
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
