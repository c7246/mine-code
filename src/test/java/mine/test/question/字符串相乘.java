package mine.test.question;

import org.junit.Test;

public class 字符串相乘 {

    @Test
    public void run() {
        String num1 = "123";
        String num2 = "456";
        System.out.println(Integer.valueOf(num1) * Integer.valueOf(num2));
        System.out.println(multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0") || num1.length() == 0 || num2.length() == 0) {
            return "0";
        }
        String max = num1.length() > num2.length() ? num1 : num2;
        String min = num1.length() > num2.length() ? num2 : num1;
        String result = "0";
        for (int i = min.length() - 1; i >= 0; i--) {
            int subNum = min.length() - 1 - i;
            if (subNum > 0) {
                max = max + "0";
            }
            int offSet = Integer.valueOf(String.valueOf(min.charAt(i)));
            for (int k = 0; k < offSet; k++) {
                result = add(result, max);
            }
        }
        return result;
    }

    /**
     * 字符串的两数相加
     *
     * @param str1
     * @param str2
     * @return
     */
    public String add(String str1, String str2) {
        String max = str1.length() > str2.length() ? str1 : str2;
        String min = str1.length() > str2.length() ? str2 : str1;
        StringBuilder sbMax = new StringBuilder(max);
        StringBuilder sbMin = new StringBuilder(min);

        int subLength = sbMax.length() - sbMin.length();
        int temp = 0;
        for (int index = sbMin.length() - 1; index >= 0; index--) {
            int sbMaxIndex = subLength + index;
            int minNum = Integer.valueOf(String.valueOf(sbMin.charAt(index)));
            int maxNum = Integer.valueOf(String.valueOf(sbMax.charAt(sbMaxIndex)));
            int sum = minNum + maxNum + temp;
            if (sum >= 10) {
                sbMax.deleteCharAt(sbMaxIndex);
                sbMax.insert(sbMaxIndex, sum - 10);
                temp = 1;
            } else {
                sbMax.deleteCharAt(sbMaxIndex);
                sbMax.insert(sbMaxIndex, sum);
                temp = 0;
            }
        }
        int index = subLength - 1;
        while (index >= 0 && temp == 1) {
            int maxNum = Integer.valueOf(String.valueOf(sbMax.charAt(index)));
            int sum = maxNum + temp;
            if (sum >= 10) {
                sbMax.deleteCharAt(index);
                sbMax.insert(index, sum - 10);
                temp = 1;
                index--;
            } else {
                sbMax.deleteCharAt(index);
                sbMax.insert(index, sum);
                temp = 0;
            }
        }
        if (temp == 1) {
            sbMax = new StringBuilder("1").append(sbMax);
        }

        return sbMax.toString();
    }
}