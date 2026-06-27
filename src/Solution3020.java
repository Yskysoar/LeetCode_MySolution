import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yskysoar
 * @createTime 2026-06-27 14:20
 * @description 3020. 子集中元素的最大数量
 * 给你一个 正整数 数组 nums 。
 * 你需要从数组中选出一个满足下述条件的子集：
 * 你可以将选中的元素放置在一个下标从 0 开始的数组中，并使其遵循以下模式：[x, x2, x4, ..., xk/2, xk, xk/2, ..., x4, x2, x]（注意，k 可以是任何 非负 的 2 的幂）。例如，[2, 4,
 * 16, 4, 2] 和 [3, 9, 3] 都符合这一模式，而 [2, 4, 8, 4, 2] 则不符合。
 * 返回满足这些条件的子集中，元素数量的 最大值 。
 * 示例 1：
 * 输入：nums = [5,4,1,2,2]
 * 输出：3
 * 解释：选择子集 {4,2,2} ，将其放在数组 [2,4,2] 中，它遵循该模式，且 22 == 4 。因此答案是 3 。
 * 示例 2：
 * 输入：nums = [1,3,2,4]
 * 输出：1
 * 解释：选择子集 {1}，将其放在数组 [1] 中，它遵循该模式。因此答案是 1 。注意我们也可以选择子集 {2} 、{4} 或 {3} ，可能存在多个子集都能得到相同的答案。
 * 提示：
 * 2 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 */
public class Solution3020 {
    public static void main(String[] args) {
        Solution3020 solution3020 = new Solution3020();
        int ans = solution3020.maximumLength(new int[]{5, 4, 1, 2, 2, 4, 16});
        System.out.println(ans);
    }

    /**
     * 哈希 + 遍历
     * @param nums 数据数组
     * @return 最大长度
     */
    public int maximumLength(int[] nums) {
        int ans = 1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }//记录数量
        for (Integer i : hashMap.keySet()) {
            if (i == 1) {
                ans = Math.max(ans, hashMap.get(i) % 2 == 0 ? hashMap.get(i) - 1 : hashMap.get(i));
                continue;
            }
            int num = i, count = 0;
            while (hashMap.containsKey(num)) {
                if (hashMap.get(num) >= 2) {
                    count += 2;
                    num *= num;
                } else {
                    break;
                }
            }
            if (hashMap.containsKey(num)) {
                ans = Math.max(ans, count + 1);
            } else {
                ans = Math.max(ans, count - 1);
            }
        }
        return ans;
    }
}
    