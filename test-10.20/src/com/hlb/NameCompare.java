package com.hlb;

import java.util.Comparator;

/**
 * @author: code_hlb
 * @date : 2023/10/20 11:35
 */
public class NameCompare implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
