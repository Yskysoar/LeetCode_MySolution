import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-10-15 9:54
 * @description 3350. 检测相邻递增子数组 II
 * 给你一个由 n 个整数组成的数组 nums ，请你找出 k 的 最大值，使得存在 两个 相邻 且长度为 k 的 严格递增 子数组。具体来说，需要检查是否存在从下标 a 和 b (a < b) 开始的 两个 子数组，并满足下述全部条件：
 * 这两个子数组 nums[a..a + k - 1] 和 nums[b..b + k - 1] 都是 严格递增 的。
 * 这两个子数组必须是 相邻的，即 b = a + k。
 * 返回 k 的 最大可能 值。
 * 子数组 是数组中的一个连续 非空 的元素序列。
 * 示例 1：
 * 输入：nums = [2,5,7,8,9,2,3,4,3,1]
 * 输出：3
 * 解释：
 * 从下标 2 开始的子数组是 [7, 8, 9]，它是严格递增的。
 * 从下标 5 开始的子数组是 [2, 3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 3 是满足题目条件的 最大 k 值。
 * 示例 2：
 * 输入：nums = [1,2,3,4,4,4,4,5,6,7]
 * 输出：2
 * 解释：
 * 从下标 0 开始的子数组是 [1, 2]，它是严格递增的。
 * 从下标 2 开始的子数组是 [3, 4]，它也是严格递增的。
 * 这两个子数组是相邻的，因此 2 是满足题目条件的 最大 k 值。
 * 提示：
 * 2 <= nums.length <= 2 * 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution3350 {
    public static void main(String[] args) {
        Solution3350 solution3350 = new Solution3350();
        int ans = solution3350.maxIncreasingSubarrays(new ArrayList<>(List.of(-8, 0, 5, 18, -9)));
        System.out.println(ans);
    }

    /**
     * 遍历+ 双指针 + 数学（可优化）
     * 最大的相邻子数组的长度来源只有：①单一的一个单增数组分成两半 ②两个相邻的子数组取较小长度
     * 先双指针遍历数据，找出所有的严格单调递增子数组，然后再按照上面的逻辑去寻找即可
     * @param nums 数据数组
     * @return 最大的相邻子数组的长度
     */
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int ans = Integer.MIN_VALUE;
        ArrayList<int[]> arrayList = new ArrayList<>();
        for (int i = 0, j = 0; j + 1 <= nums.size(); j++) {
            if (j == nums.size() - 1) {
                if (nums.get(j) > nums.get(j - 1)) {
                    arrayList.add(new int[]{i, j, j - i + 1});
                } else {
                    arrayList.add(new int[]{j, j, 1});
                }
            } else if (nums.get(j) >= nums.get(j + 1)) {
                arrayList.add(new int[]{i, j, j - i + 1});
                i = j + 1;
            }
        }
        for (int i = 0; i + 1 < arrayList.size(); i++) {
            if (arrayList.get(i)[1] + 1 == arrayList.get(i + 1)[0]) {//两个递增子数组相邻
                ans = Math.max(ans, Math.min(arrayList.get(i)[2], arrayList.get(i + 1)[2]));
            }
            ans = Math.max(ans, arrayList.get(i)[2] / 2);//同一段可以分为两段
        }
        ans = Math.max(ans, arrayList.get(arrayList.size() - 1)[2] / 2);//处理最后一个子数组
        return ans;
    }

    //优化版
    public int maxIncreasingSubarrays(int[] nums) {
        int count = 1, preCount = 0, ans = 0;
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i - 1]) {
                count++;
            } else {
                preCount = count;
                count = 1;
            }
            ans = Math.max(ans, Math.min(preCount, count));
            ans = Math.max(ans, count / 2);
        }
        return ans;
    }
}
