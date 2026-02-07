/**
 * @author Yskysoar
 * @createTime 2026-02-07 16:27
 * @description 1653. 使字符串平衡的最少删除次数
 * 给你一个字符串 s ，它仅包含字符 'a' 和 'b' 。
 * 你可以删除 s 中任意数目的字符，使得 s 平衡 。当不存在下标对 (i,j) 满足 i < j ，且 s[i] = 'b' 的同时 s[j]= 'a' ，此时认为 s 是 平衡 的。
 * 请你返回使 s 平衡 的 最少 删除次数。
 * 示例 1：
 * 输入：s = "aababbab"
 * 输出：2
 * 解释：你可以选择以下任意一种方案：
 * 下标从 0 开始，删除第 2 和第 6 个字符（"aababbab" -> "aaabbb"），
 * 下标从 0 开始，删除第 3 和第 6 个字符（"aababbab" -> "aabbbb"）。
 * 示例 2：
 * 输入：s = "bbaaaaabb"
 * 输出：2
 * 解释：唯一的最优解是删除最前面两个字符。
 * 提示：
 * 1 <= s.length <= 10^5
 * s[i] 要么是 'a' 要么是 'b'
 */
public class Solution1653 {
    public static void main(String[] args) {
        Solution1653 solution1653 = new Solution1653();
        int ans = solution1653.minimumDeletions("bbbbbbbbbbbbbb");
        System.out.println(ans);
    }

    /**
     * 枚举
     * 记录A和B的个数，取点枚举，分别删除左边的所有B以及删除右边的所有A，记录最小操作数即可
     * @param s 不平衡字符串
     * @return 最小操作数
     */
    public int minimumDeletions(String s) {
        int ans = Integer.MAX_VALUE;
        int[][] nums = new int[s.length() + 1][2];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') {
                nums[i + 1][0] += nums[i][0] + 1;
                nums[i + 1][1] += nums[i][1];
            } else {
                nums[i + 1][0] += nums[i][0];
                nums[i + 1][1] += nums[i][1] + 1;
            }
        }
        for (int[] num : nums) {//分割处归左
            int count = 0;
            //删除左边的所有B
            count += num[1];
            //删除右边的所有A
            count += (nums[nums.length - 1][0] - num[0]);
            ans = Math.min(ans, count);
        }
        return ans;
    }
}
