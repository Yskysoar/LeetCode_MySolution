import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2024-05-17 14:20
 * @description 826. 安排工作以达到最大收益
 * 你有 n 个工作和 m 个工人。给定三个数组： difficulty, profit 和 worker ，其中:
 * difficulty[i] 表示第 i 个工作的难度，profit[i] 表示第 i 个工作的收益。
 * worker[i] 是第 i 个工人的能力，即该工人只能完成难度小于等于 worker[i] 的工作。
 * 每个工人 最多 只能安排 一个 工作，但是一个工作可以 完成多次 。
 * 举个例子，如果 3 个工人都尝试完成一份报酬为 $1 的同样工作，那么总收益为 $3 。如果一个工人不能完成任何工作，他的收益为 $0 。
 * 返回 在把工人分配到工作岗位后，我们所能获得的最大利润 。
 * 示例 1：
 * 输入: difficulty = [2,4,6,8,10], profit = [10,20,30,40,50], worker = [4,5,6,7]
 * 输出: 100
 * 解释: 工人被分配的工作难度是 [4,4,6,6] ，分别获得 [20,20,30,30] 的收益。
 * 示例 2:
 * 输入: difficulty = [85,47,57], profit = [24,66,99], worker = [40,25,25]
 * 输出: 0
 * 提示:
 * n == difficulty.length
 * n == profit.length
 * m == worker.length
 * 1 <= n, m <= 104
 * 1 <= difficulty[i], profit[i], worker[i] <= 10^  5
 */
public class Solution826 {
    public static void main(String[] args) {
        Solution826 solution826 = new Solution826();
        int ans = solution826.maxProfitAssignment(new int[]{68,35,52,47,86}, new int[]{67,17,1,81,3}, new int[]{92,10,85,84,82});
        System.out.println(ans);
    }


    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int ans = 0;
        //先把数据排序
        for (int i = 0; i < difficulty.length; i++) {
            for (int j = 1; j < difficulty.length - i; j++) {
                if (difficulty[j - 1] > difficulty[j]) {
                    difficulty[j] ^= difficulty[j - 1];
                    difficulty[j - 1] ^= difficulty[j];
                    difficulty[j] ^= difficulty[j - 1];
                    profit[j] ^= profit[j - 1];
                    profit[j - 1] ^= profit[j];
                    profit[j] ^= profit[j - 1];
                }
            }
        }
        for (int k : worker) {
            int maxProfit = Integer.MIN_VALUE;
            for (int j = 0; j < difficulty.length; j++) {
                if (difficulty[j] <= k) {
                    maxProfit = Math.max(maxProfit, profit[j]);
                }
            }
            if (maxProfit == Integer.MIN_VALUE) continue;
            ans += maxProfit;
        }
        return ans;
    }
}
