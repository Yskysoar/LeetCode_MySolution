import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-08-03 20:43
 * @description 345.反转字符串中的元音字母
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 * 示例 1：
 * 输入：s = "hello"
 * 输出："holle"
 * 示例 2：
 * 输入：s = "leetcode"
 * 输出："leotcede"
 */
public class Solution345 {
    public static void main(String[] args) {
        Solution345 solution345 = new Solution345();
        String ans = solution345.reverseVowels("hello");
        System.out.println(ans);
    }

    /**
     * 双指针
     * @param s 待判断字符串
     * @return 反转后字符串
     */
    public String reverseVowels(String s) {
        int start = 0;
        int end = s.length() - 1;
        StringBuilder stringBuilder = new StringBuilder(s);
        ArrayList<Character> vowel = new ArrayList<>(List.of('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U'));
        while (start < end) {
            while (start < s.length() && !vowel.contains(s.charAt(start))) start++;
            while (end >= 0 && !vowel.contains(s.charAt(end))) end--;
            if (start < end) {
                char temp = stringBuilder.charAt(start);
                stringBuilder.setCharAt(start, stringBuilder.charAt(end));
                stringBuilder.setCharAt(end, temp);
                start++;
                end--;
            }
        }
        return stringBuilder.toString();
    }
}
