import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-07-30 0:04
 * @description 2419. 按位与最大的最长子数组
 * 给你一个长度为 n 的整数数组 nums 。
 * 考虑 nums 中进行 按位与（bitwise AND）运算得到的值 最大 的 非空 子数组。
 * 换句话说，令 k 是 nums 任意 子数组执行按位与运算所能得到的最大值。那么，只需要考虑那些执行一次按位与运算后等于 k 的子数组。
 * 返回满足要求的 最长 子数组的长度。
 * 数组的按位与就是对数组中的所有数字进行按位与运算。
 * 子数组 是数组中的一个连续元素序列。
 * 示例 1：
 * 输入：nums = [1,2,3,3,2,2]
 * 输出：2
 * 解释：
 * 子数组按位与运算的最大值是 3 。
 * 能得到此结果的最长子数组是 [3,3]，所以返回 2 。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：1
 * 解释：
 * 子数组按位与运算的最大值是 4 。
 * 能得到此结果的最长子数组是 [4]，所以返回 1 。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^6
 */
public class Solution2419 {
    public static void main(String[] args) {
        Solution2419 solution2419 = new Solution2419();
        int ans = solution2419.longestSubarray2(new int[]{1, 2, 3, 4});
        System.out.println(ans);
    }

    /**
     * 题目转换为：找数组中最长的连续最大元素的子数组
     * @param nums 数据数组
     * @return 按位与最大的最长子数组
     */
    public int longestSubarray1(int[] nums) {
        int ans = 0;
        int max = Arrays.stream(nums).max().getAsInt();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == max) {
                int j = i + 1;//记录右边界
                while (j < nums.length && nums[j] == max) j++;
                ans = Math.max(ans, j - i);
                i = j - 1;
            }
        }
        return ans;
    }

    /**
     * 题目转换为：找数组中最长的连续最大元素的子数组 + 贪心（当前位置与最大值的关系）
     * @param nums 数据数组
     * @return 按位与最大的最长子数组
     */
    public int longestSubarray2(int[] nums) {
        int ans = 0;
        int max = nums[0], count = 0;
        for (int num : nums) {
            if (num < max) {
                count = 0;//连续中断且最大值没有更新，重新开始计数
            } else if (num > max) {
                max = num;
                count = 1;
                ans = 1;//ans也必须初始化，因为当前元素是更大的值，之前存储的就不是最大的按位与结果
            } else {//最大值连续
                count++;
            }
            ans = Math.max(ans, count);//当前遍历的元素处理完后，检查长度是否更新
        }
        return ans;
    }
}
