package com.hlb.dao;

import com.hlb.entity.BookList;

/**
 * @author: code_hlb
 * @date : 2023/10/22 13:17
 * @desc : 操作接口
 */
public interface IOperation {
    void work(BookList[] bookLists);
}
