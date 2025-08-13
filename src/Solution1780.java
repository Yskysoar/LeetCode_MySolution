/**
 * @author Yskysoar
 * @createTime 2025-08-14 0:05
 * @description 1780. 判断一个数字是否可以表示成三的幂的和
 * 给你一个整数 n ，如果你可以将 n 表示成若干个不同的三的幂之和，请你返回 true ，否则请返回 false 。
 * 对于一个整数 y ，如果存在整数 x 满足 y == 3^x ，我们称这个整数 y 是三的幂。
 * 示例 1：
 * 输入：n = 12
 * 输出：true
 * 解释：12 = 31 + 32
 * 示例 2：
 * 输入：n = 91
 * 输出：true
 * 解释：91 = 30 + 32 + 34
 * 示例 3：
 * 输入：n = 21
 * 输出：false
 * 提示：
 * 1 <= n <= 10^7
 */
public class Solution1780 {
    public static void main(String[] args) {
        Solution1780 solution1780 = new Solution1780();
        boolean ans = solution1780.checkPowersOfThree(91);
        System.out.println(ans);
    }

    /**
     * 三进制转换
     * @param n 待判断数据
     * @return 是否可以被3^k之和表示表示
     */
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            if (n % 3 == 2) return false;
            n /= 3;
        }
        return true;
    }
}
