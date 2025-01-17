/**
 * @author Yskysoar
 * @createTime 2025-01-16 13:56
 * @description 3097. 或值至少为 K 的最短子数组 II
 * 给你一个 非负 整数数组 nums 和一个整数 k 。
 * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
 * 请你返回 nums 中 最短特别非空
 * 子数组
 * 的长度，如果特别子数组不存在，那么返回 -1 。
 * 示例 1：
 * 输入：nums = [1,2,3], k = 2
 * 输出：1
 * 解释：
 * 子数组 [3] 的按位 OR 值为 3 ，所以我们返回 1 。
 * 示例 2：
 * 输入：nums = [2,1,8], k = 10
 * 输出：3
 * 解释：
 * 子数组 [2,1,8] 的按位 OR 值为 11 ，所以我们返回 3 。
 * 示例 3：
 * 输入：nums = [1,2], k = 0
 * 输出：1
 * 解释：
 * 子数组 [1] 的按位 OR 值为 1 ，所以我们返回 1 。
 * 提示：
 * 1 <= nums.length <= 2 * 10^5
 * 0 <= nums[i] <= 10^9
 * 0 <= k <= 10^9
 */
public class Solution3097WA {
//    public int minimumSubarrayLength(int[] nums, int k) {
//        int left = 0;//左边界 闭
//        int right = 0;//右边界 闭
//        int[] count = new int[30];//记录位上的1个数  2^30 > 10^9
//        int[] kCount = new int[30];//记录K的结果
//        int ans = Integer.MAX_VALUE;
//        int KLength = Integer.toBinaryString(k).length();
//        for (int i = 0; i < KLength; i++) {
//            kCount[i] = k & 1;
//            k = k >> 1;
//        }
//        boolean direction = false;//T为左边界，F为右边界
//        while (left <= right && right < nums.length) {
//            //更新count数组
//            if (direction) {//减去左边界移动的数
//                for (int i = 0, num = nums[left - 1], l = Integer.toBinaryString(nums[left - 1]).length(); i < l; i++) {
//                    count[i] -= num & 1;
//                    num >>= 1;
//                }
//            } else {//加上右边界移动的数
//                for (int i = 0, num = nums[right], l = Integer.toBinaryString(nums[right]).length(); i < l; i++) {
//                    count[i] += num & 1;
//                    num >>= 1;
//                }
//            }
//            boolean isRight = false;//左边界是否右移
//            for (int i = 29; i >= Integer.toBinaryString(k).length() - 1; i--) {//判断大小
//                if (count[i] > 1) {
//                    ans = Math.min(ans, right - left + 1);//只要在最高位及其高位还有1就一定比k大，否则一定比K小
//                    isRight = true;
//                    break;
//                }
//            }
//            left += isRight ? 1 : 0;
//            right += !isRight ? 1 : 0;//左边界不右移代表着小于K，右边界右移
//            direction = isRight;
//        }
//        return ans == Integer.MAX_VALUE ? -1 : ans;
//    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int[] bits = new int[30];
        int res = Integer.MAX_VALUE;
        for (int left = 0, right = 0; right < n; right++) {
            for (int i = 0; i < 30; i++) {
                bits[i] += (nums[right] >> i) & 1;
            }
            while (left <= right && calc(bits) >= k) {
                res = Math.min(res, right - left + 1);
                for (int i = 0; i < 30; i++) {
                    bits[i] -= (nums[left] >> i) & 1;
                }
                left++;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int calc(int[] bits) {
        int ans = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] > 0) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
