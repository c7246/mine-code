package mine.test.question;

import org.junit.Test;

public class _Undone字符串转换整数 {
    @Test
    public void run() {
        String str = "42";
        System.out.println(myAtoi(str));
    }

    public int myAtoi(String str) {
        if ("".equals(str) || str == null) {
            return 0;
        }
        boolean flag = true;
        boolean flag1 = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (temp <= 32) {
                continue;
            }
            if (flag) {
                if (temp != '-' && temp != '+' && (48 > temp || temp > 57)) {
                    return 0;
                } else {
                    sb.append(temp);
                }
                flag = false;
            } else {
                if (48 <= temp && temp <= 57) {
                    if (flag1) {
                        if (temp == '0') {
                            break;
                        } else {
                            sb.append(temp);
                            flag1 = false;
                        }
                    } else {
                        sb.append(temp);
                    }
                } else {
                    break;
                }
            }
        }
        if ("-".equals(sb.toString()) || "+".equals(sb.toString()) || "".equals(sb.toString())) {
            return 0;
        }
        Double l = new Double(sb.toString());
        if (l > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (l < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            return l.intValue();
        }
    }
}