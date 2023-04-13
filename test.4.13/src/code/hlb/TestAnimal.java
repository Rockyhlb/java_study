package code.hlb;

public class TestAnimal {
    public static void main(String[] args) {

        //当子类对象被调用时，无论是否含参，父类的空参构造器一定被调用
        Pig pig = new Pig("black");
        System.out.println();
        Pig pig1 = new Pig();


    }
}
