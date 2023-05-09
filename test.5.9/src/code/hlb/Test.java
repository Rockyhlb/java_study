package code.hlb;

public class Test {
    public static void main(String[] args) {
//        Son s = new Son();
//        s.building();
//        System.out.println();
//
//        Udisk udisk = new Udisk();
//        udisk.show();
//        udisk.communication();
//
//        // 接口中静态方法不能被实现类重写，因为它属于接口独有
//        UsbConnector.method();
//        // 在实现类中可以定义一个与接口中静态方法方法名相同的静态方法，则这个静态方法归实现类独有。
//        Udisk.method();

        /*
            interface之间的多继承:
              Java中的继承都是单继承的，就是说一个父类可以被多个子类继承但是一个子类只能有一个父类。
            但是一个接口可以被不同实现类去实现，这就是我们说的Java中的多态的概念。
              接口的多继承的概念，就是说一个接口是可以继承多个接口的。一个实现类可以继承多个接口，但要实现每个接口中的抽象方法。
            不过如果接口中存在相同的接口默认方法(也就是两个接口中默认方法名相同)，这就是接口默认方法冲突。
            这个解决办法就是在实现类中覆盖重写该默认方法即可。
            如果接口默认方法名和另一个接口的抽象方法同名，返回值类型也相同，这种冲突可以通过实现类覆盖重写该方法来解决问题。
            但是若返回值类型不相同则无法解决该问题，因为这纯属没事闲的才这样做。
        **/

        Son s = new Son();
        s.building();
        s.set();  // 默认方法，所以Son类当中无需重写
        System.out.println();
        s.show();
        s.communication();

        // 接口中静态方法不能被实现类重写，因为它属于接口独有
        UsbConnector.method();
        // 在实现类中可以定义一个与接口中静态方法方法名相同的静态方法，则这个静态方法归实现类独有。
        Udisk.method();
        Son.method();
    }
}
