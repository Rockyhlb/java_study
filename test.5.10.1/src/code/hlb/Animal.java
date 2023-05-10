package code.hlb;

public abstract class Animal {
    // 抽象类的抽象方法
    abstract void eating();
}

class Dog extends Animal{
    void eating(){
        System.out.println("dog is eating");
    }
}

class Cat extends Animal{

    void eating(){
        System.out.println("cat is eating");
    }
}

class Caw extends Animal{

    void eating(){
        System.out.println("caw is eating");
    }
}
