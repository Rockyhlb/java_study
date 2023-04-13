package code.hlb;

public class Pig extends Animal{

    //当子类对象被调用时，无论是否含参，父类的空参构造器一定被调用
    public void setColor(String color){
        System.out.println("调用子类的set访问器~");
        super.color = color;
        System.out.println("你是"+this.color+"小猪");
    }

    //方法重写  -- 子类中重新定义父类中已有的方法，方法名称、参数列表和返回类型都必须与父类中的方法相同，
    //             方法重构可以让子类修改父类的行为，从而实现多态
    void show(){
        System.out.println("子类重写的方法~");
    }

    public Pig(){
        System.out.println("子类的空参构造器被调用~");
    }

    public Pig(String color){
        System.out.println("子类的有参构造器被调用~");
    }



}
