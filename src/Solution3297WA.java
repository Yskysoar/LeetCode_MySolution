import java.util.HashMap;
import java.util.Map;

/**
 * @author Yskysoar
 * @createTime 2025-01-09 14:33
 * @description 3297. 统计重新排列后包含另一个字符串的子字符串数目 I
 * 给你两个字符串 word1 和 word2 。
 * 如果一个字符串 x 重新排列后，word2 是重排字符串的
 * 前缀
 * ，那么我们称字符串 x 是 合法的 。
 * 请你返回 word1 中 合法
 * 子字符串
 * 的数目。
 * 示例 1：
 * 输入：word1 = "bcca", word2 = "abc"
 * 输出：1
 * 解释：
 * 唯一合法的子字符串是 "bcca" ，可以重新排列得到 "abcc" ，"abc" 是它的前缀。
 * 示例 2：
 * 输入：word1 = "abcabc", word2 = "abc"
 * 输出：10
 * 解释：
 * 除了长度为 1 和 2 的所有子字符串都是合法的。
 * 示例 3：
 * 输入：word1 = "abcabc", word2 = "aaabc"
 * 输出：0
 * 解释：
 * 1 <= word1.length <= 10^5
 * 1 <= word2.length <= 10^4
 * word1 和 word2 都只包含小写英文字母。
 */
public class Solution3297WA {
    public static void main(String[] args) {
        Solution3297WA solution3297WA = new Solution3297WA();
        long ans1 = solution3297WA.validSubstringCount1("dccdceee", "cec");
        long ans2 = solution3297WA.validSubstringCount2("dccdceee", "cec");
        System.out.println(ans1);
        System.out.println(ans2);

    }


    public long validSubstringCount1(String word1, String word2) {//WA超时
        long ans = 0;
        if (word1.length() < word2.length()) return ans;
        for (int i = 0; i <= word1.length() - word2.length(); i++) {//窗口可移动的范围
            for (int j = word2.length(); j <= word1.length() - i; j++) {//窗口的长度
                boolean isFlag = true;
                StringBuilder str = new StringBuilder(word1.substring(i, i + j));
                for (int k = 0; k < word2.length(); k++) {
                    if (str.indexOf(String.valueOf(word2.charAt(k))) != -1) {
                        str.delete(str.indexOf(String.valueOf(word2.charAt(k))), str.indexOf(String.valueOf(word2.charAt(k))) + 1);
                    } else {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag) {
                    ans += (word1.length() - i - j + 1);
                    break;
                }
            }
        }
        return ans;
    }

    public long validSubstringCount2(String word1, String word2) {
        long ans = 0;
        if (word1.length() < word2.length()) return ans;
        //word2的字符出现频次
        HashMap<Character, Integer> word2Count = new HashMap<>();
        for (int i = 0; i < word2.length(); i++) {
            word2Count.put(word2.charAt(i), word2Count.getOrDefault(word2.charAt(i), 0) + 1);
        }
        //word1的前缀数组
        int[][] word1Count = new int[word1.length() + 1][26];
        for (int i = 1; i < word1.length() + 1; i++) {
            System.arraycopy(word1Count[i - 1], 0, word1Count[i], 0, 26);
            word1Count[i][word1.charAt(i - 1) - 'a']++;
        }
        for (Map.Entry<Character, Integer> entry : word2Count.entrySet()) {
            if (word1Count[word1.length()][entry.getKey() - 'a'] < entry.getValue()) return 0;//如果本身该字符就不够，直接返回0
        }
        for (int i = 0; i <= word1.length() - word2.length(); i++) {
            //记录最小合法区间 [i,i + j]
            for (int j = word2.length() - 1; i + j < word1.length(); j++) {
                boolean isFlag = true;
                for (Map.Entry<Character, Integer> entry : word2Count.entrySet()) {
                    if (entry.getValue() > word1Count[i + j + 1][entry.getKey() - 'a'] - word1Count[i][entry.getKey() - 'a']) {
                        isFlag = false;
                        break;
                    }
                }
                if (isFlag) {//isFlag为true的时候才是合法的
                    ans += (word1.length() - i - j);
                    //判断左边界最多可以右滑多少
                    int add;
                    for (add = i + 1; add < i + j; add++) {//减少了的字符 word1.charAt(add - 1)
                        if (word2Count.containsKey(word1.charAt(add - 1))) {//如果减少的字符会影响结果则需要比较
                            if (word2Count.get(word1.charAt(add - 1)) > word1Count[i + j + 1][word1.charAt(add - 1) - 'a'] - word1Count[add][word1.charAt(add - 1) - 'a']) {
                                break;
                            }
                        }
                    }//add - 1 表示的是下一轮开始的左边界
                    if (add > i + 1) {
                        ans += (long) (word1.length() - j - i) * (add - i - 2);
                        i = add - 2;
                    }
                    break;
                }
            }
        }
        return ans;
    }
}
