import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-02-20 21:31
 * @description 2595. 奇偶位数
 * 给你一个 正 整数 n 。
 * 用 even 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的偶数下标的个数。
 * 用 odd 表示在 n 的二进制形式（下标从 0 开始）中值为 1 的奇数下标的个数。
 * 请注意，在数字的二进制表示中，位下标的顺序 从右到左。
 * 返回整数数组 answer ，其中 answer = [even, odd] 。
 * 示例 1：
 * 输入：n = 50
 * 输出：[1,2]
 * 解释：
 * 50 的二进制表示是 110010。
 * 在下标 1，4，5 对应的值为 1。
 * 示例 2：
 * 输入：n = 2
 * 输出：[0,1]
 * 解释：
 * 2 的二进制表示是 10。
 * 只有下标 1 对应的值为 1。
 * 提示：
 * 1 <= n <= 1000
 */
public class Solution2595 {
    public static void main(String[] args) {
        Solution2595 solution2595 = new Solution2595();
        int[] ans = solution2595.evenOddBit(50);
        System.out.println(Arrays.toString(ans));
    }
    public int[] evenOddBit(int n) {
        StringBuilder num = new StringBuilder(Integer.toBinaryString(n)).reverse();
        int[] ans = new int[2];
        for (int i = 0; i < num.length(); i++) {
            if (num.charAt(i) -'0' == 1) {
                ans[i % 2]++;
            }
        }
        return ans;
    }
}
