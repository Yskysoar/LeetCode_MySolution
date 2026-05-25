/**
 * @author Yskysoar
 * @createTime 2026-05-25 17:32
 * @description 1871. 跳跃游戏 VII
 * 给你一个下标从 0 开始的二进制字符串 s 和两个整数 minJump 和 maxJump 。一开始，你在下标 0 处，且该位置的值一定为 '0' 。当同时满足如下条件时，你可以从下标 i 移动到下标 j 处：
 * i + minJump <= j <= min(i + maxJump, s.length - 1) 且
 * s[j] == '0'.
 * 如果你可以到达 s 的下标 s.length - 1 处，请你返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：s = "011010", minJump = 2, maxJump = 3
 * 输出：true
 * 解释：
 * 第一步，从下标 0 移动到下标 3 。
 * 第二步，从下标 3 移动到下标 5 。
 * 示例 2：
 * 输入：s = "01101110", minJump = 2, maxJump = 3
 * 输出：false
 * 提示：
 * 2 <= s.length <= 10^5
 * s[i] 要么是 '0' ，要么是 '1'
 * s[0] == '0'
 * 1 <= minJump <= maxJump < s.length
 */
public class Solution1871 {
    public static void main(String[] args) {
        Solution1871 solution1871 = new Solution1871();
        boolean ans = solution1871.canReach("011010", 2, 3);
        System.out.println(ans);
    }

    /**
     * 双指针
     * 每次记录能达到的范围，控制边界，已经标记过的地方不用标记了
     * @param s       字符串
     * @param minJump 最小跳跃距离
     * @param maxJump 最大跳跃距离
     * @return 是否可以到达结尾
     */
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] canReaches = new boolean[n];
        canReaches[0] = true;

        for (int i = 0, j = 0; i < n && j < n; i++) {
            if (canReaches[i] && s.charAt(i) == '0') {
                // 注意 j 只会增大，不会减小，所以总体时间复杂度是 O(n)
                for (j = Math.max(j, i + minJump); j <= Math.min(i + maxJump, n - 1); j++) {//已经标记过的不用再标记了
                    canReaches[j] = true; // 可以跳到 j
                }
            }
        }
        return canReaches[n - 1] && s.charAt(n - 1) == '0';
    }
}
    