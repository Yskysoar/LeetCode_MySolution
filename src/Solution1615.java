import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-03-15 21:29
 * @description 1615. 最大网络秩
 * n 座城市和一些连接这些城市的道路 roads 共同组成一个基础设施网络。每个 roads[i] = [ai, bi] 都表示在城市 ai 和 bi 之间有一条双向道路。
 * 两座不同城市构成的 城市对 的 网络秩 定义为：与这两座城市 直接 相连的道路总数。如果存在一条道路直接连接这两座城市，则这条道路只计算 一次 。
 * 整个基础设施网络的 最大网络秩 是所有不同城市对中的 最大网络秩 。
 * 给你整数 n 和数组 roads，返回整个基础设施网络的 最大网络秩 。
 * 示例 1：
 * 输入：n = 4, roads = [[0,1],[0,3],[1,2],[1,3]]
 * 输出：4
 * 解释：城市 0 和 1 的网络秩是 4，因为共有 4 条道路与城市 0 或 1 相连。位于 0 和 1 之间的道路只计算一次。
 * 示例 2：
 * 输入：n = 5, roads = [[0,1],[0,3],[1,2],[1,3],[2,3],[2,4]]
 * 输出：5
 * 解释：共有 5 条道路与城市 1 或 2 相连。
 * 示例 3：
 * 输入：n = 8, roads = [[0,1],[1,2],[2,3],[2,4],[5,6],[5,7]]
 * 输出：5
 * 解释：2 和 5 的网络秩为 5，注意并非所有的城市都需要连接起来。
 */

public class Solution1615 {
    public static void main(String[] args) {
        Solution1615 solution1615 = new Solution1615();
        int ans = solution1615.maximalNetworkRank2(8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}});
        System.out.println(ans);
    }

    /**
     * 暴力：先记录每个城市连接的城市数，然后一一寻找最大连接方式
     * @param n     城市数
     * @param roads 连接方式
     * @return 两个城市可连接的最多城市数
     */
    public int maximalNetworkRank1(int n, int[][] roads) {
        int ans = 0;
        int[] num = new int[n];//元素维护线路数，下标维护城市名
        for (int[] road : roads) {
            num[road[0]]++;
            num[road[1]]++;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                for (int[] road : roads) {
                    if (Arrays.equals(road, new int[]{i, j}) || Arrays.equals(road, new int[]{j, i})) {
                        sum--;
                        break;
                    }
                }
                ans = Math.max(sum, ans);
            }
        }
        return ans;
    }

    /**
     * 暴力：先记录每个城市连接的城市数，然后一一寻找最大连接方式(数组维护连接方式，减少一轮循环)
     * @param n     城市数
     * @param roads 连接方式
     * @return 两个城市可连接的最多城市数
     */
    public int maximalNetworkRank2(int n, int[][] roads) {
        int ans = 0;
        int[] num = new int[n];//元素维护线路数，下标维护城市名
        int[][] nums = new int[n][n];//记录连接方式
        for (int[] road : roads) {
            nums[road[0]][road[1]] = 1;
            nums[road[1]][road[0]] = 1;
            num[road[0]]++;
            num[road[1]]++;
        }
        for (int i = 0; i < num.length; i++) {
            for (int j = i + 1; j < num.length; j++) {
                ans = Math.max(ans, (nums[i][j] == 1 ? num[i] + num[j] - 1 : num[i] + num[j]));
            }
        }
        return ans;
    }
}

