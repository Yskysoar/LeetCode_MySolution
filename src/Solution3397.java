import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-10-18 0:27
 * @description 3397. 执行操作后不同元素的最大数量
 * 给你一个整数数组 nums 和一个整数 k。
 * 你可以对数组中的每个元素 最多 执行 一次 以下操作：
 * 将一个在范围 [-k, k] 内的整数加到该元素上。
 * 返回执行这些操作后，nums 中可能拥有的不同元素的 最大 数量。
 * 示例 1：
 * 输入： nums = [1,2,2,3,3,4], k = 2
 * 输出： 6
 * 解释：
 * 对前四个元素执行操作，nums 变为 [-1, 0, 1, 2, 3, 4]，可以获得 6 个不同的元素。
 * 示例 2：
 * 输入： nums = [4,4,4,4], k = 1
 * 输出： 3
 * 解释：
 * 对 nums[0] 加 -1，以及对 nums[1] 加 1，nums 变为 [3, 5, 4, 4]，可以获得 3 个不同的元素。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^9
 * 0 <= k <= 10^9
 */
public class Solution3397 {
    public static void main(String[] args) {
        Solution3397 solution3397 = new Solution3397();
        int ans = solution3397.maxDistinctElements(new int[]{1, 1, 1, 2, 2, 2, 4, 4, 4, 4}, 2);
        System.out.println(ans);
    }

    /**
     * 排序 + 贪心 + 模拟
     * 每次都取当前元素可以取到的最小不同值，否则设置为上限
     * @param nums 数组数组
     * @param k    浮动范围
     * @return 不同元素的个数
     */
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        nums[0] -= k;//设置最小值
        int ans = 1;
        for (int i = 1, top; i < nums.length; i++) {
            top = nums[i] + k;//记录上限
            if (nums[i] - k > nums[i - 1]) {//前一个元素不在范围内
                nums[i] -= k;
                ans++;
            } else if (nums[i - 1] + 1 <= top) {//前一个元素在范围内且他的下一个元素也不超过上限
                nums[i] = nums[i - 1] + 1;
                ans++;
            } else {
                //因为已经排序了，说明此时nums[i - 1] + 1 > top
                //并且操作前一定和当前元素相同，该类值已经全部占位，直接赋值最大即可
                nums[i] += k;
            }
        }
        return ans;
    }
}
