import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-06-29 14:43
 * @description 1498. 满足条件的子序列数目
 * 给你一个整数数组 nums 和一个整数 target 。
 * 请你统计并返回 nums 中能满足其最小元素与最大元素的 和 小于或等于 target 的 非空 子序列的数目。
 * 由于答案可能很大，请将结果对 109 + 7 取余后返回。
 * 示例 1：
 * 输入：nums = [3,5,6,7], target = 9
 * 输出：4
 * 解释：有 4 个子序列满足该条件。
 * [3] -> 最小元素 + 最大元素 <= target (3 + 3 <= 9)
 * [3,5] -> (3 + 5 <= 9)
 * [3,5,6] -> (3 + 6 <= 9)
 * [3,6] -> (3 + 6 <= 9)
 * 示例 2：
 * 输入：nums = [3,3,6,8], target = 10
 * 输出：6
 * 解释：有 6 个子序列满足该条件。（nums 中可以有重复数字）
 * [3] , [3] , [3,3], [3,6] , [3,6] , [3,3,6]
 * 示例 3：
 * 输入：nums = [2,3,3,4,6,7], target = 12
 * 输出：61
 * 解释：共有 63 个非空子序列，其中 2 个不满足条件（[6,7], [7]）
 * 有效序列总数为（63 - 2 = 61）
 * 提示：
 * 1 <= nums.length <= 105
 * 1 <= nums[i] <= 106
 * 1 <= target <= 106
 */
public class Solution1498 {
    public static void main(String[] args) {
        Solution1498 solution1498 = new Solution1498();
        int ans = solution1498.numSubseq(new int[]{14, 4, 6, 6, 20, 8, 5, 6, 8, 12, 6, 10, 14, 9, 17, 16, 9, 7, 14, 11, 14, 15, 13, 11, 10, 18, 13, 17, 17, 14, 17, 7, 9, 5, 10, 13, 8, 5, 18, 20, 7, 5, 5, 15, 19, 14}, 22);
        System.out.println(ans);
    }

    public int numSubseq(int[] nums, int target) {
        double ans = 0;
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        int[] pow = new int[nums.length];
        pow[0] = 1;
        for (int i = 1; i < pow.length; i++) {
            pow[i] = (pow[i - 1] * 2) % 1000000007;
        }
        while (left <= right && nums[left] + nums[right] > target) right--;//找到初始位置
        while (left <= right) {
            ans = (ans + pow[right - left]) % 1000000007;//去掉左边界的点，其余点任意选取都行
            if (nums[left] * 2 > target) ans--;//只剩下左边界的情况需要判断（上一步有空序列）
            left++;
            while (left <= right && nums[left] + nums[right] > target) right--;
        }
        return (int) ans;
    }
}
