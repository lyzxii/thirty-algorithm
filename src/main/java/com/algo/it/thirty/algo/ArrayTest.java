package com.algo.it.thirty.algo;

import edu.princeton.cs.algs4.In;

import java.util.*;

/**
 * @author ：yanpeidong371
 * @description：
 * @date : 2022年11月11日
 * @since: 1.0.0
 */
public class ArrayTest {


    public static int arrayMin(int[] arr, int target) {
        int min = Integer.MAX_VALUE;
        if (arr[0] > target) {
            return 1;
        }
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                temp = temp + arr[j];
                if (temp >= target) {
                    min = Math.min(min, j);
                    break;
                }
            }

        }
        return min;
    }

    /**
     * ## 两数之和 ##
     * 给定一个整数数组 nums 和一个整数目标值 target,
     * 请你在该数组中找出和为目标值 target的那两个整数,并返回它们的数组下标。
     * 输入：nums = [2,7,11,15], target = 9
     * 输出：[0,1]
     * 解释：因为 nums[0] + nums[1] == 9 ,返回 [0, 1]
     */
    public int[] twoSum(int[] nums, int target) {

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }

        }
        return null;
    }

    public int[] twoSumInHashMap(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                return new int[]{hashMap.get(nums[i]), i};
            }
            hashMap.put(target - nums[i], i);
        }
        return null;
    }

    /**
     * 最大子数组
     */
    public int maxSubArray(int[] arr) {
        int[] result = new int[arr.length];
        result[0] = arr[0];
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            result[i] = Math.max(result[i - 1] + arr[i], arr[i]);
            temp = Math.max(temp, result[i]);
        }
        System.out.println(Arrays.toString(result));
        return temp;
    }

    /**
     * 最大子数组优化版
     */
    public int maxSubArray02(int[] arr) {
        int temp = arr[0];
        int result = arr[0];
        for (int i = 1; i < arr.length; i++) {
            temp = Math.max(temp + arr[i], arr[i]);
            result = Math.max(result, temp);
        }
        return result;
    }

    /**
     * 爬楼梯,每次可以趴1层或者2层,有多少种趴法
     * f(n) = f(n-1) +f(n-2)
     *
     * @param n
     * @return
     */
    public int climb(int n) {
        if (n == 0 | n == 1) {
            return 1;
        }
        int pre = 1;
        int now = 1;
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = pre + now;
            pre = now;
            now = result;
        }
        return result;
    }

    /**
     * 找出数组中唯一一个出现一次的元素
     *
     * @param arr
     * @return
     */
    public int findOnlyOne(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.put(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }
        for (Integer key : map.keySet()) {
            if (map.get(key) == 1) {
                return key;
            }
        }
        return 0;
    }

    /**
     * 在长度为n的nums数组中,所有数字都是在0-n-1范围内,找出重复的数字,任意返回一个重复的即可
     *
     * @param arr
     * @return
     */
    public static int findRepeatNumber(int[] arr) {
        HashSet<Integer> set = new HashSet<>(arr.length);
        for (int i = 0; i < arr.length; i++) {
            if (set.contains(arr[i])) {
                return arr[i];
            }
            set.add(arr[i]);
        }
        return -1;
    }

    public static int findRepeatNumber02(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[arr[i]]++;
            if (result[arr[i]] == 2) {
                return arr[i];
            }
        }
        return -1;
    }

    /**
     * 统计有序数组中某个值出现的次数,比如数组1,2,3,6,6,7,9taget=6,返回2
     *
     * @return
     */
    public static int numCount(int[] arr, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        return hashMap.get(target);
    }

    /**
     * 用二分查找,数组1,2,3,6,6,7,9；返回taget和taget+1的下标的差
     */
    public static int numCount02(int[] arr, int target) {
        int i = binSearch(arr, target);
        int j = binSearch(arr, target + 1);
        return j - i;
    }

    public static int binSearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (target == arr[mid]) {
                //return mid;
                right = right - 1;
            } else if (arr[mid] > target) {
                right = mid - 1;
            } else {
                left = left + 1;
            }
        }
        return right;

    }


    /**
     * 找出数组中0-n-1的数组中不存在的元素,比如数组[0,1,2,3,4,6],返回5
     * 用二分查找也可以
     */
    public static int arrShort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] + 1 != arr[i + 1]) {
                return arr[i] + 1;
            }
        }
        return -1;
    }

    /**
     * 用二分查找也可以
     */
    public static int arrShort02(int[] arr) {
        return shortSearch(arr);
    }

    private static int shortSearch(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == mid) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


    /**
     * 有序递增数组旋转,比如1,2,3,4,5,旋转后4,5,1,2,3,找出最小值
     * 采用二分查找法
     * 4,5,1,2,3, mid > right,则 left = mid +1
     * 5,1,2,3,4, mid < right,则 right = mid-1
     */
    public static int findTransferArr(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else if (arr[mid] < arr[right]) {
                right = mid;//arr[mid]可能是最小的
            } else {
                right--;
            }
        }
        return arr[left];
    }

    /**
     * N个正整数的数组,和正整数target,找出连续的子数组且和大于等于target,返回子数组的长度
     * 如数组2,3,1,2,4,3;target=7,则返回2
     * <p>
     * 使用滑动窗口
     */
    public static int findMinSubArr(int[] arr, int target) {
        int left = 0, right = -1;
        int sum = 0;
        int res = arr.length + 1;
        while (left < arr.length) {
            if (right + 1 < arr.length && sum < target) {
                right++;
                sum = sum + arr[right];
            } else {
                left++;
                sum = sum - arr[left];
            }
            if (sum > target) {
                res = Math.min(res, right - left + 1);
            }
        }
        if (res == arr.length + 1) {
            return 0;
        }
        return res;
    }

    /**
     * 滑动窗口
     * 返回一个字符串中，不含重复元素的最大字串的长度
     */
    public static int findMaxNotRepeat(String str){
        String[] strArr = str.split("");
        int left=0;
        int res=0;
        Map<String,Integer> map = new HashMap<>();
        for (int i =0;i <strArr.length;i++){
            if(map.containsKey(strArr[i]) && map.get(strArr[i]) >= left){
                left = map.get(strArr[i]) + i;
            }
            res =Math.max(res, i-left +1);
            map.put(strArr[i],i);
        }
        return res;

    }

    /**
     * 将数组中的所有0元素移到数组尾部
     * 思路：定义前面的都是不为0，后面的都是0，如果不为0，则移到前端，k表示不为0的数组，i遍历数组
     *
     * @param arr
     * @return
     */
    public static int[] moveZero(int[] arr) {
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != k) {
                    int temp = arr[i];
                    arr[i] = arr[k];
                    arr[k] = temp;
                }
                k++;
            }
        }
        return arr;
    }


    /**
     * 删除数组中target的元素,返回数组的长度，且不适用额外的空间
     */
    public static int deleteTarget(int[] arr, int target) {
        int len = arr.length;
        for (int i = 0; i < len;) {
            if (arr[i] == target) {
                arr[i] = arr[len - 1];
                len--;
            }else{
                i++;
            }
        }
        return len;
    }

    /**
     * 有序数组去重，返回去重后的数组的长度，使用双指针
     */
    public static int deleteRepeat(int[] arr) {
        int left=0;
        for(int right=1; right < arr.length;){
            if(arr[left] != arr[right]){
                left++;
                arr[left] =arr[right];
            }
            right++;
        }
        return left +1;
    }


    /**
     * 有序数组去重，同一个值最多保留1个重复元素，返回去重后的数组的长度
     */
    public static int keepTwoMore(int[] arr) {
        int left =2;
        for(int right=2; right < arr.length;){
            if(arr[left-2] != arr[right]){
                arr[left] =arr[right];
                left++;
            }
            right++;
        }
        return left;
    }

    /**
     * 合并2个数组，其中m表示数组中nums有效元素个数（num数组的尾部是n个0），n表示arr数组长度

     */
    public static int[] mergeArray(int[] nums,int m, int[] arr, int n) {
        int i = m -1;
        int j = n -1;
        int p = m+n-1;
        while(i >= 0 || j>= 0){
            if(i<0){
                nums[p] = arr[j];
                p--;
                j--;
            }else if(j<0){
                nums[p] = nums[i];
                p--;
                i--;
            }else if(nums[i] < arr[j]){
                nums[p] = arr[j];
                p--;
                j--;
            }else{
                nums[p] = nums[i];
                p--;
                i--;
            }
        }
        return nums;
    }

    /**
     * 返回数组第k大的元素
     */
    public static int noMax(int[] nums,int k) {
        return 0;
    }

    /**
     * 对撞指针
     * 有序数组，查找二数之和等于target的数组的下标
     */
    public static int[] twoSumI(int[] nums, int target){
        int left=0;
        int right =nums.length;

        while(left<right){
            if(nums[left] + nums[right] ==target){
                return new int[]{left, right};
            }else if(nums[left] + nums[right] <target){
                left++;
            }else{
                right--;
            }
        }
        return null;
    }

    /**
     * 字符串反转，指针碰撞
     */
    public static String transferStr(String str){
        int left =0;
        int right=str.length() -1;
        char[] chars = str.toCharArray();
        while(left < right){
           char temp = chars[left];
           chars[left] = chars[right];
           chars[right] =temp;
           left++;
           right--;
        }
        return Arrays.toString(chars);
    }



    public static void main(String[] args) {

        String str =null;
        System.out.println(Optional.ofNullable(str).orElse("23"));
        ArrayTest arrayTest = new ArrayTest();
        int[] ints = {2, 7, 11, 15};
        int[] result = arrayTest.twoSumInHashMap(ints, 18);
        System.out.println(Arrays.toString(result));
        int[] int2 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int i = arrayTest.maxSubArray(int2);
        System.out.println(i);
        System.out.println(arrayTest.maxSubArray02(int2));

        System.out.println(arrayTest.climb(5));

        int[] minArr = {3, 1, 2, 4, 1};
        System.out.println(arrayMin(minArr, 8));

        System.out.println("------");
        int[] repeatArr = {3, 1, 2, 4, 1, 2};
        System.out.println(findRepeatNumber(repeatArr));
        System.out.println(findRepeatNumber02(repeatArr));

        int[] targetArr = {1, 1, 2, 4, 6, 6, 6, 9};
        System.out.println(numCount(targetArr, 1));
        System.out.println(numCount02(targetArr, 1));

        int[] shortArr = {0, 1, 2, 3, 4, 5, 6, 8, 9};
        System.out.println(arrShort(shortArr));
        System.out.println(arrShort02(shortArr));


        int[] transferArr = {4, 5, 1, 2, 3};
        System.out.println(findTransferArr(transferArr));

        int[] moveArr = {0, 5, 0, 2, 0, 3};
        System.out.println(Arrays.toString(moveZero(moveArr)));


        int[] deleteRepeatArr = {0, 5, 0, 2, 0, 3};
        System.out.println(deleteTarget(deleteRepeatArr, 0));


        int[] repeat = {1, 1, 2, 2, 4, 5};
        System.out.println(deleteRepeat(repeat));

        int[] twoRepeat = {1, 1, 2, 2, 2, 3};
        System.out.println(keepTwoMore(twoRepeat));

        int[] nums = {1, 2, 3, 0, 0, 0};
        int[] arr = {2, 5, 6};
        System.out.println(Arrays.toString(ArrayTest.mergeArray(nums,3,arr,3)));
        System.out.println(transferStr("caonima"));


        System.out.println(findMaxNotRepeat("abcabcdbb"));

    }

}
