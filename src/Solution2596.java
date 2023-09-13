
/**
 * @author Yskysoar
 * @createTime 2023-09-13 23:14
 * @description 2596.检查骑士巡视方案
 * 骑士在一张 n x n 的棋盘上巡视。在 有效 的巡视方案中
 * 骑士会从棋盘的 左上角 出发，并且访问棋盘上的每个格子 恰好一次 。
 * 给你一个 n x n 的整数矩阵 grid ，由范围 [0, n * n - 1] 内的不同整数组成
 * 其中 grid[row][col] 表示单元格 (row, col) 是骑士访问的第 grid[row][col] 个单元格。
 * 骑士的行动是从下标 0 开始的。
 * 如果 grid 表示了骑士的有效巡视方案，返回 true；否则返回 false。
 * 注意，骑士行动时可以垂直移动两个格子且水平移动一个格子，或水平移动两个格子且垂直移动一个格子。
 * 示例 1：
 * 输入：grid = [[0,11,16,5,20],[17,4,19,10,15],[12,1,8,21,6],[3,18,23,14,9],[24,13,2,7,22]]
 * 输出：true
 * 解释：grid 如上图所示，可以证明这是一个有效地巡视方案。
 * 示例 2：
 * 输入：grid = [[0,3,6],[5,8,1],[2,7,4]]
 * 输出：false
 * 解释：grid 如上图所示，考虑到骑士第 7 次行动后的位置，第 8 次行动是无效的。
 */
public class Solution2596 {
    public static void main(String[] args) {
        Solution2596 solution2596 = new Solution2596();
        boolean ans = solution2596.checkValidGrid(new int[][]{{0, 3, 6}, {5, 8, 1}, {2, 7, 4}});
        System.out.println(ans);
    }

    /**
     * “日”字形检索距离：将所有位置的坐标获取然后一一匹配即可
     * @param grid 骑士位置图
     * @return 行动是否可行
     */
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) return false;//骑士一定从棋盘的 左上角 出发
        int[][] position = new int[grid.length * grid.length][2];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                position[grid[i][j]][0] = j;//横坐标
                position[grid[i][j]][1] = i;//纵坐标
            }
        }
        for (int i = 1; i < position.length; i++) {
            if (!checkPosition(position[i - 1], position[i])) return false;
        }
        return true;
    }

    /**
     * 检查坐标一是否可以移动到坐标二
     * @param p1 坐标一
     * @param p2 坐标二
     * @return true:可以移动
     */
    public boolean checkPosition(int[] p1, int[] p2) {
        //计算距离
        int x = Math.abs(p1[0] -p2[0]);//水平距离
        int y = Math.abs(p1[1] -p2[1]);//垂直距离
        //水平移动两个格子且垂直移动一个格子 或者 垂直移动两个格子且水平移动一个格子
        return (x == 2 && y == 1) || (x == 1 && y == 2);
    }
}
