/**
 * @author Yskysoar
 * @createTime 2025-08-19 18:35
 * @description 2348. 全 0 子数组的数目
 * 给你一个整数数组 nums ，返回全部为 0 的 子数组 数目。
 * 子数组 是一个数组中一段连续非空元素组成的序列。
 * 示例 1：
 * 输入：nums = [1,3,0,0,2,0,0,4]
 * 输出：6
 * 解释：
 * 子数组 [0] 出现了 4 次。
 * 子数组 [0,0] 出现了 2 次。
 * 不存在长度大于 2 的全 0 子数组，所以我们返回 6 。
 * 示例 2：
 * 输入：nums = [0,0,0,2,0,0]
 * 输出：9
 * 解释：
 * 子数组 [0] 出现了 5 次。
 * 子数组 [0,0] 出现了 3 次。
 * 子数组 [0,0,0] 出现了 1 次。
 * 不存在长度大于 3 的全 0 子数组，所以我们返回 9 。
 * 示例 3：
 * 输入：nums = [2,10,2019]
 * 输出：0
 * 解释：没有全 0 子数组，所以我们返回 0 。
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution2348 {
    public static void main(String[] args) {
        Solution2348 solution2348 = new Solution2348();
        long ans = solution2348.zeroFilledSubarray(new int[]{1, 3, 0, 0, 2, 0, 0, 4});
        System.out.println(ans);
    }

    /**
     * 滑动窗口 + 数学（连续子数组数量 = 等差数列求和）
     * @param nums 数据数组
     * @return 全0子数组的数目
     */
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] != 0 && nums[left] == 0) {//找到右边界
                ans += (long) (right - left) * (right - left + 1) / 2;//等差数列求和计算个数
                left = right;//重置左边界位置
            } else if (nums[right] == 0 && nums[left] != 0) {
                left = right;//更新左边界位置
            }
            right++;
        }
        return ans + (nums[nums.length - 1] == 0 ? (long) (right - left) * (right - left + 1) / 2 : 0);//结尾为0的特判
    }
}
