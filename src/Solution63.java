/**
 * @author Yskysoar
 * @createTime 2025-02-08 17:18
 * @description 63. 不同路径 II
 * 给定一个 m x n 的整数数组 grid。一个机器人初始位于 左上角（即 grid[0][0]）。机器人尝试移动到 右下角（即 grid[m - 1][n - 1]）。机器人每次只能向下或者向右移动一步。
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。机器人的移动路径中不能包含 任何 有障碍物的方格。
 * 返回机器人能够到达右下角的不同路径数量。
 * 测试用例保证答案小于等于 2 * 109。
 * 示例 1：
 * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
 * 输出：2
 * 解释：3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 * 示例 2：
 * 输入：obstacleGrid = [[0,1],[0,0]]
 * 输出：1
 * 提示：
 * m == obstacleGrid.length
 * n == obstacleGrid[i].length
 * 1 <= m, n <= 100
 * obstacleGrid[i][j] 为 0 或 1
 */
public class Solution63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        int ans = solution63.uniquePathsWithObstacles(new int[][]{{0, 0, 0, 1}});
        System.out.println(ans);
    }

    /**
     * 简单的dp推导，因为只有右和下两个方向
     * @param obstacleGrid 盘面
     * @return 路径数量
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0][0] == 1) return 0;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < dp[0].length; i++) {//初始化第一行
            if (obstacleGrid[0][i] == 1) break;
            dp[0][i] = 1;
        }
        for (int i = 0; i < dp.length; i++) {//初始化第一列
            if (obstacleGrid[i][0] == 1) break;
            dp[i][0] = 1;
        }
        for (int i = 1; i < dp.length; i++) {//dp推演
            for (int j = 1; j < dp[i].length; j++) {//判断位置上是否有障碍物，没有则dp，有则置为0
                dp[i][j] = obstacleGrid[i][j] == 0 ? dp[i][j - 1] + dp[i - 1][j] : 0;
            }
        }
        //返回终点位置的路径规划结果
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
