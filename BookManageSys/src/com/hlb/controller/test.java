package com.hlb.controller;

import com.hlb.entity.BookList;
import com.hlb.entity.BookStatus;

import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/22 13:13
 * @desc :  测试类
 */
public class test {

    static void menu(){
        System.out.println("==============================");
        System.out.println("=========1、管理员用户========");
        System.out.println("=========2、普通用户  ========");
        System.out.println("=========0、退    出  ========");
        System.out.println("===============================");
        System.out.print("请选择用户：");
    }

    public static void main(String[] args) throws InterruptedException {

/*        数组（Array）：可以使用数组来存储图书信息，每个元素表示一个图书，包含图书的各个属性（如书名、作者、出版社等）。
        数组的优点是访问速度快，可以通过索引直接访问元素，但不适合频繁的插入和删除操作。

        链表（Linked List）：使用链表可以动态地添加和删除图书信息。每个节点包含一个图书对象和一个指向下一个节点的指针。
        链表的优点是可以高效地进行插入和删除操作，但访问需要遍历链表。

        哈希表（Hash Table）：可以使用哈希表存储图书信息，以图书的某个属性（如图书编号）作为键，对应的值存储图书对象。
        哈希表的优点是可以快速地通过键查找到对应的图书对象，但需要处理哈希冲突。

        树（Tree）：可以使用二叉搜索树（Binary Search Tree）或平衡二叉树（如红黑树、AVL树）来存储图书信息。
        树的优点是可以高效地进行搜索、插入和删除操作，保持数据有序，但需要维护平衡性。

        图（Graph）：如果需要表示图书之间的关系（如借阅关系、作者关系等），可以使用图来存储数据。
        图的优点是能够灵活地表示复杂的关系，但图的操作相对复杂。*/
        // ArrayList<BookList> bookLists = new ArrayList<BookList>();

        BookList[] bookLists = new BookList[10];
        bookLists[0] = new BookList("20231022174843","三国","罗贯中",23.99, "novel",BookStatus.FREE,null);
        bookLists[1] = new BookList("20231022174850","红楼","曹雪芹",23.99, "novel",BookStatus.RESERVATION,null);

        // 增加异常处理  提高系统稳定性和可交互性
        menu();

        try (Scanner sc = new Scanner(System.in)){
            while(sc.hasNext()){
                try {
                    int choice = -1;
                    choice = sc.nextInt();

                    if (1 == choice){
                        System.out.print("请输入你的用户名：");
                        sc.nextLine();
                        // 向上转型，动态绑定
                        ILogin login = new Admin(sc.nextLine());
                        login.login(bookLists);
                    }else if (2 == choice){
                        System.out.print("请输入你的用户名：");
                        sc.nextLine();
                        ILogin user = new User(sc.nextLine());
                        user.login(bookLists);
                    }else {
                        System.exit(0);
                    }
                }catch (Exception e) {
                    System.out.println("出异常啦~~" + e.toString());
                    menu();
                    sc.nextLine();
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
