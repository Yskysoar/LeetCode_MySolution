/**
 * @author Yskysoar
 * @createTime 2023-08-01 14:00
 * @description 1074.元素和为目标值的子矩阵数量
 * 给出矩阵 matrix 和目标值 target，返回元素总和等于目标值的非空子矩阵的数量。
 * 子矩阵 x1, y1, x2, y2 是满足 x1 <= x <= x2 且 y1 <= y <= y2 的所有单元 matrix[x][y] 的集合。
 * 如果 (x1, y1, x2, y2) 和 (x1', y1', x2', y2') 两个子矩阵中部分坐标不同（如：x1 != x1'），那么这两个子矩阵也不同。
 * 示例 1：
 * 输入：matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
 * 输出：4
 * 解释：四个只含 0 的 1x1 子矩阵。
 * 示例 2：
 * 输入：matrix = [[1,-1],[-1,1]], target = 0
 * 输出：5
 * 解释：两个 1x2 子矩阵，加上两个 2x1 子矩阵，再加上一个 2x2 子矩阵。
 * 示例 3：
 * 输入：matrix = [[904]], target = 0
 * 输出：0
 */
public class Solution1074 {
    public static void main(String[] args) {
        Solution1074 solution1074 = new Solution1074();
        int ans = solution1074.numSubmatrixSumTarget(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 21);
        System.out.println(ans);
    }


    /**
     * 暴力遍历+前缀和(索引值为子举证右下角坐标，若索引值为x,y，则前缀和为(0~x)&(0~y)范围的元素之和)
     * @param matrix 二维矩阵
     * @param target 目标值
     * @return 子矩阵元素和等于目标值的个数
     */
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int ans = 0;
        int[][] preSums = new int[matrix.length + 1][matrix[0].length + 1];
        //计算以每个元素为右下角的子矩阵的和
        for (int i = 1; i <= matrix.length; i++) {
            for (int j = 1; j <= matrix[0].length; j++) {
                preSums[i][j] = preSums[i][j - 1] + (preSums[i - 1][j] - preSums[i - 1][j - 1]) + matrix[i - 1][j - 1];
            }
        }
        for (int startRow = 1; startRow <= matrix.length; startRow++) {
            for (int startCol = 1; startCol <= matrix[0].length; startCol++) {
                for (int endRow = startRow; endRow <= matrix.length; endRow++) {
                    for (int endCol = startCol; endCol <= matrix[0].length; endCol++) {
                        if ((preSums[endRow][endCol] - preSums[startRow - 1][endCol] - preSums[endRow][startCol - 1] + preSums[startRow - 1][startCol - 1]) == target)
                            ans++;
                    }
                }
            }
        }
        return ans;
    }
}
