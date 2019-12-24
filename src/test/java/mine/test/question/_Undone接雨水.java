package mine.test.question;

import org.junit.Test;

public class _Undone接雨水 {
	@Test
	public void result() {
		int arr[] = { 2,0,2 };
		System.out.println(trap(arr));
	}

	public int trap(int[] height) {
		int sum = 0;
		int temp = 0;
		for(int i=0,j=i+1;j<height.length;){
			if(height[i]>height[j]){
				temp = temp+height[j];
			}else{
				sum = sum +(j-1-i)*(height[i])-temp;
				temp = 0;
				i=j;
			}
			j++;
		}
		temp = 0;
		for(int i = height.length-1,j=i-1;j>=0;){
			if(height[i]>height[j]){
				temp = temp+height[j];
			}else{
				sum = sum +(i-1-j)*(height[i])-temp;
				temp = 0;
				i=j;
			}
			j--;
		}
		return  sum;
	}
}