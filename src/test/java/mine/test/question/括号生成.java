package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class 括号生成 {
    @Test
    public void run() {
        int n = 4;
        System.out.println(generateParenthesis(n));
    }

    public List<String> generateParenthesis(int n) {
        List<String> resultList = new ArrayList<>();
        Set<String> strSet = new HashSet<>();
        if (n == 1) {
            resultList.add("()");
            return resultList;
        }
        for (String temp : generateParenthesis(n - 1)) {
            for (int i = 0; i < temp.length(); i++) {
                StringBuilder sb = new StringBuilder();
                String pro = temp.substring(0,i);
                String suf = temp.substring(i,temp.length());
                sb.append(pro).append("()").append(suf);
                strSet.add(sb.toString());
            }
        }
        for (String temp : strSet) {
            resultList.add(temp);
        }
        return resultList;
    }
}