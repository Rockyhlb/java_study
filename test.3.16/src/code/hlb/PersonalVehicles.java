package code.hlb;

public class PersonalVehicles {
    //嵌套类的调用
//    class Car{
//        private String id = "202291191";
//        String brand = "奥迪RS7";
//        long distance = 100000;
//    }
//    public void assess() {
//        Car car = new Car();
//        System.out.println(car.id);
//        System.out.println(car.brand);
//        System.out.println(car.distance);
//    }

////    //使用private访问修饰符,类的外部看不到private成员，私有成员只能被该类的方法访问
//    private String id = "202291191";
//    String brand = "奥迪RS7";
//    long distance = 1000;
//    void display()
//    {
//        System.out.printf("id:%s,brand:%s,distance:%d",id,brand,distance);
//    }

////    类成员被protect,仅允许类成员和继承自它的所有类访问
//    protected String id = "202291191";
//    String brand = "奥迪RS7";
//    long distance = 1000;
//    void display()
//    {
//        System.out.printf("id:%s,brand:%s,distance:%d",id,brand,distance);
//    }
//
    private int age = 122;
    private char sex = '男';

    int getAge()
    {
        System.out.printf("%d\n",age);
        return this.age;
    }

    void setAge()
    {
        if (age >120 || age < 0)
        {
            System.out.println("输入不合法，重置为18");
            this.age = 18;
        }
    }

    void self_intro()
    {
        System.out.printf("age:%d,sex:%c",age,sex);
    }

}
