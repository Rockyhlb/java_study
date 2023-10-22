package com.hlb.dao;

import com.hlb.entity.BookList;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:19
 * @desc :  管理员下架图书
 */
public class DelBook implements IOperation {

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您将要下架的图书名：");
        while (sc.hasNextLine()) {
            String delName = sc.nextLine();
            int pos = helpIOperation.findIndexByName(bookLists,delName);
            if (helpIOperation.deleteByIndex(bookLists,pos)){
                System.out.println("删除成功！");
                break;
            }
        }
    }
}
