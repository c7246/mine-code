package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author caijinnan
 * @date 2019/12/11 17:51
 *
 * ps:任何一位正整数,有且只有固定一组质因数
 */
public class 字母异位词分组 {

    @Test
    public void run() {
        String[] arr = {"abd","abc","dba"};
        System.out.println(groupAnagrams(arr));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        String[] map = new String[strs.length];
        for (String str : strs) {
            char[] charArr = str.toCharArray();
            Arrays.sort(charArr);
            String key = String.valueOf(charArr);
            int index = 0;
            boolean flag = false;
            for(int i = 0;i<map.length;i++){
                index = i;
                if(map[i]==null){
                    break;
                }
                if(map[i].equals(key)){
                    flag = true;
                    break;
                }
            }
            if(flag){
                result.get(index).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                result.add(list);
                map[index++] = key;
            }
        }
        return result;

    }
}