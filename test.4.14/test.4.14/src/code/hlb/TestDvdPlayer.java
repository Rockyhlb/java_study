package code.hlb;

public class TestDvdPlayer {

    public static void main(String[] args) {

        // 因为是单例模式  所以只能播放一部影片，第二部覆盖了第一部，所以都播放盗梦空间
        DvdPlayer dvdPlayer1 = DvdPlayer.getInstance();
        dvdPlayer1.setFileName("千与千寻");

        DvdPlayer dvdPlayer2 = DvdPlayer.getInstance();
        dvdPlayer2.setFileName("盗梦空间");

        dvdPlayer1.play();
        dvdPlayer2.play();

        // 打印两个对象的地址
        System.out.println(dvdPlayer1);
        System.out.println(dvdPlayer2);
    }
}
