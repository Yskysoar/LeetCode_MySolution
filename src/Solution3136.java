/**
 * @author Yskysoar
 * @createTime 2025-07-15 13:21
 * @description 3136. 有效单词
 * 有效单词 需要满足以下几个条件：
 * 至少 包含 3 个字符。
 * 由数字 0-9 和英文大小写字母组成。（不必包含所有这类字符。）
 * 至少 包含一个 元音字母 。
 * 至少 包含一个 辅音字母 。
 * 给你一个字符串 word 。如果 word 是一个有效单词，则返回 true ，否则返回 false 。
 * 注意：
 * 'a'、'e'、'i'、'o'、'u' 及其大写形式都属于 元音字母 。
 * 英文中的 辅音字母 是指那些除元音字母之外的字母。
 * 示例 1：
 * 输入：word = "234Adas"
 * 输出：true
 * 解释：
 * 这个单词满足所有条件。
 * 示例 2：
 * 输入：word = "b3"
 * 输出：false
 * 解释：
 * 这个单词的长度少于 3 且没有包含元音字母。
 * 示例 3：
 * 输入：word = "a3$e"
 * 输出：false
 * 解释：
 * 这个单词包含了 '$' 字符且没有包含辅音字母。
 * 提示：
 * 1 <= word.length <= 20
 * word 由英文大写和小写字母、数字、'@'、'#' 和 '$' 组成。
 */
public class Solution3136 {
    public static void main(String[] args) {
        Solution3136 solution3136 = new Solution3136();
        boolean ans = solution3136.isValid2("UuE6");
        System.out.println(ans);
    }

    public boolean isValid1(String word) {
        if (word.contains("@") || word.contains("#") || word.contains("$")) return false;
        word = word.replace("@", "").replace("#", "").replace("$", "").toLowerCase();
        if (word.length() < 3) return false;
        if (!(word.contains("a") || word.contains("e") || word.contains("i") || word.contains("o") || word.contains("u")))
            return false;
        word = word.replace("a", "").replace("e", "").replace("i", "")
                .replace("o", "").replace("u", "").replaceAll("[0-9]+", "");
        return word.length() != 0;
    }

    public boolean isValid2(String word) {
        boolean isVowel = false;//元音
        boolean isConsonant = false;//辅音
        String str = "@#$";
        String vowel = "aeiou";
        if (word.length() < 3) return false;
        word = word.toLowerCase().replaceAll("[0-9]+", "");
        for (int i = 0; i < word.length(); i++) {
            if (str.contains(word.charAt(i) + "")) return false;
            if (vowel.contains(word.charAt(i) + "")) {
                isVowel = true;
                continue;
            }
            isConsonant = true;
        }
        return isConsonant && isVowel;
    }
}
