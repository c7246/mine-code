package mine.test.question;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class 串联所有单词的子串 {
	@Test
	public void result() {
		String s = "ababaab";
		String words[] = { "ab", "ba", "ba" };
		System.out.println(findSubstring(s, words));
	}

	public List<Integer> findSubstring(String s, String[] words) {
		ArrayList<Integer> list = new ArrayList<>();
		if (s.length() == 0 || words.length == 0)
			return list;
		int length = 0;
		for (String temp : words) {
			length += temp.length();
		}
		a: for (int i = 0; i <= s.length() - length; i++) {
//			String temp = s.substring(i,i+length);
			StringBuilder temp = new StringBuilder(s.substring(i, i + length));
			for (String regex : words) {
				int index = 0;
				if ((index = temp.indexOf(regex)) != -1) {
					while(index%regex.length()!=0) {
						int inum = index+1;
						index = temp.indexOf(regex,inum);
						if(index==-1) {
							continue a;
						}
					}
					temp.delete(index, index + regex.length());
				} else {
					continue a;
				}
			}
			list.add(i);
		}
		return list;
	}
}
