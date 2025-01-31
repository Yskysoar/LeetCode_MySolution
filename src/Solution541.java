/**
 * @author Yskysoar
 * @createTime 2025-01-31 13:32
 * @description 541. 反转字符串 II
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * 示例 1：
 * 输入：s = "abcdefg", k = 2
 * 输出："bacdfeg"
 * 示例 2：
 * 输入：s = "abcd", k = 2
 * 输出："bacd"
 * 提示：
 * 1 <= s.length <= 10^4
 * s 仅由小写英文组成
 * 1 <= k <= 10^4
 */
public class Solution541 {
    public static void main(String[] args) {
        Solution541 solution541 = new Solution541();
        String ans = solution541.reverseStr("abcdefg", 8);
        System.out.println(ans);
    }

    /**
     * 模拟
     * @param s 数据字符串
     * @param k 分组长度
     * @return 反转结果
     */
    public String reverseStr(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2 * k) {
            if (s.length() - i < k) {//剩下的字符串不足k个特殊处理
                ans.append(new StringBuffer(s.substring(i)).reverse());
            } else {
                ans.append(new StringBuffer(s.substring(i, i + k)).reverse());
                if (i + 2 * k <= s.length() - 1) {
                    ans.append(s, i + k, i + 2 * k);
                } else {
                    ans.append(s.substring(i + k));
                }
            }
        }
        return ans.toString();
    }
}
