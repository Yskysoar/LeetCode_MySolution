import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2026-08-18 01:22
 * @description 3471. 找出最大的几近缺失整数
 * 给你一个整数数组 nums 和一个整数 k 。
 * 如果整数 x 恰好仅出现在 nums 中的一个大小为 k 的子数组中，则认为 x 是 nums 中的几近缺失（almost missing）整数。
 * 返回 nums 中 最大的几近缺失 整数，如果不存在这样的整数，返回 -1 。
 * 子数组 是数组中的一个连续元素序列。
 * 示例 1：
 * 输入：nums = [3,9,2,1,7], k = 3
 * 输出：7
 * 解释：
 * 1 出现在两个大小为 3 的子数组中：[9, 2, 1]、[2, 1, 7]
 * 2 出现在三个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1]、[2, 1, 7]
 * 3 出现在一个大小为 3 的子数组中：[3, 9, 2]
 * 7 出现在一个大小为 3 的子数组中：[2, 1, 7]
 * 9 出现在两个大小为 3 的子数组中：[3, 9, 2]、[9, 2, 1]
 * 返回 7 ，因为它满足题意的所有整数中最大的那个。
 * 示例 2：
 * 输入：nums = [3,9,7,2,1,7], k = 4
 * 输出：3
 * 解释：
 * 1 出现在两个大小为 4 的子数组中：[9, 7, 2, 1]、[7, 2, 1, 7]
 * 2 出现在三个大小为 4 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7]
 * 3 出现在一个大小为 4 的子数组中：[3, 9, 7, 2]
 * 7 出现在三个大小为 4 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]、[7, 2, 1, 7]
 * 9 出现在两个大小为 4 的子数组中：[3, 9, 7, 2]、[9, 7, 2, 1]
 * 返回 3 ，因为它满足题意的所有整数中最大的那个。
 * 示例 3：
 * 输入：nums = [0,0], k = 1
 * 输出：-1
 * 解释：
 * 不存在满足题意的整数。
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] <= 50
 * 1 <= k <= nums.length
 */
public class Solution3471 {

    /**
     * 只需要考虑左右两侧和k=1的情况即可，中间的元素在k>1且k!=nums.length的时候必定不可能实现唯一存在子数组
     * @param nums 数据数组
     * @param k    子数组的长度
     * @return 是否存在合法的元素
     */
    public int largestInteger(int[] nums, int k) {
        int ans = -1;
        if (k > 1) {
            int start = 0, end = 0;
            for (int num : nums) {
                if (num == nums[0]) start++;
                if (num == nums[nums.length - 1]) end++;
            }
            if (start == 1 && end == 1) {
                ans = Math.max(nums[0], nums[nums.length - 1]);
            } else if (start == 1) {
                ans = nums[0];
            } else if (end == 1) {
                ans = nums[nums.length - 1];
            }
            if (nums.length == k) {
                ans = Arrays.stream(nums).max().getAsInt();
            }
        } else {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            for (int num : nums) {
                hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
            }
            if (hashMap.size() != 1) {
                ans = hashMap.entrySet().stream().sorted(Map.Entry.<Integer, Integer>comparingByValue().thenComparing(Map.Entry.comparingByKey(Comparator.reverseOrder()))).map(Map.Entry::getKey).findFirst().orElseThrow(); // 如果 map 为空会抛异常
            }
        }
        return ans;
    }
}
    