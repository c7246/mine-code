package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author caijinnan
 * @date 2019/12/13 11:20
 */
public class _UndoneN皇后 {

    @Test
    public void run() {
        System.out.println(solveNQueens(4));
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        String[][] arr = new String[n][n];

        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                for (int yx = 0; yx < n; yx++) {
                    if(yx==x){
                        continue;
                    }
                    boolean flag = check(yx, y, arr);

                }
            }
        }


        return result;
    }

    private boolean check(int yx, int y, String[][] arr) {
        boolean flag= true;

        for(int arrY =0;arrY<arr.length;arrY++){
            if(arr[arrY][yx].equals("Q")){
                flag =false;
                break;
            }

            for(int arrX= 0;arrX<arr[arrY].length;arrX++){

            }

        }


        return  flag;
    }
}