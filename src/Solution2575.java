import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2024-03-07 8:27
 * @description 2575. 找出字符串的可整除数组
 * 给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
 * word 的 可整除数组 div  是一个长度为 n 的整数数组，并满足：
 * 如果 word[0, ..., i] 所表示的 数值 能被 m 整除，div[i] = 1
 * 否则，div[i] = 0
 * 返回 word 的可整除数组。
 * 示例 1：
 * 输入：word = "998244353",  m = 3
 * 输出：[1, 1, 0, 0, 0, 1, 1, 0, 0]
 * 解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
 * 示例 2：
 * 输入：word = "1010",  m = 10
 * 输出：[0, 1, 0, 1]
 * 解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
 * 提示：
 * 1 <= n <= 10^5
 * word.length == n
 * word 由数字 0 到 9 组成
 * 1 <= m <= 10^9
 */
public class Solution2575 {
    public static void main(String[] args) {
        Solution2575 solution2575 = new Solution2575();
        int[] ans = solution2575.divisibilityArray("100000000010000000003019999999961000000000", 1000000000);
        System.out.println(Arrays.toString(ans));
        System.out.println(" 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0");
    }

    /**
     * 单次遍历：每次都只考虑当前数位的数以及上一位的余数，（余数*10+本数位）就是要计算的数据，这样不会数据溢出
     * @param word 字符串
     * @param m    取余数
     * @return 可整除数组
     */
    public int[] divisibilityArray(String word, int m) {
        int[] ans = new int[word.length()];
        long remainder;
        long num = 0;
        for (int i = 0; i < word.length(); i++) {
            long prefix = word.charAt(i) - '0';
            remainder = ((num == 0) ? (prefix % m) : (prefix + num * 10) % m);//根据上一位是否整除，计算本位余数
            ans[i] = (remainder == 0 ? 1 : 0);
            num = remainder;//记录本位余数
        }
        return ans;
    }

}
