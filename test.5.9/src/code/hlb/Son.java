package code.hlb;

//public class Son extends King {
//    public void science(){
//        System.out.println("科学技术");
//    }
//
//    public void math(){
//        System.out.println("数学基础");
//    }
//
//}

/*
    7.继承父类并实现多接口:
    一个类既可以继承父类也可以是很多接口的实现类。形式为:类名 extends 父类名 implements 接口名，接口名...
    当父类的成员方法名和接口中的抽象方法名相同时，返回值类型也相同，则优先继承父类，即不显式的实现接口也不会报错。
    (这句话的意思就是因为子类继承了父类中的成员方法相当与覆盖重写了接口中的抽象方法，
    所以子类中可以不实现该抽象方法，调用时直接调用父类中的该成员方法即可)。
**/
public class Son extends King implements UsbConnector,demo02{
    public void science(){
        System.out.println("科学技术");
    }

    public void math(){
        System.out.println("数学基础");
    }

    @Override
    public void show()
    {
        System.out.println("u盘已插入 -- 实现类重写接口的方法show");

        // 访问接口已经定义的变量
        System.out.println(str1 + "--" + "接口变量1");
        System.out.println(str2 + "--" + "接口变量2");
    }

    // 接口中默认方法还可以被实现类覆盖重写
    @Override
    public void communication()
    {
        System.out.println("u盘正在工作 -- 实现类重写接口的方法communication");
    }

    // 在实现类中可以定义一个与接口中静态方法方法名相同的静态方法，则这个静态方法归实现类独有。
    public static void method(){
        System.out.println("我不想摸鱼 -- 实现多重继承类的静态方法重写");
    }
}
