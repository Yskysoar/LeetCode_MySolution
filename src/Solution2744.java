import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2024-01-17 12:58
 * @description 2744. 最大字符串配对数目
 * 给你一个下标从 0 开始的数组 words ，数组中包含 互不相同 的字符串。
 * 如果字符串 words[i] 与字符串 words[j] 满足以下条件，我们称它们可以匹配：
 * 字符串 words[i] 等于 words[j] 的反转字符串。
 * 0 <= i < j < words.length
 * 请你返回数组 words 中的 最大 匹配数目。
 * 注意，每个字符串最多匹配一次。
 * 示例 1：
 * 输入：words = ["cd","ac","dc","ca","zz"]
 * 输出：2
 * 解释：在此示例中，我们可以通过以下方式匹配 2 对字符串：
 * - 我们将第 0 个字符串与第 2 个字符串匹配，因为 word[0] 的反转字符串是 "dc" 并且等于 words[2]。
 * - 我们将第 1 个字符串与第 3 个字符串匹配，因为 word[1] 的反转字符串是 "ca" 并且等于 words[3]。
 * 可以证明最多匹配数目是 2 。
 * 示例 2：
 * 输入：words = ["ab","ba","cc"]
 * 输出：1
 * 解释：在此示例中，我们可以通过以下方式匹配 1 对字符串：
 * - 我们将第 0 个字符串与第 1 个字符串匹配，因为 words[1] 的反转字符串 "ab" 与 words[0] 相等。
 * 可以证明最多匹配数目是 1 。
 * 示例 3：
 * 输入：words = ["aa","ab"]
 * 输出：0
 * 解释：这个例子中，无法匹配任何字符串。
 * 提示：
 * 1 <= words.length <= 50
 * words[i].length == 2
 * words 包含的字符串互不相同。
 * words[i] 只包含小写英文字母。
 */
public class Solution2744 {

    public static void main(String[] args) {
        Solution2744 solution2744 = new Solution2744();
        int ans = solution2744.maximumNumberOfStringPairs2(new String[]{"cd", "ac", "dc", "ca", "zz"});
        System.out.println(ans);
    }

    /**
     * 哈希表：检索当前是否有反转字符串，没有就添加进去；否则减少一次反转字符串的数量(因为每个字符串最多匹配一次)然后记录ans
     * @param words 字符串数组
     * @return 字符串配对数目的最大值
     */
    public int maximumNumberOfStringPairs1(String[] words) {
        int ans = 0;
        HashMap<String, Integer> hashMap = new HashMap<>();//反转字符串：数量
        for (String word : words) {
            if (hashMap.containsKey(word)) {//存在反转字符串
                if (hashMap.get(word) > 0) {//反转字符串有剩余可匹配字符串
                    hashMap.put(word, hashMap.get(word) - 1);//可匹配字符串数减一
                    ans++;
                } else {//可匹配字符串数为0时
                    hashMap.remove(word);//移除对应的可匹配字符串
                    hashMap.put(reverse(word), hashMap.getOrDefault(reverse(word), 0) + 1);//将本身反转并添加到哈希表
//                    hashMap.put(new StringBuilder(word).reverse().toString(), hashMap.getOrDefault(new StringBuilder(word).reverse().toString(), 0) + 1);//将本身反转并添加到哈希表
                }
            } else {////不存在反转字符串直接将本身反转并添加到哈希表
                hashMap.put(reverse(word), hashMap.getOrDefault(reverse(word), 0) + 1);
//                hashMap.put(new StringBuilder(word).reverse().toString(), hashMap.getOrDefault(new StringBuilder(word).reverse().toString(), 0) + 1);//将本身反转并添加到哈希表
            }
        }
        return ans;
    }

    /**
     * 字符串反转
     * @param s 字符串
     * @return 反转的字符串
     */
    public String reverse(String s) {
        StringBuilder str = new StringBuilder();//也可以直接调用StringBuilder内置的reserve函数进行反转
        for (int i = s.length() - 1; i >= 0; i--) {
            str.append(s.charAt(i));
        }
        return str.toString();
    }

    /**
     * 暴力双重遍历
     * @param words 字符串数组
     * @return 字符串配对数目的最大值
     */
    public int maximumNumberOfStringPairs2(String[] words) {
        int ans = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
//                if (reverse(words[i]).equals(words[j])) ans++;
                if (words[i].charAt(0) == words[j].charAt(1) && words[i].charAt(1) == words[j].charAt(0))
                    ans++;//规定字符串只有两个字符
            }
        }
        return ans;
    }
}
