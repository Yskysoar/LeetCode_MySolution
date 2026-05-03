/**
 * @author Yskysoar
 * @createTime 2026-05-03 14:41
 * @description 796. 旋转字符串
 * 给定两个字符串, s 和 goal。如果在若干次旋转操作之后，s 能变成 goal ，那么返回 true 。
 * s 的 旋转操作 就是将 s 最左边的字符移动到最右边。
 * 例如, 若 s = 'abcde'，在旋转一次之后结果就是'bcdea' 。
 * 示例 1:
 * 输入: s = "abcde", goal = "cdeab"
 * 输出: true
 * 示例 2:
 * 输入: s = "abcde", goal = "abced"
 * 输出: false
 * 提示:
 * 1 <= s.length, goal.length <= 100
 * s 和 goal 由小写英文字母组成
 */
public class Solution796 {
    public static void main(String[] args) {
        Solution796 solution796 = new Solution796();
        boolean ans = solution796.rotateString("abcde", "cdeab");
        System.out.println(ans);
    }

    /**
     * 模拟
     * @param s    原字符串
     * @param goal 目标字符串
     * @return 是否可以通过旋转变成目标字符串
     */
    public boolean rotateString(String s, String goal) {
        StringBuilder str = new StringBuilder(s);
        for (int i = 0; i < str.length(); i++) {
            if (str.toString().equals(goal)) return true;
            str.append(str.charAt(0));
            str.delete(0, 1);
        }
        return false;
    }
}
