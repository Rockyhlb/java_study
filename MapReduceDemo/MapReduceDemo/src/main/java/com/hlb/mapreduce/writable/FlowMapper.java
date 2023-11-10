package com.hlb.mapreduce.writable;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import java.io.IOException;

/**
 * @author: code_hlb
 * @date :  2023/11/10 16:27
 * @desc :  编写Mapper类
 */
public class FlowMapper extends Mapper<LongWritable, Text, Text, FlowBean> {
    private Text outK = new Text();
    private FlowBean outV = new FlowBean();

    @Override
    protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {

        //1 获取一行数据,转成字符串
        String line = value.toString();

        //2 切割数据
        String[] split = line.split(" ");

        //3 抓取我们需要的数据:手机号,上行流量,下行流量
        String phone = split[1];
        String up = split[split.length - 3];
        String down = split[split.length - 2];

        //4 封装outK outV
        try {
            outK.set(phone);
            outV.setUpFlow(Long.parseLong(up));
            outV.setDownFlow(Long.parseLong(down));
            outV.setSumFlow();
        }catch (NumberFormatException e) {
            outK.set("手机号码\t上行流量\t下行流量\t总流量");
        }

        //5 写出outK outV
        context.write(outK, outV);
    }
}