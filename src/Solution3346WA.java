import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-10-21 11:00
 * @description 3346. 执行操作后元素的最高频率 I
 * 给你一个整数数组 nums 和两个整数 k 和 numOperations 。
 * 你必须对 nums 执行 操作  numOperations 次。每次操作中，你可以：
 * 选择一个下标 i ，它在之前的操作中 没有 被选择过。
 * 将 nums[i] 增加范围 [-k, k] 中的一个整数。
 * 在执行完所有操作以后，请你返回 nums 中出现 频率最高 元素的出现次数。
 * 一个元素 x 的 频率 指的是它在数组中出现的次数。
 * 示例 1：
 * 输入：nums = [1,4,5], k = 1, numOperations = 2
 * 输出：2
 * 解释：
 * 通过以下操作得到最高频率 2 ：
 * 将 nums[1] 增加 0 ，nums 变为 [1, 4, 5] 。
 * 将 nums[2] 增加 -1 ，nums 变为 [1, 4, 4] 。
 * 示例 2：
 * 输入：nums = [5,11,20,20], k = 5, numOperations = 1
 * 输出：2
 * 解释：
 * 通过以下操作得到最高频率 2 ：
 * 将 nums[1] 增加 0 。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 0 <= k <= 10^5
 * 0 <= numOperations <= nums.length
 */
public class Solution3346WA {
    public static void main(String[] args) {
        Solution3346WA solution3346WA = new Solution3346WA();
        int ans = solution3346WA.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1);
        System.out.println(ans);
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        int ans = 0, start = 0;
        Arrays.sort(nums);
        for (int i = nums[0] - k, num, operations; i <= nums[nums.length - 1] + k; i++) {//从所有可能的数中寻找
            num = 0;
            operations = numOperations;
            while (nums[start] + k < i) start++;
            for (int j = start; j < nums.length; j++) {
                if (nums[j] - k > i) {
                    ans = Math.max(ans, num);
                    break;
                } else {
                    if (operations <= 0 && nums[j] > i) {
                        break;
                    } else if (operations <= 0) {//找后面有没有不用操作的数
                        if (nums[j] == i) num++;
                    } else {
                        if (nums[j] != i) {
                            operations--;
                        }
                        num++;
                    }
                }
            }
            ans = Math.max(ans, num);
        }
        return ans;
    }
}
