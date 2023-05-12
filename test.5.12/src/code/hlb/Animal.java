package code.hlb;

public abstract class Animal {
    abstract void eating();
}

class Cat extends Animal{
    @Override
    void eating() {
        System.out.println("小猫吃鱼");
    }
}

class Dog extends Animal{
    @Override
    void eating() {
        System.out.println("小狗吃骨头");
    }
}
