/**
 * @author Yskysoar
 * @createTime 2025-01-16 12:42
 * @description 3095. 或值至少 K 的最短子数组 I
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空
 * 子数组
 * 的长度，如果特别子数组不存在，那么返回 -1 。
 * 示例 1：
 * 输入：nums = [1,2,3], k = 2
 * 输出：1
 * 解释：
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * 注意，[2] 也是一个特别子数组。
 * 示例 2：
 * 输入：nums = [2,1,8], k = 10
 * 输出：3
 * 解释：
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 * 示例 3：
 * 输入：nums = [1,2], k = 0
 * 输出：1
 * 解释：
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 0 <= k < 64
 */
public class Solution3095 {


    public int minimumSubarrayLength(int[] nums, int k) {
        int left = 0;//左边界 闭
        int right = 0;//右边界 闭
        int ans = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            int num = 0;
            for (int i = left; i <= right; i++) {
                num |= nums[i];
            }
            if (num < k) {
                right++;
            } else {
                ans = Math.min(ans, right - left + 1);
                left++;
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
