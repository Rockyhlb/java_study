package com.hlb;

public class Student_inform {
    String name;
    String id;
    int age;
    String mobile;
    char sex;

    void self_intro()
    {
        System.out.printf("我的姓名是：%s ,学号是：%s,今年%d岁,电话号码是：%s,性别:%c\n",name,id,age,mobile,sex);
    }

    void testEqual(Student_inform stu)
    {
        System.out.printf("这两位学生" + (this.name == stu.name));
    }

}
