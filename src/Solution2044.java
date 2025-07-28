import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-07-28 15:06
 * @description 2044. 统计按位或能得到最大值的子集数目
 * 给你一个整数数组 nums ，请你找出 nums 子集 按位或 可能得到的 最大值 ，并返回按位或能得到最大值的 不同非空子集的数目 。
 * 如果数组 a 可以由数组 b 删除一些元素（或不删除）得到，则认为数组 a 是数组 b 的一个 子集 。如果选中的元素下标位置不一样，则认为两个子集 不同 。
 * 对数组 a 执行 按位或 ，结果等于 a[0] OR a[1] OR ... OR a[a.length - 1]（下标从 0 开始）。
 * 示例 1：
 * 输入：nums = [3,1]
 * 输出：2
 * 解释：子集按位或能得到的最大值是 3 。有 2 个子集按位或可以得到 3 ：
 * - [3]
 * - [3,1]
 * 示例 2：
 * 输入：nums = [2,2,2]
 * 输出：7
 * 解释：[2,2,2] 的所有非空子集的按位或都可以得到 2 。总共有 23 - 1 = 7 个子集。
 * 示例 3：
 * 输入：nums = [3,2,1,5]
 * 输出：6
 * 解释：子集按位或可能的最大值是 7 。有 6 个子集按位或可以得到 7 ：
 * - [3,5]
 * - [3,1,5]
 * - [3,2,5]
 * - [3,2,1,5]
 * - [2,5]
 * - [2,1,5]
 * 提示：
 * 1 <= nums.length <= 16
 * 1 <= nums[i] <= 10^5
 */
public class Solution2044 {
    public static void main(String[] args) {
        Solution2044 solution2044 = new Solution2044();
        int ans = solution2044.countMaxOrSubsets(new int[]{2, 2, 2});
        System.out.println(ans);
    }

    /**
     * 暴力模拟
     * @param nums 数据数组
     * @return 最大按位或的数量
     */
    public int countMaxOrSubsets(int[] nums) {
        int ans = 0, maxOR = 0;
        for (int num : nums) {
            maxOR |= num;
        }
        for (Integer subset : generateSubsets(nums)) {
            ans += (maxOR == subset ? 1 : 0);
        }
        return ans;
    }

    public static List<Integer> generateSubsets(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        // 子集总数为 2^n，可以用 1 << n 来表示
        int totalSubsets = 1 << n;

        for (int i = 0; i < totalSubsets; i++) {
            int subset = 0;

            // 遍历当前数字 i 的每一位二进制位
            for (int j = 0; j < n; j++) {
                // 判断第 j 位是否为 1，为 1 表示取 nums[j]
                if ((i & (1 << j)) != 0) {
                    subset |= nums[j];
                }
            }
            result.add(subset);
        }
        return result;
    }
}
