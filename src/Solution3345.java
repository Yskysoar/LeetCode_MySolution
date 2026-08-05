/**
 * @author Yskysoar
 * @createTime 2026-08-06 00:50
 * @description 3345. 最小可整除数位乘积 I
 * 给你两个整数 n 和 t 。请你返回大于等于 n 的 最小 整数，且该整数的 各数位之积 能被 t 整除。
 * 示例 1：
 * 输入：n = 10, t = 2
 * 输出：10
 * 解释：
 * 10 的数位乘积为 0 ，可以被 2 整除，所以它是大于等于 10 且满足题目要求的最小整数。
 * 示例 2：
 * 输入：n = 15, t = 3
 * 输出：16
 * 解释：
 * 16 的数位乘积为 6 ，可以被 3 整除，所以它是大于等于 15 且满足题目要求的最小整数。
 * 提示：
 * 1 <= n <= 100
 * 1 <= t <= 10
 */
public class Solution3345 {

    /**
     * 有限次枚举，最多十个数就会出答案
     * @param n 起点数据
     * @param t 除数
     * @return 最小合法整数
     */
    public int smallestNumber(int n, int t) {
        int ans = 100;
        while (n < 100) {
            int num = n, sum = 1;
            while (num > 0) {
                sum *= num % 10;
                num /= 10;
            }
            if (sum % t == 0) {
                ans = n;
                break;
            }
            n++;
        }
        return ans;
    }
}
    