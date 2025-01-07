import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-01-07 16:14
 * @description 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * 示例 1:
 * 输入: rowIndex = 3
 * 输出: [1,3,3,1]
 * 示例 2:
 * 输入: rowIndex = 0
 * 输出: [1]
 * 示例 3:
 * 输入: rowIndex = 1
 * 输出: [1,1]
 * 提示:
 * 0 <= rowIndex <= 33
 */
public class Solution119 {
    public static void main(String[] args) {
        Solution119 solution119 = new Solution119();
        List<Integer> ans = solution119.getRow1(34);
        System.out.println(ans);
    }


    public List<Integer> getRow1(int rowIndex) {//手算二项式展开
        if (rowIndex == 0) return new ArrayList<>(List.of(1));
        if (rowIndex == 1) return new ArrayList<>(List.of(1, 1));
        List<Integer> ans = new ArrayList<>();
        ans.add(1);
        for (int i = 1; i < rowIndex; i++) {
            long num = 1;
            for (int j = 1; j <= i; j++) {
                num *= (rowIndex - j + 1);
                num /= j;
            }
            ans.add((int) num);
        }
        ans.add(1);
        return ans;
    }

    //投机取巧，直接用上一个题的结果
    public List<Integer> getRow2(int rowIndex) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>(List.of(1)));
        for (int i = 2; i <= rowIndex + 1; i++) {//第二行开始
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < i - 1; j++) {
                row.add(ans.get(i - 2).get(j - 1) + ans.get(i - 2).get(j));
            }
            row.add(1);
            ans.add(row);
        }
        return ans.get(rowIndex);
    }
}
