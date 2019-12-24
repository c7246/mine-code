package mine.test.question;

import org.junit.Test;

public class 有效的数独 {

    @Test
    public void run() {
        char[][] arr = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        System.out.println(isValidSudoku(arr));
    }

    public boolean isValidSudoku(char[][] board) {
        boolean flag = true;
        int[][] indexArr = {
                {1, 1}, {1, 4}, {1, 7}, {4, 1}, {4, 4}, {4, 7}, {7, 1}, {7, 4}, {7, 7},
        };
        int[][] x_indexArr = new int[9][256];
        outside:
        for (int y = 0; y < board.length; y++) {
            int[] tempArr = new int[256];
            inside:
            for (int x = 0; x < board[y].length; x++) {
                char[] charArr = board[y];
                if ('.' == board[y][x]) {
                    continue;
                }
                if (tempArr[(int) charArr[x]] != 0) {
                    flag = false;
                    break outside;
                } else {
                    tempArr[(int) charArr[x]] = 1;
                }
                if (x_indexArr[x][(int) charArr[x]] != 0) {
                    flag = false;
                    break outside;
                } else {
                    x_indexArr[x][(int) charArr[x]] = 1;
                }
            }
        }
        if (!flag) {
            return flag;
        }
        outside:
        for (int[] tempArr : indexArr) {
            int[] nineArr = new int[256];
            int y = tempArr[0];
            int x = tempArr[1];
            inside:
            for (int i = y - 1; i <= y + 1; i++) {
                for (int j = x - 1; j <= x + 1; j++) {
                    if (board[i][j] == '.') {
                        continue;
                    }
                    if (nineArr[(int) board[i][j]] != 0) {
                        flag = false;
                        break outside;
                    } else {
                        nineArr[(int) board[i][j]] = 1;
                    }
                }
            }
        }
        return flag;
    }
}