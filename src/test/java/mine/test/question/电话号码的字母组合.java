package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class 电话号码的字母组合 {
    @Test
    public void run() {
        String str = "23";
        System.out.println(letterCombinations(str));
    }

    private List<String> letterCombinations(String digits) {
        List<String> resultList = new ArrayList<>();
        if (digits.equals("")) {
            return resultList;
        }
        String[] arr1 = {};
        String[] arr2 = {"a", "b", "c"};
        String[] arr3 = {"d", "e", "f"};
        String[] arr4 = {"g", "h", "i"};
        String[] arr5 = {"j", "k", "l"};
        String[] arr6 = {"m", "n", "o"};
        String[] arr7 = {"p", "q", "r", "s"};
        String[] arr8 = {"t", "u", "v"};
        String[] arr9 = {"w", "x", "y", "z"};
        String[][] arr = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8, arr9};
        int nums[] = new int[digits.length()];
        int indexArr[] = new int[nums.length];
        for (int i = 0; i < digits.length(); i++) {
            Integer index = Integer.valueOf(String.valueOf(digits.charAt(i))) - 1;
            nums[i] = index;
        }
        while (indexArr[0] < arr[nums[0]].length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < nums.length; i++) {
                sb.append(arr[nums[i]][indexArr[i]]);
            }
            resultList.add(sb.toString());
            indexArr[indexArr.length - 1]++;
            for (int i = indexArr.length - 1; i > 0; i--) {
                if (indexArr[i] >= arr[nums[i]].length) {
                    indexArr[i - 1]++;
                    indexArr[i] = 0;
                }
            }
        }
        return resultList;
    }
}