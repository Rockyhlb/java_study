package code.hlb;

public class Test {

    static Animal animals[] = new Animal[100];

    // 引用多态的两种环境
    // 1) 以父类引用变量为方法的形式参数，最后调用方法时，传递子类对象为实参
    // 2) 以父类引用变量为方法的返回值，返回值指向一个子类对象

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
