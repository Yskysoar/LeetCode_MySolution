import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-03-17 0:27
 * @description 2389. 和有限的最长子序列
 * 给你一个长度为 n 的整数数组 nums ，和一个长度为 m 的整数数组 queries 。
 * 返回一个长度为 m 的数组 answer ，其中 answer[i] 是 nums 中 元素之和小于等于 queries[i] 的 子序列 的 最大 长度  。
 * 子序列 是由一个数组删除某些元素（也可以不删除）但不改变剩余元素顺序得到的一个数组。
 * 示例 1：
 * 输入：nums = [4,5,2,1], queries = [3,10,21]
 * 输出：[2,3,4]
 * 解释：queries 对应的 answer 如下：
 * - 子序列 [2,1] 的和小于或等于 3 。可以证明满足题目要求的子序列的最大长度是 2 ，所以 answer[0] = 2 。
 * - 子序列 [4,5,1] 的和小于或等于 10 。可以证明满足题目要求的子序列的最大长度是 3 ，所以 answer[1] = 3 。
 * - 子序列 [4,5,2,1] 的和小于或等于 21 。可以证明满足题目要求的子序列的最大长度是 4 ，所以 answer[2] = 4
 * 示例 2：
 * 输入：nums = [2,3,4,5], queries = [1]
 * 输出：[0]
 * 解释：空子序列是唯一一个满足元素和小于或等于 1 的子序列，所以 answer[0] = 0 。
 */
public class Solution2389 {
    public static void main(String[] args) {
        Solution2389 solution2389 = new Solution2389();
        int[] ans = solution2389.answerQueries2(new int[]{4, 5, 2, 1}, new int[]{3, 10, 21});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 使用map记录前缀和，然后查找(元素最多就是排序后的前缀和，需要先叠加小元素)
     * @param nums    数据数组
     * @param queries 查询数组
     * @return 查询数组对应的子序列最多元素个数
     */
    public int[] answerQueries1(int[] nums, int[] queries) {
        Arrays.sort(nums);
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int sum = 0;
        int[] ans = new int[queries.length];
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            hashMap.put(i, sum);
        }
        for (int i = 0; i < queries.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (hashMap.get(j) <= queries[i]) {
                    ans[i] = j + 1;
                }
            }
        }
        return ans;
    }

    public int[] answerQueries2(int[] nums, int[] queries) {
        Arrays.sort(nums);
        int[] ans = new int[queries.length];
        int[] num = new int[nums.length];
        num[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            num[i] += num[i - 1] + nums[i];
        }
        for (int i = 0; i < queries.length; i++) {
            int start = 0;
            int end = nums.length - 1;
            while (start <= end) {
                int middle = (end - start) / 2 + start;
                if (num[middle] <= queries[i]) {
                    ans[i] = middle + 1;
                    start = middle + 1;
                } else if (num[middle] > queries[i]) {
                    end = middle - 1;
                }
            }
        }
        return ans;
    }
}
