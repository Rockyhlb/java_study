package com.hlb.dao;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 14:16
 * @desc :  普通用户借书
 */
public class BorrowBook implements IOperation {

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您将要借出的图书名：");
        while (sc.hasNextLine()) {
            String delName = sc.nextLine();
            int pos = helpIOperation.findIndexByName(bookLists,delName);
            bookLists[pos].setStatus(BookStatus.BORROWED);
            break;
        }
    }
}
