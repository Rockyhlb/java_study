package Test;

import com.zy.dao.IDao;
import com.zy.factory.JdbcFactory;
import com.zy.factory.OrderHelpFactory;
import com.zy.factory.GoodsHelpFactory;

import java.sql.SQLException;
import java.util.Scanner;

public class test {

    static Scanner input = new Scanner(System.in);

    static JdbcFactory mysqlFactory = new GoodsHelpFactory();
    static JdbcFactory linuxFactory = new OrderHelpFactory();

    public static void main(String[] args) throws SQLException {

        boolean flag_menu = true;
        int choice = -1;

        while (flag_menu) {
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            System.out.println("☆☆☆☆☆☆☆☆☆☆ 欢迎使用小周的数据库 ☆☆☆☆☆☆☆☆☆☆");
            System.out.println("☆☆☆☆☆☆☆☆☆☆ 1 这里是商品仓库数据库~ ☆☆☆☆☆☆☆");
            System.out.println("☆☆☆☆☆☆☆☆☆☆ 2 这里是本地订单数据库~ ☆☆☆☆☆☆☆");
            System.out.println("☆☆☆☆☆☆☆☆☆☆ 0 退  出              ☆☆☆☆☆☆☆☆");
            System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
            try {
                System.out.print("请选择：");
                choice = input.nextInt();
            }
            catch (Exception e){
                System.out.println("选择错误，请重新输入-->");
                input.nextLine();
            }

            switch (choice) {
                case 1:
                    String host = null, userName = null, passWd = null, dataBase = null;
                    try {
                        input.nextLine();
                        System.out.print("host: ");
                        host = input.nextLine();

                        System.out.print("userName：");
                        userName = input.nextLine();

                        System.out.print("passWd：");
                        passWd = input.nextLine();

                        System.out.print("dataBase：");
                        dataBase = input.nextLine();

                    } catch (Exception e) {
                        System.out.println("输入错误....");
                    }

                    IDao mysql = mysqlFactory.createDateBase();
                    boolean mysql_flag = mysqlFactory.connect(host, userName, passWd, dataBase);

                    while (mysql_flag) {
                        System.out.println();
                        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆☆  正在使用小周杂货铺本地数据库系统  ☆☆☆☆");
                        System.out.println("☆☆☆    1      录入商品信息    ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    2      删除商品信息    ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    3      查询商品信息    ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    4      修改商品信息    ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    0      退        出    ☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        int mysqlProcess = -1;
                        try {
                            System.out.print("请选择:");
                            mysqlProcess = input.nextInt();
                        } catch (Exception e) {
                            System.out.print("输入非法，请重新输入：");
                            input.nextLine();  // 清空缓冲区
                        }

                        switch (mysqlProcess) {
                            case 1:
                                try {
                                    // 每次factory进行增删查改操作以后都会断开连接，因此要重新获取连接
                                    mysqlFactory.connect(host, userName, passWd, dataBase);
                                    mysql.add(mysqlFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                try {
                                    mysqlFactory.connect(host, userName, passWd, dataBase);
                                    mysql.delete(mysqlFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 3:
                                try {
                                    mysqlFactory.connect(host, userName, passWd, dataBase);
                                    String sql = "select * from goods_zhouyue;";
                                    mysql.select(mysqlFactory, sql);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            case 4:
                                try {
                                    mysqlFactory.connect(host, userName, passWd, dataBase);
                                    mysql.update(mysqlFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }

                            case 0:
                                boolean flag = mysqlFactory.disconnect();
                                if (flag) {
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

                    IDao linuxDB = linuxFactory.createDateBase();

                    String linux_host = null, linux_userName = null, linux_passWd = null, linux_dataBase = null;
                    try {
                        input.nextLine();
                        System.out.print("host: ");
                        linux_host = input.nextLine();

                        System.out.print("userName: ");
                        linux_userName = input.nextLine();

                        System.out.print("passWd: ");
                        linux_passWd = input.nextLine();

                        System.out.print("dataBase: ");
                        linux_dataBase = input.nextLine();

                    } catch (Exception e) {
                        System.out.println("出错啦~");
                    }

                    boolean Linux_flag = linuxFactory.connect(linux_host, linux_userName, linux_passWd, linux_dataBase);

                    while (Linux_flag) {
                        System.out.println();
                        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆☆  正在使用小周杂货铺订单管理系统  ☆☆☆☆");
                        System.out.println("☆☆☆    1      添加订单    ☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    2      删除订单    ☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    3      查询订单    ☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    4      修改订单    ☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆    0      退    出    ☆☆☆☆☆☆☆☆☆☆☆☆");
                        System.out.println("☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆☆");
                        int dataProcess = -1;
                        try {
                            System.out.print("请选择: ");
                            dataProcess = input.nextInt();
                        } catch (Exception e) {
                            System.out.print("请重新输入：");
                            input.nextLine();
                        }

                        switch (dataProcess) {
                            case 1:
                                try {
                                    linuxFactory.connect(linux_host, linux_userName, linux_passWd, linux_dataBase);
                                    linuxDB.add(linuxFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 2:
                                try {
                                    linuxFactory.connect(linux_host, linux_userName, linux_passWd, linux_dataBase);
                                    linuxDB.delete(linuxFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 3:
                                try {
                                    linuxFactory.connect(linux_host, linux_userName, linux_passWd, linux_dataBase);
                                    String sql = "select * from order_zhouyue;";
                                    linuxDB.select(linuxFactory, sql);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 4:
                                try {
                                    linuxFactory.connect(linux_host, linux_userName, linux_passWd, linux_dataBase);
                                    linuxDB.update(linuxFactory);
                                    break;
                                } catch (SQLException e) {
                                    e.printStackTrace();
                                }
                            case 0:
                                boolean flag = linuxFactory.disconnect();
                                if (flag) {
                                    System.out.println("正在断开连接....退出成功~");
                                    Linux_flag = false;
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
