package com.hlb.dao;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 17:52
 * @desc :  普通用户预定书籍
 */
public class ResevationBook implements IOperation {

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);

        System.out.print("请输入您将要预定的图书名：");
        while (sc.hasNextLine()) {
            String delName = sc.nextLine();
            int pos = helpIOperation.findIndexByName(bookLists,delName);
            bookLists[pos].setStatus(BookStatus.RESERVATION);
            break;
        }
    }
}
