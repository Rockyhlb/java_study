package com;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class hlb {

    public static void main(String[] args) {

        HashMap<String,Integer> hashMap = new HashMap<>();

        hashMap.put("A",88);
        hashMap.put("B",77);
        hashMap.put("C",99);
        hashMap.put("D",66);
        hashMap.put(null,100);
        hashMap.put(null,98);
        hashMap.put("A",76);

        // 通过键访问
        for (String key:hashMap.keySet()) {
            System.out.println(key + " " + hashMap.get(key));
        }

        System.out.println();
        // 通过值访问
        for (Integer value:hashMap.values()) {
            System.out.println(hashMap.get(value) + " " + value);
        }

        System.out.println();
        for (Map.Entry<String,Integer> map:hashMap.entrySet()) {
            System.out.println(map.getKey() + " " + map.getValue());
        }

        int i = 1;
        // 1 0
        int j = i+++1-i--;

        System.out.println();
        System.out.println(i);
        System.out.println(j);
    }
}
