package com.hlb.mapreduce.partitioner;

import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Partitioner;

/**
 * @author: code_hlb
 * @date :  2023/11/10 18:24
 * @desc :  将统计结果按照手机归属地不同省份输出到不同文件中（分区）
 * （1）输入数据
 * （2）期望输出数据
 * 	手机号136、137、138、139开头都分别放到一个独立的4个文件中，其他开头的放到一个文件中。
 */
public class ProvincePartitioner extends Partitioner<Text, FlowBean> {

    @Override
    public int getPartition(Text text, FlowBean flowBean, int numPartitions) {
        //获取手机号前三位prePhone
        String phone = text.toString();
        String prePhone = phone.substring(0, 3);

        //定义一个分区号变量partition,根据prePhone设置分区号
        int partition;

        if("136".equals(prePhone)){
            partition = 0;
        }else if("137".equals(prePhone)){
            partition = 1;
        }else if("138".equals(prePhone)){
            partition = 2;
        }else if("139".equals(prePhone)){
            partition = 3;
        }else {
            partition = 4;
        }

        //最后返回分区号partition
        return partition;
    }
}