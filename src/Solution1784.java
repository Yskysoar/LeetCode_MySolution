/**
 * @author Yskysoar
 * @createTime 2026-03-06 15:10
 * @description 1784. 检查二进制字符串字段
 * 给你一个二进制字符串 s ，该字符串 不含前导零 。
 * 如果 s 包含 零个或一个由连续的 '1' 组成的字段 ，返回 true​​​ 。否则，返回 false 。
 * 示例 1：
 * 输入：s = "1001"
 * 输出：false
 * 解释：由连续若干个 '1' 组成的字段数量为 2，返回 false
 * 示例 2：
 * 输入：s = "110"
 * 输出：true
 * 提示：
 * 1 <= s.length <= 100
 * s[i]为 '0' 或 '1'
 * s[0] 为 '1'
 */
public class Solution1784 {
    public static void main(String[] args) {
        Solution1784 solution1784 = new Solution1784();
        boolean ans = solution1784.checkOnesSegment("1001");
        System.out.println(ans);
    }

    public boolean checkOnesSegment(String s) {
        int index0 = s.length(), index1 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                index0 = i;
                break;
            }
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '1') {
                index1 = i;
                break;
            }
        }
        return index0 > index1;
    }
}
