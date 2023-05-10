package code.hlb;

public class Test {
    public static void main(String[] args) {

        Master master = new Master();

        Dog dog = new Dog();
        dog.eating();
        master.feed(dog);   // 因为dog继承自Animal，所以可以调用feed方法，输出结果和 dog.eating(); 的输出结果相同
        System.out.println();

        Cat cat = new Cat();
        cat.eating();
        master.feed(cat);
        System.out.println();

        Caw caw = new Caw();
        caw.eating();
    }
}
