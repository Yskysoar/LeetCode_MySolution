/**
 * @author Yskysoar
 * @createTime 2025-02-02 13:49
 * @description 598.区间加法 II
 * 给你一个 m x n 的矩阵 M 和一个操作数组 op 。矩阵初始化时所有的单元格都为 0 。ops[i] = [ai, bi] 意味着当所有的 0 <= x < ai 和 0 <= y < bi 时， M[x][y] 应该加 1。
 * 在 执行完所有操作后 ，计算并返回 矩阵中最大整数的个数 。
 * 示例 1:
 * 输入: m = 3, n = 3，ops = [[2,2],[3,3]]
 * 输出: 4
 * 解释: M 中最大的整数是 2, 而且 M 中有4个值为2的元素。因此返回 4。
 * 示例 2:
 * 输入: m = 3, n = 3, ops = [[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3],[2,2],[3,3],[3,3],[3,3]]
 * 输出: 4
 * 示例 3:
 * 输入: m = 3, n = 3, ops = []
 * 输出: 9
 * 提示:
 * 1 <= m, n <= 4 * 10^4
 * 0 <= ops.length <= 10^4
 * ops[i].length == 2
 * 1 <= ai <= m
 * 1 <= bi <= n
 */
public class Solution598 {

    /**
     * 脑筋急转弯：左上角的矩阵一直在叠加，所有操作中ai最小值和bi最小值所覆盖的就是叠加最大的矩阵
     * @param m   矩阵长
     * @param n   矩阵宽
     * @param ops 操作数组
     * @return 叠加整数的个数
     */
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int aMin = Integer.MAX_VALUE;
        int bMin = Integer.MAX_VALUE;
        for (int[] op : ops) {
            aMin = Math.min(op[0], aMin);
            bMin = Math.min(op[1], bMin);
        }
        return aMin * bMin;
    }
}
