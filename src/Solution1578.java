/**
 * @author Yskysoar
 * @createTime 2025-11-03 8:53
 * @description 1578. 使绳子变成彩色的最短时间
 * Alice 把 n 个气球排列在一根绳子上。给你一个下标从 0 开始的字符串 colors ，其中 colors[i] 是第 i 个气球的颜色。
 * Alice 想要把绳子装扮成 五颜六色的 ，且她不希望两个连续的气球涂着相同的颜色，所以她喊来 Bob 帮忙。Bob 可以从绳子上移除一些气球使绳子变成 彩色 。给你一个 下标从 0 开始 的整数数组 neededTime ，其中
 * neededTime[i] 是 Bob 从绳子上移除第 i 个气球需要的时间（以秒为单位）。
 * 返回 Bob 使绳子变成 彩色 需要的 最少时间 。
 * 示例 1：
 * 输入：colors = "abaac", neededTime = [1,2,3,4,5]
 * 输出：3
 * 解释：在上图中，'a' 是蓝色，'b' 是红色且 'c' 是绿色。
 * Bob 可以移除下标 2 的蓝色气球。这将花费 3 秒。
 * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 3 。
 * 示例 2：
 * 输入：colors = "abc", neededTime = [1,2,3]
 * 输出：0
 * 解释：绳子已经是彩色的，Bob 不需要从绳子上移除任何气球。
 * 示例 3：
 * 输入：colors = "aabaa", neededTime = [1,2,3,4,1]
 * 输出：2
 * 解释：Bob 会移除下标 0 和下标 4 处的气球。这两个气球各需要 1 秒来移除。
 * 移除后，不存在两个连续的气球涂着相同的颜色。总时间 = 1 + 1 = 2 。
 * 提示：
 * n == colors.length == neededTime.length
 * 1 <= n <= 105
 * 1 <= neededTime[i] <= 104
 * colors 仅由小写英文字母组成
 */
public class Solution1578 {
    /**
     * 贪心
     * 每次都向右比较，相同的时候永远删除较小时间的气球
     * 因为题目说明气球是连续的，并不需要真的物理删除，将其时间设置为和它比较的较大值即可完成逻辑删除
     * @param colors     气球的颜色排列
     * @param neededTime 删除该气球所需时间
     * @return 删除后无连续颜色气球的最短用时
     */
    public int minCost(String colors, int[] neededTime) {
        int ans = 0;
        for (int i = 0; i < colors.length() - 1; i++) {
            if (colors.charAt(i) == colors.charAt(i + 1)) {
                ans += Math.min(neededTime[i], neededTime[i + 1]);//贪心取较小值
                //将两个元素都赋值为较大值，逻辑删除较小值
                neededTime[i] = Math.max(neededTime[i], neededTime[i + 1]);
                neededTime[i + 1] = Math.max(neededTime[i], neededTime[i + 1]);
            }
        }
        return ans;
    }
}
