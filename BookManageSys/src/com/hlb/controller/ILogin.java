package com.hlb.controller;

import com.hlb.entity.BookList;

/**
 * @author: code_hlb
 * @date :  2023/10/22 14:03
 * @desc :  登陆接口
 */
public interface ILogin {
    void login(BookList[] bookLists) throws InterruptedException;
}
