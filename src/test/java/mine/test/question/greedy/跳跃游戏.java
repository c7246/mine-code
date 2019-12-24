package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/19 10:17
 * <p>
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * <p>
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * <p>
 * 判断你是否能够到达最后一个位置。
 */
public class 跳跃游戏 {

    @Test
    public void run() {
        int[] num = {1, 1, 1, 1, 1, 1, 1, 1, 0};
        System.out.println(canJump(num));
    }

    public boolean canJump(int[] nums) {
        int distance = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < distance) {
                distance++;
            } else {
                distance = 1;
            }
        }
        return distance == 1;
    }
}
