package com.hlb.mapreduce.compress;

import java.io.IOException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.io.compress.BZip2Codec;
import org.apache.hadoop.io.compress.CompressionCodec;
import org.apache.hadoop.io.compress.GzipCodec;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.compress
 * @CreateTime : 2023/12/3 16:29
 * @Description: Map 输出端采用压缩
 * @Author: code_hlb
 */
public class WordCountDriver {

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {

        Configuration conf = new Configuration();

        // 开启map端输出压缩
        conf.setBoolean("mapreduce.map.output.compress", true);

        // 设置map端输出压缩方式
        conf.setClass("mapreduce.map.output.compress.codec", BZip2Codec.class,CompressionCodec.class);

        Job job = Job.getInstance(conf);

        job.setJarByClass(WordCountDriver.class);

        job.setMapperClass(WordCountMapper.class);
        job.setReducerClass(WordCountReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(IntWritable.class);

        job.setOutputKeyClass(Text.class);
        job.setOutputValueClass(IntWritable.class);

        FileInputFormat.setInputPaths(job, new Path(args[0]));
        FileOutputFormat.setOutputPath(job, new Path(args[1]));

        // 设置reduce端输出压缩开启
        //FileOutputFormat.setCompressOutput(job, true);
        // 设置压缩的方式
        // FileOutputFormat.setOutputCompressorClass(job, BZip2Codec.class);
        // FileOutputFormat.setOutputCompressorClass(job, GzipCodec.class);
        // FileOutputFormat.setOutputCompressorClass(job, DefaultCodec.class);

        boolean result = job.waitForCompletion(true);

        System.exit(result ? 0 : 1);
    }
}