package com.hlb;

import java.util.Arrays;

/**
 * @author: code_hlb
 * @date : 2023/10/23 14:06
 * @desc : String 类的常用方法
 */
public class TestDemo2 {

    public static void main(String[] args) {

        String str = "hello worlD";
        System.out.println("=============oldData============");
        System.out.println(str);

        System.out.println("==========trim()==========");
        // 清空字符串两边的空格
        String str5 = " hello world  ";
        System.out.println(str5.trim());

        System.out.println("==========format()==========");
        String str6 = "20231023";
        System.out.println(String.format("%s-%s-%s",str6.substring(0,4),str6.substring(4,6),str6.substring(6,8)));

        // 输出：今天的日期是：yyyy-MM-dd 00:00:00
        /*String str6 = "今天的日期是：%s";
        String formattedStr = String.format(str6, "yyyy-MM-dd 00:00:00");
        System.out.println(formattedStr);*/
    }

    public static void main5(String[] args) {

        String str = "hello worlD";
        System.out.println("=============oldData============");
        System.out.println(str);

        System.out.println("==========toUpper(Lower)Case()==========");
        // 大小写的互相转换
        System.out.println(str.toUpperCase());
        System.out.println(str.toLowerCase());

        System.out.println("==========toCharArray()==========");
        // 字符串 --> 字符数组
        char[] chars = str.toCharArray();
        for (char c: chars) {
            System.out.println(c);
        }
        // 字符数组 --> 字符串
        String str4 = String.valueOf(chars);
        // 也可以使用String的构造方法转换字符串
        //String str4 = new String(chars);
        System.out.println(str4);
    }

    public static void main4(String[] args) {

        String str = "hello world";
        System.out.println("=============oldData============");
        System.out.println(str);

        System.out.println("==========split(\" \")==========");
        // 字符串的划分  --> 返回的是一个字符串数组，因此需要重新定义变量接受返回值
        String[] splitStr = str.split(" ");
        for (String s : splitStr) {
            System.out.println(s);
        }

        System.out.println("==========subString(int beginIndex,int endIndex)==========");
        // 字符串的切割 --> 返回 "o world"
        System.out.println(str.substring(4));
        // 左闭右开的规则  --> 返回 "hell"
        System.out.println(str.substring(0,4)); // 实际只切割到[0,3]
    }

    public static void main3(String[] args) {

        String str = "hello world";
        String str1 = "hello worle";
        String str2 = "hello worlc";
        String str3 = "hello";

        System.out.println("=============oldData============");
        System.out.println(str);
        System.out.println(str1);
        System.out.println(str2);
        System.out.println(str3);

        System.out.println("==========compareTo()==========");
        // 根据字典序进行比较 前者字符逐个减后者对应字符,若长度小一方减尽都是一样的，则返回两字符串长度之差 --> 返回 -1
        System.out.println(str.compareTo(str1));
        // 返回 1
        System.out.println(str.compareTo(str2));
        // 返回 6
        System.out.println(str.compareTo(str3));

        System.out.println("==========contains(\"he\")==========");
        // 判断字符串当中是否子字符串 --> 返回false
        System.out.println(str.contains("he"));

        System.out.println("==========replace()==========");
        // 替换字符或字符串
        System.out.println(str.replace("he","hh"));
        // 替换所有满足条件的字符串
        System.out.println(str.replaceAll("l","a"));
        // 只替换第一个满足条件的字符串
        System.out.println(str.replaceFirst("l","a"));
    }

    public static void main2(String[] args) {

        String str = "hello world";
        System.out.println("=============oldData============");
        System.out.println(str);

        System.out.println("=============indexOf()============");
        // 字符‘a’第一次出现的下标  -->  字符串当中无字符‘a’ 返回-1；
        System.out.println(str.indexOf('a'));
        // 字符串‘ll’第一次出现的下标  --> 返回2
        System.out.println(str.indexOf("ll"));
        // 从下标2开始找第一次出现字符串 “wo” 的索引  -->  返回6
        System.out.println(str.indexOf("wo",2));

        System.out.println("==========lastIndexOf(\"ld\")==========");
        // 从后往前遍历，返回第一次和ld匹配的索引  -->　返回９
        // 其它lastIndexOf的使用和 indexOf 的同理
        System.out.println(str.lastIndexOf("ld"));

        System.out.println("==========charAt(1)==========");
        // 根据索引返回字符 --> 'e'
        System.out.println(str.charAt(1));
    }

    public static void main1(String[] args) {

        /*String 具有value和hash两个属性，value本质为一个字符数组，存储字符串上的每一个字符*/
        String str = "hello world";
        System.out.println(str);
        // String 的常用类方法
        System.out.println("=========length()===========");
        // 输出长度 --> 11
        System.out.println(str.length());

        System.out.println("=========isEmpty()================");
        // 判断是否为空  --> false
        System.out.println(str.isEmpty());
    }
}