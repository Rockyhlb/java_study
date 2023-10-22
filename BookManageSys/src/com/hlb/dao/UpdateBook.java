package com.hlb.dao;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.time.LocalDateTime;
import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:20
 * @desc :  管理员更新图书信息
 */
public class UpdateBook implements IOperation{

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);
        BookList bookList = new BookList();

        // 图书 固有属性 一般不会变更，因此需要更改的可能就是 价格，状态，借出时间三个因素
        System.out.println("开始修改图书信息：");
        // 为了保持信息的严谨性，我们此处通过 ID 进行图书信息的变更
        System.out.print("请输入待修改图书的ID：");
        while (sc.hasNextLine()){
            int pos = helpIOperation.findIndexById(bookLists,sc.nextLine());
            if (-1 != pos){
                // 备份bookLists[pos]的数据，在备份上操作数据，不建议直接在列表上进行修改！！！
                bookList = bookLists[pos];
                //　展示待修改图书的原数据，提高系统的友好程度
                System.out.println(bookLists[pos]);

                System.out.print("请输入待修改图书的价格：");
                bookList.setValue(sc.nextDouble());

                System.out.print("请输入待修改图书的状态(0:在馆 1:借出 2:预定)：");
                int st = sc.nextInt();
                if (0 == st){
                    bookList.setStatus(BookStatus.FREE);
                }else if (1 == st){
                    bookList.setStatus(BookStatus.BORROWED);
                }else if (2 == st){
                    bookList.setStatus(BookStatus.RESERVATION);
                }
                // 清除缓冲区
                sc.nextLine();

                System.out.print("请输入待修改图书的借出时间：");
                bookList.setLendTime(sc.nextLine());

                bookLists[pos] = bookList;
            }
            break;
        }
    }
}
