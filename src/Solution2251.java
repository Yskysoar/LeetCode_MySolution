import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-09-28 17:07
 * @description 2251.花旗内花的数目
 * 给你一个下标从 0 开始的二维整数数组 flowers ，其中 flowers[i] = [starti, endi] 表示第 i 朵花的 花期
 * 从 starti 到 endi （都 包含）。同时给你一个下标从 0 开始大小为 n 的整数数组 people ，
 * people[i] 是第 i 个人来看花的时间。
 * 请你返回一个大小为 n 的整数数组 answer ，其中 answer[i]是第 i 个人到达时在花期内花的 数目 。
 * 示例 1：
 * 输入：flowers = [[1,6],[3,7],[9,12],[4,13]], people = [2,3,7,11]
 * 输出：[1,2,2,2]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 * 示例 2：
 * 输入：flowers = [[1,10],[3,3]], people = [3,3,2]
 * 输出：[2,2,1]
 * 解释：上图展示了每朵花的花期时间，和每个人的到达时间。
 * 对每个人，我们返回他们到达时在花期内花的数目。
 */
public class Solution2251 {
    public static void main(String[] args) {
        Solution2251 solution2251 = new Solution2251();
        int[] ans = solution2251.fullBloomFlowers2(new int[][]{{1, 6}, {3, 7}, {9, 12}, {4, 13}}, new int[]{2, 3, 7, 11});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 暴力存储(内存消耗大)
     * @param flowers 花期
     * @param people 看花时间
     * @return 可以看见的花数
     */
    public int[] fullBloomFlowers1(int[][] flowers, int[] people) {
        int[] graph = new int[1000000000];
        for (int[] flower : flowers) {
            for (int j = flower[0]; j <= flower[1]; j++) {
                graph[j]++;
            }
        }
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            ans[i] = graph[people[i]];
        }
        return ans;
    }

    /**
     * 暴力遍历(超时)
     * @param flowers 花期
     * @param people 看花时间
     * @return 可以看见的花数
     */
    public int[] fullBloomFlowers2(int[][] flowers, int[] people) {
        int[] ans = new int[people.length];
        for (int i = 0; i < people.length; i++) {
            for (int[] flower : flowers) {
                if (flower[0] <= people[i] && people[i] <= flower[1]) ans[i]++;
            }
        }
        return ans;
    }
}
