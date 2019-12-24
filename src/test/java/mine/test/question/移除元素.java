package mine.test.question;

import org.junit.Test;

public class 移除元素 {
	@Test
	public void result() {
		int nums[] = {0,1,2,2,3,0,4,2};
		int val = 2;
		int len = removeElement(nums, val);
		for (int i = 0; i < len; i++) {
		    System.out.println(nums[i]);
		}
	}

	public int removeElement(int[] nums, int val) {
		int j=0;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]!=val) {
				nums[j]=nums[i];
				j++;
			}
		}
		return j;
	}
}