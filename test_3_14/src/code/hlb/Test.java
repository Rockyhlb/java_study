package code.hlb;

import com.sun.scenario.effect.impl.sw.java.JSWLinearConvolvePeer;

public class Test {
    public static void main(String[] args) {
//        String s1 = "helloworld";   //字面量字符串  存放在栈区字符串常量池当中  因此s1,s2地址相同
//        String s2 = "helloworld";
//        String s3 = new String( "helloworld");  //存放在堆区当中，每次赋值的变量都要重新分配地址
//        String s4 = new String( "helloworld");
//
//        System.out.println("s1 == s2:" + (s1 == s2));
//        System.out.println("###########################################");
//        System.out.println("s3 == s4:" + (s3 == s4));
//        System.out.println("s3 == s4:" + s3.equals(s4));

        //输出：true
        //Integer申请的变量存放在整型常量池当中，范围只有-128~127之间
//        Integer c = 127;
//        Integer d = 127;
//        System.out.println("c == d:" + (c == d));

        //输出：false
        //Integer申请的变量存放在常量池当中，范围只有-128~127之间,溢出时就相当于new了一个变量出来
//        Integer c = 128;
//        Integer d = 128;
//        System.out.println("c == d:" + (c == d));

        //利用字符串操作方法取字符串字串
//        String url = "http://www.baidu.com/product/shoes.html";
//        int index = url.indexOf(':');
//        StringBuilder sb = new StringBuilder();  //StringBuffer 跟 StringBuilder区别：线程安全性不一样
//        if (index != -1)
//        {
//            //打印原字符串
//            System.out.println(url);
//            //取协议
//            String protocal = url.substring(0,4);
//            System.out.println("protocal:" + protocal);
//            //字符串截断
//            url = url.substring(index + 3);
//            System.out.println(url);
//            //取域名
//            index = url.indexOf("/");
//            System.out.println("domain:" + url.substring(0,index));
//            //字符串截断
//            url = url.substring(index + 1);
//            System.out.println(url);
//            //取控制器部分
//            index = url.indexOf("/");
//            System.out.println("controller:" + url.substring(0,index));
//            //字符串截断
//            url = url.substring(index + 1);
//            System.out.println(url);
//            //取网页部分
//            System.out.println("page:" + url.substring(0,index));
//        }

        String url = "http://www.baidu.com/product/shoes.html";
        StringBuilder sb = new StringBuilder();
        sb.append("url:" + url);
        //slip           join
    }

}
