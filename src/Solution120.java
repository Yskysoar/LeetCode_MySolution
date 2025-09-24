import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-09-25 1:17
 * @description 120. 三角形最小路径和
 * 给定一个三角形 triangle ，找出自顶向下的最小路径和。
 * 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1
 * 。
 * 示例 1：
 * 输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
 * 输出：11
 * 解释：如下面简图所示：
 * 2
 * 3 4
 * 6 5 7
 * 4 1 8 3
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 * 示例 2：
 * 输入：triangle = [[-10]]
 * 输出：-10
 * 提示：
 * 1 <= triangle.length <= 200
 * triangle[0].length == 1
 * triangle[i].length == triangle[i - 1].length + 1
 * -10^4 <= triangle[i][j] <= 10^4
 */
public class Solution120 {
    public static void main(String[] args) {
        Solution120 solution120 = new Solution120();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(List.of(2));
        triangle.add(Arrays.asList(3, 4));
        triangle.add(Arrays.asList(6, 5, 7));
        triangle.add(Arrays.asList(4, 1, 8, 3));
        System.out.println(solution120.minimumTotal(triangle));
    }

    /**
     * 动态规划 + 贪心
     * 开头只能是正上方移动过来，结尾只能是左上方移动过来
     * 除去开头和结尾，当前位置只能是左上方和正上方位置移动过来，当前位置取以上两者较小的路径即可
     * @param triangle 三角形数据
     * @return 最小的路径和
     */
    public int minimumTotal(List<List<Integer>> triangle) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[triangle.size() + 1][triangle.get(triangle.size() - 1).size() + 1];
        dp[1][1] = triangle.get(0).get(0);//第一个元素直接初始化
        for (int i = 2; i < dp.length; i++) {//若元素全部大于0，开头结尾就不需要特殊处理开头结尾
            dp[i][1] = dp[i - 1][1] + triangle.get(i - 1).get(0);//处理开头
            for (int j = 2; j <= i - 1; j++) {//元素可能小于0，开头结尾需要特殊处理
                dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j]) + triangle.get(i - 1).get(j - 1);
            }
            dp[i][i] = dp[i - 1][i - 1] + triangle.get(i - 1).get(i - 1);//处理结尾
        }
        for (int i = 1; i < dp[dp.length - 1].length; i++) {//寻找最小路径和
            ans = Math.min(ans, dp[dp.length - 1][i]);
        }
        return ans;
    }
}
