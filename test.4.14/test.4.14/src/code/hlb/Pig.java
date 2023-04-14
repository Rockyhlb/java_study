package code.hlb;

public  class Pig extends Animal {

    public static String color = "pink";

    // 静态方法里面不能调用 this 关键字
    static void showPig(){
        System.out.println("你是" + color + "小猪~");
    }
}
