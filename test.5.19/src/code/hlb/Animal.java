package code.hlb;

public abstract class Animal{
    abstract void play();

    public void testing(){
        System.out.println("这是抽象类的test方法");
    }
}

class Dog extends Animal{

    public void play(){
        System.out.println("小狗玩飞碟");
    }

    public void dogEating(){
        System.out.println("小狗吃骨头");
    }
}

class Cat extends Animal{

    public void play(){
        System.out.println("小猫玩毛线");
    }

    public void catEating(){
        System.out.println("小猫吃鱼");
    }
}
