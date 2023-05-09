package code.hlb;

// 如果要想实现接口，就要有一个实现类去实现，而且要实现它其中的抽象方法，并且要用implements关键字。
// 形式为实现类名 implements 接口名。
public class Udisk implements UsbConnector{
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
        System.out.println("我不想摸鱼 -- 实现类重写静态方法");
    }
}
