package mine.test.question;

import org.junit.Test;

public class 乘积最大子序列 {
	@Test
	public void result() {
//		int arr[] = { 2, 3, -2, 4 };
		int arr[] = { 2,-5, -2,-4,3};
//		int arr[] = { -2, 0, -1 };
		System.out.println(maxProduct(arr));
	}

	public int maxProduct(int[] nums) {
		int dp;
        if(nums.length == 1 )return nums[0];
 
        int i,maxm,minm;
 
        dp = maxm = minm = nums[0];
        for(i=1;i<nums.length;i++){
 
            if(nums[i]>=0){
                maxm = Math.max(maxm*nums[i],nums[i]);
                minm = Math.min(minm*nums[i],nums[i]);
            }else{
                int tmp;
                tmp = maxm;
                maxm = Math.max(minm*nums[i],nums[i]);
                minm = Math.min(tmp*nums[i],nums[i]);
            }
            dp = Math.max(maxm,dp);
        }
        return dp;
    }
}