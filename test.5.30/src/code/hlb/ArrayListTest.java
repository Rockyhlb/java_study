package code.hlb;

import sun.plugin.javascript.navig.LinkArray;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class ArrayListTest {


    public static void main(String[] args) {

//        List是一个有序的集合，它允许重复元素。List中的每个元素都有一个对应的索引，
//        可以通过索引来访问元素。常见的List实现包括ArrayList和LinkedList。

        // 创建一个 arrayList 对象
        ArrayList<String> arrayList = new ArrayList<String>();
        ArrayList<String> arrayList2 = new ArrayList<String>();
        // 添加元素到列表
        arrayList.add("hello");
        arrayList.add("world");
        arrayList.add("......");

        arrayList2.add("code..");
        arrayList2.add("hlb");

        // 指定位置添加
        arrayList.add(1,"------------------");
        System.out.println("Previous arrayList:" + arrayList);

        // 指定位置添加集合对象
        arrayList.addAll(2,arrayList2);
        System.out.println("addAll[1,arrayList2]:" + arrayList);

        // 遍历列表
//        for (Object o: arrayList) {
//            System.out.println(o);
//        }
        // 获取列表长度
        System.out.println("arrayList Size = " + arrayList.size());

        // 通过索引获取元素  -- "world"
        System.out.println("arrayList[0]="+arrayList.get(0));

//                  删除元素
        arrayList.remove(1);
        System.out.println("After remove[1]: " + arrayList);

        // 替换指定位置的元素
        arrayList.set(1,"dsasdsa");
        System.out.println("After set[1,'dsasdsa']: " + arrayList);

        LinkedList<String> linkedList = new LinkedList<>();

        linkedList.add("dasdsa");
        linkedList.add("daa");

        linkedList.addAll(0,arrayList);
        linkedList.remove(1);

        System.out.println("linkList="+linkedList);

    }
}
