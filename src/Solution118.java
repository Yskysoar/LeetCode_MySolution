import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-01-07 15:58
 * @description 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: numRows = 5
 * 输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
 * 示例 2:
 * 输入: numRows = 1
 * 输出: [[1]]
 * 提示:
 * 1 <= numRows <= 30
 */
public class Solution118 {
    public static void main(String[] args) {
        Solution118 solution118 = new Solution118();
        List<List<Integer>> ans = solution118.generate(3);
        System.out.println(ans);
    }

    /**
     * 数学解法
     * @param numRows 行数
     * @return 杨辉三角数组
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));
        for (int i = 2; i <= numRows; i++) {//第二行开始
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }
}
