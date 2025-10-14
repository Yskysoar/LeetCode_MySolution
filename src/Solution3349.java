import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-10-14 10:13
 * @description 3349. 检测相邻递增子数组 I
 * 给你一个由 n 个整数组成的数组 nums 和一个整数 k，请你确定是否存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 如果可以找到这样的 两个 子数组，请返回 true；否则返回 false。
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * 示例 1：
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1], k = 3
 * 输出：true
 * 解释：
 * 从下标 2 开始的子数组为 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组为 [2, 3, 4]，它也是严格递增的。
 * 两个子数组是相邻的，因此结果为 true。
 * 示例 2：
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7], k = 5
 * 输出：false
 * 提示：
 * 2 <= nums.length <= 100
 * 1 <= 2 * k <= nums.length
 * -1000 <= nums[i] <= 1000
 */
public class Solution3349 {

    /**
     * 双指针
     * @param nums 同时检查两个子数组是否都严格递增即可，只要有一个子数组不符合要求就重新开始计数
     * @param k    子数组长度
     * @return 是否存在这样的相邻子数组
     */
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int length = 0;
        if (k == 1) return true;
        for (int i = 0; i + 1 + k < nums.size(); i++) {
            if (nums.get(i) < nums.get(i + 1) && nums.get(i + k) < nums.get(i + 1 + k)) {
                length++;
            } else {//出现不符合严格递增，重新开始计数
                length = 0;
            }
            if (length + 1 == k) {//存在一组即可
                return true;
            }
        }
        return false;
    }
}
