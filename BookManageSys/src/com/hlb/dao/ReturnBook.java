package com.hlb.dao;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 14:17
 * @desc :  普通用户归还图书
 */
public class ReturnBook implements IOperation{

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您将要归还的图书名：");
        while (sc.hasNextLine()) {
            String delName = sc.nextLine();
            int pos = helpIOperation.findIndexByName(bookLists,delName);
            bookLists[pos].setStatus(BookStatus.FREE);
            break;
        }
    }
}
