package code.hlb;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        // 异常处理
//        try {
//            System.out.print("请输入两个整数进行加法运算：");
//
//            int num1 = sc.nextInt();
//            int num2 = sc.nextInt();
//
//            System.out.println(num1+num2);
//        }
//        catch (Exception e)
//        {
//            System.out.println("请重新输入有效值：");
//        }


        Master master = new Master();

        Dog dog = new Dog();
        Cat cat = new Cat();

        master.feeding(dog);
        master.feeding(cat);

    }
}
