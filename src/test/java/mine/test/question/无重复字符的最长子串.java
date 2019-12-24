package mine.test.question;

import org.junit.Test;

public class 无重复字符的最长子串 {
	@Test
	public void result() {
		String s = "cbbb";
		System.out.println(lengthOfLongestSubstring(s));
	}

	public int lengthOfLongestSubstring(String s) {
		int result = s.length();
		while(result>0) {
			for(int i =0;i+result-1<s.length();i++) {
				if(judge(s.substring(i, i+result))) {
					return result;
				}
			}
			result-=1;
		}
		return 1;
	}
	
	public boolean judge(String s) {
		System.out.println(s);
		for(int i=0,j=s.length()-1;i<j;i++,j--) {
			if(s.charAt(i)!=s.charAt(j))return false;
		}
		return true;
	}
}
