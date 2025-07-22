import java.util.Stack;

/**
 * @author Yskysoar
 * @createTime 2025-07-23 0:44
 * @description 1717. 删除子字符串的最大得分
 * 给你一个字符串 s 和两个整数 x 和 y 。你可以执行下面两种操作任意次。
 * 删除子字符串 "ab" 并得到 x 分。
 * 比方说，从 "cabxbae" 删除 ab ，得到 "cxbae" 。
 * 删除子字符串"ba" 并得到 y 分。
 * 比方说，从 "cabxbae" 删除 ba ，得到 "cabxe" 。
 * 请返回对 s 字符串执行上面操作若干次能得到的最大得分。
 * 示例 1：
 * 输入：s = "cdbcbbaaabab", x = 4, y = 5
 * 输出：19
 * 解释：
 * - 删除 "cdbcbbaaabab" 中加粗的 "ba" ，得到 s = "cdbcbbaaab" ，加 5 分。
 * - 删除 "cdbcbbaaab" 中加粗的 "ab" ，得到 s = "cdbcbbaa" ，加 4 分。
 * - 删除 "cdbcbbaa" 中加粗的 "ba" ，得到 s = "cdbcba" ，加 5 分。
 * - 删除 "cdbcba" 中加粗的 "ba" ，得到 s = "cdbc" ，加 5 分。
 * 总得分为 5 + 4 + 5 + 5 = 19 。
 * 示例 2：
 * 输入：s = "aabbaaxybbaabb", x = 5, y = 4
 * 输出：20
 * 提示：
 * 1 <= s.length <= 10^5
 * 1 <= x, y <= 10^4
 * s 只包含小写英文字母
 */
public class Solution1717 {
    public static void main(String[] args) {
        Solution1717 solution1717 = new Solution1717();
        int ans = solution1717.maximumGain("aabbabkbbbfvybssbtaobaaaabataaadabbbmakgabbaoapbbbbobaabvqhbbzbbkapabaavbbeghacabamdpaaqbqabbjbababmbakbaabajabasaabbwabrbbaabbafubayaazbbbaababbaaha", 1926, 4320);
        System.out.println(ans);
    }

    /**
     * 贪心 + 双栈检索：优先删除得分高的子字符串，再倒序删除得分低的子字符串
     * （子字符串互为逆序，倒序后可以与前一轮的栈操作对应）
     * @param s 字符串
     * @param x ab对应的分值
     * @param y ba对应的分值
     * @return 删除子字符串后的最大得分
     */
    public int maximumGain(String s, int x, int y) {
        int ans = 0;
        String str = (x > y ? "ab" : "ba");//互逆则只需要设置一个参数即可
        Stack<Character> stackA = new Stack<>();//第一遍的栈
        Stack<Character> stackB = new Stack<>();//第二遍的栈
        for (int i = 0; i < s.length(); i++) {//正序处理分值大的字符串
            if (!stackA.isEmpty() && stackA.peek() == str.charAt(0) && s.charAt(i) == str.charAt(1)) {//栈顶元素与当前元素刚好组合成子字符串
                ans += Math.max(x, y);
                //不存入等效于出栈
                stackA.pop();//栈顶元素出栈
            } else {//否则当前元素入栈
                stackA.push(s.charAt(i));
            }
        }
        while (!stackA.isEmpty()) {//倒序处理分值小的子字符串
            if (!stackB.isEmpty() && stackB.peek() == str.charAt(0) && stackA.peek() == str.charAt(1)) {//栈顶元素与当前元素刚好组合成子字符串
                ans += Math.min(x, y);
                //两个栈都需要出栈
                stackA.pop();
                stackB.pop();
            } else {//否则当前元素入栈
                stackB.push(stackA.pop());
            }
        }
        return ans;
    }
}
