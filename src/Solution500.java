import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2024-03-22 22:39
 * @description 500. 键盘行
 * 给你一个字符串数组 words ，只返回可以使用在 美式键盘 同一行的字母打印出来的单词。键盘如下图所示。
 * 美式键盘 中：
 * 第一行由字符 "qwertyuiop" 组成。
 * 第二行由字符 "asdfghjkl" 组成。
 * 第三行由字符 "zxcvbnm" 组成。
 * American keyboard
 * 示例 1：
 * 输入：words = ["Hello","Alaska","Dad","Peace"]
 * 输出：["Alaska","Dad"]
 * 示例 2：
 * 输入：words = ["omk"]
 * 输出：[]
 * 示例 3：
 * 输入：words = ["adsdf","sfd"]
 * 输出：["adsdf","sfd"]
 * 提示：
 * 1 <= words.length <= 20
 * 1 <= words[i].length <= 100
 * words[i] 由英文字母（小写和大写字母）组成
 */
public class Solution500 {
    public static void main(String[] args) {
        Solution500 solution500 = new Solution500();
        String[] ans = solution500.findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 循环遍历比较
     * @param words 字符串数组
     * @return 可以输出的字符串
     */
    public String[] findWords(String[] words) {
        String first = "qwertyuiop";
        String second = "asdfghjkl";
        String third = "zxcvbnm";
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int num1 = 0, num2 = 0, num3 = 0;
            for (int j = 0; j < word.length(); j++) {
                String str = (word.charAt(j) + "").toLowerCase();
                if (first.contains(str)) {
                    num1++;
                } else if (second.contains(str)) {
                    num2++;
                } else if (third.contains(str)) {
                    num3++;
                }
            }
            if (num1 == word.length() || num2 == word.length() || num3 == word.length()) {
                ans.add(word);
            }
        }
        return ans.toArray(new String[0]);
    }
}
