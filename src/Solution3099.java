/**
 * @author Yskysoar
 * @createTime 2024-07-03 9:22
 * @description 3099. 哈沙德数
 * 如果一个整数能够被其各个数位上的数字之和整除，则称之为 哈沙德数（Harshad number）。给你一个整数 x 。如果 x 是 哈沙德数 ，则返回 x 各个数位上的数字之和，否则，返回 -1 。
 * 示例 1：
 * 输入： x = 18
 * 输出： 9
 * 解释：
 * x 各个数位上的数字之和为 9 。18 能被 9 整除。因此 18 是哈沙德数，答案是 9 。
 * 示例 2：
 * 输入： x = 23
 * 输出： -1
 * 解释：
 * x 各个数位上的数字之和为 5 。23 不能被 5 整除。因此 23 不是哈沙德数，答案是 -1 。
 * 提示：
 * 1 <= x <= 100
 */
public class Solution3099 {
    public static void main(String[] args) {
        Solution3099 solution3099 = new Solution3099();
        int ans = solution3099.sumOfTheDigitsOfHarshadNumber(23);
        System.out.println(ans);
    }

    /**
     * 单次遍历，获取每一位上的值相加即可
     * @param x 待判断数字
     * @return 是否为哈沙德数，是则各位之和，否则-1
     */
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int ans = 0;
        int num = x;
        while (x > 0) {
            ans += (x % 10);
            x /= 10;
        }
        return num % ans == 0 ? ans : -1;
    }
}
