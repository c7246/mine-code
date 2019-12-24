package mine.test.question;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/20 10:21
 * 数轴上放置了一些筹码，每个筹码的位置存在数组 chips 当中。
 * <p>
 * 你可以对 任何筹码 执行下面两种操作之一（不限操作次数，0 次也可以）：
 * <p>
 * 将第 i 个筹码向左或者右移动 2 个单位，代价为 0。
 * 将第 i 个筹码向左或者右移动 1 个单位，代价为 1。
 * 最开始的时候，同一位置上也可能放着两个或者更多的筹码。
 * <p>
 * 返回将所有筹码移动到同一位置（任意位置）上所需要的最小代价。
 */
public class 玩筹码 {

    @Test
    public void run() {
        int[] arr = {1,2,3,4,5};
        System.out.println(minCostToMoveChips(arr));
    }


    public int minCostToMoveChips(int[] chips) {
        int oddSum = 0;
        int evenSum = 0;
        for(int i=0;i<chips.length;i++){
            int num = chips[i];
            if(num%2==0){
                evenSum++;
            }else{
                oddSum++;
            }
        }
        return Math.min(oddSum,evenSum);
    }
}
