import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-08-25 0:15
 * @description 498. 对角线遍历
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 * 示例 1：
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,4,7,5,3,6,8,9]
 * 示例 2：
 * 输入：mat = [[1,2],[3,4]]
 * 输出：[1,2,3,4]
 * 提示：
 * m == mat.length
 * n == mat[i].length
 * 1 <= m, n <= 10^4
 * 1 <= m * n <= 10^4
 * -10^5 <= mat[i][j] <= 10^5
 */
public class Solution498 {
    public static void main(String[] args) {
        Solution498 solution498 = new Solution498();
        int[] ans = solution498.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 一共有mat.length + mat[0].length - 1个对角线，每层横轴坐标之和为层数（从0开始计数）
     * 行和列从范围内开始记录，超出范围结束
     * @param mat 待遍历矩阵
     * @return 对角线遍历结果
     */
    public int[] findDiagonalOrder(int[][] mat) {
        int[] ans = new int[mat.length * mat[0].length];
        int index = 0, row = 0, col = 0;//ans索引、行、列
        for (int k = 0; k < (mat.length + mat[0].length - 1); k++) {
            if (k % 2 == 0) {//偶数层从行开始减
                for (row = k, col = 0; row >= 0; row--, col++) {
                    if (row >= mat.length) continue;
                    if (col >= mat[0].length) break;
                    ans[index++] = mat[row][col];
                }
            } else {//奇数层从列开始减
                for (row = 0, col = k; col >= 0; row++, col--) {
                    if (col >= mat[0].length) continue;
                    if (row >= mat.length) break;
                    ans[index++] = mat[row][col];
                }
            }
        }
        return ans;
    }
}
