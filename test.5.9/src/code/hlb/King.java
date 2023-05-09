package code.hlb;

// abstract 用来修饰类，称为抽象类，不能被实例化，专门提供给其他类来继承
public abstract class King {
    // 多态的实现
    void building(){
        System.out.println("经济建设");
    }

    void fighting() {
        System.out.println("武装斗争");
    }

    // 国王希望接班人会科技知识，然而本人并不具备
    // 国王自己不会，那这个方法没法实现，也就是说没有方法体
    // 没有方法体，只有一个方法签名
    // 抽象方法  -- 没有方法体的方法签名，称之为抽象方法，同时也要将该类申明为抽象类
    abstract void science();
    abstract void math();
}
