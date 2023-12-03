package com.hlb.mapreduce.compress;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.compress
 * @CreateTime : 2023/12/3 16:30
 * @Description: TODO
 * @Author: code_hlb
 */
public class WordCountMapper extends Mapper<LongWritable, Text, Text, IntWritable>{

    Text k = new Text();
    IntWritable v = new IntWritable(1);

    @Override
    protected void map(LongWritable key, Text value, Context context)throws IOException, InterruptedException {

        // 1 获取一行
        String line = value.toString();

        // 2 切割
        String[] words = line.split(" ");

        // 3 循环写出
        for(String word:words){
            k.set(word);
            context.write(k, v);
        }
    }
}