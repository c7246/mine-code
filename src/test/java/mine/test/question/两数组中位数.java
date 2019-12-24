package mine.test.question;

import java.util.Arrays;

import org.junit.Test;

public class 两数组中位数 {
	@Test
	public void result() {
		int a[] = {1,2};
		int b[] = {3,4};
		System.out.println(findMedianSortedArrays(a, b));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		double result=0L;
		int arr[] = new int[nums1.length+nums2.length];
		int index = arr.length;
		System.arraycopy(nums1, 0, arr, 0, nums1.length);
		System.arraycopy(nums2, 0, arr, nums1.length, nums2.length);
		Arrays.sort(arr);
		if(index%2==0) {
			result = (arr[index/2-1]+arr[index/2])/2.0;
		}else {
			result = arr[index/2];
		}
		return result;
	}
}