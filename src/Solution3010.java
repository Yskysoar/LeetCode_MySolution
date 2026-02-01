import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-02-01 12:48
 * @description 3010. 将数组分成最小总代价的子数组 I
 * 给你一个长度为 n 的整数数组 nums 。
 * 一个数组的 代价 是它的 第一个 元素。比方说，[1,2,3] 的代价是 1 ，[3,4,1] 的代价是 3 。
 * 你需要将 nums 分成 3 个 连续且没有交集 的子数组。
 * 请你返回这些子数组的 最小 代价 总和 。
 * 示例 1：
 * 输入：nums = [1,2,3,12]
 * 输出：6
 * 解释：最佳分割成 3 个子数组的方案是：[1] ，[2] 和 [3,12] ，总代价为 1 + 2 + 3 = 6 。
 * 其他得到 3 个子数组的方案是：
 * - [1] ，[2,3] 和 [12] ，总代价是 1 + 2 + 12 = 15 。
 * - [1,2] ，[3] 和 [12] ，总代价是 1 + 3 + 12 = 16 。
 * 示例 2：
 * 输入：nums = [5,4,3]
 * 输出：12
 * 解释：最佳分割成 3 个子数组的方案是：[5] ，[4] 和 [3] ，总代价为 5 + 4 + 3 = 12 。
 * 12 是所有分割方案里的最小总代价。
 * 示例 3：
 * 输入：nums = [10,3,1,1]
 * 输出：12
 * 解释：最佳分割成 3 个子数组的方案是：[10,3] ，[1] 和 [1] ，总代价为 10 + 1 + 1 = 12 。
 * 12 是所有分割方案里的最小总代价。
 * 提示：
 * 3 <= n <= 50
 * 1 <= nums[i] <= 50
 */
public class Solution3010 {
    public static void main(String[] args) {
        Solution3010 solution3010 = new Solution3010();
        int ans = solution3010.minimumCost(new int[]{1, 2, 3, 12});
        System.out.println(ans);
    }

    /**
     * 排序 + 贪心
     * @param nums 数据数组
     * @return 合法分割后的最小总代价
     */
    public int minimumCost(int[] nums) {
        int ans = nums[0];//第一个元素一定是一个子数组的代价
        int[] newNums = new int[nums.length - 1];
        System.arraycopy(nums, 1, newNums, 0, nums.length - 1);
        Arrays.sort(newNums);
        ans += newNums[0] + newNums[1];
        return ans;
    }
}
