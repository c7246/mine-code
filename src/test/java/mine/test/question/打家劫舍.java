package mine.test.question;

import org.junit.Test;

public class 打家劫舍 {
	@Test
	public void result() {
		int arr[] = {2,1,1,2,2};
		System.out.println(rob(arr));
	}

	public int rob(int[] nums) {
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