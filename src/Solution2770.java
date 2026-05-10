import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-05-10 21:17
 * @description 2770. 达到末尾下标所需的最大跳跃次数
 */
public class Solution2770 {
    public static void main(String[] args) {
        Solution2770 solution2770 = new Solution2770();
        int ans = solution2770.maximumJumps(new int[]{0,2,1,3}, 1);
        System.out.println(ans);
    }

    /**
     * dp[j]表示到达下标j所需的最大跳跃次数，状态转移方程为：dp[j] = max(j | j ∈ abs(nums[j] - nums[i]) <= target) + 1
     * @param nums   数据数组
     * @param target 差值
     * @return 最大跳跃次数
     */
    public int maximumJumps(int[] nums, int target) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != -1 && Math.abs(nums[i] - nums[j]) <= target) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[dp.length - 1];
    }
}