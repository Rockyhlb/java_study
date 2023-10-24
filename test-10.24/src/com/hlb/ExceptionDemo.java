package com.hlb;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author: code_hlb
 * @date :  2023/10/24 13:57
 * @desc :  自定义异常
 */
public class ExceptionDemo {

    public static void main(String[] args) {

        // 实现一个登陆窗口
        Scanner sc = new Scanner(System.in);

        try {
            menu();
            while (sc.hasNextLine()){
                int choice = sc.nextInt();

                if (1 == choice){
                    Login login = new Login();

                    sc.nextLine();
                    System.out.println("请输入您的账户名：");
                    String name = sc.nextLine();
                    System.out.println("请输入您的密码：");
                    String passwd = sc.nextLine();

                    if (!name.equals(login.getName())){
                        // 抛出自定义异常
                        throw new NameException("账户名错误~");
                    }

                    if (!passwd.equals(login.getPasswd())){
                        // 抛出自定义异常
                        throw new PasswdExption("密码错误~");
                    }
                    System.out.println("登陆成功！");
                }else if(0 == choice) {
                    System.out.println("退出成功！");
                    Thread.sleep(500);
                    System.exit(0);
                }
            }
        }catch (NameException | PasswdExption e){
            throw e;
        } catch (InterruptedException | InputMismatchException e) {
            e.printStackTrace();
        }catch (Exception e){
            System.out.println("出现异常！");
        } finally {
            sc.close();
        }
    }

    static void menu(){
        System.out.println("======================");
        System.out.println("=======1、 登陆========");
        System.out.println("=======0、 退出========");
        System.out.println("======================");
        System.out.print("请输入您的选择：");
    }
}
