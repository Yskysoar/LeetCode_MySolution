/**
 * @author Yskysoar
 * @createTime 2024-08-22 23:33
 * @description 3133. 数组最后一个元素的最小值
 * 给你两个整数 n 和 x 。你需要构造一个长度为 n 的 正整数 数组 nums
 * 对于所有 0 <= i < n - 1 ，满足 nums[i + 1] 大于 nums[i] ，并且数组 nums 中所有元素的按位 AND
 * 运算结果为 x 。
 * 返回 nums[n - 1] 可能的 最小 值。
 * 示例 1：
 * 输入：n = 3, x = 4
 * 输出：6
 * 解释：
 * 数组 nums 可以是 [4,5,6] ，最后一个元素为 6 。
 * 示例 2：
 * 输入：n = 2, x = 7
 * 输出：15
 * 解释：
 * 数组 nums 可以是 [7,15] ，最后一个元素为 15 。
 * 提示：
 * 1 <= n, x <= 10^8
 */
public class Solution3133 {
    public static void main(String[] args) {
        Solution3133 solution3133 = new Solution3133();
        long ans = solution3133.minEnd(2, 7);
        System.out.println(ans);
    }

    /**
     * 位运算
     * @param n 数组内元素数量
     * @param x 起始数字
     * @return 数组最后一个元素
     */
    public long minEnd(int n, int x) {
        long ans = x;
        while (--n > 0) {
            ans++;// 将 ans 加 1，确保结果递增，且逐步填充 x 的二进制表示中的 0
            ans |= x;// 使用位或运算符将 ans 与 x 进行位或运算，保留 x 的所有二进制 1
        }
        return ans;
    }
}
