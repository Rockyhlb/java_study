package com.hlb.mapreduce.compress;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.compress
 * @CreateTime : 2023/12/3 16:31
 * @Description: TODO
 * @Author: code_hlb
 */
public class WordCountReducer extends Reducer<Text, IntWritable, Text, IntWritable>{

    IntWritable v = new IntWritable();

    @Override
    protected void reduce(Text key, Iterable<IntWritable> values,
                          Context context) throws IOException, InterruptedException {

        int sum = 0;

        // 1 汇总
        for(IntWritable value:values){
            sum += value.get();
        }

        v.set(sum);

        // 2 输出
        context.write(key, v);
    }
}