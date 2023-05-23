package code.hlb;

public abstract class Animal {

    abstract void eating();
}

class Dog extends Animal{
    public Dog() {
    }

    public void eating(){
        System.out.println("小狗吃骨头");
    }

    public void playing(){
        System.out.println("小狗捉耗子");
    }
}

class Cat extends Animal{
    public Cat() {
    }

    public void eating(){
        System.out.println("小猫吃鱼");
    }

    public void playing(){
        System.out.println("小猫捉鱼");
    }
}