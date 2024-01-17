import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-08-24 22:25
 * @description 1267.统计参与通讯的服务器
 * 这里有一幅服务器分布图，服务器的位置标识在 m * n 的整数矩阵网格 grid 中，1 表示单元格上有服务器，0 表示没有。
 * 如果两台服务器位于同一行或者同一列，我们就认为它们之间可以进行通信。
 * 请你统计并返回能够与至少一台其他服务器进行通信的服务器的数量。
 * 示例 1：
 * 输入：grid = [[1,0],[0,1]]
 * 输出：0
 * 解释：没有一台服务器能与其他服务器进行通信。
 * 示例 2：
 * 输入：grid = [[1,0],[1,1]]
 * 输出：3
 * 解释：所有这些服务器都至少可以与一台别的服务器进行通信。
 * 示例 3：
 * 输入：grid = [[1,1,0,0],[0,0,1,0],[0,0,1,0],[0,0,0,1]]
 * 输出：4
 * 解释：第一行的两台服务器互相通信，第三列的两台服务器互相通信，但右下角的服务器无法与其他服务器通信。
 */
public class Solution1267 {
    public static void main(String[] args) {
        Solution1267 solution1267 = new Solution1267();
        int ans = solution1267.countServers3(new int[][]{{1, 1}, {1, 0}});
        System.out.println(ans);
    }

    /**
     * 暴力搜索：分别按行和列检索
     * @param grid 服务器分布矩阵
     * @return 可以通讯的服务器数量
     */
    public int countServers1(int[][] grid) {
        int[][] flag = new int[grid.length][grid[0].length];
        //按行查找
        for (int i = 0; i < grid.length; i++) {
            int col = 0;
            int num = 0;
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    flag[i][j] = 1;
                    num++;
                    col = (num == 1 ? j : col);//记录第一个服务器纵坐标
                }
            }
            if (num == 1) flag[i][col] = 0;//一行只有一个服务器就取消标记
        }
        //按列查找
        for (int i = 0; i < grid[0].length; i++) {
            int row = 0;
            int num = 0;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    flag[j][i]++;
                    num++;
                    row = (num == 1 ? j : row);
                }
            }
            if (num == 1) flag[row][i]--;
        }
        return (int) Arrays.stream(flag).flatMapToInt(Arrays::stream).filter(value -> value == 1 || value == 2).count();
    }

    /**
     * 哈希表：用哈希表保存当前行/列的服务器数量，只需要再遍历一次矩阵判断当前位置是否可通讯(当前位置有服务器且当前行/列的服务器数量大于1)
     * @param grid 服务器分布矩阵
     * @return 可以通讯的服务器数量
     */
    public int countServers2(int[][] grid) {
        HashMap<Integer, Integer> rows = new HashMap<>();
        HashMap<Integer, Integer> cols = new HashMap<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    rows.put(i, rows.getOrDefault(i, 0) + 1);//记录当前行服务器数量
                    cols.put(j, cols.getOrDefault(j, 0) + 1);//记录当前列服务器数量
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1 && (rows.get(i) > 1 || cols.get(j) > 1)) ans++;
            }
        }
        return ans;
    }

    /**
     * 等价替换：可通讯服务器数量 = 总服务器数量 - 不可通讯服务器数量
     * @param grid 服务器分布矩阵
     * @return 可以通讯的服务器数量
     */
    public int countServers3(int[][] grid) {
        int gridNums = 0;//总服务器数量
        int wrong = 0;//不可通讯服务器数量
        for (int[] value : grid) {
            int col = 0;
            int num = 0;
            for (int j = 0; j < value.length; j++) {
                if (value[j] == 1) {
                    gridNums++;//总服务器计数
                    num++;
                    col = (num == 1 ? j : col);//记录第一个服务器纵坐标
                }
            }
            if (num == 1) {//如果当前行只有一个服务器，判断当前列服务器数量
                int row = 0;
                for (int[] ints : grid) {
                    if (ints[col] == 1) row++;
                }
                if (row == 1) wrong++;
            }
        }
        return gridNums - wrong;
    }
}
