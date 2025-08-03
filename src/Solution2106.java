/**
 * @author Yskysoar
 * @createTime 2025-08-03 15:04
 * @description 2106. 摘水果
 * 在一个无限的 x 坐标轴上，有许多水果分布在其中某些位置。给你一个二维整数数组 fruits ，其中 fruits[i] = [positioni, amounti] 表示共有 amounti 个水果放置在 positioni
 * 上。fruits 已经按 positioni 升序排列 ，每个 positioni 互不相同 。
 * 另给你两个整数 startPos 和 k 。最初，你位于 startPos 。从任何位置，你可以选择 向左或者向右 走。在 x 轴上每移动 一个单位 ，就记作 一步 。你总共可以走 最多 k
 * 步。你每达到一个位置，都会摘掉全部的水果，水果也将从该位置消失（不会再生）。
 * 返回你可以摘到水果的 最大总数 。
 * 示例 1：
 * 输入：fruits = [[2,8],[6,3],[8,6]], startPos = 5, k = 4
 * 输出：9
 * 解释：
 * 最佳路线为：
 * - 向右移动到位置 6 ，摘到 3 个水果
 * - 向右移动到位置 8 ，摘到 6 个水果
 * 移动 3 步，共摘到 3 + 6 = 9 个水果
 * 示例 2：
 * 输入：fruits = [[0,9],[4,1],[5,7],[6,2],[7,4],[10,9]], startPos = 5, k = 4
 * 输出：14
 * 解释：
 * 可以移动最多 k = 4 步，所以无法到达位置 0 和位置 10 。
 * 最佳路线为：
 * - 在初始位置 5 ，摘到 7 个水果
 * - 向左移动到位置 4 ，摘到 1 个水果
 * - 向右移动到位置 6 ，摘到 2 个水果
 * - 向右移动到位置 7 ，摘到 4 个水果
 * 移动 1 + 3 = 4 步，共摘到 7 + 1 + 2 + 4 = 14 个水果
 * 示例 3：
 * 输入：fruits = [[0,3],[6,4],[8,5]], startPos = 3, k = 2
 * 输出：0
 * 解释：
 * 最多可以移动 k = 2 步，无法到达任一有水果的地方
 * 提示：
 * 1 <= fruits.length <= 10^5
 * fruits[i].length == 2
 * 0 <= startPos, positioni <= 2 * 10^5
 * 对于任意 i > 0 ，positioni-1 < positioni 均成立（下标从 0 开始计数）
 * 1 <= amounti <= 10^4
 * 0 <= k <= 2 * 10^5
 */
public class Solution2106 {
    public static void main(String[] args) {
        Solution2106 solution2106 = new Solution2106();
        int ans = solution2106.maxTotalFruits(new int[][]{{0, 10000}}, 200000, 200000);
        System.out.println(ans);
    }

    /**
     * 前缀和 + 滑动窗口
     * 最优的移动路线肯定在L、R、LR、RL中，多次转向需要浪费k去遍历空位置
     * 要使得转向有效，就必须保证转向后可以越过起点，即单向移动不多于k/2
     * @param fruits   水果位置和数量
     * @param startPos 起点
     * @param k        可移动步数
     * @return 最大的可获取水果数量
     */
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int[] preSum = new int[Math.max(fruits[fruits.length - 1][0] + 1, startPos + 1) + 1];//内+1是数组长度，外+1是前缀和哨兵
        for (int[] fruit : fruits) preSum[fruit[0] + 1] = fruit[1];
        for (int i = 1; i < preSum.length; i++) preSum[i] += preSum[i - 1];
        //不转向移动 L/R
        int leftSum = preSum[startPos + 1] - preSum[Math.max(startPos - k, 0)];
        int rightSum = preSum[Math.min(startPos + k + 1, preSum.length - 1)] - preSum[startPos];
        int ans = Math.max(leftSum, rightSum);
        //一次转向（最多移动k/2就转向，否则不可能回到起点）
        for (int i = (k / 2); i > 0; i--) {//需要处理边界
            leftSum = preSum[Math.min(startPos + (k - 2 * i) + 1, preSum.length - 1)] - preSum[Math.max(startPos - i, 0)];
            rightSum = preSum[Math.min(startPos + i + 1, preSum.length - 1)] - preSum[Math.max(startPos - (k - 2 * i), 0)];
            ans = Math.max(ans, Math.max(leftSum, rightSum));
        }
        return ans;
    }
}
