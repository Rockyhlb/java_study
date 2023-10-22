package com.hlb.controller;

import com.hlb.dao.*;
import com.hlb.entity.BookList;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:37
 * @desc :  普通用户操作端
 */
public class User implements ILogin{
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void login(BookList[] bookLists) throws InterruptedException {
        System.out.println("hello, " + name + ": 欢迎进入" + "普通用户界面~~");
        menu();

        try {
            Scanner sc = new Scanner(System.in);
            while (sc.hasNext()){
                try {
                    int choice = sc.nextInt();
                    if (1 == choice){
                        // 动态绑定对多态的实现
                        IOperation ope = new SearchBook();
                        ope.work(bookLists);
                        menu();
                    }else if(2 == choice){
                        IOperation ope = new BorrowBook();
                        ope.work(bookLists);
                        menu();
                    }else if(3 == choice) {
                        IOperation ope = new ReturnBook();
                        ope.work(bookLists);
                        menu();
                    }else if(4 == choice) {
                        IOperation ope = new ResevationBook();
                        ope.work(bookLists);
                        menu();
                    }else if (0 == choice){
                        System.out.println("退出成功，正在返回主菜单...\n");
                        // 线程等待 1000 ms
                        Thread.sleep(500);
                        test.menu();
                    }else {
                        System.out.println("输入错误~~");
                        menu();
                        break;
                    }
                }catch (Exception e){
                    System.out.println("出异常啦~~" + e.toString());
                    menu();
                    sc.nextLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void menu(){
        System.out.println();
        System.out.println("=========================");
        System.out.println("=======1、查询图书=======");
        System.out.println("=======2、借    书=======");
        System.out.println("=======3、还    书=======");
        System.out.println("=======4、预    定=======");
        System.out.println("=======0、退    出=======");
        System.out.println("=========================");
        System.out.print("请选择您将进行的操作: ");
    }
}
