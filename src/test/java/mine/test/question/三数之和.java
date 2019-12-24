package mine.test.question;

import org.junit.Test;

import java.util.*;

public class 三数之和 {
    @Test
    public void run() {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> temp = threeSum(nums);
        for (List<Integer> listTemp : temp) {
            System.out.println(listTemp);
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 1) {
            return resultList;
        }
        for (int i = 0; nums[i] <= 0 && i < nums.length - 2; i++) {
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
                if (sum > 0) {
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    List<Integer> tempList = new ArrayList<>(3);
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    resultList.add(tempList);
                    left++;
                    right = nums.length - 1;
                }
            }
        }
        return resultList;
    }
}