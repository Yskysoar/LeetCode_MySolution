import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Yskysoar
 * @createTime 2025-08-28 1:26
 * @description 3446. 按对角线进行矩阵排序
 * 给你一个大小为 n x n 的整数方阵 grid。返回一个经过如下调整的矩阵：
 * 左下角三角形（包括中间对角线）的对角线按 非递增顺序 排序。
 * 右上角三角形 的对角线按 非递减顺序 排序。
 * 示例 1：
 * 输入： grid = [[1,7,3],[9,8,2],[4,5,6]]
 * 输出： [[8,2,3],[9,6,7],[4,5,1]]
 * 解释：
 * 标有黑色箭头的对角线（左下角三角形）应按非递增顺序排序：
 * [1, 8, 6] 变为 [8, 6, 1]。
 * [9, 5] 和 [4] 保持不变。
 * 标有蓝色箭头的对角线（右上角三角形）应按非递减顺序排序：
 * [7, 2] 变为 [2, 7]。
 * [3] 保持不变。
 * 示例 2：
 * 输入： grid = [[0,1],[1,2]]
 * 输出： [[2,1],[1,0]]
 * 解释：
 * 标有黑色箭头的对角线必须按非递增顺序排序，因此 [0, 2] 变为 [2, 0]。其他对角线已经符合要求。
 * 示例 3：
 * 输入： grid = [[1]]
 * 输出： [[1]]
 * 解释：
 * 只有一个元素的对角线已经符合要求，因此无需修改。
 * 提示：
 * grid.length == grid[i].length == n
 * 1 <= n <= 10
 * -10^5 <= grid[i][j] <= 10^5
 */
public class Solution3446 {
    public static void main(String[] args) {
        Solution3446 solution3446 = new Solution3446();
        int[][] ans = solution3446.sortMatrix(new int[][]{{1, 7, 3}, {9, 8, 2}, {4, 5, 6}});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 模拟 + 排序
     * @param grid 待排序矩阵
     * @return 每一个对角线按照要求排序后的矩阵
     */
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length;
        //左下角三角形（包括中间对角线）的对角线数据  按照递减排序
        for (int i = n - 1; i >= 0; i--) {
            ArrayList<Integer> num = new ArrayList<>();
            for (int j = 0; j <= n - 1 - i; j++) {
                num.add(grid[i + j][j]);
            }
            num.sort(Comparator.comparingInt((Integer x) -> x).reversed());
            for (int j = 0; j <= n - 1 - i; j++) {
                grid[i + j][j] = num.get(j);
            }
        }
        //右上角三角形的对角线数据  按照递增排序
        for (int j = n - 1; j > 0; j--) {
            ArrayList<Integer> num = new ArrayList<>();
            for (int i = 0; i <= n - 1 - j; i++) {
                num.add(grid[i][i + j]);
            }
            num.sort(Comparator.comparingInt(x -> x));
            for (int i = 0; i <= n - 1 - j; i++) {
                grid[i][i + j] = num.get(i);
            }
        }
        return grid;
    }
}
