/**
 * @author Yskysoar
 * @createTime 2025-08-20 1:41
 * @description 1277. 统计全为 1 的正方形子矩阵
 * 给你一个 m * n 的矩阵，矩阵中的元素不是 0 就是 1，请你统计并返回其中完全由 1 组成的 正方形 子矩阵的个数。
 * 示例 1：
 * 输入：matrix =
 * [
 * [0,1,1,1],
 * [1,1,1,1],
 * [0,1,1,1]
 * ]
 * 输出：15
 * 解释：
 * 边长为 1 的正方形有 10 个。
 * 边长为 2 的正方形有 4 个。
 * 边长为 3 的正方形有 1 个。
 * 正方形的总数 = 10 + 4 + 1 = 15.
 * 示例 2：
 * 输入：matrix =
 * [
 * [1,0,1],
 * [1,1,0],
 * [1,1,0]
 * ]
 * 输出：7
 * 解释：
 * 边长为 1 的正方形有 6 个。
 * 边长为 2 的正方形有 1 个。
 * 正方形的总数 = 6 + 1 = 7.
 * 提示：
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 */
public class Solution1277 {
    public static void main(String[] args) {
        Solution1277 solution1277 = new Solution1277();
        int ans = solution1277.countSquares(new int[][]{{0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}});
        System.out.println(ans);
    }

    /**
     * dp + 数学
     * dp[i][j]代表当前位置在内往左上角延申的最大全为 1 的正方形子矩阵边长
     * dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;
     * 全为 1 的正方形子矩阵数量为dp矩阵元素之和（dp[i][j]可以理解为包括当前位置在内可以新增dp[i][j]个正方形，边长从1~dp[i][j]）
     * @param matrix 0/1 矩阵
     * @return 全为 1 的正方形子矩阵数量
     */
    public int countSquares(int[][] matrix) {
        int ans = 0;
        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (matrix[i - 1][j - 1] == 1) {//必须保证当前位置是1
                    dp[i][j] = Math.min(dp[i - 1][j], Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1;//会被小正方形限制
                }
                ans += dp[i][j];
            }
        }
        return ans;
    }
}
