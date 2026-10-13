import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2026-10-13 14:04
 * @description 3727. 最大交替平方和
 * 给你一个整数数组 nums。你可以以任意顺序 重新排列元素 。
 * 数组 arr 的 交替得分 定义为：
 * score = arr[0]^2 - arr[1]^2 + arr[2]^2 - arr[3]^2 + ...
 * 在对 nums 重新排列后，返回其 最大可能的交替得分。
 * 示例 1：
 * 输入： nums = [1,2,3]
 * 输出： 12
 * 解释：
 * nums 的一种可行重排为 [2,1,3]，该排列在所有可能重排中给出了最大交替得分。
 * 交替得分计算如下：
 * score = 2^2 - 1^2 + 3^2 = 4 - 1 + 9 = 12
 * 示例 2：
 * 输入： nums = [1,-1,2,-2,3,-3]
 * 输出： 16
 * 解释：
 * nums 的一种可行重排为 [-3,-1,-2,1,3,2]，该排列在所有可能重排中给出了最大交替得分。
 * 交替得分计算如下：
 * score = (-3)^2 - (-1)^2 + (-2)^2 - (1)^2 + (3)^2 - (2)^2 = 9 - 1 + 4 - 1 + 9 - 4 = 16
 * 提示：
 * 1 <= nums.length <= 10^5
 * -4 * 10^4 <= nums[i] <= 4 * 10^4
 */
public class Solution3727 {
    public static void main(String[] args) {
        Solution3727 solution3727 = new Solution3727();
        long ans = solution3727.maxAlternatingSum(new int[]{1, -1, 2, -2, 3, -3});
        System.out.println(ans);
    }

    /**
     * 反正都要平方，就不用管正负号了，直接将原始数据全部先平方后排序，大减小就行
     * @param nums 数据数组
     * @return 最大的交替得分
     */
    public long maxAlternatingSum(int[] nums) {
        long ans = 0;
        for (int i = 0; i < nums.length; i++) nums[i] *= nums[i];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            ans += (i < nums.length / 2 ? -nums[i] : nums[i]);
        }
        return ans;
    }
}
    