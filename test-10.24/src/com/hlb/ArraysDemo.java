package com.hlb;

import java.util.Arrays;

/**
 * @author: code_hlb
 * @date :  2023/10/24 12:40
 * @desc :  Arrays 常用方法
 */
public class ArraysDemo {

    public static void main(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        int nums1[] = Arrays.copyOf(nums,10);

        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n==========Arrays.sort(nums)==========");
        // 默认为递增排序
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));

        System.out.println("\n==========Arrays.sort(nums1,from,to)==========");
        // 只排序某部分的数据
        Arrays.sort(nums1,0,4);
        System.out.println(Arrays.toString(nums1));

    }

    public static void main6(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        int nums1[] = Arrays.copyOf(nums,10);

        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n==========Arrays.setAll(nums1,func)==========");
        // 接收一个函数，从数组下标0开始，分别将i传递到i中，并将返回值重新赋给nums1[i]
        // 比fill(nums,data) 更加灵活，但是如果data固定，fill的效率更高

        /*    public static void setAll(int[] array, IntUnaryOperator generator) {
                Objects.requireNonNull(generator);
                for (int i = 0; i < array.length; i++)
                array[i] = generator.applyAsInt(i);
        }*/
        // 输出： [0, 3, 6, 9, 12, 15, 18, 21, 24, 27]
//        Arrays.setAll(nums1,i -> i * 3);
//        System.out.println(Arrays.toString(nums1));
        // 输出： [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
        Arrays.setAll(nums1,i -> i);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main5(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        int nums1[] = Arrays.copyOf(nums,10);

        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n==========Arrays.fill(nums1,0)==========");
        // 填充，指定一个数组，将开始下标(0开始)到结束下标(nums.length)的数据填充为0
        Arrays.fill(nums,0);
        System.out.println(Arrays.toString(nums));

        System.out.println("\n==========Arrays.fill(nums1,fromIndex,toIndex,data)==========");
        // 填充，指定一个数组，将开始下标(0开始)到结束下标的数据填充为data，还是左闭右开的规则
        Arrays.fill(nums1,6,9,-1);
        System.out.println(Arrays.toString(nums1));
    }

    public static void main4(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        int nums1[] = Arrays.copyOf(nums,10);

        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        System.out.println("\n==========nums.length==========");
        // 思考：length 和 length() 有什么去区别？
        // 1、length 表示属性，length() 表示方法
        // 2、length 是数组的一个属性值，用于求数组长度
        // 3、length() 是String类对象的一个成员方法，用于求String实体内容的长度
        System.out.println(nums.length);

        System.out.println("\n==========Arrays.equals(nums,nums1)==========");
        // 比较原理：
        // 1、首先比较num == nums1,看两个数组的引用是不是都指向同一个地址
        // 2、再比较两个数组的长度  -->  返回false
        // 3、最后比较两个数组中相同位置处的元素是否相同
        System.out.println(Arrays.equals(nums,nums1));
    }

    public static void main3(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }

        // 通过Arrays.copyOf实现数组的拷贝并扩容
        System.out.println("\n==========Arrays.copyOf(nums,newLength)==========");
        // 数组初次定义就已经定长，因此此处会报ArrayIndexOutOfBoundsException
        // nums[nums.length] = 2;
        // 那如果我们需要将数组扩容应该如何进行呢？
        int nums1[] = Arrays.copyOf(nums,10);
        System.out.println(Arrays.toString(nums1));

        // 通过Arrays.copyOfRange实现数组的部分拷贝
        System.out.println("\n==========Arrays.copyOfRange(nums,from,to)==========");
        // 左闭右开
        int nums2[] = Arrays.copyOfRange(nums,0,3);
        System.out.println(Arrays.toString(nums2));
    }

    public static void main2(String[] args) {
        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        // 通过Arrays.toString(nums) 方法进行打印
        System.out.println("\n==========Arrays.toString(nums)==========");
        System.out.println(Arrays.toString(nums));
    }

    public static void main1(String[] args) {

        // 定义一个数组nums
        int[] nums = {1,3,2,5,4,7};
        int nums1[] = Arrays.copyOf(nums,10);

        System.out.println("==========oldData==========");
        // 数组是一个引用，指向的是一个堆地址，因此直接打印nums是一个地址
        // System.out.println(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }
}
