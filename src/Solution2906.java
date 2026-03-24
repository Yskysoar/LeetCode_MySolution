import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-03-24 17:43
 * @description 2906. 构造乘积矩阵
 * 给你一个下标从 0 开始、大小为 n * m 的二维整数矩阵 grid ，定义一个下标从 0 开始、大小为 n * m 的的二维矩阵 p。如果满足以下条件，则称 p 为 grid 的 乘积矩阵 ：
 * 对于每个元素 p[i][j] ，它的值等于除了 grid[i][j] 外所有元素的乘积。乘积对 12345 取余数。
 * 返回 grid 的乘积矩阵。
 * 示例 1：
 * 输入：grid = [[1,2],[3,4]]
 * 输出：[[24,12],[8,6]]
 * 解释：p[0][0] = grid[0][1] * grid[1][0] * grid[1][1] = 2 * 3 * 4 = 24
 * p[0][1] = grid[0][0] * grid[1][0] * grid[1][1] = 1 * 3 * 4 = 12
 * p[1][0] = grid[0][0] * grid[0][1] * grid[1][1] = 1 * 2 * 4 = 8
 * p[1][1] = grid[0][0] * grid[0][1] * grid[1][0] = 1 * 2 * 3 = 6
 * 所以答案是 [[24,12],[8,6]] 。
 * 示例 2：
 * 输入：grid = [[12345],[2],[1]]
 * 输出：[[2],[0],[0]]
 * 解释：p[0][0] = grid[0][1] * grid[0][2] = 2 * 1 = 2
 * p[0][1] = grid[0][0] * grid[0][2] = 12345 * 1 = 12345. 12345 % 12345 = 0 ，所以 p[0][1] = 0
 * p[0][2] = grid[0][0] * grid[0][1] = 12345 * 2 = 24690. 24690 % 12345 = 0 ，所以 p[0][2] = 0
 * 所以答案是 [[2],[0],[0]] 。
 * 提示：
 * 1 <= n == grid.length <= 10^5
 * 1 <= m == grid[i].length <= 10^5
 * 2 <= n * m <= 10^5
 * 1 <= grid[i][j] <= 10^9
 */
public class Solution2906 {
    public static void main(String[] args) {
        Solution2906 solution2906 = new Solution2906();
        int[][] ans = solution2906.constructProductMatrix(new int[][]{{8, 18}, {24, 20}, {9, 5}, {26, 26}, {19, 19}, {20, 1}, {20, 23}, {15, 19}, {24, 14}, {12, 15}, {22, 3}, {22, 11}, {9, 25}});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 二维转一维 + 前后缀和
     * @param grid 数据矩阵
     * @return 除去自身以外的矩阵乘积矩阵
     */
    public int[][] constructProductMatrix(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        int[] nums = new int[grid.length * grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[i * grid[i].length + j] = grid[i][j];
            }
        }
        long[] preSum = new long[nums.length + 1];
        preSum[0] = 1;
        long[] endSum = new long[nums.length + 1];
        endSum[endSum.length - 1] = 1;
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = (preSum[i] % 12345) * (nums[i] % 12345);
            endSum[endSum.length - 1 - i - 1] = (endSum[endSum.length - 1 - i] % 12345) * (nums[nums.length - 1 - i] % 12345);
        }
        for (int i = 0; i < ans.length; i++) {
            for (int j = 0; j < ans[i].length; j++) {
                ans[i][j] = (int) ((preSum[i * ans[i].length + j] * endSum[i * ans[i].length + j + 1] % 12345));
            }
        }
        return ans;
    }
}
