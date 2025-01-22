/**
 * @author Yskysoar
 * @createTime 2025-01-20 21:38
 * @description 2239. 找到最接近 0 的数字
 * 给你一个长度为 n 的整数数组 nums ，请你返回 nums 中最 接近 0 的数字。如果有多个答案，请你返回它们中的 最大值 。
 * 示例 1：
 * 输入：nums = [-4,-2,1,4,8]
 * 输出：1
 * 解释：
 * -4 到 0 的距离为 |-4| = 4 。
 * -2 到 0 的距离为 |-2| = 2 。
 * 1 到 0 的距离为 |1| = 1 。
 * 4 到 0 的距离为 |4| = 4 。
 * 8 到 0 的距离为 |8| = 8 。
 * 所以，数组中距离 0 最近的数字为 1 。
 * 示例 2：
 * 输入：nums = [2,-1,1]
 * 输出：1
 * 解释：1 和 -1 都是距离 0 最近的数字，所以返回较大值 1 。
 * 提示：
 * 1 <= n <= 1000
 * -10^5 <= nums[i] <= 10^5
 */
public class Solution2239 {
    public static void main(String[] args) {
        Solution2239 solution2239 = new Solution2239();
        int ans = solution2239.findClosestNumber(new int[]{100000, 100000, 100000, 100000, 100000, 100000});
        System.out.println(ans);
    }
    public int findClosestNumber(int[] nums) {
        int min = Integer.MAX_VALUE;//记正数
        int max = Integer.MIN_VALUE;//记负数
        for (int num : nums) {
            if (num > 0) {
                min = Math.min(min, num);
            } else if (num < 0) {
                max = Math.max(max, num);
            } else {
                return 0;
            }
        }
        if (min == Integer.MAX_VALUE) {
            return max;
        } else if (max ==Integer.MIN_VALUE) {
            return min;
        } else {
            return Math.abs(min) <= Math.abs(max) ? min : max;
        }
    }
}
