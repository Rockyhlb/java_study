package code.hlb;

public class Animal {

    //当子类对象被调用时，无论是否含参，父类的空参构造器一定被调用
    String color;
    int weight;

    //访问修饰符的公开性由高到低排序
    public int test1;
    protected int test2;    //只能被子类访问和本类   -- 可以被同包的子类访问
    int test3;              // 默认类型  -- default -- 不能被不同包的子类访问
    private int test4;      // 私有属性  只能被内部类访问

    public Animal(){
        System.out.println("调用父类的空参构造器~");
    }

    public Animal(String color){
        System.out.println("调用父类的空参构造器~");
    }

    void show(){

        System.out.println("父类的show方法~");
    }
}
