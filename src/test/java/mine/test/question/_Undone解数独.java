package mine.test.question;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _Undone解数独 {
    @Test
    public void run() {
        char[][] arr = {
                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
        };
//        char[][] arr = {
//                {'.', '.', '9', '7', '4', '8', '.', '.', '.'},
//                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
//                {'.', '2', '.', '1', '.', '9', '.', '.', '.'},
//                {'.', '.', '7', '.', '.', '.', '2', '4', '.'},
//                {'.', '6', '4', '.', '1', '.', '5', '9', '.'},
//                {'.', '9', '8', '.', '.', '.', '3', '.', '.'},
//                {'.', '.', '.', '8', '.', '3', '.', '2', '.'},
//                {'.', '.', '.', '.', '.', '.', '.', '.', '6'},
//                {'.', '.', '.', '2', '7', '5', '9', '.', '.'}
//        };
                /*{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };*/
        solveSudoku(arr);
    }

    public void solveSudoku(char[][] board) {
        int count = 0;
        int[][] nineRepeatArr = new int[9][256];
        int[][] nineCenterIndexArr = {
                {1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7},
        };
        int[][] indexArr = new int[9][9];
        indexArr[0][0] = 0;
        indexArr[0][1] = 1;
        indexArr[0][2] = 2;
        indexArr[1][0] = 3;
        indexArr[1][1] = 4;
        indexArr[1][2] = 5;
        indexArr[2][0] = 6;
        indexArr[2][1] = 7;
        indexArr[2][2] = 8;
        int[][] rowRepeatArr = new int[9][256];
        int[][] columnRepeatArr = new int[9][256];
        char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        boolean flag = true;
        //行列重复数组填值
        outside:
        for (int y = 0; y < board.length; y++) {
            char[] charTempArr = board[y];
            inside:
            for (int x = 0; x < charTempArr.length; x++) {
                char element = board[y][x];
                if ('.' == element) {
                    continue;
                }
                rowRepeatArr[y][element] = 1;
                columnRepeatArr[x][element] = 1;
            }
        }
        //九宫格重复判断数组填值
        outside:
        for (int k = 0; k < nineCenterIndexArr.length; k++) {
            int[] tempArr = nineCenterIndexArr[k];
            int y = tempArr[0];
            int x = tempArr[1];
            inside:
            for (int i = y - 1; i <= y + 1; i++) {
                for (int j = x - 1; j <= x + 1; j++) {
                    if (board[i][j] == '.') {
                        count++;
                        continue;
                    }
                    nineRepeatArr[k][board[i][j]] = 1;
                }
            }
        }

        int times = 50;
        while (times > 0) {
            times--;
            System.out.println(count);
            //数字唯一可摆放
            for (int i = 0; i < nineCenterIndexArr.length; i++) {
                int centerY = nineCenterIndexArr[i][0];
                int centerX = nineCenterIndexArr[i][1];
                for (char num : nums) {
                    List<int[]> indexList = new ArrayList<>();
                    for (int y = centerY - 1; y <= centerY + 1; y++) {
                        for (int x = centerX - 1; x <= centerX + 1; x++) {
                            char temp = board[y][x];
                            if (temp != '.') {
                                continue;
                            }
                            if (rowRepeatArr[y][num] == 0 && columnRepeatArr[x][num] == 0 && nineRepeatArr[i][num] == 0) {
                                int[] tempArr = new int[2];
                                tempArr[0] = y;
                                tempArr[1] = x;
                                indexList.add(tempArr);
                            }
                        }
                    }
                    if (indexList.size() == 1) {
                        int[] arr = indexList.get(0);
                        int y = arr[0];
                        int x = arr[1];
                        rowRepeatArr[y][num] = 1;
                        columnRepeatArr[x][num] = 1;
                        nineRepeatArr[i][num] = 1;
                        board[y][x] = num;
                        count--;
                    }
                }
            }
            //位置唯一可摆放数字
            for (int y = 0; y < board.length; y++) {
                char[] tempArr = board[y];
                for (int x = 0; x < tempArr.length; x++) {
                    int nineY = y / 3;
                    int nineX = x / 3;
                    int index = indexArr[nineY][nineX];
                    char temp = tempArr[x];
                    if (temp != '.') {
                        continue;
                    }
                    List<Character> numList = new ArrayList<>();
                    for (char tempChar : nums) {
                        if (rowRepeatArr[y][tempChar] == 0 && columnRepeatArr[x][tempChar] == 0 && nineRepeatArr[index][tempChar] == 0) {
                            numList.add(tempChar);
                        }
                    }
                    if (numList.size() == 1) {
                        temp = numList.get(0);
                        rowRepeatArr[y][temp] = 1;
                        columnRepeatArr[x][temp] = 1;
                        nineRepeatArr[index][temp] = 1;
                        tempArr[x] = temp;
                        count--;
                    }
                }
            }
        }


        for (int i = 0; i < board.length; i++) {
            System.out.println(Arrays.toString(board[i]));
        }
    }
}