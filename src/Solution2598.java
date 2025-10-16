import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-10-16 8:54
 * @description 2598. 执行操作后的最大 MEX
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 value 。
 * 在一步操作中，你可以对 nums 中的任一元素加上或减去 value 。
 * 例如，如果 nums = [1,2,3] 且 value = 2 ，你可以选择 nums[0] 减去 value ，得到 nums = [-1,2,3] 。
 * 数组的 MEX (minimum excluded) 是指其中数组中缺失的最小非负整数。
 * 例如，[-1,2,3] 的 MEX 是 0 ，而 [1,0,3] 的 MEX 是 2 。
 * 返回在执行上述操作 任意次 后，nums 的最大 MEX 。
 * 示例 1：
 * 输入：nums = [1,-10,7,13,6,8], value = 5
 * 输出：4
 * 解释：执行下述操作可以得到这一结果：
 * - nums[1] 加上 value 两次，nums = [1,0,7,13,6,8]
 * - nums[2] 减去 value 一次，nums = [1,0,2,13,6,8]
 * - nums[3] 减去 value 两次，nums = [1,0,2,3,6,8]
 * nums 的 MEX 是 4 。可以证明 4 是可以取到的最大 MEX 。
 * 示例 2：
 * 输入：nums = [1,-10,7,13,6,8], value = 7
 * 输出：2
 * 解释：执行下述操作可以得到这一结果：
 * - nums[2] 减去 value 一次，nums = [1,-10,0,13,6,8]
 * nums 的 MEX 是 2 。可以证明 2 是可以取到的最大 MEX 。
 * 提示：
 * 1 <= nums.length, value <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution2598 {
    public static void main(String[] args) {
        Solution2598 solution2598 = new Solution2598();
        int ans = solution2598.findSmallestInteger(new int[]{0, -3}, 4);
        System.out.println(ans);
    }

    /**
     * 贪心 + 哈希
     * 每一个元素的正向取余结果都唯一，可以构造出来的数都是在这个取余结果上加减 k * value
     * 可以将 nums 种数字按照对 k 取余后的结果进行分组，同组内的数字可以变成的数字集合都是相同的
     * 可以从 0 开始遍历直到无法用剩余数字变成当前数字即可得到答案
     * @param nums  数据数组
     * @param value 操作值
     * @return 操作后最大的MEX
     */
    public int findSmallestInteger(int[] nums, int value) {
        int ans = 0;
        HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % value < 0) {
                hashMap.computeIfAbsent(nums[i] % value + value, k -> new ArrayList<>()).add(i);
            } else {
                hashMap.computeIfAbsent(nums[i] % value, k -> new ArrayList<>()).add(i);
            }
        }
        while (hashMap.containsKey(ans % value) && hashMap.get(ans % value).size() > 0) {
            hashMap.get(ans % value).remove(0);//移除一个元素占用此位置
            ans++;
        }
        return ans;
    }
}
