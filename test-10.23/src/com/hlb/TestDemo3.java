package com.hlb;

/**
 * @author: code_hlb
 * @date :  2023/10/23 17:05
 * @desc :  String 和  StringBuilder StringBuffer 的区别
 */
public class TestDemo3 {

    public static void main(String[] args) {

        /*：
        String 不能进行更改，因此每次的 += 都会产生新的对象
        str += " world"的本质是：
        StringBuilder sb = new StringBuilder();
        sb.append(" world");
        str = sb.toString();*/
        String str = "hello";
        str += " world";

        // StringBuilder 和 StringBuffer 都可以直接在原地址上修改数据，并不会产生新的对象
        StringBuilder sbd = new StringBuilder("hello java,");
        // StrBuffer 是被synchronized修饰的(相当于多了一个上锁开锁机制)，是线程安全的
        StringBuffer sbf = new StringBuffer("hello C,");

        System.out.println("===========odlData()===========");
        System.out.println(sbd);
        System.out.println(sbf);

        System.out.println("===========append()===========");
        // 都支持任意数据类型的追加
        sbd.append(1212);
        sbd.append(23.2);
        sbd.append("dasdsa");
        sbf.append(132);
        sbf.append(32.2);
        sbf.append("das");
        System.out.println(sbd);
        System.out.println(sbf);

        // String的部分方法在StringBuilder和StringBuffer当中也适用，可通过观察源码(按住ctrl键将光标移动到类名上即可跳转)得知；

        System.out.println("===========reverse()===========");
        // 数据的反转
        System.out.println(sbd.reverse());
        System.out.println(sbf.reverse());

        System.out.println("==========StringBuilder 和 StringBuffer转换为String==============");
        // StringBuilder 和 StringBuffer 转换为String
        String parseSbd = sbd.toString();
        System.out.println(parseSbd.getClass());
        String parseSbf = sbf.toString();
        System.out.println(parseSbf.getClass());
    }
}
