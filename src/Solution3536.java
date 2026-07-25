/**
 * @author Yskysoar
 * @createTime 2026-07-25 09:13
 * @description 3536. 两个数字的最大乘积
 * 给定一个正整数 n。
 * 返回 任意两位数字 相乘所得的 最大 乘积。
 * 注意：如果某个数字在 n 中出现多次，你可以多次使用该数字。
 * 示例 1：
 * 输入： n = 31
 * 输出： 3
 * 解释：
 * n 的数字是 [3, 1]。
 * 任意两位数字相乘的结果为：3 * 1 = 3。
 * 最大乘积为 3。
 * 示例 2：
 * 输入： n = 22
 * 输出： 4
 * 解释：
 * n 的数字是 [2, 2]。
 * 任意两位数字相乘的结果为：2 * 2 = 4。
 * 最大乘积为 4。
 * 示例 3：
 * 输入： n = 124
 * 输出： 8
 * 解释：
 * n 的数字是 [1, 2, 4]。
 * 任意两位数字相乘的结果为：1 * 2 = 2, 1 * 4 = 4, 2 * 4 = 8。
 * 最大乘积为 8。
 * 提示：
 * 10 <= n <= 10^9
 */
public class Solution3536 {
    /**
     * 遍历 + 记录
     * @param n 初始数字
     * @return 最大乘积
     */
    public int maxProduct(int n) {
        int[] nums = new int[2];
        while (n > 0) {
            int num = n % 10;
            if (num >= nums[0]) {
                nums[1] = nums[0];
                nums[0] = num;
            } else if (num >= nums[1]) {
                nums[1] = num;
            }
            n /= 10;
        }
        return nums[0] * nums[1];
    }
}
    