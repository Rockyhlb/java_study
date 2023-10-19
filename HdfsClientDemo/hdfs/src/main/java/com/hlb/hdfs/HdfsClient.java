package com.hlb.hdfs;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.*;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;

/**
 * @author: code_hlb
 * @date : 2023/10/19 20:20
 */
public class HdfsClient {
    @Test
    public void testMkdirs() throws IOException, URISyntaxException, InterruptedException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();

        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration,"rocky");

        // 2 创建目录
        fs.mkdirs(new Path("/sanGuo/wei/"));
        fs.mkdirs(new Path("/sanGuo/shu/"));
        fs.mkdirs(new Path("/sanGuo/wu/"));

        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testCopyFromLocalFile() throws IOException, InterruptedException, URISyntaxException {

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        configuration.set("dfs.replication", "2");
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 上传文件
        fs.copyFromLocalFile(new Path("D:\\JavaCode\\hadoop_code\\HdfsClientDemo\\hdfs\\src\\main\\resources\\caocao.txt"),
                new Path("/sanGuo/wei"));

        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testCopyToLocalFile() throws IOException, InterruptedException, URISyntaxException{

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 执行下载操作
        // boolean delSrc 指是否将原文件删除
        // Path src 指要下载的文件路径
        // Path dst 指将文件下载到的路径
        // boolean useRawLocalFileSystem 是否开启文件校验
        fs.copyToLocalFile(false, new Path("/sanGuo/wei/caocao.txt"), new Path("D:/JavaCode/hadoop_code/HdfsClientDemo/hdfs/src/main/resources/loadFromHdfs"), true);

        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testRename() throws IOException, InterruptedException, URISyntaxException{

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 修改文件名称
        fs.rename(new Path("/sanGuo/wei/caocao.txt"), new Path("/sanGuo/wei/caozhi.txt"));

        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testDelete() throws IOException, InterruptedException, URISyntaxException{

        // 1 获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 执行删除
        fs.delete(new Path("/sanGuo/wu"), true);

        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testListFiles() throws IOException, InterruptedException, URISyntaxException {

        // 1获取文件系统
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 获取文件详情
        // listFiles() 方法获取指定路径下的所有文件和目录的迭代器
        /* listFiles() 方法有两个参数：
            第一个参数是 Path 对象，用于指定要遍历的路径。在这里，路径为根目录 /。
            第二个参数是一个布尔值，用于表示是否递归地遍历子目录。
            如果设置为 true，则会递归遍历子目录；如果设置为 false，则只遍历指定路径下的直接子文件和子目录。
         */
        RemoteIterator<LocatedFileStatus> listFiles = fs.listFiles(new Path("/"), true);

        while (listFiles.hasNext()) {
            LocatedFileStatus fileStatus = listFiles.next();

            System.out.println("==============" + fileStatus.getPath() + "==============");
            // fileStatus 变量是 org.apache.hadoop.fs.FileStatus 类型，表示一个文件或目录的状态
            // 返回权限信息
            System.out.print(fileStatus.getPermission() + " ");
            // 返回文件所有者
            System.out.print(fileStatus.getOwner() + " ");
            // 返回文件所属的用户组
            System.out.print(fileStatus.getGroup() + " ");
            // 返回文件长度（单位为字节）
            System.out.print(fileStatus.getLen() + " ");
            // 返回文件的最近修改时间（以 Unix 时间戳表示）--> 修改时间到现在的毫秒数
            System.out.print(fileStatus.getModificationTime() + " ");
            // 将时间戳转换为标准Date输出
            /*long timeStamp = fileStatus.getModificationTime();
            Date date = new Date(timeStamp);
            System.out.println(date);*/

            // 返回文件的副本数
            System.out.print(fileStatus.getReplication() + " ");
            // 返回文件的块大小（单位为字节）
            System.out.print(fileStatus.getBlockSize() + " ");
//            System.out.print(fileStatus.getBlockSize()/1024/1024 + "Mb ");
            // 获得该文件的名称
            System.out.println(fileStatus.getPath().getName());

            // 获取块信息
            // getBlockLocations() 方法通过网络请求获取该文件所在的块信息，并将其作为 org.apache.hadoop.fs.BlockLocation 数组返回
            // 该数组中的每个元素都代表一个文件块（block），包含了块所在的主机名、起始偏移量和长度等信息
            BlockLocation[] blockLocations = fileStatus.getBlockLocations();
            System.out.println(Arrays.toString(blockLocations));
            System.out.println();
        }
        // 3 关闭资源
        fs.close();
    }

    @Test
    public void testListStatus() throws IOException, InterruptedException, URISyntaxException{

        // 1 获取文件配置信息
        Configuration configuration = new Configuration();
        FileSystem fs = FileSystem.get(new URI("hdfs://hadoop100:9000"), configuration, "rocky");

        // 2 判断是文件还是文件夹
        FileStatus[] listStatus = fs.listStatus(new Path("/"));

        for (FileStatus fileStatus : listStatus) {

            // 如果是文件
            if (fileStatus.isFile()) {
                System.out.println("file:"+fileStatus.getPath().getName());
            }else {
                System.out.println("dir:"+fileStatus.getPath().getName());
            }
        }

        // 3 关闭资源
        fs.close();
    }
}
