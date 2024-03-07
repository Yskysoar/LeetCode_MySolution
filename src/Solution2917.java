/**
 * @author Yskysoar
 * @createTime 2024-03-06 21:52
 * @description 2917. 找出数组中的 K-or 值
 * 给你一个下标从 0 开始的整数数组 和一个整数 。numsk
 * nums 中的 K-or 是一个满足以下条件的非负整数：
 * 只有在 中，至少存在 个元素的第 位值为 1 ，那么 K-or 中的第 位的值才是 1 。numskii
 * 返回 的 K-or 值。nums
 * 注意 ：对于整数 ，如果  ，则 中的第 位值为 1 ，其中 为按位与运算符。x(2i AND x) == 2ixiAND
 * 示例 1：
 * 输入：nums = [7,12,9,8,9,15], k = 4
 * 输出：9
 * 解释：nums[0]、nums[2]、nums[4] 和 nums[5] 的第 0 位的值为 1 。
 * nums[0] 和 nums[5] 的第 1 位的值为 1 。
 * nums[0]、nums[1] 和 nums[5] 的第 2 位的值为 1 。
 * nums[1]、nums[2]、nums[3]、nums[4] 和 nums[5] 的第 3 位的值为 1 。
 * 只有第 0 位和第 3 位满足数组中至少存在 k 个元素在对应位上的值为 1 。因此，答案为 2^0 + 2^3 = 9 。
 * 示例 2：
 * 输入：nums = [2,12,1,11,4,5], k = 6
 * 输出：0
 * 解释：因为 k == 6 == nums.length ，所以数组的 6-or 等于其中所有元素按位与运算的结果。因此，答案为 2 AND 12 AND 1 AND 11 AND 4 AND 5 = 0 。
 * 示例 3：
 * 输入：nums = [10,8,5,9,11,6,8], k = 1
 * 输出：15
 * 解释：因为 k == 1 ，数组的 1-or 等于其中所有元素按位或运算的结果。因此，答案为 10 OR 8 OR 5 OR 9 OR 11 OR 6 OR 8 = 15 。
 * 提示：
 * 1 <= nums.length <= 50
 * 0 <= nums[i] < 231
 * 1 <= k <= nums.length
 */
public class Solution2917 {
//    这题的意思是这样的：nums整数数组中所有数的二进制表示中，至少有k个整数二进制编码的第i位为1。
//    将满足上述条件的所有数字的二进制第i位全部表示成1，其余不满足的表示成为0。这样得到的一个二进制编码的整数叫做tmd K-or值
//    然后再tips中，他说整数最大31位

    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; i++) {
            // 相当于把所有的整数展开成31位二进制编码
            int count = 0;
            for (int num : nums) {// 相当于遍历每个二进制编码的第i位
                // 遍历数组，num >> i 为 num的二进制表现向右移动 i 位，对 1 按位与，若第i位为 1 则与后为 1（计数+1），否则为 0
                count += (num >> i) & 1;
            }
            if (count >= k) ans |= (1 << i);
        }
        return ans;
    }
}
