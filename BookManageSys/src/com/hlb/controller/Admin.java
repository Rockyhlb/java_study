package com.hlb.controller;

import com.hlb.dao.*;
import com.hlb.entity.BookList;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:37
 * @desc :  管理员操作端
 */
public class Admin implements ILogin{

    private String name;

    public Admin(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void login(BookList[] bookLists) throws InterruptedException {
        System.out.println("hello, " + name + ": " + "欢迎进入" + "管理员界面~~");
        menu();

        try {

            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()) {
                try {
                    int choice = sc.nextInt();
                    if (1 == choice) {
                        // 动态绑定对多态的实现
                        IOperation ope = new SearchBook();
                        ope.work(bookLists);
                        menu();
                    } else if (2 == choice) {
                        IOperation ope = new AddBook();
                        ope.work(bookLists);
                        menu();
                    } else if (3 == choice) {
                        IOperation ope = new UpdateBook();
                        ope.work(bookLists);
                        menu();
                    } else if (4 == choice) {
                        IOperation ope = new DelBook();
                        ope.work(bookLists);
                        menu();
                    } else if (0 == choice) {
                        System.out.println("退出成功，正在返回主菜单...\n");
                        // 线程等待 1000 ms
                        Thread.sleep(1000);
                        test.menu();
                        break;
                    } else {
                        System.out.println("输入错误~~");
                        menu();
                    }
                } catch (Exception e) {
                    System.out.println("出异常啦~~" + e.toString());
                    menu();
                    sc.nextLine();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void menu(){
        System.out.println();
        System.out.println("========================");
        System.out.println("=======1、查询图书=======");
        System.out.println("=======2、添加图书=======");
        System.out.println("=======3、修改图书=======");
        System.out.println("=======4、删除图书=======");
        System.out.println("=======0、退    出=======");
        System.out.println("========================");
        System.out.print("请选择您将进行的操作: ");
    }
}
