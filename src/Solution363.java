/**
 * @author Yskysoar
 * @createTime 2023-08-01 23:25
 * @description 363.矩形区域不超过k的最大数值和
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * 示例 1：
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域 [[0, 1], [-2, 3]] 的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 */
public class Solution363 {
    public static void main(String[] args) {
        Solution363 solution363 = new Solution363();
        int ans = solution363.maxSumSubmatrix(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 19);
        System.out.println(ans);
    }

    /**
     * 暴力遍历+前缀和(索引值为子举证右下角坐标，若索引值为x,y，则前缀和为(0~x)&(0~y)范围的元素之和)
     * @param matrix 二维矩阵
     * @param k 目标值
     * @return 不超过k的最大数值和
     */
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int ans = Integer.MIN_VALUE;
        int[][] preSums = new int[matrix.length + 1][matrix[0].length + 1];
        //计算以每个元素为右下角的子矩阵的和
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                preSums[i][j] = matrix[i - 1][j - 1] + preSums[i][j - 1] + (preSums[i - 1][j] - preSums[i - 1][j - 1]);
            }
        }
        for (int startRow = 1; startRow <= matrix.length; startRow++) {
            for (int startCol = 1; startCol <= matrix[0].length; startCol++) {
                for (int endRow = startRow; endRow <= matrix.length; endRow++) {
                    for (int endCol = startCol; endCol <= matrix[0].length; endCol++) {
                        int sum = preSums[endRow][endCol] - preSums[startRow - 1][endCol] - preSums[endRow][startCol - 1] + preSums[startRow - 1][startCol - 1];
                        if (sum <= k) ans = Math.max(ans, sum);
                    }
                }
            }
        }
        return ans;
    }
}
