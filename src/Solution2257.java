/**
 * @author Yskysoar
 * @createTime 2025-11-02 11:12
 * @description 2257. 统计网格图中没有被保卫的格子数
 * 给你两个整数 m 和 n 表示一个下标从 0 开始的 m x n 网格图。同时给你两个二维整数数组 guards 和 walls ，其中 guards[i] = [rowi, coli] 且 walls[j] = [rowj,
 * colj] ，分别表示第 i 个警卫和第 j 座墙所在的位置。
 * 一个警卫能看到 4 个坐标轴方向（即东、南、西、北）的 所有 格子，除非他们被一座墙或者另外一个警卫 挡住 了视线。如果一个格子能被 至少 一个警卫看到，那么我们说这个格子被 保卫 了。
 * 请你返回空格子中，有多少个格子是 没被保卫 的。
 * 示例 1：
 * 输入：m = 4, n = 6, guards = [[0,0],[1,1],[2,3]], walls = [[0,1],[2,2],[1,4]]
 * 输出：7
 * 解释：上图中，被保卫和没有被保卫的格子分别用红色和绿色表示。
 * 总共有 7 个没有被保卫的格子，所以我们返回 7 。
 * 示例 2：
 * 输入：m = 3, n = 3, guards = [[1,1]], walls = [[0,1],[1,0],[2,1],[1,2]]
 * 输出：4
 * 解释：上图中，没有被保卫的格子用绿色表示。
 * 总共有 4 个没有被保卫的格子，所以我们返回 4 。
 * 提示：
 * 1 <= m, n <= 10^5
 * 2 <= m * n <= 10^5
 * 1 <= guards.length, walls.length <= 5 * 10^4
 * 2 <= guards.length + walls.length <= m * n
 * guards[i].length == walls[j].length == 2
 * 0 <= row_i, row_j < m
 * 0 <= col_i, col_j < n
 * guards 和 walls 中所有位置 互不相同 。
 */
public class Solution2257 {

    /**
     * 模拟（守卫视角）
     * @param m      行数
     * @param n      列数
     * @param guards 守卫坐标
     * @param walls  墙坐标
     * @return 无法被守护的坐标
     */
    public int countUnguarded0(int m, int n, int[][] guards, int[][] walls) {
        int ans = m * n - guards.length - walls.length;
        int[][] grids = new int[m][n];//1是守卫 2是墙 -1是可以被保护的格子
        for (int[] guard : guards) {
            grids[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grids[wall[0]][wall[1]] = 2;
        }
        for (int[] guard : guards) {
            //上
            for (int i = guard[0] - 1; i >= 0; i--) {
                if (grids[i][guard[1]] == 1 || grids[i][guard[1]] == 2) break;
                if (grids[i][guard[1]] == 0) {
                    grids[i][guard[1]] = -1;
                    ans--;
                }
            }
            //下
            for (int i = guard[0] + 1; i < m; i++) {
                if (grids[i][guard[1]] == 1 || grids[i][guard[1]] == 2) break;
                if (grids[i][guard[1]] == 0) {
                    grids[i][guard[1]] = -1;
                    ans--;
                }
            }
            //左
            for (int j = guard[1] - 1; j >= 0; j--) {
                if (grids[guard[0]][j] == 1 || grids[guard[0]][j] == 2) break;
                if (grids[guard[0]][j] == 0) {
                    grids[guard[0]][j] = -1;
                    ans--;
                }
            }
            //右
            for (int j = guard[1] + 1; j < n; j++) {
                if (grids[guard[0]][j] == 1 || grids[guard[0]][j] == 2) break;
                if (grids[guard[0]][j] == 0) {
                    grids[guard[0]][j] = -1;
                    ans--;
                }
            }
        }
        return ans;
    }

    /**
     * 模拟（坐标视角）
     * 单个方向只有经过了守卫，才会有视野
     * @param m      行数
     * @param n      列数
     * @param guards 守卫坐标
     * @param walls  墙坐标
     * @return 无法被守护的坐标
     */
    public int countUnguarded1(int m, int n, int[][] guards, int[][] walls) {
        int ans = 0;
        int[][] grid = new int[m][n];//1是守卫 2是墙 -1是可以被保护的格子
        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 1;
        }
        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 2;
        }
        // 水平方向扫描
        for (int i = 0; i < m; i++) {
            boolean seen = false;
            // 左 -> 右
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    seen = false;
                } else if (grid[i][j] == 1) {
                    seen = true;
                } else if (seen) {
                    grid[i][j] = -1;
                }
            }
            seen = false;
            // 右 -> 左
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 2) {
                    seen = false;
                } else if (grid[i][j] == 1) {
                    seen = true;
                } else if (seen) {
                    grid[i][j] = -1;
                }
            }
        }

        // 垂直方向扫描
        for (int j = 0; j < n; j++) {
            boolean seen = false;
            // 下 -> 上
            for (int i = m - 1; i >= 0; i--) {
                if (grid[i][j] == 2) {
                    seen = false;
                } else if (grid[i][j] == 1) {
                    seen = true;
                } else if (seen) {
                    grid[i][j] = -1;
                }
            }
            seen = false;
            // 上 -> 下
            for (int i = 0; i < m; i++) {
                if (grid[i][j] == 2) {
                    seen = false;
                } else if (grid[i][j] == 1) {
                    seen = true;
                } else if (seen) {
                    grid[i][j] = -1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) ans++;
            }
        }
        return ans;
    }
}
