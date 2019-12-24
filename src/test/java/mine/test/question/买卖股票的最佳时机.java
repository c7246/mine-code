package mine.test.question;

import org.junit.Test;

public class 买卖股票的最佳时机 {
	@Test
	public void result() {
//		int arr[] = {7,1,5,3,6,4};
		int arr[] = {7,1,5,3,6,4};
		System.out.println(maxProfit(arr));
	}

	public int maxProfit(int[] prices) {
		if(prices.length==0)return 0;
		int minprice = prices[0];
		int max=0;
//		int minprice = Math.min(prices[0], prices[1]);
//		int sum=prices[1]-prices[0];
		for(int i=0;i<prices.length;i++) {
			max=Math.max(max, prices[i]-minprice);
			minprice=Math.min(minprice, prices[i]);
		}
		return max;
	}
}