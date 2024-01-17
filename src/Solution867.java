import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-02-15 16:12
 * @description 867. 转置矩阵
 * 给你一个二维整数数组 matrix， 返回 matrix 的 转置矩阵 。
 * 矩阵的 转置 是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 * 输入：matrix = [[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class Solution867 {
    public static void main(String[] args) {
        Solution867 solution867 = new Solution867();
        int[][] res = solution867.transpose2(new int[][]{{1, 2, 3}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(res));
    }

    /**
     * 模拟转置：直接调换
     * @param matrix 要转置的矩阵
     * @return 转置后的矩阵
     */
    public int[][] transpose1(int[][] matrix) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int[][] ans = new int[col][row];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                ans[j][i] = matrix[i][j];
            }
        }
        return ans;
    }

    /**
     * 模拟转置：直接调换，但是是二维数组的一维表示
     * @param matrix 要转置的矩阵
     * @return 转置后的矩阵
     */
    public int[][] transpose2(int[][] matrix) {
        int row = matrix.length;//行数
        int col = matrix[0].length;//列数
        int[][] ans = new int[col][row];
        for (int i = 0; i < row * col; i++) {
            ans[i / row][i % row] = matrix[i % row][i / row];
        }
        return ans;
    }
}
