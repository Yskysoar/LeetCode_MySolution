/**
 * @author Yskysoar
 * @createTime 2025-08-22 0:09
 * @description 3195. 包含所有 1 的最小矩形面积 I
 * 给你一个二维 二进制 数组 grid。请你找出一个边在水平方向和竖直方向上、面积 最小 的矩形，并且满足 grid 中所有的 1 都在矩形的内部。
 * 返回这个矩形可能的 最小 面积。
 * 示例 1：
 * 输入： grid = [[0,1,0],[1,0,1]]
 * 输出： 6
 * 解释：
 * 这个最小矩形的高度为 2，宽度为 3，因此面积为 2 * 3 = 6。
 * 示例 2：
 * 输入： grid = [[0,0],[1,0]]
 * 输出： 1
 * 解释：
 * 这个最小矩形的高度和宽度都是 1，因此面积为 1 * 1 = 1。
 * 提示：
 * 1 <= grid.length, grid[i].length <= 1000
 * grid[i][j] 是 0 或 1。
 * 输入保证 grid 中至少有一个 1
 */
public class Solution3195 {
    public static void main(String[] args) {
        Solution3195 solution3195 = new Solution3195();
        int ans = solution3195.minimumArea(new int[][]{{0, 1, 0}, {1, 0, 1}});
        System.out.println(ans);
    }

    /**
     * 贪心 + 遍历
     * 找上下左右四个方向最边界的1即可
     * @param grid 0/1 矩阵
     * @return 包裹所有1的矩阵面积
     */
    public int minimumArea(int[][] grid) {
        int top = Integer.MAX_VALUE, bottom = Integer.MIN_VALUE;
        int left = Integer.MAX_VALUE, right = Integer.MIN_VALUE;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    top = Math.min(top, i);
                    left = Math.min(left, j);
                    bottom = Math.max(bottom, i);
                    right = Math.max(right, j);
                }
            }
        }
        return (bottom - top + 1) * (right - left + 1);
    }
}
