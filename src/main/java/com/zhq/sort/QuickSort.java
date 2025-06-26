package com.zhq.sort;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {5, 1, 6, 2, 4, 3};
        quickSort(nums, 0, 5);
        System.out.println(Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int pivot = partition(nums, left, right);
        quickSort(nums, left, pivot - 1);
        quickSort(nums, pivot + 1, right);
    }

    public static int partition(int[] nums, int left, int right) {
        int base = nums[left];
        int i = left;
        int j = right;
        while (i < j) {
            // 从右往左找一个小于基准数的
            while (i < j && nums[j] >= base) {
                j--;
            }
            // 从左往右找一个大于基准数的
            while (i < j && nums[i] <= base) {
                i++;
            }
            // 交换一下
            swap(nums, i, j);
        }
        // 把基准数跟i换一下
        swap(nums, i, left);
        return i;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
