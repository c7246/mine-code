package mine.test.question;

import org.junit.Test;

public class 爬楼梯 {
	@Test
	public void result() {
		System.out.println(climbStairs(4));
	}
	//1:1
	//2:1-1,2
	//3:1-1-1,2-1,1-2
	//4:1-1-1-1,1-1-2,1-2-1,2-1-1,2-2
	//5:1*1,1-1-1-2*4,1-2-2*3;
	public int climbStairs(int n) {
		int list[] = new int[n+3];
		list[0] = 1;
		list[1]=2;
		for(int i=2;i<n;i++) {
			list[i]=(list[i-1]+list[i-2]);
		}
		return list[n-1];
	}
}
