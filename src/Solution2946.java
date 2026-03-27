/**
 * @author Yskysoar
 * @createTime 2026-03-27 10:06
 * @description 2946. 循环移位后的矩阵相似检查
 * 给你一个下标从 0 开始且大小为 m x n 的整数矩阵 mat 和一个整数 k 。请你将矩阵中的 奇数 行循环 右 移 k 次，偶数 行循环 左 移 k 次。
 * 如果初始矩阵和最终矩阵完全相同，则返回 true ，否则返回 false 。
 * 示例 1：
 * 输入：mat = [[1,2,1,2],[5,5,5,5],[6,3,6,3]], k = 2
 * 输出：true
 * 解释：
 * 初始矩阵如图一所示。
 * 图二表示对奇数行右移一次且对偶数行左移一次后的矩阵状态。
 * 图三是经过两次循环移位后的最终矩阵状态，与初始矩阵相同。
 * 因此，返回 true 。
 * 示例 2：
 * 输入：mat = [[2,2],[2,2]], k = 3
 * 输出：true
 * 解释：由于矩阵中的所有值都相等，即使进行循环移位，矩阵仍然保持不变。因此，返回 true 。
 * 示例 3：
 * 输入：mat = [[1,2]], k = 1
 * 输出：false
 * 解释：循环移位一次后，mat = [[2,1]]，与初始矩阵不相等。因此，返回 false 。
 * 提示：
 * 1 <= mat.length <= 25
 * 1 <= mat[i].length <= 25
 * 1 <= mat[i][j] <= 25
 * 1 <= k <= 50
 */
public class Solution2946 {
    public static void main(String[] args) {
        Solution2946 solution2946 = new Solution2946();
        boolean ans = solution2946.areSimilar1(new int[][]{{1, 2, 1, 2}, {5, 5, 5, 5}, {6, 3, 6, 3}}, 2);
        System.out.println(ans);
    }

    public boolean areSimilar1(int[][] mat, int k) {
        int p = k % mat[0].length;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (i % 2 == 0) {//left
                    if (mat[i][(j - p + mat[0].length) % mat[0].length] != mat[i][j]) return false;
                } else {
                    if (mat[i][(j + p) % mat[0].length] != mat[i][j]) return false;
                }
            }
        }
        return true;
    }

    public boolean areSimilar2(int[][] mat, int k) {
        int[][] ans = new int[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                ans[i][j] = mat[i][j];
            }
        }
        for (int i = 0, p = k % mat[i].length; i < mat.length; i++) {
            if (i % 2 == 0) {
                int[] num = new int[p];
                for (int j = 0; j < p; j++) {
                    num[j] = mat[i][j];
                }
                for (int j = p; j < mat[i].length; j++) {
                    mat[i][j - p] = mat[i][j];
                }
                for (int j = mat[i].length - p; j < mat[i].length; j++) {
                    mat[i][j] = num[j - (mat[i].length - p)];
                }
            } else {
                int[] num = new int[p];
                for (int j = mat[i].length - p; j < mat[i].length; j++) {
                    num[j - (mat[i].length - p)] = mat[i][j];
                }
                for (int j = 0; j < mat[i].length - p; j++) {
                    mat[i][j + p] = mat[i][j];
                }
                for (int j = 0; j < p; j++) {
                    mat[i][j] = num[j];
                }
            }
        }
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (ans[i][j] != mat[i][j]) return false;
            }
        }
        return true;
    }
}
