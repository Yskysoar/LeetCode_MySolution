/**
 * @author Yskysoar
 * @createTime 2024-04-11 8:34
 * @description 263. 丑数
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：n = 6
 * 输出：true
 * 解释：6 = 2 × 3
 * 示例 2：
 * 输入：n = 1
 * 输出：true
 * 解释：1 没有质因数，因此它的全部质因数是 {2, 3, 5} 的空集。习惯上将其视作第一个丑数。
 * 示例 3：
 * 输入：n = 14
 * 输出：false
 * 解释：14 不是丑数，因为它包含了另外一个质因数 7 。
 * 提示：
 * -2^31 <= n <= 2^31 - 1
 */
public class Solution263 {
    public static void main(String[] args) {
        Solution263 solution263 = new Solution263();
        boolean ans = solution263.isUgly(14);
        System.out.println(ans);
    }

    /**
     * 循环遍历 n=2^a+3^b+3^c
     * @param n 待判断元素
     * @return 判断结果
     */
    public boolean isUgly(int n) {
        if (n <= 0) return false;
        int[] nums = new int[]{2, 3, 5};
        for (int num : nums) {
            while (n % num == 0) {
                n /= num;
            }
        }
        return n == 1;
    }
}
