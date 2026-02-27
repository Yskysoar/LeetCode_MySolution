/**
 * @author Yskysoar
 * @createTime 2026-02-28 0:58
 * @description 1680. 连接连续二进制数字
 * 给你一个整数 n ，请你将 1 到 n 的二进制表示连接起来，并返回连接结果对应的 十进制 数字对 109 + 7 取余的结果。
 * 示例 1：
 * 输入：n = 1
 * 输出：1
 * 解释：二进制的 "1" 对应着十进制的 1 。
 * 示例 2：
 * 输入：n = 3
 * 输出：27
 * 解释：二进制下，1，2 和 3 分别对应 "1" ，"10" 和 "11" 。
 * 将它们依次连接，我们得到 "11011" ，对应着十进制的 27 。
 * 示例 3：
 * 输入：n = 12
 * 输出：505379714
 * 解释：连接结果为 "1101110010111011110001001101010111100" 。
 * 对应的十进制数字为 118505380540 。
 * 对 10^9 + 7 取余后，结果为 505379714 。
 * 提示：
 * 1 <= n <= 10^5
 */
public class Solution1680 {
    public static void main(String[] args) {
        Solution1680 solution1680 = new Solution1680();
        int ans = solution1680.concatenatedBinary(42);
        System.out.println(ans);
    }

    /**
     * 位运算
     * @param n 最大值
     * @return 计算结果
     */
    public int concatenatedBinary(int n) {
        final int MOD = 1000000007;
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = ((ans << Integer.toBinaryString(i).length()) % MOD + i) % MOD;
        }
        return (int) ans;
    }
}
