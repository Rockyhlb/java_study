package com.hlb;

public class HelloJava {
    //main回车快速建立类
    public static void main(String[] args) {
        int index=0;
        System.out.printf("斐波那契数列的第%d个位置的数是：%d",6,fblq_count(index=6));
    }

    static int fblq_count(int index)
    {
        if(index==1||index==0)
        {
            return 1;
        }
        else
        {
            return fblq_count(index-1) + fblq_count(index-2);
        }
    }
}
