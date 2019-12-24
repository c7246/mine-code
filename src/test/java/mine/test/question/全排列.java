package mine.test.question;

import org.junit.Test;

import java.util.*;

/**
 * @author caijinnan
 * @date 2019/12/11 15:42
 */
public class 全排列 {
    @Test
    public void run() {
        int[] arr = {1, 2, 3,4};
        System.out.println(permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        return getList(nums, set);
    }

    private List<List<Integer>> getList(int[] nums, Set<Integer> set) {
        List<List<Integer>> result = new ArrayList<>();
        if (set.size() == nums.length) {
            List<Integer> temp = new ArrayList<>();
            result.add(temp);
            return result;
        }
        for (int i = 0; i < nums.length; i++) {
            HashSet<Integer> tempSet = new HashSet<>();
            tempSet.addAll(set);
            if (tempSet.contains(i)) {
                continue;
            }
            tempSet.add(i);

            List<List<Integer>> tempResult = getList(nums, tempSet);
            for (List<Integer> tempList : tempResult) {
                tempList.add(nums[i]);
            }
            result.addAll(tempResult);
        }


        return result;
    }
}