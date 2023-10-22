package com.hlb.dao;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:18
 * @desc :  管理员添加图书
 */
public class AddBook extends helpIOperation implements IOperation {

    @Override
    public void work(BookList[] bookLists) {

        Scanner sc = new Scanner(System.in);
        BookList bookList = new BookList();

        // 根据当前时间的年月日时分秒生成唯一的ID
        LocalDateTime localDateTime = LocalDateTime.now();
        // 定义时间格式化格式
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        // 格式化为字符串录入
        bookList.setId(localDateTime.format(formatter));

        System.out.println("开始录入图书信息：");
        System.out.print("请输入待录入图书的书名：");
        bookList.setName(sc.nextLine());
        System.out.print("请输入作者：");
        bookList.setAuthor(sc.nextLine());
        System.out.print("请输入价格：");
        bookList.setValue(sc.nextDouble());
        System.out.print("请输入类别：");
        sc.nextLine();
        bookList.setType(sc.nextLine());
        // 添加图书时默认图书状态为 “在馆”
        bookList.setStatus(BookStatus.FREE);
        // 添加图书时默认图书借出时间为 null
        bookList.setLendTime(null);

        // 将bookList 对象加入到链表当中

        int pos = helpIOperation.findFreeIndex(bookLists);
        if (-1 != pos){
            bookLists[pos] = bookList;
            System.out.println("添加成功~");
        }else {
            System.out.println("添加失败~");
        }
    }
}
