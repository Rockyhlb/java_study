package code.hlb;

public class TestVehicles {
    //嵌套类的调用
//    public static void main(String[] args) {
//        PersonalVehicles car1 = new PersonalVehicles();
//        car1.assess();
//    }

//    //访问修饰符的使用
//    public static void main(String[] args) {
//        PersonalVehicles car1 = new PersonalVehicles();
//        //报错，当类中成员被private时，类的外部看不到private成员，私有成员只能被该类的方访问
//        System.out.printf("id:%s,brand:%s,distance:%d", car1.id, car1.brand, car1.distance);
//        System.out.println("\n*************************");
//        car1.display();
//    }

//        //类成员被protect,仅允许类成员和继承自它的所有类访问
//        System.out.printf("id:%s,brand:%s,distance:%d",car1.id,car1.brand,car1.distance);
//        System.out.println("\n*************************");
//        car1.display();
//    }

    public static void main(String[] args) {
        PersonalVehicles stu1 = new PersonalVehicles();
        stu1.setAge();
        stu1.getAge();
        stu1.self_intro();
    }
}
