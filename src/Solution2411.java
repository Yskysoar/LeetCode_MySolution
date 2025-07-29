import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-07-29 10:10
 * @description 2411. 按位或最大的最小子数组长度
 * 给你一个长度为 n 下标从 0 开始的数组 nums ，数组中所有数字均为非负整数。对于 0 到 n - 1 之间的每一个下标 i ，你需要找出 nums 中一个 最小 非空子数组，它的起始位置为 i （包含这个位置），同时有 最大
 * 的 按位或运算值 。
 * 换言之，令 Bij 表示子数组 nums[i...j] 的按位或运算的结果，你需要找到一个起始位置为 i 的最小子数组，这个子数组的按位或运算的结果等于 max(Bik) ，其中 i <= k <= n - 1 。
 * 一个数组的按位或运算值是这个数组里所有数字按位或运算的结果。
 * 请你返回一个大小为 n 的整数数组 answer，其中 answer[i]是开始位置为 i ，按位或运算结果最大，且 最短 子数组的长度。
 * 子数组 是数组里一段连续非空元素组成的序列。
 * 示例 1：
 * 输入：nums = [1,0,2,1,3]
 * 输出：[3,3,2,2,1]
 * 解释：
 * 任何位置开始，最大按位或运算的结果都是 3 。
 * - 下标 0 处，能得到结果 3 的最短子数组是 [1,0,2] 。
 * - 下标 1 处，能得到结果 3 的最短子数组是 [0,2,1] 。
 * - 下标 2 处，能得到结果 3 的最短子数组是 [2,1] 。
 * - 下标 3 处，能得到结果 3 的最短子数组是 [1,3] 。
 * - 下标 4 处，能得到结果 3 的最短子数组是 [3] 。
 * 所以我们返回 [3,3,2,2,1] 。
 * 示例 2：
 * 输入：nums = [1,2]
 * 输出：[2,1]
 * 解释：
 * 下标 0 处，能得到最大按位或运算值的最短子数组长度为 2 。
 * 下标 1 处，能得到最大按位或运算值的最短子数组长度为 1 。
 * 所以我们返回 [2,1] 。
 * 提示：
 * n == nums.length
 * 1 <= n <= 10^5
 * 0 <= nums[i] <= 10^9
 */
public class Solution2411 {
    public static void main(String[] args) {
        Solution2411 solution2411 = new Solution2411();
        int[] ans = solution2411.smallestSubarrays(new int[]{1, 0, 2, 1, 3});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 参考：https://leetcode.cn/problems/smallest-subarrays-with-maximum-bitwise-or/solutions/1830593/by-tsreaper-icon
     * 贪心 + 枚举：由于按位或只要第一次出现1，那么结果一定变大，倒序记录每个二进制位上为1的最小位置，然后取单行出现的位置最大值即可
     * @param nums 数据数组
     * @return 按位或最大的最小子数组长度
     */
    public int[] smallestSubarrays(int[] nums) {
        int[] ans = new int[nums.length];
        //bits[i][j]用来记录大于等于第i个元素对应第j个二进制位上为1的最近元素位置
        int[][] bits = new int[nums.length][32];
        StringBuilder str = new StringBuilder(Integer.toBinaryString(nums[nums.length - 1])).reverse();
        for (int j = 0; j < str.length(); j++) {
            bits[nums.length - 1][j] = (str.charAt(j) == '1' ? nums.length : 0);
        }//尾元素需要特殊处理
        for (int i = nums.length - 2; i >= 0; i--) {//倒序处理
            str = new StringBuilder(Integer.toBinaryString(nums[i])).reverse();
            for (int j = 0; j < bits[i].length; j++) {//如果该位置的某位二进制数为1，则更新位置，否则沿用上一个位置
                bits[i][j] = (j < str.length() && str.charAt(j) == '1' ? i + 1 : bits[i + 1][j]);
            }
        }
        for (int i = 0; i < nums.length; i++) {//开始查找右位置边界
            int max = i + 1;
            for (int j = 0; j < bits[i].length; j++) {
                max = Math.max(max, bits[i][j]);
            }
            ans[i] = max - i;//右位置 - 左索引 = 数组长度
        }
        return ans;
    }
}
