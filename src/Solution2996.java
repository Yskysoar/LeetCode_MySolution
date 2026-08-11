import java.util.HashSet;
import java.util.Set;

/**
 * @author Yskysoar
 * @createTime 2026-08-11 23:48
 * @description 2996. 大于等于顺序前缀和的最小缺失整数
 * 给你一个下标从 0 开始的整数数组 nums 。
 * 如果一个前缀 nums[0..i] 满足对于 1 <= j <= i 的所有元素都有 nums[j] = nums[j - 1] + 1 ，
 * 那么我们称这个前缀是一个 顺序前缀 。特殊情况是，只包含 nums[0] 的前缀也是一个
 * 顺序前缀 。
 * 请你返回 nums 中没有出现过的 最小 整数 x ，满足 x 大于等于 最长 顺序前缀的和。
 * 示例 1：
 * 输入：nums = [1,2,3,2,5]
 * 输出：6
 * 解释：nums 的最长顺序前缀是 [1,2,3] ，和为 6 ，6 不在数组中，所以 6 是大于等于最长顺序前缀和的最小整数。
 * 示例 2：
 * 输入：nums = [3,4,5,1,12,14,13]
 * 输出：15
 * 解释：nums 的最长顺序前缀是 [3,4,5] ，和为 12 ，12、13 和 14 都在数组中，但 15 不在，所以 15 是大于等于最长顺序前缀和的最小整数。
 * 提示：
 * 1 <= nums.length <= 50
 * 1 <= nums[i] <= 50
 */
public class Solution2996 {
    public static void main(String[] args) {
        Solution2996 solution2996 = new Solution2996();
        int ans = solution2996.missingInteger1(new int[]{37,1,2,9,5,8,5,2,9,4});
        System.out.println(ans);
    }

    /**
     * 前缀和 + set表
     * @param nums 数据数组
     * @return 合法的最小整数
     */
    public int missingInteger1(int[] nums) {
        int n = nums.length;
        Set<Integer> numSet = new HashSet<>(n);
        for (int num : nums) {
            numSet.add(num);
        }
        int total = nums[0];

        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1] + 1) {
                total += nums[i];
            } else {
                break;
            }
        }

        while (numSet.contains(total)) {
            total += 1;
        }

        return total;
    }

    /**
     * PLUS版
     * @param nums 数据数组
     * @return 最长顺序组
     */
    public int missingInteger2(int[] nums) {
        int start = 0, end = 0, length = Integer.MIN_VALUE, sum = nums[0], ans;
        int[] preSum = new int[nums.length + 1];
        HashSet<Integer> numSet = new HashSet<>();
        numSet.add(nums[0]);
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = nums[i] + preSum[i];
            numSet.add(nums[i]);
        }//计算前缀和
        while (end + 1 < nums.length) {
            while (end + 1 < nums.length && nums[end + 1] == nums[end] + 1) end++;
            if (end - start + 1 > length) {
                length = end - start + 1;
                sum = preSum[end + 1] - preSum[start];
            }
            start = end + 1;
            end = start;
        }
        ans = sum;
        while (numSet.contains(ans)) {
            ans++;
        }
        return ans;
    }
}
    