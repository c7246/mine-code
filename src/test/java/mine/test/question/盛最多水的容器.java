package mine.test.question;

import org.junit.Test;

public class 盛最多水的容器 {
	@Test
	public void result() {
		int arr[] = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.println(maxArea(arr));
	}

	public int maxArea(int[] height) {
		int max = 0;
		for(int i=0,j=height.length-1;i<j;) {
			int s = 0;
			if(height[i]>height[j]) {
				s = (j-i)*height[j];
				j--;
			}else {
				s = (j-i)*height[i];
				i++;
			}
			max = s<max?max:s;
		}
		return max;
	}
}