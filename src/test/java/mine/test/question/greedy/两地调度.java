package mine.test.question.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caijinnan
 * @date 2019/12/18 19:40
 * 公司计划面试 2N 人。第 i 人飞往 A 市的费用为 costs[i][0]，飞往 B 市的费用为 costs[i][1]。
 * 返回将每个人都飞到某座城市的最低费用，要求每个城市都有 N 人抵达。
 * <p>
 * 输入：[[10,20],[30,200],[400,50],[30,20]]
 * 470 290
 * 输出：110
 * 解释：
 * 第一个人去 A 市，费用为 10。
 * 第二个人去 A 市，费用为 30。
 * 第三个人去 B 市，费用为 50。
 * 第四个人去 B 市，费用为 20。
 * <p>
 * <p>
 * <p>
 * 输入：[[10,20],[30,200],[400,50],[20,30]]
 */
public class 两地调度 {

    @Test
    public void run() {
        //a = 11 b=8
        int[][] arr = new int[][]{
                {9, 10},
                {20, 1},
                {9, 1},
                {9, 1}
        };
        System.out.println(twoCitySchedCost(arr));
    }


    public int twoCitySchedCost(int[][] costs) {
        int bSum = 0;
        int[] subArr = new int[costs.length];
        for (int i = 0; i < costs.length; i++) {
            int[] arr = costs[i];
            subArr[i] = arr[0] - arr[1];
            bSum+=arr[1];
        }
        Arrays.sort(subArr);
        for(int i=0;i<subArr.length/2;i++){
            bSum+=subArr[i];
        }
        return bSum;
    }
}