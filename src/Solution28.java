/**
 * @author StudyRoom
 * @createTime 2024-03-13 9:32
 * @description 28. 找出字符串中第一个匹配项的下标
 * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
 * 示例 1：
 * 输入：haystack = "sadbutsad", needle = "sad"
 * 输出：0
 * 解释："sad" 在下标 0 和 6 处匹配。
 * 第一个匹配项的下标是 0 ，所以返回 0 。
 * 示例 2：
 * 输入：haystack = "leetcode", needle = "leeto"
 * 输出：-1
 * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
 * 提示：
 * 1 <= haystack.length, needle.length <= 10^4
 * haystack 和 needle 仅由小写英文字符组成
 */
public class Solution28 {
    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int ans = solution28.strStr2("leetcode", "leeto");
        System.out.println(ans);
    }

    public int strStr1(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    /**
     * 滑动窗口
     * @param haystack 待查找字符串
     * @param needle   字串
     * @return 字符串中字串的第一处索引
     */
    public int strStr2(String haystack, String needle) {
        int left = 0;
        int right = needle.length() - 1;
        while (right < haystack.length()) {
            if (haystack.substring(left, right + 1).equals(needle)) return left;
            left++;
            right++;
        }
        return -1;
    }
}
