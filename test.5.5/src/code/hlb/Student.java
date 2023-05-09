package code.hlb;

public class Student {

    static Student st1 = null;
    private Student(){}
    static Student getInstance(){
        if (st1 == null)
        {
          st1 = new Student();
        }
        return  st1;
    }

    void play(String str){
        System.out.println(str);
    }

}

class Test1 {
    public static void main(String[] args) {

        // 因为Student类的构造方法已经被私有化，所以无法实例化
        // Student st1 = new Student();

        // 单例模式即可对类的私有对象进行访问
        Student st1 = Student.getInstance();
        Student st2 = Student.getInstance();
        st1.play("nhdsabh");
        st2.play("dsanjnas");

    }
}
