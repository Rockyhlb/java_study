package code.hlb;

/*
* 单例模式的设计
* */

public class DvdPlayer {

    String fileName;

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    void play(){
        System.out.println("正在播放...." + this.fileName);
    }

    //设计为单例模式，需遵循的步骤
    //1  -- 声明一个本类的静态对象
    static DvdPlayer dvdPlayr = null;

    //2  -- 将本类的构造器私有化
    private DvdPlayer(){}

    //3  -- 设计一个静态方法向类外部公开本类实例
    //getInstance -- 获取一个实例
    public static DvdPlayer getInstance(){
        if (dvdPlayr == null)
        {
            dvdPlayr  = new DvdPlayer();
        }
        return dvdPlayr;
    }
}
