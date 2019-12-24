package mine.test.question;

import org.junit.Test;

public class 删除排序数组中的重复项 {
	@Test
	public void tesult() {
		int arr[] = {0,1,1,1,1,2,2,3,3,4};
		int len = removeDuplicates(arr);
		for (int i = 0; i < len; i++) {
		    System.out.println(arr[i]);
		}
	}

	public int removeDuplicates(int[] nums) {
		 	if (nums == null || nums.length == 0) {
	            return 0;
	        }

	        if (nums.length == 1) {
	            return nums.length;
	        }

	        int i = 1, j = 0;
	        while (i < nums.length) {
	            if (nums[i - 1] != nums[i]) {
	                nums[++j] = nums[i];
	            }
	            i++;
	        }
	        return j + 1;
//		LinkedHashSet<Integer> set = new LinkedHashSet<>();
//		for(int i:nums) {
//			set.add(i);
//		}
//		int i = 0;
//		for(Integer num:set) {
//			nums[i]=num;
//			i++;
//		}
//		return i;
	}
}