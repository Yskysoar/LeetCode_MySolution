import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-04-28 0:37
 * @description 2033. 获取单值网格的最小操作数
 * 给你一个大小为 m x n 的二维整数网格 grid 和一个整数 x 。每一次操作，你可以对 grid 中的任一元素 加 x 或 减 x 。
 * 单值网格 是全部元素都相等的网格。
 * 返回使网格化为单值网格所需的 最小 操作数。如果不能，返回 -1 。
 * 示例 1：
 * 输入：grid = [[2,4],[6,8]], x = 2
 * 输出：4
 * 解释：可以执行下述操作使所有元素都等于 4 ：
 * - 2 加 x 一次。
 * - 6 减 x 一次。
 * - 8 减 x 两次。
 * 共计 4 次操作。
 * 示例 2：
 * 输入：grid = [[1,5],[2,3]], x = 1
 * 输出：5
 * 解释：可以使所有元素都等于 3 。
 * 示例 3：
 * 输入：grid = [[1,2],[3,4]], x = 2
 * 输出：-1
 * 解释：无法使所有元素相等。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 105
 * 1 <= m * n <= 105
 * 1 <= x, grid[i][j] <= 10^4
 */
public class Solution2033 {
    public static void main(String[] args) {
        Solution2033 solution2033 = new Solution2033();
        int ans = solution2033.minOperations(new int[][]{{146}}, 86);
        System.out.println(ans);
    }

    /**
     * 贪心算法
     * 为了操作的次数最少，最终的中间值应该限定在Min~Max之间，取中间值判断最小的操作次数即可
     * @param grid 待操作矩阵
     * @param x    操作数
     * @return 最小操作次数
     */
    public int minOperations(int[][] grid, int x) {
        if (grid.length * grid[0].length == 1) return 0;
        int[] nums = new int[grid.length * grid[0].length];//mxn记录元素
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                nums[i * grid[i].length + j] = grid[i][j];
            }
        }
        Arrays.sort(nums);
        int count1 = 0, count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                if ((nums[nums.length / 2] - nums[i]) % x != 0) return -1;
                count1 += (nums[nums.length / 2] - nums[i]) / x;
            } else {
                if ((nums[i] - nums[nums.length / 2]) % x != 0) return -1;
                count1 += (nums[i] - nums[nums.length / 2]) / x;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (i < nums.length / 2) {
                if ((nums[nums.length / 2 - 1] - nums[i]) % x != 0) return -1;
                count2 += (nums[nums.length / 2 - 1] - nums[i]) / x;
            } else {
                if ((nums[i] - nums[nums.length / 2 - 1]) % x != 0) return -1;
                count2 += (nums[i] - nums[nums.length / 2 - 1]) / x;
            }
        }
        return Math.min(count1, count2);
    }
}
