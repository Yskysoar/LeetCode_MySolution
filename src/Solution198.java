/**
 * @author Yskysoar
 * @createTime 2023-09-17 11:08
 * @description 198.打家劫舍
 * 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统
 * 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下
 * 一夜之内能够偷窃到的最高金额。
 * 示例 1：
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2：
 * 输入：[2,7,9,3,1]
 * 输出：12
 * 解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 */
public class Solution198 {
    public static void main(String[] args) {
        Solution198 solution198 = new Solution198();
        int ans = solution198.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(ans);
    }

    /**
     * 动态规划：dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1])
     * @param nums 每个房间的价值
     * @return 可以获取的最大金钱数量
     */
    public int rob(int[] nums) {
        int[] dp = new int[nums.length + 1];//索引值代表房子的号码
        dp[0] = 0;//边界值，无房子
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);//状态转移式
        }
        return dp[nums.length];
    }
}
