import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-05-08 10:18
 * @description 383. 赎金信
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * 如果可以，返回 true ；否则返回 false 。
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 * 示例 1：
 * 输入：ransomNote = "a", magazine = "b"
 * 输出：false
 * 示例 2：
 * 输入：ransomNote = "aa", magazine = "ab"
 * 输出：false
 * 示例 3：
 * 输入：ransomNote = "aa", magazine = "aab"
 * 输出：true
 */
public class Solution383 {
    public static void main(String[] args) {
        Solution383 solution383 = new Solution383();
        boolean ans = solution383.canConstruct("aa", "aab");
        System.out.println(ans);
    }

    /**
     * 暴露读取：全部遍历，当有字符数量不够的时候直接返回false
     * @param ransomNote 组成的字符
     * @param magazine 提供的字符
     * @return 是否可以构成
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] words = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            words[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--words[ransomNote.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
