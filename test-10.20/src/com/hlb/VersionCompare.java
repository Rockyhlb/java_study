package com.hlb;

import java.util.Comparator;

/**
 * @author: code_hlb
 * @date : 2023/10/20 11:32
 */
public class VersionCompare implements Comparator<Computer> {
    @Override
    public int compare(Computer o1, Computer o2) {
        return o1.getOsVersion() - o2.getOsVersion();
    }
}
