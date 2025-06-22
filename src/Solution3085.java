import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-06-21 8:36
 * @description 3085. 成为 K 特殊字符串需要删除的最少字符数
 * 给你一个字符串 word 和一个整数 k。
 * 如果 |freq(word[i]) - freq(word[j])| <= k 对于字符串中所有下标 i 和 j  都成立，则认为 word 是 k 特殊字符串。
 * 此处，freq(x) 表示字符 x 在 word 中的出现频率，而 |y| 表示 y 的绝对值。
 * 返回使 word 成为 k 特殊字符串 需要删除的字符的最小数量。
 * 示例 1：
 * 输入：word = "aabcaba", k = 0
 * 输出：3
 * 解释：可以删除 2 个 "a" 和 1 个 "c" 使 word 成为 0 特殊字符串。word 变为 "baba"，此时 freq('a') == freq('b') == 2。
 * 示例 2：
 * 输入：word = "dabdcbdcdcd", k = 2
 * 输出：2
 * 解释：可以删除 1 个 "a" 和 1 个 "d" 使 word 成为 2 特殊字符串。word 变为 "bdcbdcdcd"，此时 freq('b') == 2，freq('c') == 3，freq('d') == 4。
 * 示例 3：
 * 输入：word = "aaabaaa", k = 2
 * 输出：1
 * 解释：可以删除 1 个 "b" 使 word 成为 2特殊字符串。因此，word 变为 "aaaaaa"，此时每个字母的频率都是 6。
 * 提示：
 * 1 <= word.length <= 10^5
 * 0 <= k <= 10^5
 * word 仅由小写英文字母组成。
 */
public class Solution3085 {
    public static void main(String[] args) {
        Solution3085 solution3085 = new Solution3085();
        int ans = solution3085.minimumDeletions("cicgjjgjjg", 1);
        System.out.println(ans);
    }

    /**
     * 窗口思想 + 暴力遍历，记录次数并顺序排序，以当前位置为基准，向左或者向右进行延展，不在范围内的值则：
     * 左边全减，右边减到上边界，返回所有位置的左右减少量之和的最小值即可
     * @param word 字符串
     * @param k    差值上限
     * @return 最少删除次数
     */
    public int minimumDeletions(String word, int k) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        int ans = Integer.MAX_VALUE;
        for (char s : word.toCharArray()) {//记录次数
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for (char c : hashMap.keySet()) {
            int left = 0, right = 0;
            for (char i : hashMap.keySet()) {
                if (hashMap.get(i) < hashMap.get(c) - k) {//当前基准向左延伸
                    left += hashMap.get(i);
                } else if (hashMap.get(i) > hashMap.get(c)) {
                    left += hashMap.get(i) - hashMap.get(c);
                }
                if (hashMap.get(i) > hashMap.get(c) + k) {
                    right += hashMap.get(i) - hashMap.get(c) - k;
                } else if (hashMap.get(i) < hashMap.get(c)) {//当前基准向右延伸
                    right += hashMap.get(i);
                }
            }
            ans = Math.min(ans, Math.min(left, right));
        }
        return ans;
    }
}
