package com.hlb.mapreduce.outputformat;

import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.outputformat
 * @CreateTime : 2023/12/2 21:42
 * @Description: TODO
 * @Author: code_hlb
 */
public class LogReducer extends Reducer<Text, NullWritable,Text, NullWritable> {
    @Override
    protected void reduce(Text key, Iterable<NullWritable> values, Context context)
            throws IOException, InterruptedException {
        // 防止有相同的数据,迭代写出
        for (NullWritable value : values) {
            context.write(key,NullWritable.get());
        }
    }
}