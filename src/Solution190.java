/**
 * @author Yskysoar
 * @createTime 2026-02-16 16:18
 * @description 190. 颠倒二进制位
 * 颠倒给定的 32 位有符号整数的二进制位。
 * 示例 1：
 * 输入：n = 43261596
 * 输出：964176192
 * 解释：
 * 整数	        二进制
 * 43261596	    00000010100101000001111010011100
 * 964176192	00111001011110000010100101000000
 * 示例 2：
 * 输入：n = 2147483644
 * 输出：1073741822
 * 解释：
 * 整数	        二进制
 * 2147483644	01111111111111111111111111111100
 * 1073741822	00111111111111111111111111111110
 * 提示：
 * 0 <= n <= 2^31 - 2
 * n 为偶数
 */
public class Solution190 {
    public static void main(String[] args) {
        Solution190 solution190 = new Solution190();
        int ans = solution190.reverseBits(43261596);
        System.out.println(ans);
    }

    public int reverseBits(int n) {
        return Integer.reverse(n);
    }
}
