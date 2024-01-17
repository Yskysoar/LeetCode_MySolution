/**
 * @author Yskysoar
 * @createTime 2023-07-27 22:31
 * @description 162.寻找峰值
 * 峰值元素是指其值严格大于左右相邻值的元素
 * 给你一个整数数组 nums，找到峰值元素并返回其索引
 * 数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可
 * 你可以假设 nums[-1] = nums[n] = -∞
 * 你必须实现时间复杂度为 O(log n) 的算法来解决此问题
 * 示例 1：
 * 输入：nums = [1,2,3,1]
 * 输出：2
 * 解释：3 是峰值元素，你的函数应该返回其索引 2
 * 示例 2：
 * 输入：nums = [1,2,1,3,5,6,4]
 * 输出：1 或 5
 * 解释：你的函数可以返回索引 1，其峰值元素为 2；
 * 或者返回索引 5，其峰值元素为 6
 */
public class Solution162 {
    public static void main(String[] args) {
        Solution162 solution162 = new Solution162();
        int ans = solution162.findPeakElement1(new int[]{1, 2, 3, 1});
        System.out.println(ans);
    }


    /**
     * 暴力遍历
     * @param nums 数值数组
     * @return 任意峰值位置
     */
    public int findPeakElement1(int[] nums) {
        if (nums.length == 2) {
            return nums[0] > nums[1] ? 0 : 1;
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        if (nums.length >= 2 && nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;
        return 0;
    }

    /**
     * 二分查找：具有极大值的连续函数性质，当前元素大于右邻接元素则极大值在右邻接元素左边(也可能就是当前元素)，否则就在当前元素右边
     * @param nums 数值数组
     * @return 任意峰值位置
     */
    public int findPeakElement2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (right - left) / 2 + left;
            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    /**
     * 找最大值：最大值一定是一个峰值
     * @param nums 数值数组
     * @return 任意峰值位置
     */
    public int findPeakElement3(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[ans] < nums[i]) {
                ans = i;
            }
        }
        return ans;
    }
}
