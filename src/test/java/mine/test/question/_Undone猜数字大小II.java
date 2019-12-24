package mine.test.question;

import org.junit.Test;

public class _Undone猜数字大小II {
    @Test
    public void result() {
        // 0, 1, 2, 4, 6, 8,10,12,14,16,18,21,24,27,30,34,38,42,46,49

        // 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12,13,14,15,16,17,18,19,20
//		int mine = getMoneyAmountM(20);
//		System.out.println(mine + "\n");
//		for(int n = 1;n<=20;n++) {
//			System.out.println(resultNum(n));
//		}
        for (int i = 1; i < 10; i++) {
            System.out.println(i + ":" + getMoneyAmountM(i));
        }
    }

    public int getMoneyAmountM(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 0;
        }

        int[] arr = new int[n];
        arr[0] = 0;
        arr[1] = 1;
        boolean[] flagArr = new boolean[n];
        flagArr[0] = true;
        flagArr[1] = false;
        for (int i = 2; i < n; i++) {
            int a = arr[i - 1];
            int b = arr[i - 2];
            boolean aFlag = flagArr[i - 1];
            if (!aFlag) {
                a += i;
            }
            b += i;

            flagArr[i] = a < b;
            arr[i] = a > b ? b : a;
        }


        return arr[n - 1];
    }
}