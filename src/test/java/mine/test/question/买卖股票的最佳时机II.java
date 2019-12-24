package mine.test.question;

import org.junit.Test;

public class 买卖股票的最佳时机II {
	@Test
	public void result() {
		int arr[] = { 7, 1, 5, 3, 6, 4 };
		System.out.println(maxProfit(arr));
	}

	public int maxProfit(int[] prices) {
		if (prices.length == 0)
			return 0;
		int minprice = prices[0];
		int max = 0;
		int sum=0;
		for (int i = 0; i < prices.length; i++) {
			int temp = max;
			max = Math.max(max, prices[i] - minprice);
			minprice = Math.min(minprice, prices[i]);
			if(max!=temp) {
				sum = sum +max;
				max=0;
				minprice = prices[i];
			}
		}
		return sum;
	}
}