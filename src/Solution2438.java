import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-08-11 0:19
 * @description 2438. 二的幂数组中查询范围内的乘积
 * 给你一个正整数 n ，你需要找到一个下标从 0 开始的数组 powers ，它包含 最少 数目的 2 的幂，且它们的和为 n 。
 * powers 数组是 非递减 顺序的。根据前面描述，构造 powers 数组的方法是唯一的。
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] ，其中 queries[i] 表示请你求出满足 lefti <= j <= righti 的所有
 * powers[j] 的乘积。
 * 请你返回一个数组 answers ，长度与 queries 的长度相同，其中 answers[i]是第 i 个查询的答案。由于查询的结果可能非常大，请你将每个 answers[i] 都对 109 + 7 取余 。
 * 示例 1：
 * 输入：n = 15, queries = [[0,1],[2,2],[0,3]]
 * 输出：[2,4,64]
 * 解释：
 * 对于 n = 15 ，得到 powers = [1,2,4,8] 。没法得到元素数目更少的数组。
 * 第 1 个查询的答案：powers[0] * powers[1] = 1 * 2 = 2 。
 * 第 2 个查询的答案：powers[2] = 4 。
 * 第 3 个查询的答案：powers[0] * powers[1] * powers[2] * powers[3] = 1 * 2 * 4 * 8 = 64 。
 * 每个答案对 109 + 7 得到的结果都相同，所以返回 [2,4,64] 。
 * 示例 2：
 * 输入：n = 2, queries = [[0,0]]
 * 输出：[2]
 * 解释：
 * 对于 n = 2, powers = [2] 。
 * 唯一一个查询的答案是 powers[0] = 2 。答案对 109 + 7 取余后结果相同，所以返回 [2] 。
 * 提示：
 * 1 <= n <= 109
 * 1 <= queries.length <= 10^5
 * 0 <= starti <= endi < powers.length
 */
public class Solution2438 {
    public static void main(String[] args) {
        Solution2438 solution2438 = new Solution2438();
        int[] ans = solution2438.productQueries(15, new int[][]{{0, 1}, {2, 2}, {0, 3}});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 二进制 + 前缀和
     * 下面题解中有高效的二进制低位到高位处理方法:
     * https://leetcode.cn/problems/range-product-queries-of-powers/solutions/1895314/bao-li-yu-chu-li-by-endlesscheng-kt0t
     * @param n       待拆解数字
     * @param queries 乘积范围
     * @return 各个乘积的结果数组
     */
    public int[] productQueries(int n, int[][] queries) {
        int[] ans = new int[queries.length];
        int MOD = 1000000000 + 7;//取余
        ArrayList<Integer> arrayList = new ArrayList<>();
        StringBuilder str = new StringBuilder(Integer.toBinaryString(n)).reverse();
        for (int i = 0; i < str.length(); i++) {//根据二进制结果记录符合的位权
            if (str.charAt(i) == '1') {
                arrayList.add(i);
            }
        }//直接记录数据乘积太大了会溢出
        int[] preSum = new int[arrayList.size() + 1];
        preSum[0] = 0;
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + arrayList.get(i - 1);
        }//前缀和
        for (int i = 0; i < queries.length; i++) {
            ans[i] = (int) (Math.pow(2, preSum[queries[i][1] + 1] - preSum[queries[i][0]]) % MOD);//利用位权计算答案
        }
        return ans;
    }
}
