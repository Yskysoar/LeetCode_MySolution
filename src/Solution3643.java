import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-03-21 10:01
 * @description 3643. 垂直翻转子矩阵
 * 给你一个 m x n 的整数矩阵 grid，以及三个整数 x、y 和 k。
 * 整数 x 和 y 表示一个 正方形子矩阵 的左上角下标，整数 k 表示该正方形子矩阵的边长。
 * 你的任务是垂直翻转子矩阵的行顺序。
 * 返回更新后的矩阵。
 * 示例 1：
 * 输入： grid = [[1,2,3,4],[5,6,7,8],[9,10,11,12],[13,14,15,16]], x = 1, y = 0, k = 3
 * 输出： [[1,2,3,4],[13,14,15,8],[9,10,11,12],[5,6,7,16]]
 * 解释：
 * 上图展示了矩阵在变换前后的样子。
 * 示例 2：
 * 输入： grid = [[3,4,2,3],[2,3,4,2]], x = 0, y = 2, k = 2
 * 输出： [[3,4,4,2],[2,3,2,3]]
 * 解释：
 * 上图展示了矩阵在变换前后的样子。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 50
 * 1 <= grid[i][j] <= 100
 * 0 <= x < m
 * 0 <= y < n
 * 1 <= k <= min(m - x, n - y)
 */
public class Solution3643 {
    public static void main(String[] args) {
        Solution3643 solution3643 = new Solution3643();
        int[][] ans = solution3643.reverseSubmatrix(new int[][]{{14, 3, 18, 16}, {2, 14, 11, 20}, {19, 19, 4, 15}, {11, 15, 18, 6}}, 0, 0, 4);
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 模拟 + 数组
     * 根据要求直接原地交换即可
     * @param grid 矩阵数据
     * @param x    左上角横坐标
     * @param y    左上角纵坐标
     * @param k    内嵌矩阵边长
     * @return 翻转结果
     */
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        for (int i = 0; i < k / 2; i++) {
            for (int j = 0; j < k; j++) {
                grid[x + i][y + j] ^= grid[x + k - i - 1][y + j];
                grid[x + k - i - 1][y + j] ^= grid[x + i][y + j];
                grid[x + i][y + j] ^= grid[x + k - i - 1][y + j];
            }
        }
        return grid;
    }
}
