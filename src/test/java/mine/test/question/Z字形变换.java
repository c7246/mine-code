package mine.test.question;

import org.junit.Test;

import java.util.Arrays;


public class Z字形变换 {

    @Test
    public void run() {
        String str = "A";
        System.out.println(convert(str, 1));
    }

    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            int index = i;
            int nextIndex;
            if (i == 0 || i == numRows - 1) {
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    index += 2 * numRows - 2;
                    if (index == 0) {
                        break;
                    }
                }
            } else {
                while (index < s.length()) {
                    sb.append(s.charAt(index));
                    nextIndex = index + 2 * (numRows - i - 1);
                    if (nextIndex < s.length()) {
                        sb.append(s.charAt(nextIndex));
                    }
                    index += 2 * numRows - 2;
                    if (index == 0) {
                        break;
                    }
                }
            }
        }
        return sb.toString();
    }
}