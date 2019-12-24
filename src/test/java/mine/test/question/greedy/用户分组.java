package mine.test.question.greedy;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caijinnan
 * @date 2019/12/20 19:40
 * 有 n 位用户参加活动，他们的 ID 从 0 到 n - 1，
 * 每位用户都 恰好 属于某一用户组。
 * 给你一个长度为 n 的数组 groupSizes，其中包含每位用户所处的用户组的大小，
 * 请你返回用户分组情况（存在的用户组以及每个组中用户的 ID）。
 * <p>
 * 你可以任何顺序返回解决方案，ID 的顺序也不受限制。此外，题目给出的数据保证至少存在一种解决方案。
 */
public class 用户分组 {

    @Test
    public void run() {
        int[] groupSizes = {1};
        for(List<Integer> list : groupThePeople(groupSizes)){
            System.out.println(list);
        }
    }

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList[] arr = new ArrayList[groupSizes.length];
        for (int i = 0; i < groupSizes.length; i++) {
            int range = groupSizes[i];
            ArrayList<Integer> list = arr[range-1];
            if (list == null) {
                list = new ArrayList<>();
                list.add(i);
                arr[range-1] = list;
            } else {
                list.add(i);
            }
            if(list.size()==range){
                result.add(list);
                arr[range-1]=null;
            }
        }
        return result;
    }
}