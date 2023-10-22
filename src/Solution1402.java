import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-10-22 13:09
 * @description 1402. 做菜顺序
 * 一个厨师收集了他 n 道菜的满意程度 satisfaction ，
 * 这个厨师做出每道菜的时间都是 1 单位时间。
 * 一道菜的 「 like-time 系数 」定义为烹饪这道菜结束的时间（包含之前每道菜所花费的时间）乘以这道菜的满意程度
 * 也就是 time[i]*satisfaction[i] 。
 * 返回厨师在准备了一定数量的菜肴后可以获得的最大 like-time 系数 总和。
 * 你可以按 任意 顺序安排做菜的顺序，你也可以选择放弃做某些菜来获得更大的总和。
 * 示例 1：
 * 输入：satisfaction = [-1,-8,0,5,-9]
 * 输出：14
 * 解释：去掉第二道和最后一道菜，最大的 like-time 系数和为 (-1*1 + 0*2 + 5*3 = 14)
 * 每道菜都需要花费 1 单位时间完成。
 * 示例 2：
 * 输入：satisfaction = [4,3,2]
 * 输出：20
 * 解释：可以按照任意顺序做菜 (2*1 + 3*2 + 4*3 = 20)
 * 示例 3：
 * 输入：satisfaction = [-1,-4,-5]
 * 输出：0
 * 解释：大家都不喜欢这些菜，所以不做任何菜就可以获得最大的 like-time 系数。
 */
public class Solution1402 {
    public static void main(String[] args) {
        Solution1402 solution1402 = new Solution1402();
        int ans = solution1402.maxSatisfaction2(new int[]{-1, -8, 0, 5, -9});
        System.out.println(ans);
    }

    /**
     * 动态规划：状态转移方程式dp[i][j]=max(dp[i - 1][j], dp[i - 1][j - 1] + j * satisfaction[i - 1])
     * @param satisfaction 菜品满意程度
     * @return 最大的like-time系数
     */
    public int maxSatisfaction1(int[] satisfaction) {
        int ans = 0;
        int[][] dp = new int[satisfaction.length + 1][satisfaction.length + 1];
        Arrays.sort(satisfaction);
        for (int i = 1; i <= satisfaction.length; i++) {//第i道菜品
            for (int j = 1; j <= i; j++) {//时间系数
                dp[i][j] = dp[i - 1][j - 1] + j * satisfaction[i - 1];
                if (j < i) dp[i][j] = Math.max(dp[i - 1][j], dp[i][j]);
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }

    public int maxSatisfaction2(int[] satisfaction) {
        int ans = 0;
        Arrays.sort(satisfaction);
        int[] num = new int[satisfaction.length];
        for (int i = 0; i < num.length; i++) {
            for (int j = 1; j <= i + 1; j++) {
                num[i] += satisfaction[satisfaction.length - 1 - (i + 1) + j] * j;
            }
            ans = Math.max(ans, num[i]);
        }
        return ans;
    }
}
