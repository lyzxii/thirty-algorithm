package com.algo.it.thirty.sort;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月15日
 * @since: 1.0.0
 */
public class SortAlgo {

    public static void main(String[] args) {

        int[] arr = {15,2, 19, 11, 6,30,90};
        quickSort2(arr,0,arr.length -1);
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 冒泡排序:
     * 相邻的2个元素相互依次比较，大的往后放，经过一次循环就会拿到最大的，多次循环实现排序
     *
     * @param arr
     */
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) { //执行arr.length-1次循环
            for (int j = 0; j < arr.length - 1 - i; j++) { //每次循环去比较并替换，每循环一次确定最大的值
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 选择排序:
     * 从0索引开始，依次同后面的元素比较，小的往前放，一次循环后拿到最小的，多次循环实现排序
     *
     * @param arr
     */
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { //执行arr.length-1次循环
            for (int j = i + 1; j < arr.length; j++) { //0索引同1，2，3，4比较，1索引同2，3，4比较，依次类推
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    /**
     * 插入排序（InsertSort）：
     * 将数组的第一个数认为是有序数组，从前往后（从后往前）扫描该有序数组，
     * 把数组中其余n-1个数，根据数值的大小，插入到有序数组中，直至数组中
     * 的所有数有序排列为止。这样的话，n个元素需要进行n-1趟排序
     *
     * @param arr
     */
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }

    /**
     * 选择一个支点将数据分成2部分，可以任意选择，一般选择中间那个数据；左部分是9，5，2，右部分是2，7，6
     * 最左边的start指针，往右移动，每次移动前比较当前位置的元素与支点元素大小，如果大于支点，则这个元素就是要被替换到支点右边，如果不大于则继续右移，直到找到大于支点的元素
     * 最右边的end指针，往左移动，每次移动前比较当前位置的元素同支点元素的大小，如果小于支点元素，则这个元素就要被替换到支点左边，如果不小于，则继续左移，直到找到大于支点的元素
     * 左右2个指针找到替换的元素，执行替换，替换完继续移动，直到2个指针重合，第一次循环完成，在递归对左右2分布分别执行此操作
     * ————————————————
     * 版权声明：本文为CSDN博主「Lyzxii」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
     * 原文链接：https://blog.csdn.net/weixin_37598682/article/details/104953902
     * @param arr
     */
    public static void quickSort(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int pivot = arr[(i + j) /2]; //支点是数组中的一个值
        System.out.println(pivot);
        while(i <= j){ //i和j这2个指针只要没重叠（交换左右位置），就执行循环
            while(arr[i] < pivot){ //一直右移找到大于支点值得索引i
                i++;
            }
            while(arr[j] > pivot){//一直坐移找到小于支点值得索引j
                j--;
            }
            if(i<=j){ //找到上面说的2个索引，就替换他们的位置，这里判断i<=j才操作
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
                i++; //交换完后继续移动
                j--; //交换完后继续移动，在判断
            }
        }
        System.out.println(Arrays.toString(arr));
        //执行到这里，第一次循环完成，可以保证支点索引位置的左边的所有元素比支点索引右面的元素小
        if(start < j){
            quickSort(arr,start,j);
        }
        if(end > i){
            quickSort(arr,i,end);
        }

    }


    public static void quickSort2(int[] arr,int start,int end){
        int i = start;
        int j = end;
        int pivot = arr[0]; //支点是数组中的一个值
        while(i < j){ //i和j这2个指针只要没重叠（交换左右位置），就执行循环

            while(i < j && arr[j] >= pivot){//一直坐移找到小于支点值得索引j
                j--;
            }

            while(i < j && arr[i] <= pivot){ //一直右移找到大于支点值得索引i
                i++;
            }
            if(i<j){ //找到上面说的2个索引，就替换他们的位置，这里判断i<=j才操作
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] =temp;
            }
        }

        arr[0] =arr[i];
        arr[i] =pivot;
        //执行到这里，第一次循环完成，可以保证支点索引位置的左边的所有元素比支点索引右面的元素小
        quickSort2(arr,start,j-1);
        quickSort2(arr,i+1,end);

    }


}
