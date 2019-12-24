package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class 最接近的三数之和 {
    @Test
    public void run() {
        int[] nums = {1,1,1,1};
        System.out.println(threeSumClosest(nums,0));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            return nums[0];
        }
        int difference = Integer.MAX_VALUE;
        int result = target;
        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            for (int left = i + 1, right = nums.length - 1; left < right; ) {
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    left++;
                    continue;
                }
                if (right < nums.length - 1 && nums[right] == nums[right + 1]) {
                    right--;
                    continue;
                }
                int sum = nums[i] + nums[left] + nums[right];
                if (sum - target > 0) {
                    if (difference >sum - target) {
                        difference = sum-target;
                        result = sum;
                    }
                    right--;
                } else if (sum - target < 0) {
                    if (difference > target-sum) {
                        difference = target-sum;
                        result = sum;
                    }
                    left++;
                } else {
                    return target;
                }
            }
        }
        return result;
    }
}