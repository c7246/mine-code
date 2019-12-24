package mine.test.question;

import org.junit.Test;

public class 使用最小花费爬楼梯 {
	@Test
	public void result() {
//		int arr[] = {0,0,1,1};
		int arr[] = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//		int arr[] = {10, 15, 20};
		System.out.println(minCostClimbingStairs(arr));
	}

	public int minCostClimbingStairs(int[] cost) {
		if(cost.length==1)return cost[0];
		if(cost.length==0)return 0;
		int minsum[] = new int[cost.length];
		minsum[0]=cost[0];
		minsum[1]=cost[1];
		for(int i = 2;i<cost.length;i++) {
			minsum[i] = Math.min(minsum[i-2]+cost[i],minsum[i-1]+cost[i]);
		}
		return Math.min(minsum[minsum.length-1], minsum[minsum.length-2]); 
	}
}