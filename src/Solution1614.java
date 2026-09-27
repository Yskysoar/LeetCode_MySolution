/**
 * @author Yskysoar
 * @createTime 2026-09-28 02:02
 * @description 1614. 括号的最大嵌套深度
 * 给定 有效括号字符串 s，返回 s 的 嵌套深度。嵌套深度是嵌套括号的 最大 数量。
 * 示例 1：
 * 输入：s = "(1+(2*3)+((8)/4))+1"
 * 输出：3
 * 解释：数字 8 在嵌套的 3 层括号中。
 * 示例 2：
 * 输入：s = "(1)+((2))+(((3)))"
 * 输出：3
 * 解释：数字 3 在嵌套的 3 层括号中。
 * 示例 3：
 * 输入：s = "()(())((()()))"
 * 输出：3
 * 提示：
 * 1 <= s.length <= 100
 * s 由数字 0-9 和字符 '+'、'-'、'*'、'/'、'('、')' 组成
 * 题目数据保证括号字符串 s 是 有效的括号字符串
 */
public class Solution1614 {

    /**
     * 单调栈 + 记录最大值
     * @param s 待判断字符串
     * @return 最深嵌套层数
     */
    public int maxDepth(String s) {
        int count = 0, ans = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
                ans = Math.max(ans, count);
            } else if (s.charAt(i) == ')') {
                count--;
            }
        }
        return ans;
    }
}
    