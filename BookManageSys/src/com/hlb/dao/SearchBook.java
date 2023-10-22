package com.hlb.dao;

import com.hlb.entity.BookList;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:19
 * @desc :  展示库存图书信息
 */
public class SearchBook implements IOperation {

    @Override
    public void work(BookList[] bookLists) {

        if (bookLists == null){
            System.out.println("当前还没有图书~~");
        }else {
            for (int i = 0; i < bookLists.length && bookLists[i] != null; i++) {
                System.out.println(bookLists[i]);
            }
        }
    }
}
