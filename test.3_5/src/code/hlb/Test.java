package code.hlb;

public class Test {
    public static void main(String[] args) {
        Kid kid = new Kid();
        kid.say();
        System.out.println(kid.name);
    }
}


@SuppressWarnings({"all"})
//把所有的警告镇压【该类不会报警告】
class Parent {
    @Deprecated//表示这个name已经过时了
    public String name = "jack";

    public void say() {
        System.out.println("父亲说：我为我的儿子感到骄傲~");
    }
}

@SuppressWarnings("unused")
class Kid extends Parent {
    private int age = 10;

    @Override//该注解只能用于重写父类方法
    public void say() {
        System.out.println("孩子说：我要努力学习~");
    }
}
