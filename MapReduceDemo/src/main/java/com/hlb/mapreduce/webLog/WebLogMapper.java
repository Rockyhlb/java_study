package com.hlb.mapreduce.webLog;

import java.io.IOException;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.webLog
 * @CreateTime : 2023/12/3 15:44
 * @Description: TODO
 * @Author: code_hlb
 */
public class WebLogMapper extends Mapper<LongWritable, Text, Text, NullWritable>{

    @Override
    protected void map(LongWritable key, Text value, Context context)
            throws IOException, InterruptedException {

        // 1 获取1行数据
        String line = value.toString();

        // 2 解析日志
        boolean result = parseLog(line,context);

        // 3 日志不合法退出
        if (!result) {
            return;
        }

        // 4 日志合法就直接写出
        context.write(value, NullWritable.get());
    }

    // 2 封装解析日志的方法
    private boolean parseLog(String line, Context context) {

        // 1 截取
        String[] fields = line.split(" ");

        // 2 日志长度大于11的为合法
        return fields.length > 11;
    }
}