package code.hlb;

import java.util.Scanner;

public class Test {
    static Vehicles[] vehicles = new Vehicles[100];
    static int[] days = new int[100];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int choice = -1;
        boolean flag = true;

        int day = 0;
        int freePosition = -1;  // 记录空闲位置

        while (flag){
            System.out.println("************* 小黄鸭出租行 *********");
            System.out.println("***********1    卡车出租***********");
            System.out.println("***********2    小汽车出租*********");
            System.out.println("***********3    拖拉机出租*********");
            System.out.println("***********0    退      出*********");
            System.out.println("***********************************");
            System.out.print("请选择您要租赁的车-->: ");
            choice = sc.nextInt();

            switch (choice)
            {
                case 1:
                    System.out.print("请输入卡车的载重量：");
                    int weight = sc.nextInt();
                    System.out.print("请问需要租多少天：");
                    day = sc.nextInt();

                    freePosition = getFreePosition();
                    if (-1 != freePosition){
                        // 向下转型
                        vehicles[freePosition] = new Truck(weight);
                        days[freePosition] = day;
                    }
                    else {
                        System.out.println("无空闲位置");
                        flag = false;
                    }
                    break;
                case 2:
                    System.out.print("请输入小汽车的座数：");
                    int seats = sc.nextInt();
                    System.out.print("请问需要租多少天：");
                    day = sc.nextInt();

                    freePosition = getFreePosition();
                    if (-1 != freePosition){
                        vehicles[freePosition] = new Car(seats);
                        days[freePosition] = day;
                    }
                    else {
                        System.out.println("无空闲位置");
                        flag = false;
                    }
                    break;
                case 3:
                    System.out.print("请输入拖拉机的排放量：");
                    float disCharge = sc.nextFloat();
                    System.out.print("请问需要租多少天：");
                    day = sc.nextInt();

                    freePosition = getFreePosition();
                    if (-1 != freePosition){
                        vehicles[freePosition] = new TuoLaJi(disCharge);
                        days[freePosition] = day;
                    }
                    else {
                        System.out.println("无空闲位置");
                        flag = false;
                    }
                    break;
                case 0:
                    flag = false;
                    break;
                default:
                    System.out.println("请输入合法输入~~");
                    break;
            }

            if (flag){
                System.out.print("还要继续租别的车么？(Y or F):");
                String sure = sc.next();
                if (sure.equals("F"))
                {
                    flag = false;
                }
            }
        }

        double fee = countTotalFee();

        if(0 != fee){
            System.out.println("总共需要收取" + fee + "租金");
        }
    }

    // 利用多态自动计算租金
    private static double countTotalFee(){
        double total = 0;
        for (int i = 0; i < vehicles.length && vehicles[i] != null; i++){
            total += vehicles[i].countFee(days[i]);
        }
        return  total;
    }

    private static int getFreePosition(){
        int freePosion = -1;
        for (int i = 0; i < vehicles.length;i++){
            if (vehicles[i] == null){
                freePosion = i;
                break;
            }
        }
        return freePosion;
    }
}
