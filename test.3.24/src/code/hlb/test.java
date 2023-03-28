package code.hlb;

public class test {
//    public static void main(String[] args) {
//
//        student_inf stu1 = new student_inf(18,"dbsha","67862843");
//        System.out.println(stu1.age);
//        System.out.println(stu1.name);
//        System.out.println(stu1.id);
//    }

    public static void main(String[] args) {

        //继承
        Inherite in1 = new Inherite();

        in1.setAge(18);
        in1.setName("zjj");
        in1.setId("06150223");

        in1.self_intro();
    }
}
