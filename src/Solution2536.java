import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-08-02 11:41
 * @description 2536.子矩阵元素加一
 * 给你一个正整数 n ，表示最初有一个 n x n 、下标从 0 开始的整数矩阵 mat ，矩阵中填满了 0 。
 * 另给你一个二维整数数组 query 。针对每个查询 query[i] = [row1i, col1i, row2i, col2i] ，请你执行下述操作：
 * 找出 左上角 为 (row1i, col1i) 且 右下角 为 (row2i, col2i) 的子矩阵，将子矩阵中的 每个元素 加 1 。
 * 也就是给所有满足 row1i <= x <= row2i 和 col1i <= y <= col2i 的 mat[x][y] 加 1 。
 * 返回执行完所有操作后得到的矩阵 mat 。
 * 示例 1：
 * 输入：n = 3, queries = [[1,1,2,2],[0,0,1,1]]
 * 输出：[[1,1,0],[1,2,1],[0,1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵、执行完第二个操作后的矩阵。
 * - 第一个操作：将左上角为 (1, 1) 且右下角为 (2, 2) 的子矩阵中的每个元素加 1 。
 * - 第二个操作：将左上角为 (0, 0) 且右下角为 (1, 1) 的子矩阵中的每个元素加 1 。
 * 示例 2：
 * 输入：n = 2, queries = [[0,0,1,1]]
 * 输出：[[1,1],[1,1]]
 * 解释：上图所展示的分别是：初始矩阵、执行完第一个操作后的矩阵。
 * - 第一个操作：将矩阵中的每个元素加 1 。
 */
public class Solution2536 {
    public static void main(String[] args) {
        Solution2536 solution2536 = new Solution2536();
        int[][] ans = solution2536.rangeAddQueries2(3, new int[][]{{1, 1, 2, 2}, {0, 0, 1, 1}});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 暴力执行
     * @param n 矩阵边长
     * @param queries 操作数组
     * @return 操作完成后的矩阵mat
     */
    public int[][] rangeAddQueries1(int n, int[][] queries) {
        int[][] matrix = new int[n][n];
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[2]; i++) {
                for (int j = query[1]; j <= query[3]; j++) {
                    matrix[i][j]++;
                }
            }
        }
        return matrix;
    }

    /*
      二维差分理解：https://leetcode.cn/problems/increment-submatrices-by-one/solutions/2062841/er-wei-cha-fen-tu-jie-by-newhar-4tch/
     */

    /**
     * 二维差分
     * @param n 矩阵边长
     * @param queries 操作数组
     * @return 操作完成后的矩阵mat
     */
    public int[][] rangeAddQueries2(int n, int[][] queries) {
        int[][] matrix = new int[n + 2][n + 2];//差分矩阵
        for (int[] query : queries) {
            int x1 = query[0], x2 = query[2], y1 = query[1], y2 = query[3];//操作范围
            matrix[x1 + 1][y1 + 1]++;//左上+1
            matrix[x2 + 2][y2 + 2]++;//右下+1
            matrix[x2 + 2][y1 + 1]--;//左下-1
            matrix[x1 + 1][y2 + 2]--;//右上-1
        }//中间部分是初始数组大小
        int[][] ans = new int[n][n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                matrix[i][j] = matrix[i][j] + matrix[i - 1][j] + (matrix[i][j - 1] - matrix[i - 1][j - 1]);
                ans[i - 1][j - 1] = matrix[i][j];
            }
        }
        return ans;
    }
}
