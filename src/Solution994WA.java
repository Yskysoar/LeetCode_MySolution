import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2024-05-13 22:43
 * @description 994. 腐烂的橘子
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 * 值 0 代表空单元格；
 * 值 1 代表新鲜橘子；
 * 值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 * 示例 1：
 * 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
 * 输出：4
 * 示例 2：
 * 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
 * 输出：-1
 * 解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个方向上。
 * 示例 3：
 * 输入：grid = [[0,2]]
 * 输出：0
 * 解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 10
 * grid[i][j] 仅为 0、1 或 2
 */
public class Solution994WA {
    public static void main(String[] args) {
        Solution994WA solution994WA = new Solution994WA();
        int ans = solution994WA.orangesRotting(new int[][]{{2,1,1},{0,1,1},{1,0,1}});
        System.out.println(ans);
    }

    public int orangesRotting(int[][] grid) {
        int ans = 0;
        int[][] arrays = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            arrays[i] = Arrays.copyOf(grid[i], grid[i].length);
        }
        ArrayList<int[]> arrayList = new ArrayList<>();
        while (true) {
            for (int x = 0; x < grid.length; x++) {
                for (int y = 0; y < grid[x].length; y++) {
                    if (grid[x][y] == 2) arrayList.add(new int[]{x, y});
                }
            }
            for (int[] ints : arrayList) {
                updateGrid(grid, ints[0], ints[1]);
            }
            arrayList.clear();
            int num = 0;
            for (int i = 0; i < grid.length; i++) {
                if (Arrays.equals(grid[i], arrays[i])) num++;
                if (num == grid.length) return ans;
            }
            for (int i = 0; i < grid.length; i++) {
                arrays[i] = Arrays.copyOf(grid[i], grid[i].length);
            }
            ans++;
        }
    }

    public void updateGrid(int[][] grid, int x, int y) {
        if (y - 1 >= 0 && grid[x][y - 1] != 0) grid[x][y - 1] = 2;
        if (y + 1 <= grid[0].length - 1 && grid[x][y + 1] != 0) grid[x][y + 1] = 2;
        if (x - 1 >= 0 && grid[x - 1][y] != 0) grid[x - 1][y] = 2;
        if (x + 1 <= grid.length - 1 && grid[x + 1][y] != 0) grid[x + 1][y] = 2;
    }


}
