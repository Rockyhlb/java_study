package code.hlb;

import java.util.Scanner;

public class User {
    Scanner sc = new Scanner(System.in);
    Car car = new Car();
    Truck truck = new Truck();

    void menu(){
        System.out.println("********************************");
        System.out.println("***********小黄鸭租车行**********");
        System.out.println("***********  1   租车  **********");
        System.out.println("***********  0   退出  **********");
        System.out.println("********************************");

        System.out.print("请选择：");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
                System.out.println("本租车行目前只有卡车和轿车可供出租-->");

                System.out.println("卡车(数量 卡车重量 天数)：");
                int nums = sc.nextInt();
                float weight = sc.nextFloat();
                int day1 = sc.nextInt();
                float truck_rent = truck.truck_rent(nums,weight,day1);

                System.out.println("轿车(数量 天数)：");
                int nums2 = sc.nextInt();
                int day2 = sc.nextInt();
                float car_rent = car.car_rent(nums2,day2);

                System.out.println("卡车总租金为：" + truck_rent + " " + "轿车总租金为：" + car_rent + "总租金为：" +
                        (truck_rent+car_rent));
                break;
            case 0:
                break;
            default:
                System.out.println("非法输入，请重新输入....");
                menu();
        }
    }
}
