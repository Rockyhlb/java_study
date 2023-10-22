package com.hlb.dao;

import com.hlb.entity.BookList;

/**
 * @author: code_hlb
 * @date :  2023/10/22 17:08
 * @desc :  一些辅助增删查改操作的静态方法
 */
public class helpIOperation {

    // 辅助 AddBook -->  查找列表空闲位置
    public static int findFreeIndex(BookList[] bookLists){

        for (int i = 0; i < bookLists.length; i++) {
            if (bookLists[i] == null){
                return i;
            }
        }
        return -1;
    }

    // 辅助 DelBook --> 根据图书名查找下标
    public static int findIndexByName(BookList[] bookLists,String name){

        for (int i = 0; i < bookLists.length; i++) {
            if (bookLists[i].getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    // 辅助 DelBook --> 根据下标删除图书信息
    public static boolean deleteByIndex(BookList[] bookLists,int index){

        try {
            for (int i = index; i < bookLists.length && bookLists[i] != null; i++) {
                bookLists[i] = bookLists[i + 1];
            }
            return true;
        }
        catch (Exception e){
            System.out.println("删除失败~~");
            return false;
        }
    }

    // 辅助 UpdateBook --> 根据图书 ID 查找下标
    public static int findIndexById(BookList[] bookLists,String Id){

        for (int i = 0; i < bookLists.length; i++) {
            if (bookLists[i].getId().equals(Id)){
                return i;
            }
        }
        return -1;
    }
}
