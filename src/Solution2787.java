import java.util.ArrayList;

/**
 * @author Yskysoar
 * @createTime 2025-08-12 15:22
 * @description 2787. 将一个数字表示成幂的和的方案数
 * 给你两个 正 整数 n 和 x 。
 * 请你返回将 n 表示成一些 互不相同 正整数的 x 次幂之和的方案数。换句话说，你需要返回互不相同整数 [n1, n2, ..., nk] 的集合数目，满足 n = n1^x + n2^x + ... + nk^x。
 * 由于答案可能非常大，请你将它对 10^9 + 7 取余后返回。
 * 比方说，n = 160 且 x = 3 ，一个表示 n 的方法是 n = 2^3 + 3^3 + 5^3 。
 * 示例 1：
 * 输入：n = 10, x = 2
 * 输出：1
 * 解释：我们可以将 n 表示为：n = 3^2 + 1^2 = 10 。
 * 这是唯一将 10 表达成不同整数 2 次方之和的方案。
 * 示例 2：
 * 输入：n = 4, x = 1
 * 输出：2
 * 解释：我们可以将 n 按以下方案表示：
 * - n = 4^1 = 4 。
 * - n = 3^1 + 1^1 = 4 。
 */
public class Solution2787 {
    public static void main(String[] args) {
        Solution2787 solution2787 = new Solution2787();
        int ans = solution2787.numberOfWays(213, 1);
        System.out.println(ans);
    }

    /**
     * dp + 01完全背包问题
     * 当前背包容量为n，有1~n个物品，每个物品的重量为i^x，要求选择一些不同的物品，使得背包恰好放满
     * @param n 背包容量
     * @param x 物品重量权重
     * @return 背包问题的方法数
     */
    public int numberOfWays(int n, int x) {
        int MOD = 1000000000 + 7;//取余
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; Math.pow(i, x) <= n; i++) {
            arrayList.add((int) Math.pow(i, x));
        }//记录所有可选范围内的x次方数
        int[][] dp = new int[arrayList.size() + 1][n + 1];//dp[i][j]表示当元素据为i^x，前i个元素之和为j的方法数
        dp[0][0] = 1;//初始化：前0个元素之和的方法数为1
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {//显然根据初始化定义，只要j等于0，那么一定会有一种方法
                if (arrayList.get(i - 1) > j) {//当前元素已经大于j，不可选择，和dp[i - 1][j]的方法数一样
                    dp[i][j] = dp[i - 1][j];
                } else {//当前元素小于等于j，方法数为两方案之和：①不选，和dp[i - 1][j]的方法数一样 ②选中，则还需要寻找dp[i - 1][j - i^x]的方法数
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arrayList.get(i - 1)]) % MOD;
                }
            }
        }
        return dp[arrayList.size()][n];
    }
}
