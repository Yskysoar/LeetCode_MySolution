/**
 * @author Yskysoar
 * @createTime 2025-07-21 0:33
 * @description 1957. 删除字符使字符串变好
 * 一个字符串如果没有 三个连续 相同字符，那么它就是一个 好字符串 。
 * 给你一个字符串 s ，请你从 s 删除 最少 的字符，使它变成一个 好字符串 。
 * 请你返回删除后的字符串。题目数据保证答案总是 唯一的 。
 * 示例 1：
 * 输入：s = "leeetcode"
 * 输出："leetcode"
 * 解释：
 * 从第一组 'e' 里面删除一个 'e' ，得到 "leetcode" 。
 * 没有连续三个相同字符，所以返回 "leetcode" 。
 * 示例 2：
 * 输入：s = "aaabaaaa"
 * 输出："aabaa"
 * 解释：
 * 从第一组 'a' 里面删除一个 'a' ，得到 "aabaaaa" 。
 * 从第二组 'a' 里面删除两个 'a' ，得到 "aabaa" 。
 * 没有连续三个相同字符，所以返回 "aabaa" 。
 * 示例 3：
 * 输入：s = "aab"
 * 输出："aab"
 * 解释：没有连续三个相同字符，所以返回 "aab" 。
 * 提示：
 * 1 <= s.length <= 105
 * s 只包含小写英文字母。
 */
public class Solution1957 {
    public static void main(String[] args) {
        Solution1957 solution1957 = new Solution1957();
        String ans = solution1957.makeFancyString("leeetcode");
        System.out.println(ans);
    }

    /**
     * 遍历检索
     * @param s 初始字符串
     * @return 好字符串
     */
    public String makeFancyString(String s) {
        if (s.length() <= 2) return s;
        StringBuilder ans = new StringBuilder(s.substring(0, 2));//前两个字符可以直接初始化
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == s.charAt(i) && s.charAt(i - 2) == s.charAt(i)) {//存在一样的字符就不加入
                continue;
            }
            ans.append(s.charAt(i));//可以加入的字符
        }
        return ans.toString();
    }
}
