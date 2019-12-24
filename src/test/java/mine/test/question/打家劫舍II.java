package mine.test.question;

import org.junit.Test;

public class 打家劫舍II {
	@Test
	public void result() {
//		int arr[] = {2,1,1,2};
//		int arr[] = {2,2,4,3,2,5};
		int arr[] = {2,7,9,3,1};
		System.out.println(rob(arr));
	}

	public int rob(int[] nums) {
		if(nums.length==0)return 0;
		if(nums.length==1)return nums[0];
		int arr1[] = new int[nums.length-1];
		int arr2[] = new int[nums.length-1];
		for(int i=0;i<arr1.length;i++) {
			arr1[i]=nums[i];
			arr2[i]=nums[i+1];
		}
		return Math.max(rob1(arr1), rob1(arr2));
	}
	public int rob1(int[] nums) {
		if(nums.length==1)return nums[0];
		if(nums.length==0)return 0;
		int maxsum[] = new int[nums.length];
		maxsum[0]=nums[0];
		maxsum[1]=Math.max(nums[0], nums[1]);
		for(int i = 2;i<nums.length;i++) {
			maxsum[i] = Math.max(maxsum[i-1],maxsum[i-2]+nums[i]);
		}
		return maxsum[maxsum.length-1];
	}
}