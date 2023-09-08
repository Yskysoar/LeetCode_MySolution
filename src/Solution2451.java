/**
 * @author Yskysoar
 * @createTime 2023-05-25 12:35
 * @description 2451. 差值数组不同的字符串
 * 给你一个字符串数组 words ，每一个字符串长度都相同，令所有字符串的长度都为 n 。
 * 每个字符串 words[i] 可以被转化为一个长度为 n - 1 的 差值整数数组 difference[i] ，
 * 其中对于 0 <= j <= n - 2 有 difference[i][j] = words[i][j+1] - words[i][j] 。
 * 注意两个字母的差值定义为它们在字母表中 位置 之差，也就是说 'a' 的位置是 0 ，'b' 的位置是 1 ，'z' 的位置是 25 。
 * 比方说，字符串 "acb" 的差值整数数组是 [2 - 0, 1 - 2] = [2, -1] 。
 * words 中所有字符串 除了一个字符串以外 ，其他字符串的差值整数数组都相同。你需要找到那个不同的字符串。
 * 请你返回 words中 差值整数数组 不同的字符串
 * 示例 1：
 * <p>
 * 输入：words = ["adc","wzy","abc"]
 * 输出："abc"
 * 解释：
 * - "adc" 的差值整数数组是 [3 - 0, 2 - 3] = [3, -1] 。
 * - "wzy" 的差值整数数组是 [25 - 22, 24 - 25]= [3, -1] 。
 * - "abc" 的差值整数数组是 [1 - 0, 2 - 1] = [1, 1] 。
 * 不同的数组是 [1, 1]，所以返回对应的字符串，"abc"。
 * 示例 2：
 * <p>
 * 输入：words = ["aaa","bob","ccc","ddd"]
 * 输出："bob"
 * 解释：除了 "bob" 的差值整数数组是 [13, -13] 以外，其他字符串的差值整数数组都是 [0, 0] 。
 */
public class Solution2451 {
    public static void main(String[] args) {
        Solution2451 solution2451 = new Solution2451();
        String ans = solution2451.oddString(new String[]{"ddd", "poo", "baa", "onn"});
        System.out.println(ans);
    }

    public String oddString(String[] words) {
        int n = words.length;
        int len = words[0].length();
        for (int i = 1; i < len; i++) {
            int temp1 = words[0].charAt(i) - words[0].charAt(i - 1);
            int temp2 = words[1].charAt(i) - words[1].charAt(i - 1);
            if (temp1 != temp2) {
                int temp3 = words[2].charAt(i) - words[2].charAt(i - 1);
                if (temp3 == temp1) {
                    return words[1];
                } else return words[0];
            } else {
                for (int j = 2; j < n; j++) {
                    int temp3 = words[j].charAt(i) - words[j].charAt(i - 1);
                    if (temp3 != temp2) {
                        return words[j];
                    }
                }
            }
        }
        return "";
    }

//    public String oddString(String[] words) {
//        String ans = "";
//        int length = 1;
//        int[] num = new int[words[0].length() - 1];
//        HashSet<String> set = new HashSet<>();
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words[i].length() - 1; j++) {
//                num[j] = words[i].charAt(j + 1) - words[i].charAt(j);
//            }
//            set.add(Arrays.toString(num));
//            if (length != set.size()) {
//
//            }
//            ans = words[i];
//        }
//        return ans;
//    }
}
