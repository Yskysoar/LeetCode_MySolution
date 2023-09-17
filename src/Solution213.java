/**
 * @author Yskysoar
 * @createTime 2023-09-17 11:32
 * @description 213.打家劫舍II
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
 * 这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 * 示例 1：
 * 输入：nums = [2,3,2]
 * 输出：3
 * 解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
 * 示例 2：
 * 输入：nums = [1,2,3,1]
 * 输出：4
 * 解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：3
 */
public class Solution213 {
    public static void main(String[] args) {
        Solution213 solution213 = new Solution213();
        int ans = solution213.rob(new int[]{1,7,9,2});
        System.out.println(ans);
    }

    /**
     * 动态规划：如果下标为0处偷了，那么n-1处就不能偷，因此考虑[0,n-2]的打家劫舍问题
     *         如果下标为0处不偷，那么n-1处可以偷，因此考虑[1,n-1]的打家劫舍问题
     *         最后比较二者大小即可
     * @param nums 每个房子的价值
     * @return 可以获取的最大总价值
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = nums[1];//不偷第一个房子
        for (int i = 3; i <= nums.length; i++) {//房间号[2,n]
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        dp[1] = nums[0];
        dp[2] = nums[0];//偷第一个房子
        for (int i = 3; i < nums.length; i++) {//房间号[1,n-1]
            dp[i] = Math.max(dp[i - 1], nums[i - 1] + dp[i - 2]);
        }
        return Math.max(dp[nums.length], dp[nums.length - 1]);
    }
}
