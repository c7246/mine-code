package mine.test.question.greedy;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author caijinnan
 * @date 2019/12/20 13:45
 * <p>
 * 每个孩子最多只能给一块饼干。对每个孩子 i ，都有一个胃口值 gi ，这是能让孩子们满足胃口的饼干的最小尺寸；
 * 并且每块饼干 j ，都有一个尺寸 sj 。
 * 如果 sj >= gi ，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * <p>
 * 注意：
 * <p>
 * 你可以假设胃口值为正。
 * 一个小朋友最多只能拥有一块饼干。
 */
public class 分发饼干 {

    @Test
    public void run() {
        int[] g = {1, 9, 8};
        int[] s = {10, 9, 8, 7};
        System.out.println(findContentChildren(g, s));
    }

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int sum = 0;
        for (int i = 0, j = 0; i < g.length && j < s.length; ) {
            if (s[j] >= g[i]) {
                sum++;
                j++;
                i++;
            } else {
                j++;
            }
        }
        return sum;
    }

}
