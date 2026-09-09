/**
 * @author Yskysoar
 * @createTime 2026-09-09 12:21
 * @description 3871. 统计范围内的逗号 II
 * 给你一个整数 n。
 * 返回将所有从 [1, n]（包含两端）范围内的整数以 标准 数字格式书写时所用到的 逗号总数。
 * 在 标准 格式中：
 * 从右边开始，每 三位 数字后插入一个逗号。
 * 位数 少于四位 的数字不包含逗号。
 * 示例 1：
 * 输入： n = 1002
 * 输出： 3
 * 解释：
 * 数字 "1,000"、"1,001" 和 "1,002" 每个都包含一个逗号，总计 3 个逗号。
 * 示例 2：
 * 输入： n = 998
 * 输出： 0
 * 解释：
 * 从 1 到 998 的所有数字位数都少于四位，因此没有使用逗号。
 * 提示：
 * 1 <= n <= 10^15
 */
public class Solution3871 {
    public static void main(String[] args) {
        Solution3871 solution3871 = new Solution3871();
        long ans = solution3871.countCommas(154729);
        System.out.println(ans);
    }

    /**
     * 大于等于 10^3 的数，都会包含至少 1 个逗号，这一部分总共贡献 n - 10^3 + 1 个逗号。
     * 大于等于 10^6 的数，会包含至少 2 个逗号（即在前一步的基础上，每个数额外多贡献 1 个逗号），总共额外贡献 n - 10^6 + 1 个。
     * 以此类推，我们只需通过变量 p 每次乘以 1000，并累加当前段的贡献值 n - p + 1 即可。
     * @param n 初始数据
     * @return 最终数量
     */
    public long countCommas(long n) {
        long p = 1000, res = 0;
        while (p <= n) {
            res += n - p + 1;
            p *= 1000;
        }
        return res;
    }
}
    