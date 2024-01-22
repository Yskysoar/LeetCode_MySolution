import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2024-01-21 23:11
 * @description 3. 无重复字符的最长子串
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 */
public class Solution3 {

    public static void main(String[] args) {
        Solution3 solution3 = new Solution3();
        int ans = solution3.lengthOfLongestSubstring("p w1 wke1b");
        System.out.println(ans);
    }

    /**
     * 滑动窗口
     * @param s 待查找字符串
     * @return 无重复字符的最长子串长度
     */
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<>();//记录查找过的字符的位置
        int ans = 0;
        String string = "";
        for (int i = 0; i < s.length(); i++) {
            if (hashMap.containsKey(s.charAt(i))) {//已经记录过该字符
                ans = Math.max(ans, string.length());//比较保存的结果和当前长度
                for (int j = 0; j <= string.indexOf(s.charAt(i)); j++) {
                    hashMap.remove(string.charAt(j));
                }//将重复的字符之前的所有字符都取消记录
                string = string.substring(string.indexOf(s.charAt(i)) + 1);//截取未重复字符
            }
            hashMap.put(s.charAt(i), i);//更新记录
            string += s.charAt(i);//拼接当前字符
        }
        return Math.max(ans, string.length());//需要考虑最后添加字符的长度是否为最大值
    }
}