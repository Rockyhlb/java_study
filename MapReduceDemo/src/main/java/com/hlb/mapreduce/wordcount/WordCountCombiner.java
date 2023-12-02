package com.hlb.mapreduce.wordcount;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.wordcount
 * @CreateTime : 2023/12/2 21:24
 * @Description: 统计过程中对每一个MapTask的输出进行局部汇总，以减小网络传输量即采用Combiner功能
 * @Author: code_hlb
 */
public class WordCountCombiner extends Reducer<Text, IntWritable, Text, IntWritable> {
    private IntWritable outV = new IntWritable();
    @Override
    protected void reduce(Text key, Iterable<IntWritable> values, Context context)
                         throws IOException, InterruptedException {
        int sum = 0;
        for (IntWritable value : values) {
            sum += value.get();
        }
        //封装outKV
        outV.set(sum);
        //写出outKV
        context.write(key,outV);
    }
}