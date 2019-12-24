package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 四数之和 {
    @Test
    public void run() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        //-2 -1 0 0 1 2
        List<List<Integer>> temp = fourSum(nums, 0);
        for (List<Integer> listTemp : temp) {
            System.out.println(listTemp);
        }
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> resultList = new ArrayList<>();
        Arrays.sort(nums);
        if (nums.length < 1) {
            return resultList;
        }
        int sum = 0;
        for (int a = 0; a < nums.length - 3; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) {
                continue;
            }
            for (int b = a + 1; b < nums.length - 2; b++) {
                if (b > a + 1 && nums[b] == nums[b - 1]) {
                    continue;
                }
                for (int c = b+1, d = nums.length - 1; c < d; ) {
                    if (c > b+1 && nums[c] == nums[c - 1]) {
                        c++;
                        continue;
                    }
                    if (d < nums.length - 1 && nums[d] == nums[d + 1]) {
                        d--;
                        continue;
                    }
                    sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if (sum > target) {
                        d--;
                    } else if (sum < target) {
                        c++;
                    } else {
                        List<Integer> tempList = new ArrayList<>(3);
                        tempList.add(nums[a]);
                        tempList.add(nums[b]);
                        tempList.add(nums[c]);
                        tempList.add(nums[d]);
                        resultList.add(tempList);
                        c++;
                        d = nums.length - 1;
                    }
                }
            }
        }
        return resultList;
    }
}