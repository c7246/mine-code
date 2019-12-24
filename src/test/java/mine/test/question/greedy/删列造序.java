package mine.test.question.greedy;

import org.junit.Test;

/**
 * @author caijinnan
 * @date 2019/12/20 10:04
 * 给定由 N 个小写字母字符串组成的数组 A，其中每个字符串长度相等。
 * <p>
 * 删除 操作的定义是：选出一组要删掉的列，删去 A 中对应列中的所有字符，形式上，第 n 列为 [A[0][n], A[1][n], ..., A[A.length-1][n]]）。
 * 比如，有 A = ["abcdef", "uvwxyz"]，
 * 要删掉的列为 {0, 2, 3}，删除后 A 为["bef", "vyz"]， A 的列分别为["b","v"], ["e","y"], ["f","z"]。
 * 你需要选出一组要删掉的列 D，对 A 执行删除操作，使 A 中剩余的每一列都是 非降序 排列的，然后请你返回 D.length 的最小可能值。
 */
public class 删列造序 {

    @Test
    public void run(){
        String[] arr = {"rrjk","furt","guzm"};
        System.out.println(minDeletionSize(arr));
    }
    public int minDeletionSize(String[] A) {
        if(A.length==0||A.length==1){
            return 0;
        }
        int sum = 0;
        String tempStr = A[0];
        int length = tempStr.length();
        for(int index = 0;index<length;index++){
            char tempChar =tempStr.charAt(index);
            boolean flag = true;
            for(int i=1;i<A.length;i++){
                char compareChar = A[i].charAt(index);
                if(tempChar>compareChar){
                    flag = false;
                    break;
                }
                tempChar=compareChar;
            }
            if(!flag){
                sum++;
            }
        }
        return sum;
    }

}
