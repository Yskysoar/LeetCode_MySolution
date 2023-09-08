/**
 * @author Yskysoar
 * @createTime 2023-04-05 18:42
 * @description 2427. 公因子的数目
 * 给你两个正整数 a 和 b ，返回 a 和 b 的 公 因子的数目。
 * 如果 x 可以同时整除 a 和 b ，则认为 x 是 a 和 b 的一个 公因子 。
 * 示例 1：
 * 输入：a = 12, b = 6
 * 输出：4
 * 解释：12 和 6 的公因子是 1、2、3、6 。
 * 示例 2：
 * 输入：a = 25, b = 30
 * 输出：2
 * 解释：25 和 30 的公因子是 1、5 。
 */
public class Solution2427 {
    public static void main(String[] args) {

    }

    /**
     * 暴力枚举：数据量太小了
     * @param a 正整数a
     * @param b 正整数b
     * @return 公因子数量
     */
    public int commonFactors1(int a, int b) {
        int ans = 0;
        for (int i = 1; i <= Math.min(a, b); i++) {
            if (a % i == 0 && b % i == 0) ans++;
        }
        return ans;
    }

    /**
     * 枚举到最大公因子
     * @param a 正整数a
     * @param b 正整数b
     * @return 公因子数量
     */
    public int commonFactors2(int a, int b) {
        int ans = 0;
        for (int i = 1; i * i <= gcd(a, b); i++) {
            if (gcd(a, b) % i == 0) {
                ans++;
                if (i * i != gcd(a, b)) ans++;//如果i是最大公因数的因子，那么gcd(a, b)/i也是因子，可以额外加一个答案
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        while (b != 0) {
            a %= b;
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return a;
    }

}












