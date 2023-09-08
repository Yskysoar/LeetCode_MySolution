/**
 * @author Yskysoar
 * @createTime 2023-07-28 12:32
 * @description 209.长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。
 * 如果不存在符合条件的子数组，返回 0 。
 * 示例 1：
 * 输入：target = 7, nums = [2,3,1,2,4,3]
 * 输出：2
 * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
 * 示例 2：
 * 输入：target = 4, nums = [1,4,4]
 * 输出：1
 * 示例 3：
 * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
 * 输出：0
 */
public class Solution209 {
    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int ans = solution209.minSubArrayLen2(11, new int[]{1, 2, 3, 4, 5});
        System.out.println(ans);
    }

    /**
     * 暴力遍历（超时）
     * @param target 目标值
     * @param nums   数值数组
     * @return 最小连续区间的长度
     */
    public int minSubArrayLen1(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min((j - i + 1), ans);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    /**
     * 滑动窗口：控制窗口何时移动左右的边界即可
     * @param target 目标值
     * @param nums   数值数组
     * @return 最小连续区间的长度
     */
    public int minSubArrayLen2(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {//移动右边界
            sum += nums[right];
            while (sum >= target) {
                ans = Math.min((right - left + 1), ans);
                sum -= nums[left++];//移动左边界
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }


}
