import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-02-06 13:40
 * @description 3634. 使数组平衡的最少移除数目
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果一个数组的 最大 元素的值 至多 是其 最小 元素的 k 倍，则该数组被称为是 平衡 的。
 * 你可以从 nums 中移除 任意 数量的元素，但不能使其变为 空 数组。
 * 返回为了使剩余数组平衡，需要移除的元素的 最小 数量。
 * 注意：大小为 1 的数组被认为是平衡的，因为其最大值和最小值相等，且条件总是成立。
 * 示例 1:
 * 输入：nums = [2,1,5], k = 2
 * 输出：1
 * 解释：
 * 移除 nums[2] = 5 得到 nums = [2, 1]。
 * 现在 max = 2, min = 1，且 max <= min * k，因为 2 <= 1 * 2。因此，答案是 1。
 * 示例 2:
 * 输入：nums = [1,6,2,9], k = 3
 * 输出：2
 * 解释：
 * 移除 nums[0] = 1 和 nums[3] = 9 得到 nums = [6, 2]。
 * 现在 max = 6, min = 2，且 max <= min * k，因为 6 <= 2 * 3。因此，答案是 2。
 * 示例 3:
 * 输入：nums = [4,6], k = 2
 * 输出：0
 * 解释：
 * 由于 nums 已经平衡，因为 6 <= 4 * 2，所以不需要移除任何元素。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 1 <= k <= 10^5
 */
public class Solution3634 {
    public static void main(String[] args) {
        Solution3634 solution3634 = new Solution3634();
        int ans = solution3634.minRemoval(new int[]{1, 6, 2, 9}, 3);
        System.out.println(ans);
    }

    /**
     * 排序 + 滑动窗口 + 溢出
     * 只要求数量，不要求顺序，限制最大值大小的关键是最小值和K，其中k不变，那么根据滑动窗口，左边界不动右边界滑动直到左边界限制上限，再移动左边界
     * @param nums 数据数组
     * @param k    限制参数
     * @return 实现最大平衡数组
     */
    public int minRemoval(int[] nums, int k) {
        int ans = 0;
        int left = 0, right = 0;
        Arrays.sort(nums);
        while (right < nums.length) {
            long num = (long) nums[left] * k;//数据量溢出
            if (nums[right] <= num) {
                right++;
            } else {
                ans = Math.max(ans, right - left);
                left++;
            }
        }
        return nums.length - Math.max(ans, right - left);
    }
}
