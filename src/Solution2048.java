/**
 * @author Yskysoar
 * @createTime 2025-10-24 11:13
 * @description 2048. 下一个更大的数值平衡数
 * 如果整数  x 满足：对于每个数位 d ，这个数位 恰好 在 x 中出现 d 次。那么整数 x 就是一个 数值平衡数 。
 * 给你一个整数 n ，请你返回 严格大于 n 的 最小数值平衡数 。
 * 示例 1：
 * 输入：n = 1
 * 输出：22
 * 解释：
 * 22 是一个数值平衡数，因为：
 * - 数字 2 出现 2 次
 * 这也是严格大于 1 的最小数值平衡数。
 * 示例 2：
 * 输入：n = 1000
 * 输出：1333
 * 解释：
 * 1333 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 1000 的最小数值平衡数。
 * 注意，1022 不能作为本输入的答案，因为数字 0 的出现次数超过了 0 。
 * 示例 3：
 * 输入：n = 3000
 * 输出：3133
 * 解释：
 * 3133 是一个数值平衡数，因为：
 * - 数字 1 出现 1 次。
 * - 数字 3 出现 3 次。
 * 这也是严格大于 3000 的最小数值平衡数。
 * 提示：
 * 0 <= n <= 10^6
 */
public class Solution2048 {
    public static void main(String[] args) {
        Solution2048 solution2048 = new Solution2048();
        int ans = solution2048.nextBeautifulNumber(10);
        System.out.println(ans);
    }

    /**
     * 模拟 + 字符串
     * @param n 初始数字
     * @return 严格大于n的最小的数值平衡数
     */
    public int nextBeautifulNumber(int n) {
        while (true) {
            boolean isFlag = true;
            n++;
            String s = String.valueOf(n);
            for (int i = s.length(), length = s.length(); i > 0; i--, length = s.length()) {
                s = s.replace(String.valueOf(i), "");
                if (length - s.length() != 0 && length - s.length() != i) {
                    isFlag = false;
                    break;
                }
            }
            if (!isFlag) continue;
            if (s.length() == 0) return n;
        }
    }
}
