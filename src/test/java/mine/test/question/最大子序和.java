package mine.test.question;

import org.junit.Test;

public class 最大子序和 {
	@Test
	public void result() {
		int arr[] = {-2,1,-3,4,-1,2,1,-5,4};
//		int arr[] = {-2,1};
		System.out.println(maxSubArray(arr));
	}

	public int maxSubArray(int[] nums) {
		int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0)
                sum += num;
            else
                sum = num;
            res = Math.max(res, sum);
        }
        return res;
	}
}