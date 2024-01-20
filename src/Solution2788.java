import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2024-01-20 14:09
 * @description 2788. 按分隔符拆分字符串
 * 给你一个字符串数组 words 和一个字符 separator ，请你按 separator 拆分 words 中的每个字符串。
 * 返回一个由拆分后的新字符串组成的字符串数组，不包括空字符串 。
 * 注意
 * separator 用于决定拆分发生的位置，但它不包含在结果字符串中。
 * 拆分可能形成两个以上的字符串。
 * 结果字符串必须保持初始相同的先后顺序。
 * 示例 1：
 * 输入：words = ["one.two.three","four.five","six"], separator = "."
 * 输出：["one","two","three","four","five","six"]
 * 解释：在本示例中，我们进行下述拆分：
 * "one.two.three" 拆分为 "one", "two", "three"
 * "four.five" 拆分为 "four", "five"
 * "six" 拆分为 "six"
 * 因此，结果数组为 ["one","two","three","four","five","six"] 。
 * 示例 2：
 * 输入：words = ["$easy$","$problem$"], separator = "$"
 * 输出：["easy","problem"]
 * 解释：在本示例中，我们进行下述拆分：
 * "$easy$" 拆分为 "easy"（不包括空字符串）
 * "$problem$" 拆分为 "problem"（不包括空字符串）
 * 因此，结果数组为 ["easy","problem"] 。
 * 示例 3：
 * 输入：words = ["|||"], separator = "|"
 * 输出：[]
 * 解释：在本示例中，"|||" 的拆分结果将只包含一些空字符串，所以我们返回一个空数组 [] 。
 * 提示：
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * words[i] 中的字符要么是小写英文字母，要么就是字符串 ".,|$#@" 中的字符（不包括引号）
 * separator 是字符串 ".,|$#@" 中的某个字符（不包括引号）
 */
public class Solution2788 {

    /**
     * 模拟：遍历每一个字符串，遇到分割符号就重新记录字符串，每一个元素遍历完后进行空字符串校验
     * @param words     单词字符串
     * @param separator 分隔符
     * @return 分割后的字符串集合
     */
    public List<String> splitWordsBySeparator1(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        for (String word : words) {
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) != separator) {
                    str.append(word.charAt(j));
                } else if ((word.charAt(j) == separator) && (str.length() != 0)) {
                    ans.add(str.toString());
                    str = new StringBuilder();
                }
            }
            if (!str.isEmpty()) {
                ans.add(str.toString());
                str = new StringBuilder();
            }
        }
        return ans;
    }

    /**
     * 双指针：左指针记录右指针寻找到的分割符，右指针寻找字符串的边界即可
     * @param words     单词字符串
     * @param separator 分隔符
     * @return 分割后的字符串集合
     */
    public List<String> splitWordsBySeparator2(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int left = 0;
            int right = 0;
            while (right < word.length()) {
                if (word.charAt(right) == separator || right +1 == word.length()) {//右指针只需要在结尾或者分割符处进行操作
                    if (word.charAt(right) != separator) {//当前位置为结尾且不是分割符
                        ans.add(word.substring(left, right + 1));//左闭右开
                    } else if (right > left) {//当前位置是分割符
                        ans.add(word.substring(left, right));
                    }
                    left = right + 1;
                }
                right++;
            }
        }
        return ans;
    }

    /**
     * 双指针：左指针记录右指针寻找到的分割符，右指针寻找字符串的边界即可
     * @param words     单词字符串
     * @param separator 分隔符
     * @return 分割后的字符串集合
     */
    public List<String> splitWordsBySeparator3(List<String> words, char separator) {
        List<String> ans = new ArrayList<>();
        for (String word : words) {
            int left = 0;
            int right = 0;
            while (right < word.length()) {
                right++;
                if (right == word.length() || word.charAt(right - 1) == separator) {//右指针只需要在结尾或者分割符处进行操作
                    if (word.charAt(right - 1) != separator) {//当前位置为结尾且不是分割符
                        ans.add(word.substring(left, right));//左闭右开
                    } else if (right - 1 > left) {//当前位置是分割符
                        ans.add(word.substring(left, right - 1));
                    }
                    left = right;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2788 solution2788 = new Solution2788();
        List<String> list = Arrays.asList("one.two.three","four.five","six");
        List<String> ans = solution2788.splitWordsBySeparator2(list, '.');
        System.out.println(Arrays.toString(ans.toArray()));
    }
}
