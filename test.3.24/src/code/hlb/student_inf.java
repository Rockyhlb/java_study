package code.hlb;

public class student_inf {

//    int age;
//    String name;
//    String id;
//    public student_inf(int age, String name, String id) {
//        this.age = age;
//        this.name = name;
//        this.id = id;
//    }

    int age;
    String name;
    String id;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    void self_intro()
    {
        System.out.println("age = " + age);
        System.out.println("name = " + name);
        System.out.println("id = " + id);
    }
}
