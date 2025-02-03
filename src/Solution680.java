/**
 * @author Yskysoar
 * @createTime 2025-02-03 15:55
 * @description 680. 验证回文串 II
 * 给你一个字符串 s，最多 可以从中删除一个字符。
 * 请你判断 s 是否能成为回文字符串：如果能，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：s = "aba"
 * 输出：true
 * 示例 2：
 * 输入：s = "abca"
 * 输出：true
 * 解释：你可以删除字符 'c' 。
 * 示例 3：
 * 输入：s = "abc"
 * 输出：false
 * 提示：
 * 1 <= s.length <= 10^5
 * s 由小写英文字母组成
 */
public class Solution680 {
    public static void main(String[] args) {
        Solution680 solution680 = new Solution680();
        boolean ans = solution680.validPalindrome("cbbcc");
        System.out.println(ans);
    }

    /**
     * 因为最大只删除一次，双指针找到矛盾的地方尝试左右各自删除，检查剩余的字符串是否符合即可
     * @param s 数据字符串
     * @return 是否可以变成回文串
     */
    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) break;
            left++;
            right--;
        }
        if (left >= right) return true;//本身就是回文串
        //尝试删除左边
        int leftDel = left + 1;
        int rightCopy = right;
        while (leftDel < rightCopy) {
            if (s.charAt(leftDel) != s.charAt(rightCopy)) break;
            leftDel++;
            rightCopy--;
        }
        if (leftDel >= rightCopy) return true;
        //尝试删除右边
        int leftCopy = left;
        int rightDel = right - 1;
        while (leftCopy < rightDel) {
            if (s.charAt(leftCopy) != s.charAt(rightDel)) break;
            leftCopy++;
            rightDel--;
        }
        return leftCopy >= rightDel;
    }
}
