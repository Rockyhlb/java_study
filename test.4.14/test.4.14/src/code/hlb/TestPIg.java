package code.hlb;

public class TestPIg {

    public static void main(String[] args) {
        // static 关键字适用于方法、变量和内部类，静态修饰，可以通过类名直接调用
        Pig pig = new Pig();
        pig.showPig();
        Pig.showPig();

    }
}
