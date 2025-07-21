import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-07-22 0:54
 * @description 1695. 删除子数组的最大得分
 * 给你一个正整数数组 nums ，请你从中删除一个含有 若干不同元素 的子数组。删除子数组的 得分 就是子数组各元素之 和 。
 * 返回 只删除一个 子数组可获得的 最大得分 。
 * 如果数组 b 是数组 a 的一个连续子序列，即如果它等于 a[l],a[l+1],...,a[r] ，那么它就是 a 的一个子数组。
 * 示例 1：
 * 输入：nums = [4,2,4,5,6]
 * 输出：17
 * 解释：最优子数组是 [2,4,5,6]
 * 示例 2：
 * 输入：nums = [5,2,1,2,5,2,1,2,5]
 * 输出：8
 * 解释：最优子数组是 [5,2,1] 或 [1,2,5]
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 */
public class Solution1695 {
    public static void main(String[] args) {
        Solution1695 solution1695 = new Solution1695();
        int ans = solution1695.maximumUniqueSubarray2(new int[]{4, 2, 4, 5, 6, 2, 4, 4});
        System.out.println(ans);
    }

    /**
     * 前缀和 + 滑动窗口（双循环）
     * @param nums 数据数组
     * @return 删除的子数组的最大得分
     */
    public int maximumUniqueSubarray(int[] nums) {
        int ans = Integer.MIN_VALUE, right = 0;//右起点
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }//前缀和
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = right; j < nums.length; j++) {//下一次直接从重复元素的下一个元素开始(区间平移)
                if (hashMap.containsKey(nums[j]) && hashMap.get(nums[j]) >= i) {//在左边界右边的才合法
                    ans = Math.max(ans, preSum[j - 1] - preSum[i] + nums[i]);
                    i = hashMap.get(nums[j]);//外循环会自动加一
                    hashMap.put(nums[j], j);//更新元素位置信息
                    right = j + 1;
                    break;
                }
                hashMap.put(nums[j], j);//更新元素位置信息
                if (j == nums.length - 1) return Math.max(preSum[j] - preSum[i] + nums[i], ans);//直接到结尾了，再右移左边界只会更小
            }
        }
        return ans;
    }

    /**
     * 前缀和 + 滑动窗口（双指针）
     * @param nums 数据数组
     * @return 删除的子数组的最大得分
     */
    public int maximumUniqueSubarray2(int[] nums) {
        int ans = Integer.MIN_VALUE;
        int left = 0, right = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i];
        }//前缀和
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        while (right < nums.length) {
            if (hashMap.containsKey(nums[right]) && hashMap.get(nums[right]) >= left) {
                ans = Math.max(ans, preSum[right - 1] - preSum[left] + nums[left]);
                //平移区间
                left = hashMap.get(nums[right]) + 1;
            }
            hashMap.put(nums[right], right);//更新元素位置信息
            right++;
        }
        return Math.max(ans, preSum[right - 1] - preSum[left] + nums[left]);
    }
}
