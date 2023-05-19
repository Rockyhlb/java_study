package code.hlb;

public class Test {

    static Animal animals[] = new Animal[100];

    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        int i = 0;

        // 向上转型
        animals[i++] = dog;
        animals[i++] = cat;
        getInformation();
    }

    private static void getInformation(){
        for (Animal animal:animals){
            if (animal != null){
                animal.play();
                if (animal instanceof Dog){
                    // 向下转型
                    ((Dog) animal).dogEating();
                    System.out.println();
                }
                else if(animal instanceof Cat){
                    ((Cat) animal).catEating();
                    System.out.println();
                }
            }
        }
    }
}
