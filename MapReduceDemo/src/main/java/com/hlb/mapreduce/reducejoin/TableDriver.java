package com.hlb.mapreduce.reducejoin;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import java.io.IOException;

/**
 * @BelongsProject: MapReduceDemo.iml
 * @BelongsPackage: com.hlb.mapreduce.reducejoin
 * @CreateTime : 2023/12/2 22:16
 * @Description: 通过将关联条件作为Map输出的key，将两表满足Join条件的数据并携带数据所来源的文件信息，
 *               发往同一个ReduceTask，在Reduce中进行数据的串联。
 *               缺点：这种方式中，合并的操作是在Reduce阶段完成，Reduce端的处理压力太大，
 *                    Map节点的运算负载则很低，资源利用率不高，且在Reduce阶段极易产生数据倾斜。
 *               解决方案：Map端实现数据合并。
 * @Author: code_hlb
 */
public class TableDriver {
    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Job job = Job.getInstance(new Configuration());

        job.setJarByClass(TableDriver.class);
        job.setMapperClass(TableMapper.class);
        job.setReducerClass(TableReducer.class);

        job.setMapOutputKeyClass(Text.class);
        job.setMapOutputValueClass(TableBean.class);

        job.setOutputKeyClass(TableBean.class);
        job.setOutputValueClass(NullWritable.class);

        FileInputFormat.setInputPaths(job, new Path("/input"));
        FileOutputFormat.setOutputPath(job, new Path("/output/reduceJoin"));

        boolean b = job.waitForCompletion(true);
        System.exit(b ? 0 : 1);
    }
}