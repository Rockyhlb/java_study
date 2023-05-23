package code.hlb;

import java.security.DigestException;

public class Test {

    static Animal animals[] = new Animal[100];

    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();

        // 向上转型
        animals[0] = dog;
        animals[1] = cat;

        animals[0].eating();
        animals[1].eating();
        System.out.println();

        for (Animal animal:animals){
            if (animal instanceof Dog){
                ((Dog) animal).playing();
            }
            else if(animal instanceof Cat){
                ((Cat) animal).playing();
            }
        }

    }
}
