/**
 * @author Yskysoar
 * @createTime 2025-06-26 1:43
 * @description 2311. 小于等于 K 的最长二进制子序列
 * 给你一个二进制字符串 s 和一个正整数 k 。
 * 请你返回 s 的 最长 子序列的长度，且该子序列对应的 二进制 数字小于等于 k 。
 * 注意：
 * 子序列可以有 前导 0 。
 * 空字符串视为 0 。
 * 子序列 是指从一个字符串中删除零个或者多个字符后，不改变顺序得到的剩余字符序列。
 * 示例 1：
 * 输入：s = "1001010", k = 5
 * 输出：5
 * 解释：s 中小于等于 5 的最长子序列是 "00010" ，对应的十进制数字是 2 。
 * 注意 "00100" 和 "00101" 也是可行的最长子序列，十进制分别对应 4 和 5 。
 * 最长子序列的长度为 5 ，所以返回 5 。
 * 示例 2：
 * 输入：s = "00101001", k = 1
 * 输出：6
 * 解释："000001" 是 s 中小于等于 1 的最长子序列，对应的十进制数字是 1 。
 * 最长子序列的长度为 6 ，所以返回 6 。
 * 提示：
 * 1 <= s.length <= 1000
 * s[i] 要么是 '0' ，要么是 '1' 。
 * 1 <= k <= 10^9
 */
public class Solution2311 {
    public static void main(String[] args) {
        Solution2311 solution2311 = new Solution2311();
        int ans = solution2311.longestSubsequence("00101001", 1);
        System.out.println(ans);
    }

    /**
     * 贪心算法：子序列只需要考虑部分元素即可，不需要考虑连续元素，从低位向高位依次考虑当前元素是否可以被选择即可
     * @param s 二进制序列
     * @param k 十进制数
     * @return 最大长度
     */
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int num = 0;//记录当前保留的二进制值
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                ans++;
            } else {
                if (num + Math.pow(2, s.length() - 1 - i) <= k) {
                    num += Math.pow(2, s.length() - 1 - i);
                    ans++;
                }
            }
        }
        return ans;
    }
}
