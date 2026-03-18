/**
 * @author Yskysoar
 * @createTime 2026-03-18 14:23
 * @description 3070. 元素和小于等于 k 的子矩阵的数目
 * 给你一个下标从 0 开始的整数矩阵 grid 和一个整数 k。
 * 返回包含 grid 左上角元素、元素和小于或等于 k 的 子矩阵的数目。
 * 示例 1：
 * 输入：grid = [[7,6,3],[6,6,1]], k = 18
 * 输出：4
 * 解释：如上图所示，只有 4 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 18 。
 * 示例 2：
 * 输入：grid = [[7,2,9],[1,5,0],[2,6,6]], k = 20
 * 输出：6
 * 解释：如上图所示，只有 6 个子矩阵满足：包含 grid 的左上角元素，并且元素和小于或等于 20 。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= n, m <= 1000
 * 0 <= grid[i][j] <= 1000
 * 1 <= k <= 10^9
 */
public class Solution3070 {
    public static void main(String[] args) {
        Solution3070 solution3070 = new Solution3070();
        int ans = solution3070.countSubmatrices(new int[][]{{7, 6, 3}, {6, 6, 1}}, 18);
        System.out.println(ans);
    }

    /**
     * 二维前缀和
     * 记录当前前缀和为当前位置到左上角所围成的矩形的面积，计算完成后统计是否合法即可
     * @param grid 初始矩阵
     * @param k    校验值
     * @return 存在多少个合法的矩阵
     */
    public int countSubmatrices(int[][] grid, int k) {
        int ans = 0;
        int[][] preSum = new int[grid.length + 1][grid[0].length + 1];
        for (int i = 1; i < preSum.length; i++) {
            for (int j = 1; j < preSum[i].length; j++) {
                preSum[i][j] = preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1] + grid[i - 1][j - 1];
                if (preSum[i][j] <= k) ans++;
            }//计算到grid左上角的矩形的面积
        }
        return ans;
    }
}
