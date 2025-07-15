/**
 * @author Yskysoar
 * @createTime 2025-07-16 0:12
 * @description 3201. 找出有效子序列的最大长度 I
 * 给你一个整数数组 nums。
 * nums 的子序列 sub 的长度为 x ，如果其满足以下条件，则称其为 有效子序列：
 * (sub[0] + sub[1]) % 2 == (sub[1] + sub[2]) % 2 == ... == (sub[x - 2] + sub[x - 1]) % 2
 * 返回 nums 的 最长的有效子序列 的长度。
 * 一个 子序列 指的是从原数组中删除一些元素（也可以不删除任何元素），剩余元素保持原来顺序组成的新数组。
 * 示例 1：
 * 输入： nums = [1,2,3,4]
 * 输出： 4
 * 解释：
 * 最长的有效子序列是 [1, 2, 3, 4]。
 * 示例 2：
 * 输入： nums = [1,2,1,1,2,1,2]
 * 输出： 6
 * 解释：
 * 最长的有效子序列是 [1, 2, 1, 2, 1, 2]。
 * 示例 3：
 * 输入： nums = [1,3]
 * 输出： 2
 * 解释：
 * 最长的有效子序列是 [1, 3]。
 * 提示：
 * 2 <= nums.length <= 2 * 10^5
 * 1 <= nums[i] <= 10^7
 */
public class Solution3201 {
    public static void main(String[] args) {
        Solution3201 solution3201 = new Solution3201();
        int ans = solution3201.maximumLength(new int[]{1, 2, 3, 4});
        System.out.println(ans);
    }

    /**
     * 子序列任取连续两项之和的奇偶性始终保持一直，只有三种取法：全部都是奇数，全部都是偶数、奇偶严格交错
     * @param nums 整数数组
     * @return 最长的有效子序列长度
     */
    public int maximumLength(int[] nums) {
        int odd = (nums[0] % 2 == 1 ? 1 : 0), even = (nums[0] % 2 == 0 ? 1 : 0);//奇数和偶数元素的数量(默认先记录第一项)
        int ans = 1, index = 0;//奇偶组合的元素数量(默认从第一项开始)，index记录上一个符合的元素索引
        for (int i = 1; i < nums.length; i++) {//从nums[0]开始一定是最长的子序列
            if ((nums[i] + nums[index]) % 2 == 1) {//(奇数 + 偶数) % 2 == 1
                index = i;
                ans++;
            }
            //记录奇偶元素个数
            odd += (nums[i] % 2 == 1 ? 1 : 0);
            even += (nums[i] % 2 == 0 ? 1 : 0);
        }
        return Math.max(Math.max(odd, even), ans);
    }
}
