/**
 * @author Yskysoar
 * @createTime 2023-11-08 11:07
 * @description 2609. 最长平衡子字符串
 * 给你一个仅由 0 和 1 组成的二进制字符串 s 。
 * 如果子字符串中 所有的 0 都在 1 之前 且其中 0 的数量等于 1 的数量
 * 则认为 s 的这个子字符串是平衡子字符串。请注意，空子字符串也视作平衡子字符串。
 * 返回  s 中最长的平衡子字符串长度。
 * 子字符串是字符串中的一个连续字符序列。
 * 示例 1：
 * 输入：s = "01000111"
 * 输出：6
 * 解释：最长的平衡子字符串是 "000111" ，长度为 6 。
 * 示例 2：
 * 输入：s = "00111"
 * 输出：4
 * 解释：最长的平衡子字符串是 "0011" ，长度为  4 。
 * 示例 3：
 * 输入：s = "111"
 * 输出：0
 * 解释：除了空子字符串之外不存在其他平衡子字符串，所以答案为 0 。
 */
public class Solution2609 {
    public static void main(String[] args) {
        Solution2609 solution2609 = new Solution2609();
        int ans = solution2609.findTheLongestBalancedSubstring("001101");
        System.out.println(ans);
    }

    /**
     * 滑动窗口
     * @param s 字符串
     * @return 最长平衡字符串的长度
     */
    public int findTheLongestBalancedSubstring(String s) {
        int ans = 0;
        int left = 0;//左边界
        int right = 0;//右边界
        while (left < s.length()) {
            if (s.charAt(left) - '0' == 0) {
                while (s.charAt(right) - '0' == 0 && right + 1 < s.length()) right++;//找到当前可以延伸到的最远距离的0
                if (right < left) break;
                if (right + 1 == s.length() && s.charAt(right) - '0' == 0) break;
                int lengthLeft = right - left;
                left = right;
                while (s.charAt(right) - '0' == 1 && right + 1 < s.length()) right++;//找到当前可以延伸到的最远距离的1
                int lengthRight = s.charAt(right) - '0' == 1 ? right - left + 1 : right - left;
                ans = Math.max(ans, Math.min(lengthLeft, lengthRight) * 2);
                left = right;
            } else {
                left++;
                right = left;
            }
        }
        return ans;
    }
}

