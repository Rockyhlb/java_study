package com.hlb;

/**
 * @author: code_hlb
 * @date :  2023/10/23 14:06
 * @desc : "==" 和 "equals()" 在字符串和自定义对象间的区别
 */
public class TestDemo1 {
    public static void main(String[] args) {
        // 使用new关键字新建一个地址
        String str = new String("hello");
        // “hello”都存放在常量池当中，因此str1和str2都指向同一个地址
        String str1 = "hello";
        String str2 = "hello";

        // 输出：false  比较的是引用的地址
        System.out.println(str == str1);
        // 输出：true   逐个比较字符串
        System.out.println(str.equals(str1));
        // 输出：true   逐个比较字符串
        System.out.println(str.equals(str1));

        Student student1 = new Student("hlb");
        Student student2 = new Student("hlb");

        // 输出：false
        System.out.println(student1 == student2);
        // 输出false  Student的默认父类是 Object, 因此默认调用的equals方法还是Object的equals方法，
        // Object的equals方法本质还是 this == obj
        // 因此我们的自定义类型需要进行字符串比较时，应该重写equals方法
        System.out.println(student1.equals(student2));
    }
}

class Student{
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
