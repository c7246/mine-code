package mine.test.question.greedy;

import org.junit.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author caijinnan
 * @date 2019/12/20 14:17
 *
 * 输入：A = [4,2,3], K = 1
 * 输出：5
 * 解释：选择索引 (1,) ，然后 A 变为 [4,-2,3]。
 */
public class K次取反后最大化的数组和 {

    @Test
    public void run(){
        int[] A = {2,-3,-1,5,-4};
        int K = 2;
        System.out.println(largestSumAfterKNegations(A,K));
    }

    public int largestSumAfterKNegations(int[] A, int K) {
        int sum = 0;
        while(K>0){
            Arrays.sort(A);
            A[0]=-A[0];
            K--;
        }
        for(int num : A){
            sum+=num;
        }
        return sum;
    }
}