package com.hlb;

public class testStudent {
    public static void main(String[] args) {
        //生成对象
        Student_inform stu1 = new Student_inform();
        Student_inform stu2 = new Student_inform();
        //赋值
        stu1.name = "rocky";
        stu1.id = "211177010056";
        stu1.age = 19;
        stu1.mobile = "17785779447";
        stu1.sex = '男';

        stu2.name = "smith";
        stu2.id = "2111770100256";
        stu2.age = 20;
        stu2.mobile = "17812738822";
        stu2.sex = '女';

        stu1.self_intro();
        stu2.self_intro();
        System.out.print("############################\n");
        stu1.testEqual(stu2);
    }
}
