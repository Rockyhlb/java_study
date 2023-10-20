package com.hlb;

import com.sun.xml.internal.ws.policy.EffectiveAlternativeSelector;

import java.util.Comparator;
import java.util.Objects;

/**
 * @author: code_hlb
 * @date : 2023/10/20 10:59
 */
public class Computer implements Device,Cloneable {

    private String name;
    private int osVersion;

    class Money implements Cloneable{
        private int money;

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
        }

        public Money(int money) {
            this.money = money;
        }

        @Override
        protected Object clone() throws CloneNotSupportedException {
            return super.clone();
        }
    }
    Money m = new Money(5999);

    @Override
    public void connect() {

        KeyBoard keyBoard = new KeyBoard();
        keyBoard.connect();

        Mouse mouse = new Mouse();
        mouse.connect();
        System.out.println(m.money +"￥ " + name + " 正在启动！");
    }

    @Override
    public void disconnect() {

        KeyBoard keyBoard = new KeyBoard();
        keyBoard.disconnect();

        Mouse mouse = new Mouse();
        mouse.disconnect();

        System.out.println(name + " 正在关机!");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(int osVersion) {
        this.osVersion = osVersion;
    }

    public Computer(String name, int osVersion) {
        this.name = name;
        this.osVersion = osVersion;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "name='" + name + '\'' +
                ", osVersion=" + osVersion +
                ", money=" + m.money +
                '}';
    }

    // 根据重写hashcode方法，实现将两个一样的对象放到一个位置
    @Override
    public int hashCode() {
        return Objects.hash(name,osVersion);
    }

    // 浅拷贝  -->  computer.m 和 computer1.m 所指向的引用都是第一个堆地址
//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        return super.clone();
//    }

    // 深拷贝  -->  computer1 克隆computer时，新 new 了一个Monney对象，因此堆地址已经变更
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Computer tmp = (Computer) super.clone();
        // Money 类当中也需要重写clone方法并且实现Cloneable接口
        tmp.m = (Money) this.m.clone();
        return tmp;
    }

    public int compareTo(Computer c){
        return this.osVersion - c.osVersion;
    }
}
