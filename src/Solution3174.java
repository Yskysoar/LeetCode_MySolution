/**
 * @author Yskysoar
 * @createTime 2024-09-05 22:37
 * @description 3174. 清除数字
 * 给你一个字符串 s 。
 * 你的任务是重复以下操作删除 所有 数字字符：
 * 删除 第一个数字字符 以及它左边 最近 的 非数字 字符。
 * 请你返回删除所有数字字符以后剩下的字符串。
 * 示例 1：
 * 输入：s = "abc"
 * 输出："abc"
 * 解释：
 * 字符串中没有数字。
 * 示例 2：
 * 输入：s = "cb34"
 * 输出：""
 * 解释：
 * 一开始，我们对 s[2] 执行操作，s 变为 "c4" 。
 * 然后对 s[1] 执行操作，s 变为 "" 。
 * 提示：
 * 1 <= s.length <= 100
 * s 只包含小写英文字母和数字字符。
 * 输入保证所有数字都可以按以上操作被删除。
 */
public class Solution3174 {
    public static void main(String[] args) {
        Solution3174 solution3174 = new Solution3174();
        String s = solution3174.clearDigits("abc1");
        System.out.println(s);
    }

    /**
     * 单次遍历直接拼接，遇到数字直接把最后一个单词去除
     * @param s 待操作单词
     * @return 操作结果
     */
    public String clearDigits(String s) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) - 'a' >= 0 && s.charAt(i) - 'a' <= 26) {
                ans.append(s.charAt(i));
            } else {
                ans.replace(ans.length() - 1, ans.length(), "");
            }
        }
        return ans.toString();
    }
}
