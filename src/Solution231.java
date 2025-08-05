/**
 * @author Yskysoar
 * @createTime 2025-08-04 1:20
 * @description 231. 2 的幂
 * 给你一个整数 n，请你判断该整数是否是 2 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 如果存在一个整数 x 使得 n == 2x ，则认为 n 是 2 的幂次方。
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 解释：20 = 1
 * 示例 2：
 * 输入：n = 16
 * 输出：true
 * 解释：24 = 16
 * 示例 3：
 * 输入：n = 3
 * 输出：false
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 */
public class Solution231 {
    public static void main(String[] args) {
        Solution231 solution231 = new Solution231();
        boolean ans = solution231.isPowerOfTwo(-2147483648);
        System.out.println(ans);
    }

    /**
     * 记录二进制1的个数，只要超过一个就不是2^k次方
     * @param n 待判断数
     * @return 是否为2^k
     */
    public boolean isPowerOfTwo(int n) {
        int ans = 0;
        if (n < 0) return false;
        String binary = Integer.toBinaryString(n);
        for (int i = 0; i < binary.length(); i++) {
            ans += binary.charAt(i) == '1' ? 1 : 0;
        }
        return ans == 1;
    }
}
