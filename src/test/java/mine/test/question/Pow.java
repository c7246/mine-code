package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caijinnan
 * @date 2019/12/13 10:09
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 */
public class Pow {

    @Test
    public void run() {
        System.out.println(myPow(2.00000,10));
    }


    public double myPow(double x, int n) {
        double ndouble = Double.valueOf(n);
        if (x == 1D || x == 0D) {
            return x;
        }
        if (n == 0) {
            return 1D;
        }
        List<Double> numList = new ArrayList<>();
        boolean flag = true;
        if (ndouble < 0) {
            ndouble = -ndouble;
            flag = false;
        }
        while (ndouble > 0) {
            if (ndouble % 2 == 0) {
                numList.add(1D);
            } else {
                numList.add(x);
            }
            ndouble = Math.floor(ndouble / 2);
        }
        double num = 1D;
        for (int i = numList.size() - 1; i > 0; i--) {
            num = numList.get(i);
            num = num * num * numList.get(i - 1);
            numList.set(i - 1, num);
        }
        num = numList.get(0);

        if (!flag) {
            num = 1 / num;
        }
        return num;
    }
}
