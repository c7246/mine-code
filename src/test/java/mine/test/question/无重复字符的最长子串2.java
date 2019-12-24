package mine.test.question;

import org.junit.Test;

import java.util.Arrays;

public class 无重复字符的最长子串2 {
    @Test
    public void run() {
        String str = " ";
        System.out.println(lengthOfLongestSubstring(str));
    }

    /**
     * 通过数组存储重复字符,遇到重复字符后,从第一个重复字符的后一个字符继续开始,并保存此时长度
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int tempLength = 0;
        int[] intArr = new int[200];
        Arrays.fill(intArr, -1);
        for (int i = 0; i < s.length(); i++) {
            char charTemp = s.charAt(i);
            int charIndex = charTemp;
            if (intArr[charIndex] == -1) {
                intArr[charIndex] = i;
                tempLength++;
            } else {
                maxLength = Math.max(maxLength, tempLength);
                tempLength = 0;
                i = intArr[charIndex];
                Arrays.fill(intArr, -1);
            }
        }
        return Math.max(maxLength,tempLength);
    }

}