import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-09-14 10:34
 * @description 1222.可以攻击国王的皇后
 * 在一个 8x8 的棋盘上，放置着若干「黑皇后」和一个「白国王」。
 * 给定一个由整数坐标组成的数组 queens ，表示黑皇后的位置；
 * 以及一对坐标 king ，表示白国王的位置，返回所有可以攻击国王的皇后的坐标(任意顺序)。
 * 示例 1：
 * 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
 * 输出：[[0,1],[1,0],[3,3]]
 * 解释：
 * [0,1] 的皇后可以攻击到国王，因为他们在同一行上。
 * [1,0] 的皇后可以攻击到国王，因为他们在同一列上。
 * [3,3] 的皇后可以攻击到国王，因为他们在同一条对角线上。
 * [0,4] 的皇后无法攻击到国王，因为她被位于 [0,1] 的皇后挡住了。
 * [4,0] 的皇后无法攻击到国王，因为她被位于 [1,0] 的皇后挡住了。
 * [2,4] 的皇后无法攻击到国王，因为她和国王不在同一行/列/对角线上。
 * 示例 2：
 * 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
 * 输出：[[2,2],[3,4],[4,4]]
 * 示例 3：
 * 输入：queens = [[5,6],[7,7],[2,1],[0,7],[1,6],[5,1],[3,7],[0,3],[4,0],[1,2],[6,3],[5,0],[0,4],[2,2],[1,1],[6,4],[5,4],[0,0],[2,6],[4,5],[5,2],[1,4],[7,5],[2,3],[0,5],[4,2],[1,0],[2,7],[0,1],[4,6],[6,1],[0,6],[4,3],[1,7]], king = [3,4]
 * 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
 */
public class Solution1222 {
    public static void main(String[] args) {
        Solution1222 solution1222 = new Solution1222();
        List<List<Integer>> ans = solution1222.queensAttacktheKing(new int[][]{{0,0},{1,1},{2,2},{3,4},{3,5},{4,4},{4,5}}, new int[]{3,3});
        System.out.println(ans);
    }

    /**
     * 暴力检索八个方向是否有皇后即可
     * @param queens 黑皇后坐标
     * @param king 白国王坐标
     * @return 可以进行攻击的黑皇后坐标组
     */
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int x = king[1];//白国王横坐标
        int y = king[0];//白国王纵坐标
        List<List<Integer>> ans = new ArrayList<>();
        int[][] grid = new int[8][8];
        grid[y][x] = 2;
        for (int[] queen : queens) grid[queen[0]][queen[1]] = 1;//绘制棋盘
        //水平
        for (int i = x - 1; i >= 0; i--) {//向左
            if (grid[y][i] == 1) {
                ans.add(Arrays.asList(y, i));
                break;
            }
        }
        for (int i = x + 1; i < grid.length; i++) {//向右
            if (grid[y][i] == 1) {
                ans.add(Arrays.asList(y, i));
                break;
            }
        }
        //垂直
        for (int i = y - 1; i >= 0; i--) {//向上
            if (grid[i][x] == 1) {
                ans.add(Arrays.asList(i, x));
                break;
            }
        }
        for (int i = y + 1; i < grid.length; i++) {//向下
            if (grid[i][x] == 1) {
                ans.add(Arrays.asList(i, x));
                break;
            }
        }
        //左斜线
        for (int i = 1; (x - i) >= 0 && (y - i) >= 0; i++) {
            if (grid[y - i][x - i] == 1) {
                ans.add(Arrays.asList(y - i, x - i));
                break;
            }
        }
        for (int i = 1; (x + i) < grid.length && (y + i) < grid.length; i++) {
            if (grid[y + i][x + i] == 1) {
                ans.add(Arrays.asList(y + i, x + i));
                break;
            }
        }
        //右斜线
        for (int i = 1; (x + i) < grid.length && (y - i) >= 0; i++) {
            if (grid[y - i][x + i] == 1) {
                ans.add(Arrays.asList(y - i, x + i));
                break;
            }
        }
        for (int i = 1; (x - i) >= 0 && (y + i) < grid.length; i++) {
            if (grid[y + i][x - i] == 1) {
                ans.add(Arrays.asList(y + i, x - i));
                break;
            }
        }
        return ans;
    }
}
