package mine.test.question.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caijinnan
 * @date 2019/12/11 14:28
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * <p>
 * 示例:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: 2
 * 解释: 跳到最后一个位置的最小跳跃数是 2。
 *      从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
 */
public class 跳跃游戏II {


    @Test
    public void run() {
        int[] arr = new int[2502];
        for(int i = 2500;i>=0;i--){
            arr[2500-i] = i;
        }
        arr[2500]=1;
        arr[2501]=0;
        long start = System.currentTimeMillis();
        System.out.println(jump(arr));
        System.err.println(System.currentTimeMillis()-start);
    }


    public int jump(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return 0;
        }
        int total = 0;
        int index = 0;
        int endIndex = nums.length-1;
        while(endIndex>0) {
            int target = endIndex;
            for (int i = endIndex-1; i >= 0; i--) {
                int distance = target - i;
                if (nums[i] >= distance && distance > index) {
                    index = distance;
                    endIndex = i;
                }
            }
            total++;
            index = 0;
        }
        return total;

    }

}
