import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2026-05-28 01:28
 * @description 3121. 统计特殊字母的数量 II
 * 给你一个字符串 word。如果 word 中同时出现某个字母 c 的小写形式和大写形式，并且 每个 小写形式的 c 都出现在第一个大写形式的 c 之前，则称字母 c 是一个 特殊字母 。
 * 返回 word 中 特殊字母 的数量。
 * 示例 1:
 * 输入：word = "aaAbcBC"
 * 输出：3
 * 解释：
 * 特殊字母是 'a'、'b' 和 'c'。
 * 示例 2:
 * 输入：word = "abc"
 * 输出：0
 * 解释：
 * word 中不存在特殊字母。
 * 示例 3:
 * 输入：word = "AbBCab"
 * 输出：0
 * 解释：
 * word 中不存在特殊字母。
 * 提示：
 * 1 <= word.length <= 2 * 105
 * word 仅由小写和大写英文字母组成。
 */
public class Solution3121 {
    public static void main(String[] args) {
        Solution3121 solution3121 = new Solution3121();
        int ans = solution3121.numberOfSpecialChars("AbBCab");
        System.out.println(ans);
    }

    /**
     * 记录大小写字母的位置，然后比较即可
     * @param word 字符串
     * @return 特殊字母的数量
     */
    public int numberOfSpecialChars(String word) {
        int ans = 0;
        int[] Up = new int[26];
        Arrays.fill(Up, -1);
        HashMap<Character, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                if (!hashMap.containsKey(word.charAt(i))) {
                    hashMap.put(word.charAt(i), new ArrayList<>());
                }
                hashMap.get(word.charAt(i)).add(i);
            } else if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z' && Up[word.charAt(i) - 'A'] == -1) {
                Up[word.charAt(i) - 'A'] = i;
            }
        }
        for (int i = 0; i < Up.length; i++) {
            if (Up[i] != -1) {
                if (hashMap.containsKey((char) ('a' + i))) {
                    boolean isFlag = true;
                    for (int j = 0; j < hashMap.get((char) ('a' + i)).size(); j++) {
                        if (hashMap.get((char) ('a' + i)).get(j) > Up[i]) {
                            isFlag = false;
                            break;
                        }
                    }
                    if (isFlag) ans++;
                }
            }
        }
        return ans;
    }
}
    