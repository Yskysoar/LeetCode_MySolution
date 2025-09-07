/**
 * @author Yskysoar
 * @createTime 2025-09-08 3:04
 * @description 1317. 将整数转换为两个无零整数的和
 * 「无零整数」是十进制表示中 不含任何 0 的正整数。
 * 给你一个整数 n，请你返回一个 由两个整数组成的列表 [a, b]，满足：
 * a 和 b 都是无零整数
 * a + b = n
 * 题目数据保证至少有一个有效的解决方案。
 * 如果存在多个有效解决方案，你可以返回其中任意一个。
 * 示例 1：
 * 输入：n = 2
 * 输出：[1,1]
 * 解释：a = 1, b = 1。a + b = n 并且 a 和 b 的十进制表示形式都不包含任何 0。
 * 示例 2：
 * 输入：n = 11
 * 输出：[2,9]
 * 示例 3：
 * 输入：n = 10000
 * 输出：[1,9999]
 * 示例 4：
 * 输入：n = 69
 * 输出：[1,68]
 * 示例 5：
 * 输入：n = 1010
 * 输出：[11,999]
 * 提示：
 * 2 <= n <= 10^4
 */
public class Solution1317 {

    /**
     * 暴力枚举
     * @param n 元素和
     * @return 两个合法无零整数
     */
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for (int i = 1; i < n; i++) {
            if (!String.valueOf(i).contains("0") && !String.valueOf(n - i).contains("0")) {
                ans[0] = i;
                ans[1] = n - i;
                break;
            }
        }
        return ans;
    }
}
