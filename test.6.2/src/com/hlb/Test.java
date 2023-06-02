package com.hlb;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> addList = new ArrayList<>();
        ArrayList<Integer> deleteList = new ArrayList<>();

        arrayList.add(10);
        arrayList.add(20);
        arrayList.add(30);
        arrayList.add(40);
        System.out.println("arrayList = " + arrayList);

        addList.add(50);
        addList.add(60);
        addList.add(70);
        System.out.println("addList = " +addList);

        arrayList.addAll(addList);
        System.out.println("arraylist after addAll = " + arrayList);

        deleteList.add(10);
        deleteList.add(20);
        System.out.println("deleteList = " + deleteList);
        arrayList.removeAll(deleteList);
        System.out.println("arrayList After removeAll = " + arrayList);

        for (int i=0; i<arrayList.size();i++) {
            if(arrayList.get(i) < 40){
                deleteList.add(arrayList.get(i));
            }
        }
        System.out.println("deleteList = " + deleteList);
        arrayList.removeAll(deleteList);
        System.out.println("arrayList after loop removeIf:"+arrayList);


        /**
         * lambda 表达式，代表一个匿名方法，只有JDK1.8 以上版本才支持
         * s -> s.length() < 20
         *
         * 解析为一个匿名方法
         * boolean f(x<? super String></?>){
         *     return x.length() <20
         * }
         *
         * 把以上方法转化为一个lambda表达式：
         * 1) 表达式省略方法名称
         *    (x){return x.length() < 20}
         * 2) 表达式中不能有大括号，大括号改为 “ -> ”
         *    (x) -> return x.length() <20
         * 3) 方法体中不能有return关键字，并且只能有一个语句
         *    (x) -> x.length() < 20
         * 4) 如果只有一个参数，则参数小括号也可以省略
         *    x -> x..length() < 20
         */

        arrayList.removeIf(s -> s < 50);
        System.out.println("arrayList after removeIf(s -> s < 50):"+arrayList);

        // 泛型类来约束数组
        ArrayList<Demo> demoList = new ArrayList<>();
        Demo demo1 = new Demo("001","hjj",21);
        Demo demo2 = new Demo("002","zjj",18);

        demoList.add(demo1);
        demoList.add(demo2);
        System.out.println("通过for循环遍历：");
        for (Demo demo:demoList){
            System.out.println(demo.getId() + "\t" + demo.getName() + "\t" + demo.getAge());
        }

        // 使用迭代器遍历列表
        // 1) 获取该列表的迭代器
        Iterator<Demo> it = demoList.iterator();
        // 2) 构造 while 循环对列表遍历
        System.out.println("通过迭代器循环遍历：");
        while (it.hasNext()){
            Demo demo = it.next();
            System.out.println(demo.getId() + "\t" + demo.getName() + "\t" + demo.getAge());
        }

        demoList.removeIf(x -> x.getId().equals("001"));
        System.out.println("通过lambda表达式进行removeIf删除:");
        for (Demo demo:demoList){
            System.out.println(demo.getId() + "\t" + demo.getName() + "\t" + demo.getAge());
        }
    }
}
