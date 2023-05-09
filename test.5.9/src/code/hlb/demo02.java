package code.hlb;

public interface demo02 {
    public abstract void show();
    public default void set(){
        System.out.println("接口2的默认方法");
    }
}
