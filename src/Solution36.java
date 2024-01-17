public class Solution36 {
    public static void main(String[] args) {
        Solution36 solution36 = new Solution36();
        char[][] arr = new char[][]
                {{'.', '.', '4', '.', '.', '.', '6', '3', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'5', '.', '.', '.', '.', '.', '.', '9', '.'},
                        {'.', '.', '.', '5', '6', '.', '.', '.', '.'},
                        {'4', '.', '3', '.', '.', '.', '.', '.', '1'},
                        {'.', '.', '.', '7', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                        {'.', '.', '.', '.', '.', '.', '.', '.', '.'},};
        boolean res = solution36.isValidSudoku(arr);
        System.out.println(res);
    }

    public boolean isValidSudoku(char[][] board) {
        int[] row;//行
        int[] col;//列
        int[][] boxs = new int[9][9];//九宫格(9个九宫格，一个box有九个位置)
        //题目给出board.length(行) == board[i],length(列) == 9
        for (int i = 0; i < 9; i++) {
            row = new int[9];
            col = new int[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    //行
                    row[board[i][j] - '0' - 1]++;
                    if (row[board[i][j] - '0' - 1] > 1) {
                        return false;
                    }
                    //九宫格
                    boxs[(i / 3) + (j / 3) * 3][board[i][j] - '0' - 1]++;
                    if (boxs[(i / 3) + (j / 3) * 3][board[i][j] - '0' - 1] > 1) {
                        return false;
                    }
                }
                //列
                if (board[j][i] != '.') {
                    col[board[j][i] - '0' - 1]++;
                    if (col[board[j][i] - '0' - 1] > 1) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

