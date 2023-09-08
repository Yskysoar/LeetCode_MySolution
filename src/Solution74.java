public class Solution74 {
    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        boolean res = solution74.searchMatrix3(new int[][]{{1}, {3}}, 2);
        System.out.println(res);
    }

    public boolean searchMatrix1(int[][] matrix, int target) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (target == matrix[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int index;
        for (index = 0; index < row; index++) {
            if (target >= matrix[index][0] && target <= matrix[index][col - 1]) {
                break;
            }
        }
        for (int i = 0; i < col; i++) {
            if (index == row) {
                break;
            } else if (target == matrix[index][i]) {
                return true;
            }
        }
        return false;
    }

    public boolean searchMatrix3(int[][] matrix, int target) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int left = 0;//左边界
        int right = row * col - 1;//右边界
        while (left <= right) {
            int middle = (right - left) / 2 + left;//防止int越界
            if (target < matrix[middle / col][middle % col]) {
                right = middle - 1;
            } else if (target > matrix[middle / col][middle % col]) {
                left = middle + 1;
            } else {
                return true;
            }
        }
        return false;
    }
}
