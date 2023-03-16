//package code.hlb;
//
//import java.util.Scanner;
//
//public class GuessNum {
//    public static void main(String[] args) {
//        Scanner scan = new Scanner(System.in);
//
//        int  RanNUm = 10;
//        int choices = 1;
//
//        while(choices <= 3)
//        {
//            System.out.print("请输入你猜的数字：");
//            if (scan.hasNextInt())
//            {
//                int guess_num = scan.nextInt();
//                if (guess_num == RanNUm)
//                {
//                    System.out.println("恭喜你，猜对了!\n");
//                }
//                else
//                {
//                    System.out.print("请重新猜数字：");
//                    choices++;
//                }
//            }
//        }
//        if (choices > 3)
//        {
//            System.out.println("你的机会已经使用完！\n");
//        }
//    }
//}
