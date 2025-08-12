/**
 * @author Yskysoar
 * @createTime 2025-08-13 0:38
 * @description 326. 3 的幂
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。如果是，返回 true ；否则，返回 false 。
 * 整数 n 是 3 的幂次方需满足：存在整数 x 使得 n == 3x
 * 示例 1：
 * 输入：n = 27
 * 输出：true
 * 示例 2：
 * 输入：n = 0
 * 输出：false
 * 示例 3：
 * 输入：n = 9
 * 输出：true
 * 示例 4：
 * 输入：n = 45
 * 输出：false
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 */
public class Solution326 {
    public static void main(String[] args) {
        Solution326 solution326 = new Solution326();
        boolean ans = solution326.isPowerOfThree(1);
        System.out.println(ans);
    }

    /**
     * 三进制原理
     * @param n 待判断数据
     * @return 是否为3的幂次方
     */
    public boolean isPowerOfThree(int n) {
        if (n == 1) return true;
        if (n <= 0 || n % 3 != 0) return false;
        int model = 0;
        while (model == 0) {
            if (n == 1) return true;
            model = n % 3;
            n /= 3;
        }
        return false;
    }
}
