/**
 * @author Yskysoar
 * @createTime 2026-08-22 12:32
 * @description 3622. 判断整除性
 * 给你一个正整数 n。请判断 n 是否可以被以下两值之和 整除：
 * n 的 数字和（即其各个位数之和）。
 * n 的 数字积（即其各个位数之积）。
 * 如果 n 能被该和整除，返回 true；否则，返回 false。
 * 示例 1：
 * 输入： n = 99
 * 输出： true
 * 解释：
 * 因为 99 可以被其数字和 (9 + 9 = 18) 与数字积 (9 * 9 = 81) 之和 (18 + 81 = 99) 整除，因此输出为 true。
 * 示例 2：
 * 输入： n = 23
 * 输出： false
 * 解释：
 * 因为 23 无法被其数字和 (2 + 3 = 5) 与数字积 (2 * 3 = 6) 之和 (5 + 6 = 11) 整除，因此输出为 false。
 * 提示：
 * 1 <= n <= 10^6
 */
public class Solution3622 {

    /**
     * 模拟
     * @param n 元数据
     * @return 计算结果是否合法
     */
    public boolean checkDivisibility(int n) {
        int ans = n;
        long sum = 0, multiple = 1;
        while (n > 0) {
            sum += (n % 10);
            multiple *= (n % 10);
            n /= 10;
        }
        return ans % (sum + multiple) == 0;
    }
}
    