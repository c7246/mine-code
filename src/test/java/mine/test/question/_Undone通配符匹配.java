package mine.test.question;

import org.junit.Test;
import scala.collection.parallel.mutable.ParTrieMap;

/**
 * 给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 * '?' 可以匹配任何单个字符。
 * '*' 可以匹配任意字符串（包括空字符串）。
 * 两个字符串完全匹配才算匹配成功。
 * 说明:
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 ? 和 *。
 * 示例 1:
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 */
public class _Undone通配符匹配 {

    @Test
    public void run() {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        if (pLength == 0 && sLength != 0) {
            return false;
        }
        if ((pLength == 0 || p.equals("?") || p.equals("*")) && sLength == 0) {
            return true;
        }
        if (sLength == 0) {
            return false;
        }
        char one = '?';
        char all = '*';
        int[] arr = new int[256];



        return true;
    }

}