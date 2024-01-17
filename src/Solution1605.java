import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-03-14 0:10
 * @description 1605. 给定行和列的和求可行矩阵
 * 给你两个非负整数数组 rowSum 和 colSum ，其中 rowSum[i] 是二维矩阵中第 i 行元素的和， colSum[j] 是第 j 列元素的和。
 * 换言之你不知道矩阵里的每个元素，但是你知道每一行和每一列的和。
 * 请找到大小为 rowSum.length x colSum.length 的任意 非负整数 矩阵，且该矩阵满足 rowSum 和 colSum 的要求。
 * 请你返回任意一个满足题目要求的二维矩阵，题目保证存在 至少一个 可行矩阵。
 * 示例 1：
 * 输入：rowSum = [3,8], colSum = [4,7]
 * 输出：[[3,0],
 * [1,7]]
 * 解释：
 * 第 0 行：3 + 0 = 3 == rowSum[0]
 * 第 1 行：1 + 7 = 8 == rowSum[1]
 * 第 0 列：3 + 1 = 4 == colSum[0]
 * 第 1 列：0 + 7 = 7 == colSum[1]
 * 行和列的和都满足题目要求，且所有矩阵元素都是非负的。
 * 另一个可行的矩阵为：[[1,2],
 * [3,5]]
 * 示例 2：
 * 输入：rowSum = [5,7,10], colSum = [8,6,8]
 * 输出：[[0,5,0],
 * [6,1,0],
 * [2,0,8]]
 * 示例 3：
 * 输入：rowSum = [14,9], colSum = [6,9,8]
 * 输出：[[0,9,5],
 * [6,0,3]]
 * 示例 4：
 * 输入：rowSum = [1,0], colSum = [1]
 * 输出：[[1],
 * [0]]
 * 示例 5：
 * 输入：rowSum = [0], colSum = [0]
 * 输出：[[0]]
 */
public class Solution1605 {
    public static void main(String[] args) {
        Solution1605 solution1605 = new Solution1605();
        int[][] ans = solution1605.restoreMatrix(new int[]{8, 7, 10}, new int[]{5, 7, 9, 4});
        System.out.println(Arrays.deepToString(ans));
    }

    /**
     * 已知行列和求可行矩阵(题目有解)：比较当前位置行和/列和的较小值，将其放入当前位置，对应行和和列和减去当前位置的值然后去下一个位置，可以保证每次放的数据是最优解
     * @param rowSum 每一行的和
     * @param colSum 每一列的和
     * @return 一个可行矩阵
     */
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] ans = new int[rowSum.length][colSum.length];//生成一个对应的二维矩阵
        for (int i = 0; i < rowSum.length; i++) {
            for (int j = 0; j < colSum.length; j++) {
                ans[i][j] = Math.min(rowSum[i], colSum[j]);//每次都放入行和或列和中较小的一个保证可以正常放入
                rowSum[i] -= ans[i][j];//减去当前放入的行值
                colSum[j] -= ans[i][j];//减去当前放入的列值
            }
        }
        return ans;
    }
}

//    int[][] ans = new int[rowSum.length][colSum.length];//生成一个对应的二维矩阵
//        int minElem = 0;
//        int index = 0;
//        for (int i : rowSum) {
//            if (minElem < i) {
//                minElem = i;
//            }
//        }
//        for (int i = 0; i < colSum.length; i++) {
//            if (minElem < colSum[i]) {
//                index = i;
//                ans[0][i] = minElem;//因为是行和的最小值，所以放在哪一行都行
//                ans[1][i] = colSum[i] - minElem;
//                for (int j = 2; j < rowSum.length; j++) {
//                    ans[j][i] = 0;
//                }
//                break;
//            }
//        }
//
//        for (int i = 0; i < rowSum.length; i++) {
//            boolean isFlag = true;
//            for (int j = 0; j < colSum.length; j++) {
//                if (isFlag && j != index && colSum[i] > rowSum[i] - ans[i][index]) {
//                    ans[i][j] = rowSum[i] - ans[i][index];
//                    isFlag = false;
//                } else {
//                    ans[i][j] = 0;
//                }
//            }
//        }