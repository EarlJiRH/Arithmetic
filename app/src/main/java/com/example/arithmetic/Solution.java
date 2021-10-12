package com.example.arithmetic;


/**
 * ================================================
 * 类名：com.example.arithmetic
 * 时间：2021/10/11 10:54
 * 描述：leetcode
 * 修改人：
 * 修改时间：
 * 修改备注：
 * ================================================
 *
 * @author Admin
 */
public class Solution {

    public static void main(String[] args) {
        //================Array操作 start======================

        //nums1 nums2数组从小到大顺序排序
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        //[1, 2, 3, 5, 6, 10]
        Array.merge(nums1, 3, nums2, 3);
        //[1, 2, 3, 5, 10, 0]
//        Arithmetic.merge(nums1, 3, nums2, 2);

        int[] nums = {1, 2, 2, 3, 5, 5, 10};
        Array.removeDuplicates(nums);


        int[] nums3={0,1,0,3,12};
        Array.moveZeroes(nums3);

        //================Array操作 end======================
    }


}
