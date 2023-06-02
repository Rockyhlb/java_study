package com.hlb;

import java.util.HashMap;
import java.util.Map;

public class MapTest {
    public static void main(String[] args) {

        /*
        * Map是一个键值对的集合。Map中的每个元素都由一个唯一的键和一个对应的值组成。常见的Map实现包括HashMap和TreeMap。
        * */

        // 创建一个HashMap对象
        Map<String, Integer> map = new HashMap<>();

        // 添加键值对到Map中
        map.put("C#",0);
        map.put("Java", 1);
        map.put("Python", 2);
        map.put("C++", 3);

        // 获取Map大小
        System.out.println("Map size: " + map.size());

        // 遍历Map
        System.out.println("Previous Map:" + map);

        for (String key : map.keySet()) {
            System.out.println(key + ": " + map.get(key));
        }

        // 检查键是否存在于Map中
        boolean containsKey = map.containsKey("Java");
        System.out.println("Contains Java key: " + containsKey);

        // 删除键值对
        map.remove("Python");
        System.out.println("After remove: " + map);
    }
}
