package mine.test.question;

import org.junit.Test;

public class 报数 {
	@Test
	public void result() {
		System.out.println(countAndSay(5));
	}

	public String countAndSay(int n) {
		if(n==1)return "1";
		String str = countAndSay(n-1);
		char arr[] = str.toCharArray();
		String re ="";
		int sum=1;
		for(int i = 0;i<arr.length;i++) {
			if(i==arr.length-1) {
				re = re+sum+arr[i];
				break;
			}
			if(arr[i]!=arr[i+1]) {
				re = re+sum+arr[i];
				sum=1;
			}else {
				sum++;
				if(i==arr.length-1) {
					re = re+sum+arr[i];
					break;
				}
			}
		}
		return re;
	}
}