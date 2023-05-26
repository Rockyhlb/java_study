package code.hlb;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {

    static Scanner input;

    public static void main(String[] args) {


        try {
            input = new Scanner(System.in);

            System.out.print("请输入除数：");
            int num1 = input.nextInt();
            System.out.print("请输入被除数：");
            int num2 = input.nextInt();
            System.out.println(num1/num2);
        }
        catch (ArithmeticException e1) {
            // err -- 红色字体打印,且打印在最后一行
            System.err.println(e1.toString());
            System.out.println(e1.getMessage());
        }
        catch (InputMismatchException e2){
            System.err.println(e2.toString());
            System.out.println(e2.getMessage());
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        finally {
            // 作善后处理  例如关闭打开的文件或者断开数据库的连接
            System.out.println("finally");
        }

        System.out.println("hahaha");
    }
}
