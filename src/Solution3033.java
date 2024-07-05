import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2024-07-05 9:04
 * @description 3033. 修改矩阵
 * 给你一个下标从 0 开始、大小为 m x n 的整数矩阵 matrix ，新建一个下标从 0 开始、名为 answer 的矩阵。使 answer 与 matrix 相等，接着将其中每个值为 -1 的元素替换为所在列的 最大 元素。
 * 返回矩阵 answer 。
 * 示例 1：
 * 输入：matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
 * 输出：[[1,2,9],[4,8,6],[7,8,9]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * - 将单元格 [1][1] 中的值替换为列 1 中的最大值 8 。
 * - 将单元格 [0][2] 中的值替换为列 2 中的最大值 9 。
 * 示例 2：
 * 输入：matrix = [[3,-1],[5,2]]
 * 输出：[[3,2],[5,2]]
 * 解释：上图显示了发生替换的元素（蓝色区域）。
 * 提示：
 * m == matrix.length
 * n == matrix[i].length
 * 2 <= m, n <= 50
 * -1 <= matrix[i][j] <= 100
 * 测试用例中生成的输入满足每列至少包含一个非负整数。
 */
public class Solution3033 {
    public static void main(String[] args) {
        Solution3033 solution3033 = new Solution3033();
        int[][] ans = solution3033.modifiedMatrix(new int[][]{{1, 2, -1}, {4, -1, 6}, {7, 8, 9}});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 双层暴力遍历，在复制的时候寻找每一列的最大值和元素值为-1的行索引
     * @param matrix 待修改数组
     * @return -1被替换后数组
     */
    public int[][] modifiedMatrix(int[][] matrix) {
        int[][] ans = new int[matrix.length][matrix[0].length];
        for (int j = 0; j < matrix[0].length; j++) {
            int max = 0;
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < matrix.length; i++) {
                if (matrix[i][j] > matrix[max][j]) max = i;
                if (matrix[i][j] == -1) nums.add(i);
                ans[i][j] = matrix[i][j];
            }
            for (Integer num : nums) {
                ans[num][j] = matrix[max][j];
            }
        }
        return ans;
    }
}
