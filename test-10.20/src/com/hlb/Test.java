package com.hlb;

/**
 * @author: code_hlb
 * @date : 2023/10/20 11:02
 */
public class Test {

    public static void testDevice(Device device){
        device.connect();
        System.out.println("=========connect========");
        device.disconnect();
        System.out.println("==========disconnect========");
    }



    public static void main(String[] args) throws CloneNotSupportedException {
        Computer computer = new Computer("Leovoe",11);
        testDevice(computer);
        System.out.println(computer);

        Computer computer1 = (Computer) computer.clone();
        System.out.println(computer1);

        System.out.println("========hashcode========");
        System.out.println(computer.hashCode());
        System.out.println(computer1.hashCode());

        System.out.println("====================");
        System.out.println(computer.equals(computer1));

        // 通过versionCompare比较 系统版本
        VersionCompare versionCompare = new VersionCompare();
        if(0 == versionCompare.compare(computer,computer1)){
            System.out.println("version is same!");
        }else {
            System.out.println("version is not same!");
        }

        // 通过NameCompare比较 系统版本
        NameCompare nameCompare = new NameCompare();
        if(0 == nameCompare.compare(computer,computer1)){
            System.out.println("name is same!");
        }else {
            System.out.println("name is not same!");
        }

        /*System.out.println("====================");
        System.out.println(computer.m.getMoney());
        System.out.println(computer1.m.getMoney());
        computer.m.setMoney(7999);
        // 两台电脑的价格输出都是7999,证明此处是浅拷贝
        System.out.println("=========浅拷贝=========");
        System.out.println(computer.m.getMoney());
        System.out.println(computer1.m.getMoney());*/

        System.out.println("====================");
        System.out.println(computer.m.getMoney());
        System.out.println(computer1.m.getMoney());
        computer.m.setMoney(7999);
        // 只有一台电脑的价格输出是7999,证明此处是深拷贝
        System.out.println("=========深拷贝=========");
        System.out.println(computer.m.getMoney());
        System.out.println(computer1.m.getMoney());
    }
}
