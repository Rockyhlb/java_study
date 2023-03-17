package code.hlb;

public class Student_Inf {
//    String id;
//    boolean sex;
//    float score;
//    char lesson;
//    //String类型的默认值为null,boolean的默认值为false，float的默认值为0.0，int类型默认值为0，char的默认值为空格
//    void self()
//    {
//        System.out.println(id);
//        System.out.println(sex);
//        System.out.println(score);
//        System.out.println(lesson);
//    }

//    int nianling;
//
//    public int getNianling() {
//        return nianling;
//    }
//
//    public void setNianling(int nianling) {
//        this.nianling = nianling;
//    }
//
//    String id;
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    String name;
//    boolean sex;
//
//    public boolean isSex() {
//        return sex;
//    }
//
//    public void setSex(boolean sex) {
//        this.sex = sex;
//    }

    String id;
    String name;
    int score;

    //构造类方法，构造名称必须跟类名称一致，构造方法没有返回值且不写void

    Student_Inf(){}
    Student_Inf(String id,String name,int score)
    {
        this.id = id;
        this.name = name;
        this.score = score;
    }
}
