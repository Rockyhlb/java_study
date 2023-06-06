package com.hlb;

import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class Test {

    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();

        Random rd = new Random();

        int j = 0;
        while (j <1000){
            list.add(rd.nextInt(100000));
            j++;
        }

        long begin = System.currentTimeMillis();
////         删除可以被2整除的数
//        for (int i=0; i<list.size(); i++){
//
//            if (0 == list.get(i)%2){
//                // 如果满足条件，删除指定位置的数据以后，数组长度会弹性减小，所以可以通过i--，最后再通过for循环的i++，
//                // 使得i控制list的位置不会指向下下一个
//                list.remove(i--);
//            }
//            // 如果不满足删除条件，list长度不变,继续i++指向下一个位置
//        }

        list.removeIf(s -> s%2==0);

        for (int result : list) {
            System.out.println(result);
        }

        long end = System.currentTimeMillis();
        System.out.println("运行时间为："+ (end-begin)+" ms");


        Stack stack = new Stack();
        stack.push("pig");
        stack.push("cat");
        stack.push("dog");





    }
}
