package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author caijinnan
 * @date 2019/12/11 15:42
 */
public class 全排列II {
    @Test
    public void run() {
        int[] arr = {1, 2, 2};
        System.out.println(permute(arr));
    }

    public List<List<Integer>> permute(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashSet<List<Integer>> listSet = getSet(nums, set);
        List<List<Integer>> list = new ArrayList<>();
        for (List<Integer> temp : listSet) {
            list.add(temp);
        }
        return list;
    }

    private HashSet<List<Integer>> getSet(int[] nums, Set<Integer> set) {
        HashSet<List<Integer>> result = new HashSet<>();
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

            HashSet<List<Integer>> tempResult = getSet(nums, tempSet);
            for (List<Integer> tempList : tempResult) {
                tempList.add(nums[i]);
            }
            result.addAll(tempResult);
        }


        return result;
    }
}