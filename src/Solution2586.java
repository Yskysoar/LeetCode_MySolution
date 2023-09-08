import java.util.Arrays;
import java.util.Collection;

/**
 * @author Yskysoar
 * @createTime 2023-03-13 15:02
 * @description 2586. 统计范围内的元音字符串数
 *
 * 给你一个下标从 0 开始的字符串数组 words 和两个整数：left 和 right 。
 *
 * 如果字符串以元音字母开头并以元音字母结尾，那么该字符串就是一个 元音字符串 ，其中元音字母是 'a'、'e'、'i'、'o'、'u' 。
 *
 * 返回 words[i] 是元音字符串的数目，其中 i 在闭区间 [left, right] 内。
 *
 * 示例 1：
 *
 * 输入：words = ["are","amy","u"], left = 0, right = 2
 * 输出：2
 * 解释：
 * - "are" 是一个元音字符串，因为它以 'a' 开头并以 'e' 结尾。
 * - "amy" 不是元音字符串，因为它没有以元音字母结尾。
 * - "u" 是一个元音字符串，因为它以 'u' 开头并以 'u' 结尾。
 * 在上述范围中的元音字符串数目为 2 。
 * 示例 2：
 *
 * 输入：words = ["hey","aeo","mu","ooo","artro"], left = 1, right = 4
 * 输出：3
 * 解释：
 * - "aeo" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * - "mu" 不是元音字符串，因为它没有以元音字母开头。
 * - "ooo" 是一个元音字符串，因为它以 'o' 开头并以 'o' 结尾。
 * - "artro" 是一个元音字符串，因为它以 'a' 开头并以 'o' 结尾。
 * 在上述范围中的元音字符串数目为 3 。
 */
public class Solution2586 {
    public static void main(String[] args) {
        Solution2586 solution2586 = new Solution2586();
        int ans = solution2586.vowelStrings(new String[]{"hey", "aeo", "mu", "ooo", "artro"}, 1, 4);
        System.out.println(ans);
    }

    /**
     * 判断指定区间的单词有多少是元音单词
     * @param words 单词组
     * @param left 区间左边界
     * @param right 区间右边界
     * @return 区间内元音单词数量
     */
    public int vowelStrings(String[] words, int left, int right) {
        int ans = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(words[i])) ans++;
        }
        return ans;
    }

    /**
     * 判断单词是不是元音单词
     * @param word 待判断单词
     * @return 是，则返回true，否则false
     */
    public boolean isVowel(String word) {
        Collection<Character> vowel = Arrays.asList('a', 'e', 'i', 'o', 'u');
        char start = word.charAt(0);//首字母
        char end = word.charAt(word.length() - 1);//尾字母
        return vowel.contains(start) && vowel.contains(end);
    }
}
