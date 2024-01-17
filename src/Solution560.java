import java.util.Arrays;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-08-01 20:50
 * @description 560.和为k的子数组
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的连续子数组的个数 。
 * 示例 1：
 * 输入：nums = [1,1,1], k = 2
 * 输出：2
 * 示例 2：
 * 输入：nums = [1,2,3], k = 3
 * 输出：2
 */
public class Solution560 {
    //本题无法使用“滑动窗口”解题，因为数据可能存在负数，无法保证移动窗口后的数据变化情况
    public static void main(String[] args) {
        Solution560 solution560 = new Solution560();
        int ans = solution560.subarraySum3(new int[]{1, 1, 1}, 2);
        System.out.println(ans);
    }

    /**
     * 暴力遍历
     * @param nums 整数数组
     * @param k    目标值
     * @return 连续子数组个数
     */
    public int subarraySum1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

    /**
     * 暴力遍历(右边界顺序，固定右边界会超时，因为每次右边界移动实际上是在原有的所有结果上加当前的值)
     * @param nums 整数数组
     * @param k    目标值
     * @return 连续子数组个数
     */
    public int subarraySum2(int[] nums, int k) {
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            int sum = Arrays.stream(nums).limit(right + 1).sum();//超时原因
            for (int left = 0; left <= right; left++) {
                if (sum == k) ans++;
                sum -= nums[left];
            }
        }
        return ans;
    }

    /**
     * 暴力遍历(右边界倒序)
     * @param nums 整数数组
     * @param k    目标值
     * @return 连续子数组个数
     */
    public int subarraySum3(int[] nums, int k) {
        int ans = 0;
        for (int right = 0; right < nums.length; right++) {
            int sum = 0;
            for (int left = right; left >= 0; left--) {
                sum += nums[left];
                if (sum == k) ans++;
            }
        }
        return ans;
    }

    /**
     * 前缀和+暴力遍历(减少了计算的时间，循环内只需要简单的条件判断而不用其他计算)
     * @param nums 整数数组
     * @param k    目标值
     * @return 连续子数组个数
     */
    public int subarraySum4(int[] nums, int k) {
        int ans = 0;
        int[] preSum = new int[nums.length];
        preSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            preSum[i] = nums[i] + preSum[i - 1];
        }
        for (int right = 0; right < nums.length; right++) {
            if (preSum[right] == k) ans++;
            for (int left = 0; left < right; left++) {
                if (preSum[right] - preSum[left] == k) ans++;
            }
        }
        return ans;
    }

    /**
     * 前缀和+哈希表(哈希表可以简化存储，因为每次右边界移动实际上是在原有的所有结果上加当前的值，所以存在上一轮的前缀和+当前值=k的情况，哈希表可以简化这些寻找过程)
     * @param nums 整数数组
     * @param k    目标值
     * @return 连续子数组个数
     */
    public int subarraySum5(int[] nums, int k) {
        int ans = 0;
        int preSum = 0;
        HashMap<Integer, Integer> preSumNums = new HashMap<>();//key:前缀和  value:前缀和的个数
        //map的初始化是保证第一次出现preSum=k的情况出现时，可以将此情况记录
        preSumNums.put(0, 1);//对于一开始的情况，下标0之前没有元素，可以认为前缀和为0，个数为1
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            ans += preSumNums.getOrDefault(preSum - k, 0);//preSum - (preSum - k) == k
            preSumNums.put(preSum, preSumNums.getOrDefault(preSum, 0) + 1);//维护当前的前缀和
        }
        return ans;
    }
}
