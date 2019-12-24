package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/20 16:14
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * s = "abc", t = "ahbgdc"
 * 返回 true.
 * <p>
 * s = "axc", t = "ahbgdc"
 * 返回 false.
 */
public class 判断子序列 {

    @Test
    public void run() {
        String s = "acb";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
    }


    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) {
            return false;
        }
        int lastIndex = 0;
        boolean flag = true;
        outside :for(char sTemp:s.toCharArray()){
            if(lastIndex>=t.length()){
                flag = false;
                break;
            }
            for(int i = lastIndex;i<t.length();i++){
                char tTemp = t.charAt(i);
                if(sTemp==tTemp){
                    lastIndex=i+1;
                    break;
                }
                if(i==t.length()-1){
                    flag =false;
                    break outside;
                }
            }
        }
        return flag;
    }
}
