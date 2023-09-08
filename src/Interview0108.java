import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2023-02-17 14:03
 * @description 面试题 01.08. 零矩阵
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * 示例 1
 * 输入：           输出：
 * [             [
 *   [1,1,1],      [1,0,1],
 *   [1,0,1],      [0,0,0],
 *   [1,1,1]       [1,0,1]
 * ]             ]
 *
 * 示例 2
 * 输入：            输出：
 * [              [
 *   [0,1,2,0],     [0,0,0,0],
 *   [3,4,5,2],     [0,4,5,0],
 *   [1,3,1,5]      [0,3,1,0]
 * ]              ]
 */
public class Interview0108 {
    public static void main(String[] args) {
        Interview0108 interview0108 = new Interview0108();
        int[][] matrix = new int[][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        interview0108.setZeroes(matrix);
        for (int[] ints : matrix) {
            System.out.println(Arrays.toString(ints));
        }

    }

    /**
     * 模拟法：找到要清零的行列然后进行操作
     * @param matrix 要处理的数组
     */
    public void setZeroes(int[][] matrix) {
        int row = matrix.length;//行
        int col = matrix[0].length;//列
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();

        //记录要清零的行和列(去重减少操作)
        for (int i = 0; i < row * col; i++) {
            if (matrix[i % row][i / row] == 0) {
                rowSet.add(i % row);
                colSet.add(i / row);
            }
        }
        //清零
        for (int index : rowSet) {
            for (int i = 0; i < col; i++) {
                matrix[index][i] = 0;
            }
        }
        for (int index : colSet) {
            for (int i = 0; i < row; i++) {
                matrix[i][index] = 0;
            }
        }
    }
}


