/**
 * @author Yskysoar
 * @createTime 2025-07-01 0:16
 * @description 3330. 找到初始输入字符串 I
 * Alice 正在她的电脑上输入一个字符串。但是她打字技术比较笨拙，她 可能 在一个按键上按太久，导致一个字符被输入 多次 。
 * 尽管 Alice 尽可能集中注意力，她仍然可能会犯错 至多 一次。
 * 给你一个字符串 word ，它表示 最终 显示在 Alice 显示屏上的结果。
 * 请你返回 Alice 一开始可能想要输入字符串的总方案数。
 * 示例 1：
 * 输入：word = "abbcccc"
 * 输出：5
 * 解释：
 * 可能的字符串包括："abbcccc" ，"abbccc" ，"abbcc" ，"abbc" 和 "abcccc" 。
 * 示例 2：
 * 输入：word = "abcd"
 * 输出：1
 * 解释：
 * 唯一可能的字符串是 "abcd" 。
 * 示例 3：
 * 输入：word = "aaaa"
 * 输出：4
 * 提示：
 * 1 <= word.length <= 100 abbaa abaa abba
 * word 只包含小写英文字母
 */
public class Solution3330 {

    /**
     * 双指针查找相同元素区间，至多犯错一次，即犯错的时候就是当前连续区间的长度-1种情况
     * @param word 字符串
     * @return 可能的字符串数量
     */
    public int possibleStringCount(String word) {//哈希表无法区分重复元素是否连续，例如abbaa的情况
        int ans = 0;
        for (int left = 0, right = 0; right <= word.length(); right++) {
            if (right == word.length() || word.charAt(right) != word.charAt(left)) {
                ans += right - left - 1;
                left = right;
            }
        }
        return ans + 1;
    }
}
