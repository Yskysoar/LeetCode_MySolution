import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yskysoar
 * @createTime 2026-07-20 10:39
 * @description 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 * 位于 grid[i][j]（j < n - 1）的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 * 示例 1：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
 * 输出：[[9,1,2],[3,4,5],[6,7,8]]
 * 示例 2：
 * 输入：grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
 * 输出：[[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
 * 示例 3：
 * 输入：grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
 * 输出：[[1,2,3],[4,5,6],[7,8,9]]
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m <= 50
 * 1 <= n <= 50
 * -1000 <= grid[i][j] <= 1000
 * 0 <= k <= 100
 */
public class Solution1260 {
    public static void main(String[] args) {
        Solution1260 solution1260 = new Solution1260();
        List<List<Integer>> ans = solution1260.shiftGrid(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        for (List<Integer> list : ans) {
            System.out.println(list);
        }
    }

    /**
     * 空间换时间
     * @param grid 二维原数组
     * @param k    迁移次数
     * @return 迁移后结果
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int[] nums = new int[grid.length * grid[0].length];
        int index = 0;
        for (int[] ints : grid) {
            for (int num : ints) {
                nums[index++] = num;
            }
        }
        index -= (k % nums.length);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (index >= nums.length) index = 0;
                grid[i][j] = nums[index++];
            }
        }
        return Arrays.stream(grid)
                .map(row -> Arrays.stream(row)      // IntStream
                        .boxed()                    // 装箱为 Stream<Integer>
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
    }
}
    