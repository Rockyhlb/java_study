package code.hlb;

import java.util.Scanner;

public class test {
//    public static void main(String[] args) {
//        //Student stu1 = new Student("100001","张三",'男');
//        Student stu1 = new Student();
//
//        stu1.setId("2070615");
//        stu1.setName("zjj是🐖");
//
//        Scanner scan = new Scanner(System.in);
//        System.out.print("请输入"+stu1.name+"的性别:");
//        while (scan.hasNext())
//        {
//            String sex =  scan.next();
//            stu1.setSex(sex);
//        }
//        stu1.self();
//    }

    public static void main(String[] args) {

        Student stu1 = new Student();
        stu1.test1(24,21);
        stu1.test1(7.2,9.1);
        stu1.test1(8,2,9.2);
        stu1.test1(2.3,"小明");
    }
}
