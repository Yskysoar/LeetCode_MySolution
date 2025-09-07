import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-09-07 18:01
 * @description 1304. 和为零的 N 个不同整数
 * 给你一个整数 n，请你返回 任意 一个由 n 个 各不相同 的整数组成的数组，并且这 n 个数相加和为 0 。
 * 示例 1：
 * 输入：n = 5
 * 输出：[-7,-1,1,3,4]
 * 解释：这些数组也是正确的 [-5,-1,1,2,3]，[-3,-1,2,-2,4]。
 * 示例 2：
 * 输入：n = 3
 * 输出：[-1,0,1]
 * 示例 3：
 * 输入：n = 1
 * 输出：[0]
 * 提示：
 * 1 <= n <= 1000
 */
public class Solution1304 {
    public static void main(String[] args) {
        Solution1304 solution1304 = new Solution1304();
        int[] ans = solution1304.sumZero(6);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 数学
     * 找到分割点，左右对称填入即可
     * @param n 结果数组的长度
     * @return 所有元素之和为0的数组
     */
    public int[] sumZero(int n) {
        int[] ans = new int[n];
        for (int i = 0; i < n / 2; i++) {//对称填入，奇数中间自动补0
            ans[i] = i + 1;
            ans[n - i - 1] = -i - 1;
        }
        return ans;
    }
}
