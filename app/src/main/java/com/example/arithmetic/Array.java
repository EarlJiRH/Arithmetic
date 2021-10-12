package com.example.arithmetic;

import java.util.Arrays;

/**
 * ================================================
 * 类名：com.example.arithmetic
 * 时间：2021/10/11 13:13
 * 描述：数组操作的算法示例
 * 修改人：
 * 修改时间：
 * 修改备注：
 * ================================================
 *
 * @author Admin
 */
public class Array {


    /**
     * @author Admin
     * @date 2021/10/11 13:09
     * https://leetcode-cn.com/problems/merge-sorted-array/
     * 88.合并两个有序数组  归并排序
     * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，
     * 分别表示 nums1 和 nums2 中的元素数目。
     * <p>
     * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
     * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。
     * <p>
     * 为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。
     * nums2 的长度为 n 。
     * O(n)
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        //主体思路:i、j两个索引,谁值小放谁
        //细节:边界问题(i、j可能出界)
        //nums1[i] nums2[j] 先比较大小
        int i = m - 1, j = n - 1;

        //k 最终数组nums1的下标 最大->0 倒序赋值 避免开新数组的内存开销
        for (int k = m + n - 1; k >= 0; k--) {
            //边界问题
            //a. j<0 nums2数组内的元素已经全部复制到nums1数组内 仅需对nums1数组再进行排序即可
            //b. i>=0 (i、j的边界即为0) i==0 表示 nums1数组已经完成排序 此时k=0 可以跳出循环体了
            //i、j 二者之一<0 即表示其已经处理完 两者均<0 表示已经处理完成
            //主体思路
            //将数组nums2的前n个值与数组nums1前m个值进行正序排序 判断两个数组进行排序的最大值
            if (j < 0 || (i >= 0 && nums1[i] >= nums2[j])) {
                nums1[k] = nums1[i];
                i--;
            } else {
                //i < 0 || (j >= 0 && nums1[i] < nums2[j])
                nums1[k] = nums2[j];
                j--;
            }

//            if (i < 0 || (j >= 0 && nums1[i] < nums2[j])) {
//                nums1[k] = nums2[j];
//                j--;
//            } else {
//                nums1[k] = nums1[i];
//                i--;
//            }
        }
        System.out.println("数组1: " + Arrays.toString(nums1));
    }


    /**
     * @author Admin
     * @date 2021/10/11 13:15
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     * 26. 删除有序数组中的重复项 数组去重
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * O(n)
     */
    public static Integer removeDuplicates(int[] nums) {
        int length = 0;
        //从后面往前覆盖 不需要考虑数组中超出新长度后面的元素
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                nums[length] = nums[i];
                length++;
            }
        }
        System.out.println("数组: " + Arrays.toString(nums));
        System.out.println("数组长度: " + length);
        return length;
    }

    /**
     * @author Admin
     * @date 2021/10/11 13:29
     * https://leetcode-cn.com/problems/move-zeroes/
     * 283. 移动零
     * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * O(n)
     */

    public static void moveZeroes(int[] nums) {
        int n = 0;
        //从后往前覆盖
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[n] = nums[i];
                n++;
            }
        }
        //nums[n] 后面的数据全部赋值为0
        while (n < nums.length) {
            nums[n] = 0;
            n++;
        }
        System.out.println("数组操作后结果: " + Arrays.toString(nums));
    }

}
