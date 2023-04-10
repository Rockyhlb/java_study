package com.hlb.controller;

import com.hlb.dao.DvdManager;
import com.hlb.enums.DvdStatus;

import java.text.ParseException;
import java.util.Scanner;

public class Worker {
    DvdManager dm = new DvdManager();
    public void  menu() throws ParseException {
        dm.init();
        do{
            Scanner input = new Scanner(System.in);
            System.out.println();
            System.out.print("***** DVD出租管理信息系统 *****\n");
            System.out.print("*****  1       显示      *****\n");
            System.out.print("*****  2       上架      *****\n");
            System.out.print("*****  3       下架      *****\n");
            System.out.print("*****  4       出租      *****\n");
            System.out.print("*****  5       归还      *****\n");
            System.out.print("*****  6       查找      *****\n");
            System.out.print("*****  7       排序      *****\n");
            System.out.print("*****  0       退出      *****\n");
            System.out.print("******************************\n");
            System.out.print("请输入选项:>>");
            int choice = input.nextInt();

            switch (choice)
            {
                case 1:
                {
                    dm.print_dvdArray(dm.dvds);
                    continue;
                }
                case 2:
                {
                    dm.upline(dm.dvds);
                    continue;
                }
                case 3:
                {
                    dm.print_dvdArray(dm.dvds);
                    dm.downline(dm.dvds);
                    continue;
                }
                case 4:
                {
                    dm.print_dvdArray(dm.dvds);
                    dm.borrowDvd(dm.dvds);
                    continue;
                }
                case 5:
                {
                    dm.print_dvdArray(dm.dvds);
                    dm.returnDvd(dm.dvds);
                    continue;
                }
                case 6:
                {
                    search_menu();
                    input = new Scanner(System.in);
                    System.out.print("请输入查找方式:>>");

                    int choice_sea = input.nextInt();
                    switch (choice_sea)
                    {
                        case 1:
                            dm.searchById(dm.dvds);
                            break;
                        case 2:
                            dm.searchByName(dm.dvds);
                            break;
                        case 3:
                            input = new Scanner(System.in);
                            System.out.print("请输入目标影片的状态( 0: '在店'，1: '出租',2: '坏碟',3: '预定'):>");

                            int search_flag = input.nextInt();
                            switch (search_flag)
                            {
                                case 0:
                                    dm.search(DvdStatus.INSTORE);
                                    break;
                                case 1:
                                    dm.search(DvdStatus.OUTSTORE);
                                    break;
                                case 2:
                                    dm.search(DvdStatus.BADDISK);
                                    break;
                                case 3:
                                    dm.search(DvdStatus.SUBSCRIPT);
                                    break;
                                default:
                                    System.out.println("输入非法！");
                                    break;
                            }
                            break;
                        case 4:
                            dm.searchByFire(dm.dvds);
                            break;
                        default:
                            System.out.print("请输入有效选项:>>");
                            continue;
                    }

                    continue;
                }
                case 7:
                {
                    sort_menu();
                    input = new Scanner(System.in);

                    System.out.print("请输入排序方式:>>");
                    int choice_sor = input.nextInt();

                    switch (choice_sor)
                    {
                        case 1:
                            dm.sortById();
                            dm.print_dvdArray(dm.dvds);
                            break;
                        case 2:
                            dm.sortByName();
                            dm.print_dvdArray(dm.dvds);
                            break;
                        case 3:
                            dm.sortByFire();
                            dm.print_dvdArray(dm.dvds);
                            break;
                        case 4:
                            dm.sortByProfit();
                            dm.print_dvdArray(dm.dvds);
                            break;
                        default:
                            System.out.print("请输入有效选项:>>");
                            continue;
                    }

                    continue;
                }
                case 0:
                {
                    System.out.println("退出成功~~");
                    break;
                }
                default:
                    System.out.print("输入非法，请重新输入：\n");
                    continue;
            }
            break;
        }while(true);
    }

    public void search_menu()
    {
        System.out.println("************************************");
        System.out.println("********* 1   按 id 查找 ***********");
        System.out.println("********* 2   按name查找 ***********");
        System.out.println("********* 3   按状态查找 ***********");
        System.out.println("********* 4   按热度查找 ***********");
        System.out.println("************************************");
    }

    public void sort_menu()
    {
        System.out.println("************************************");
        System.out.println("********* 1   按 id 排序 ***********");
        System.out.println("********* 2   按name排序 ***********");
        System.out.println("********* 3   按热度排序 ***********");
        System.out.println("********* 4   按利润排序 ***********");
        System.out.println("************************************");
    }
}
