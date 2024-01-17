import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-03-16 10:22
 * @description 2488. 统计中位数为 K 的子数组
 * 给你一个长度为 n 的数组 nums ，该数组由从 1 到 n 的 不同 整数组成。另给你一个正整数 k 。
 * 统计并返回 nums 中的 中位数 等于 k 的非空子数组的数目。
 * 注意：
 * 数组的中位数是按 递增 顺序排列后位于 中间 的那个元素，如果数组长度为偶数，则中位数是位于中间靠 左 的那个元素。
 * 例如，[2,3,1,4] 的中位数是 2 ，[8,4,3,5,1] 的中位数是 4 。
 * 子数组是数组中的一个连续部分。
 * 示例 1：
 * 输入：nums = [3,2,1,4,5], k = 4
 * 输出：3
 * 解释：中位数等于 4 的子数组有：[4]、[4,5] 和 [1,4,5] 。
 * 示例 2：
 * 输入：nums = [2,3,1], k = 3
 * 输出：1
 * 解释：[3] 是唯一一个中位数等于 3 的子数组。
 */
public class Solution2488 {
    public static void main(String[] args) {
        Solution2488 solution2488 = new Solution2488();
        int ans = solution2488.countSubarrays2(new int[]{5, 19, 11, 15, 13, 16, 4, 6, 2, 7, 10, 8, 18, 20, 1, 3, 17, 9, 12, 14}, 6);
        System.out.println(ans);
    }

    /**
     * 滑动判断数组和是否为0(数据>10^5会超时)
     * @param nums 数组
     * @param k    规定的中位数
     * @return 子数组的个数
     */
    public int countSubarrays1(int[] nums, int k) {
        int kIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                nums[i] = 0;
                kIndex = i;
            } else if (nums[i] > k) {
                nums[i] = 1;
            } else {
                nums[i] = -1;
            }
        }//将严格大于k的值修改为1，严格小于k的值修改为-1，k修改为0，且k只有一个
        int ans = 1;
        int sum = 0;
        int left = kIndex - 1;
        int right = kIndex + 1;
        while (left >= 0) {
            sum += nums[left];
            if (sum == 0 || sum == 1) ans++;
            left--;
        }
        sum = 0;
        left = kIndex - 1;
        while (right < nums.length) {
            sum += nums[right];
            if (sum == 0 || sum == 1) ans++;
            right++;
        }
        sum = 0;
        while (left >= 0) {
            sum += nums[left];
            int tempSum = sum;
            right = kIndex + 1;
            while (right < nums.length) {
                tempSum += nums[right];
                if (tempSum == 0 || tempSum == 1) ans++;
                right++;
            }
            left--;
        }
        return ans;
    }

    /**
     * 滑动判断数组和是否为0，增加数组维护前缀和(数据>10^5会超时)
     * @param nums 数组
     * @param k    规定的中位数
     * @return 子数组的个数
     */
    public int countSubarrays2(int[] nums, int k) {
        int ans = 1;
        int kIndex = 0;
        int[] num = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                kIndex = i;
                nums[i] = 0;
                continue;
            }
            nums[i] = nums[i] > k ? 1 : -1;
        }//将严格大于k的值修改为1，严格小于k的值修改为-1，k修改为0，且k只有一个
        int sum = 0;
        int left = kIndex - 1;
        int right = kIndex + 1;
        while (left >= 0) {
            sum += nums[left];
            num[left] = sum;
            if (sum == 0 || sum == 1) ans++;
            left--;
        }
        sum = 0;
        while (right < nums.length) {
            left = kIndex - 1;
            sum += nums[right];
            num[right] = sum;
            if (sum == 0 || sum == 1) ans++;
            while (left >= 0) {
                if (num[left] + sum == 0 || num[left] + sum == 1) ans++;
                left--;
            }
            right++;
        }
        return ans;
    }

    /**
     * 使用HashMap维护不同前缀和的数量，可以直接调用map的信息减少一层循环
     * @param nums 数组
     * @param k    规定的中位数
     * @return 子数组的个数
     */
    public int countSubarrays3(int[] nums, int k) {
        int ans = 1;
        int kIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == k) {
                nums[i] = 0;
                kIndex = i;
                continue;
            }
            nums[i] = nums[i] > k ? 1 : -1;
        }//将严格大于k的值修改为1，严格小于k的值修改为-1，k修改为0，且k只有一个
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for (int i = kIndex - 1; i >= 0; i--) {//记录k左侧前缀和的数量
            sum += nums[i];
            if (sum == 0 || sum == 1) ans++;//记录左侧已经满足条件的子数组数量
            //记录不同前缀和在区间内的数量
            map.put(sum, map.getOrDefault(sum, 0) + 1);//map.getOrDefault(target, default)：若在map中找到key==target就返回对应的value，否则返回default
        }
        sum = 0;
        for (int i = kIndex + 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum == 0 || sum == 1) ans++;//记录右侧已经满足条件的子数组数量
            //记录双向数组情况，也就是k在子数组中直接位于中间的情况
            ans += map.getOrDefault(-sum, 0);//子数组长度为奇数，k直接就是中位数
            ans += map.getOrDefault(-sum + 1, 0);//子数组长度为偶数，k要靠左边所以数组和为1
        }
        return ans;
    }
}
