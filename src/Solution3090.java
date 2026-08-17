import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-08-14 15:56
 * @description 3090. 每个字符最多出现两次的最长子字符串
 * 给你一个字符串 s ，请找出满足每个字符最多出现两次的最长子字符串，并返回该子字符串的 最大 长度。
 * 示例 1：
 * 输入： s = "bcbbbcba"
 * 输出： 4
 * 解释：
 * 以下子字符串长度为 4，并且每个字符最多出现两次："bcbbbcba"。
 * 示例 2：
 * 输入： s = "aaaa"
 * 输出： 2
 * 解释：
 * 以下子字符串长度为 2，并且每个字符最多出现两次："aaaa"。
 * 提示：
 * 2 <= s.length <= 100
 * s 仅由小写英文字母组成
 */
public class Solution3090 {

    /**
     * 滑动窗口
     * 左边枚举，右边寻找当前起点的合法最大长度字符串，一旦不合格则本次左起点枚举结束，将左起点右移
     * @param s 初始字符串
     * @return 最长合法字符串的长度
     */
    public int maximumLengthSubstring(String s) {
        int ans = 0;
        for (int left = 0; left < s.length(); left++) {
            int[] count = new int[26];
            for (int right = left; right < s.length(); right++) {
                count[s.charAt(right) - 'a']++;
                if (count[s.charAt(right) - 'a'] > 2) break;
                ans = Math.max(ans, right - left + 1);
            }
        }
        return ans;
    }
}
    