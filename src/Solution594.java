import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-06-30 0:04
 * @description 594. 最长和谐子序列
 * 和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
 * 给你一个整数数组 nums ，请你在所有可能的 子序列 中找到最长的和谐子序列的长度。
 * 数组的 子序列 是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。
 * 示例 1：
 * 输入：nums = [1,3,2,2,5,2,3,7]
 * 输出：5
 * 解释：
 * 最长和谐子序列是 [3,2,2,2,3]。
 * 示例 2：
 * 输入：nums = [1,2,3,4]
 * 输出：2
 * 解释：
 * 最长和谐子序列是 [1,2]，[2,3] 和 [3,4]，长度都为 2。
 * 示例 3：
 * 输入：nums = [1,1,1,1]
 * 输出：0
 * 解释：
 * 不存在和谐子序列。
 * 提示：
 * 1 <= nums.length <= 2 * 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution594 {
    public static void main(String[] args) {
        Solution594 solution594 = new Solution594();
        int ans = solution594.findLHS2(new int[]{1, 3, 2, 2, 5, 2, 3, 7});
        System.out.println(ans);
    }

    /**
     * 哈希表统计频次即可
     * @param nums 数据数组
     * @return 最长合法子序列长度
     */
    public int findLHS1(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {//记录各个元素的数量
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Integer integer : hashMap.keySet()) {
            if (hashMap.containsKey(integer + 1)) {
                ans = Math.max(ans, hashMap.get(integer) + hashMap.get(integer + 1));
            }
        }
        return ans;
    }

    /**
     * 排序 + 双指针
     * @param nums 数据数组
     * @return 最长合法子序列长度
     */
    public int findLHS2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);//排序
        int left = 0, right = 0;
        while (left < nums.length && right < nums.length) {
            while (right < nums.length && nums[right] == nums[left]) right++;//此时right-1是最后一个和nums[left]元素的索引
            if (right == nums.length) break;
            if (nums[right] == nums[left] + 1) {
                int count = right - left;
                left = right;
                while (right < nums.length && nums[right] == nums[left]) right++;
                count += right - left;
                ans = Math.max(ans, count);
            } else {
                left = right;
            }
        }
        return ans;
    }
}
