import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-09-22 0:12
 * @description 3005. 最大频率元素计数
 * 给你一个由 正整数 组成的数组 nums 。
 * 返回数组 nums 中所有具有 最大 频率的元素的 总频率 。
 * 元素的 频率 是指该元素在数组中出现的次数。
 * 示例 1：
 * 输入：nums = [1,2,2,3,1,4]
 * 输出：4
 * 解释：元素 1 和 2 的频率为 2 ，是数组中的最大频率。
 * 因此具有最大频率的元素在数组中的数量是 4 。
 * 示例 2：
 * 输入：nums = [1,2,3,4,5]
 * 输出：5
 * 解释：数组中的所有元素的频率都为 1 ，是最大频率。
 * 因此具有最大频率的元素在数组中的数量是 5 。
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Solution3005 {

    /**
     * 排序 + 滑动窗口
     * @param nums 待统计数组
     * @return 最大频次的出现次数
     */
    public int maxFrequencyElements(int[] nums) {
        int ans = 0;
        int maxFrequency = 0, left = 0, right = 0;
        Arrays.sort(nums);
        while (right < nums.length) {
            if (nums[right] == nums[left]) {
                right++;
            } else {
                if (right - left == maxFrequency) {
                    ans++;
                } else if (right - left > maxFrequency) {
                    maxFrequency = right - left;//更新频率
                    ans = 1;//重置记录
                }
                left = right;//更新区间起始位置
            }
        }
        if (right - left == maxFrequency) {
            ans++;
        } else if (right - left > maxFrequency) {
            maxFrequency = right - left;//更新频率
            ans = 1;//重置记录
        }
        return ans * maxFrequency;
    }
}
