import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-10-18 12:15
 * @description 2530. 执行 K 次操作后的最大分数
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。你的 起始分数 为 0 。
 * 在一步 操作 中：
 * 选出一个满足 0 <= i < nums.length 的下标 i ，
 * 将你的 分数 增加 nums[i] ，并且
 * 将 nums[i] 替换为 ceil(nums[i] / 3) 。
 * 返回在 恰好 执行 k 次操作后，你可能获得的最大分数。
 * 向上取整 函数 ceil(val) 的结果是大于或等于 val 的最小整数。
 * 示例 1：
 * 输入：nums = [10,10,10,10,10], k = 5
 * 输出：50
 * 解释：对数组中每个元素执行一次操作。最后分数是 10 + 10 + 10 + 10 + 10 = 50 。
 * 示例 2：
 * 输入：nums = [1,10,3,3,3], k = 3
 * 输出：17
 * 解释：可以执行下述操作：
 * 第1步 操作：选中 i = 1 ，nums 变为 [1,4,3,3,3] 。分数增加 10 。
 * 第2步 操作：选中 i = 1 ，nums 变为 [1,2,3,3,3] 。分数增加 4 。
 * 第3步 操作：选中 i = 2 ，nums 变为 [1,1,1,3,3] 。分数增加 3 。
 * 最后分数是 10 + 4 + 3 = 17 。
 */
public class Solution2530WA {
    public static void main(String[] args) {
        Solution2530WA solution2530WA = new Solution2530WA();
        long ans = solution2530WA.maxKelements(new int[]{1, 10, 3, 3, 3}, 3);
        System.out.println(ans);
    }

    /**
     * 暴力模拟(WA:超时)
     * @param nums 分数数组
     * @param k 操作次数
     * @return 执行 K 次操作后的最大分数
     */
    public long maxKelements(int[] nums, int k) {
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            Arrays.sort(nums);
            ans += nums[nums.length - 1];
            nums[nums.length - 1] = (nums[nums.length - 1] % 3 == 0) ? (nums[nums.length - 1] / 3) : (nums[nums.length - 1] / 3) + 1;
        }
        return ans;
    }
}
