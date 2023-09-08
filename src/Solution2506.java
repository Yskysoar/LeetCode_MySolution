import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @author Yskysoar
 * @createTime 2023-03-09 21:39
 * @description 2506. 统计相似字符串对的数目
 * 给你一个下标从 0 开始的字符串数组 words 。
 *
 * 如果两个字符串由相同的字符组成，则认为这两个字符串 相似 。
 *
 * 例如，"abca" 和 "cba" 相似，因为它们都由字符 'a'、'b'、'c' 组成。
 * 然而，"abacba" 和 "bcfd" 不相似，因为它们不是相同字符组成的。
 * 请你找出满足字符串 words[i] 和 words[j] 相似的下标对 (i, j) ，并返回下标对的数目，其中 0 <= i < j <= word.length - 1
 * 示例 1：
 *
 * 输入：words = ["aba","aabb","abcd","bac","aabc"]
 * 输出：2
 * 解释：共有 2 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 3 且 j = 4 ：words[3] 和 words[4] 只由字符 'a'、'b' 和 'c' 。
 * 示例 2：
 *
 * 输入：words = ["aabb","ab","ba"]
 * 输出：3
 * 解释：共有 3 对满足条件：
 * - i = 0 且 j = 1 ：words[0] 和 words[1] 只由字符 'a' 和 'b' 组成。
 * - i = 0 且 j = 2 ：words[0] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * - i = 1 且 j = 2 ：words[1] 和 words[2] 只由字符 'a' 和 'b' 组成。
 * 示例 3：
 *
 * 输入：words = ["nba","cba","dba"]
 * 输出：0
 * 解释：不存在满足条件的下标对，返回 0 。
 */
public class Solution2506 {
    public static void main(String[] args) {
        Solution2506 solution2506 = new Solution2506();
        int ans = solution2506.similarPairs2(new String[]{"aabb","ab","ba"});
        System.out.println(ans);
    }

    /**
     * set去重
     * @param words 单词组
     * @return 有多少相似单词
     */
    public int similarPairs1(String[] words) {
        int number = words.length;//单词的数量
        int count =0;//记录有多少相似数据
        String[] nums = new String[number];
        for (int i = 0; i < number; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = 0; j < words[i].length(); j++) {
                set.add(words[i].charAt(j));
            }
            Iterator<Character> integer = set.iterator();
            StringBuilder temp = new StringBuilder();
            while (integer.hasNext()) {
                temp.append(integer.next());
            }
            nums[i] = String.valueOf(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i].equals(nums[j])) count++;
            }
        }
        return count;
    }

    /**
     * 暴力
     * @param words 单词组
     * @return 有多少相似单词
     */
    public int similarPairs2(String[] words) {
        int number = words.length;//单词的数量
        int count =0;//记录有多少相似数据
        int[][] nums = new int[number][26];//记录每个字母的数量
        for (int i = 0; i < number; i++) {
            for (char c : words[i].toCharArray()) {
                nums[i][c - 'a'] = 1;
            }
        }
        for (int i = 0; i < number; i++) {
            for (int j = i + 1; j < number; j++) {
                if (Arrays.equals(nums[i], nums[j])) count++;//比较两组字母对应是否相同，相同即为相似
            }
        }
        return count;
    }
}
