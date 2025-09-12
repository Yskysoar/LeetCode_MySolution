import java.util.Collections;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-09-13 1:07
 * @description 3541. 找到频率最高的元音和辅音
 * 给你一个由小写英文字母（'a' 到 'z'）组成的字符串 s。你的任务是找出出现频率 最高 的元音（'a'、'e'、'i'、'o'、'u' 中的一个）和出现频率最高的辅音（除元音以外的所有字母），并返回这两个频率之和。
 * 注意：如果有多个元音或辅音具有相同的最高频率，可以任选其中一个。如果字符串中没有元音或没有辅音，则其频率视为 0。
 * 一个字母 x 的 频率 是它在字符串中出现的次数。
 * 示例 1：
 * 输入: s = "successes"
 * 输出: 6
 * 解释:
 * 元音有：'u' 出现 1 次，'e' 出现 2 次。最大元音频率 = 2。
 * 辅音有：'s' 出现 4 次，'c' 出现 2 次。最大辅音频率 = 4。
 * 输出为 2 + 4 = 6。
 * 示例 2：
 * 输入: s = "aeiaeia"
 * 输出: 3
 * 解释:
 * 元音有：'a' 出现 3 次，'e' 出现 2 次，'i' 出现 2 次。最大元音频率 = 3。
 * s 中没有辅音。因此，最大辅音频率 = 0。
 * 输出为 3 + 0 = 3。
 * 提示:
 * 1 <= s.length <= 100
 * s 只包含小写英文字母
 */
public class Solution3541 {
    public static void main(String[] args) {
        Solution3541 solution3541 = new Solution3541();
        int ans = solution3541.maxFreqSum("aeiaeia");
        System.out.println(ans);
    }

    public int maxFreqSum(String s) {
        HashMap<Character, Integer> vowel = new HashMap<>();
        HashMap<Character, Integer> consonant = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
                vowel.put(s.charAt(i), vowel.getOrDefault(s.charAt(i), 0) + 1);
            } else {
                consonant.put(s.charAt(i), consonant.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        return (vowel.size() != 0 ? Collections.max(vowel.values()) : 0) + (consonant.size() != 0 ? Collections.max(consonant.values()) : 0);
    }
}
