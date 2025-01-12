/**
 * @author Yskysoar
 * @createTime 2025-01-12 14:00
 * @description 2275. 按位与结果大于零的最长组合
 * 对数组 nums 执行 按位与 相当于对数组 nums 中的所有整数执行 按位与 。
 * 例如，对 nums = [1, 5, 3] 来说，按位与等于 1 & 5 & 3 = 1 。
 * 同样，对 nums = [7] 而言，按位与等于 7 。
 * 给你一个正整数数组 candidates 。计算 candidates 中的数字每种组合下 按位与 的结果。
 * 返回按位与结果大于 0 的 最长 组合的长度。
 * 示例 1：
 * 输入：candidates = [16,17,71,62,12,24,14]
 * 输出：4
 * 解释：组合 [16,17,62,24] 的按位与结果是 16 & 17 & 62 & 24 = 16 > 0 。
 * 组合长度是 4 。
 * 可以证明不存在按位与结果大于 0 且长度大于 4 的组合。
 * 注意，符合长度最大的组合可能不止一种。
 * 例如，组合 [62,12,24,14] 的按位与结果是 62 & 12 & 24 & 14 = 8 > 0 。
 * 示例 2：
 * 输入：candidates = [8,8]
 * 输出：2
 * 解释：最长组合是 [8,8] ，按位与结果 8 & 8 = 8 > 0 。
 * 组合长度是 2 ，所以返回 2 。
 * 提示：
 * 1 <= candidates.length <= 10^5
 * 1 <= candidates[i] <= 10^7
 */
public class Solution2275 {
    public static void main(String[] args) {
        Solution2275 solution2275 = new Solution2275();
        int ans = solution2275.largestCombination(new int[]{16, 16, 48, 71, 62, 12, 24, 14, 17, 18, 19, 20, 10000});
        System.out.println(ans);
    }

    /**
     * 找到对应的二进制数位上1最多的个数
     * @param candidates 数据数组
     * @return 1的个数
     */
    public int largestCombination(int[] candidates) {
        int ans = 0;
        int max = 0;
        String[] candidatesBinary = new String[candidates.length];
        for (int i = 0; i < candidates.length; i++) {//全部转换为二进制数
            max = Math.max(max, Integer.toBinaryString(candidates[i]).length());//记录最大的数位
            candidatesBinary[i] = Integer.toBinaryString(candidates[i]);
        }
        for (int i = 0; i < max; i++) {
            int num = 0;
            for (String s : candidatesBinary) {
                int index = s.length() - 1 - i;
                if (index >= 0 && s.charAt(index) - '0' == 1) {
                    num++;
                }
            }
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
