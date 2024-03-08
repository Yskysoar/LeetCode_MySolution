/**
 * @author Yskysoar
 * @createTime 2024-03-08 9:28
 * @description 2834. 找出美丽数组的最小和
 * 给你两个正整数： 和 。ntarget
 * 如果数组 满足下述条件，则称其为 美丽数组 。nums
 * nums.length == n.
 * nums 由两两互不相同的正整数组成。
 * 在范围 内，不存在 两个 不同 下标 和 ，使得 。[0, n-1]ijnums[i] + nums[j] == target
 * 返回符合条件的美丽数组所可能具备的 最小 和，并对结果进行取模 。109 + 7
 * 示例 1：
 * 输入：n = 2, target = 3
 * 输出：4
 * 解释：nums = [1,3] 是美丽数组。
 * - nums 的长度为 n = 2 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 4 是符合条件的美丽数组所可能具备的最小和。
 * 示例 2：
 * 输入：n = 3, target = 3
 * 输出：8
 * 解释：
 * nums = [1,3,4] 是美丽数组。
 * - nums 的长度为 n = 3 。
 * - nums 由两两互不相同的正整数组成。
 * - 不存在两个不同下标 i 和 j ，使得 nums[i] + nums[j] == 3 。
 * 可以证明 8 是符合条件的美丽数组所可能具备的最小和。
 * 示例 3：
 * 输入：n = 1, target = 1
 * 输出：1
 * 解释：nums = [1] 是美丽数组。
 * 提示：
 * 1 <= n <= 10^9
 * 1 <= target <= 10^9
 */
public class Solution2834 {
    public static void main(String[] args) {
        Solution2834 solution2834 = new Solution2834();
        int ans = solution2834.minimumPossibleSum(1000000000, 1000000000);
        System.out.println(ans);
    }

    /**
     * 贪心算法：每次都取较小的因子(target的所有构成为：<1,target-1>、<2,target-2>...),超过target/2后，直接从target开始取(全是正整数)
     * @param n      美丽数组的长度
     * @param target 目标值
     * @return 美丽数组的元素和
     */
    public int minimumPossibleSum(int n, int target) {
        int mod = 1000000007;
        long ans = 0L;
        if (n > (target / 2)) {//美丽数组的长度比target的一半更长，需要从target开始补充
            ans = (((long) (1 + (target / 2)) * (target / 2) / 2 +
                    ((long) target + target + (n - (target / 2)) - 1) * (n - (target / 2)) / 2) % mod);
        } else {
            ans = (((long) (1 + n) * n) / 2) % mod;
        }
        return (int) ans;
    }
}
