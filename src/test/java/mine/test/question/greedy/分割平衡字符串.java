package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/19 17:13
 * <p>
 * 在一个「平衡字符串」中，'L' 和 'R' 字符的数量是相同的。
 * <p>
 * 给出一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
 * <p>
 * 返回可以通过分割得到的平衡字符串的最大数量。
 * <p>
 * 输入：s = "RLRRLLRLRL"
 * 输出：4
 * <p>
 * 输入：s = "RLLLLRRRLR"
 * 输出：3
 */
public class 分割平衡字符串 {

    @Test
    public void run() {
        String str = "RLLLRRLRRL";
        System.out.println(balancedStringSplit(str));
    }


    public int balancedStringSplit(String s) {
        int n = 0;
        int sum=0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == 'R') {
                n--;
            } else {
                n++;
            }
            if (n == 0) {
                sum++;
            }
        }
        return sum;
    }


}