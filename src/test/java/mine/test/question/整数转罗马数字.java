package mine.test.question;

import org.junit.Test;

import java.util.LinkedHashMap;

public class 整数转罗马数字 {
    @Test
    public void run() {
        int i = 9;
        System.out.println(intToRoman(i));
    }

    public String intToRoman(int num) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        LinkedHashMap<String, Integer> numMap = new LinkedHashMap<>();
        map.put(1000, "M");
        map.put(900, "CM");
        map.put(500, "D");
        map.put(400, "CD");
        map.put(100, "C");
        map.put(90, "XC");
        map.put(50, "L");
        map.put(40, "XL");
        map.put(10, "X");
        map.put(9, "IX");
        map.put(5, "V");
        map.put(4, "IV");
        map.put(1, "I");
        for (Integer key : map.keySet()) {
            numMap.put(map.get(key), num / key);
            num = num % key;
        }
        StringBuilder sb = new StringBuilder();
        for (String key : numMap.keySet()) {
            Integer count = numMap.get(key);
            for (int i = 0; i < count; i++) {
                sb.append(key);
            }
        }
        return sb.toString();
    }
}