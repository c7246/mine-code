package mine.test.question;

import org.junit.Test;

import java.util.Arrays;

public class 在排序数组中查找元素的第一个和最后一个位置 {

    @Test
    public void run() {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(searchRange(nums, 8)));
    }

    public int[] searchRange(int[] nums, int target) {
        int[] arr = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1) {
                if (nums[i] == target && nums[i - 1] != target) {
                    arr[0] = i;
                    arr[1] = i;
                }
                if (nums[i] > target && nums[i - 1] == target) {
                    arr[1] = i-1;
                }
                if(i==nums.length-1&&nums[i]==target){
                    arr[1] = i;
                }
            } else {
                if (nums[i] == target) {
                    arr[0] = i;
                    arr[1] = i;
                }
            }
        }
        return arr;
    }
}