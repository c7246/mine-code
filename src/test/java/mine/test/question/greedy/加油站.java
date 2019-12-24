package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/19 16:09
 * 在一条环路上有 N 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 如果你可以绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1。
 */
public class 加油站 {


    @Test
    public void run() {
        int[] gas = {1, 2, 3, 2, 7, 5};
        int[] cost = {3, 1, 7, 3, 1, 2};
        //            -2,-2,-2,3,3
        System.out.println(canCompleteCircuit(gas, cost));

    }


    public int canCompleteCircuit(int[] gas, int[] cost) {
        int costSum = 0;
        int getSum = 0;
        int index = 0;
        for (int i = 0; i < gas.length; i++) {
            int num = gas[i] - cost[i];
            if (index == 0 && num > 0) {
                index = i;
            }
            getSum += num;
            costSum += num;
            if (getSum <= 0) {
                index = 0;
                getSum = 0;
            }
        }
        if (costSum < 0) {
            return -1;
        }
        return index;
    }
}
