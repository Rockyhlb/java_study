package code.hlb;

public interface UsbConnector {

    //    接口(interface)是抽象方法和常量值的定义的集合。
    //    从本质上讲，接口是一种特殊的抽象类，这种抽象类中只包含常量和方法的定义，而没有变量和方法的实现。

    // 写抽象方法的几种形式，可以省略public abstract 或public 或 abstract都可以。
    void show();

    // 在接口中可以有默认方法，形式为 public default 返回值类型 方法名(){ }。
    default void communication()
    {
        System.out.println("正在通过usb口取电、通信");
    }

    // 在接口中可以有静态方法，形式为 public static 返回值类型 方法名(){ }。
    static void method(){
        System.out.println("我想摸鱼 -- 接口静态方法");
    }

    // 在接口中定义常量，形式为public final 数据类型 变量名 = 数值;。这里面的public 和 final都可以省略掉。
    String str1 = "hello";
    public String str2 = "world";
}
