import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-08-09 19:09
 * @description 18.四数之和
 * 给你一个由 n 个整数组成的数组 nums ，和一个目标值 target 。
 * 请你找出并返回满足下述全部条件且不重复的四元组 [nums[a], nums[b], nums[c], nums[d]]
 * （若两个四元组元素一一对应，则认为两个四元组重复）：
 * 0 <= a, b, c, d < n
 * a、b、c 和 d 互不相同
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * 你可以按 任意顺序 返回答案 。
 * 示例 1：
 * 输入：nums = [1,0,-1,0,-2,2], target = 0
 * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * 示例 2：
 * 输入：nums = [2,2,2,2,2], target = 8
 * 输出：[[2,2,2,2]]
 */
public class Solution18 {
    public static void main(String[] args) {
        Solution18 solution18 = new Solution18();
        List<List<Integer>> ans = solution18.fourSum(new int[]{1000000000, 1000000000, 1000000000, 1000000000}, -294967296);
        System.out.println(ans);
    }

    /**
     * 逻辑降维：转换为三数之和，和Solution15一样使用‘排序+双指针’完成
     * @param nums   数据数组
     * @param target 目标值
     * @return 不重复的所有四元组
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            long threeSum = target - nums[i];//防止数据溢出
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                long twoSum = threeSum - nums[j];//防止数据溢出
                int left = j + 1;
                int right = nums.length - 1;
                HashSet<Integer> hashSet = new HashSet<>();
                while (left < right) {
                    if (hashSet.contains(nums[left])) {
                        left++;
                        continue;
                    }
                    if (nums[left] + nums[right] == twoSum) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        hashSet.add(nums[left]);
                        left++;
                    } else if (nums[left] + nums[right] < twoSum) {
                        left++;//因为数组进行排序了，只能是左元素偏小，所以左指针右移
                    } else if (nums[left] + nums[right] > twoSum) {
                        right--;//因为数组进行排序了，只能是右元素偏大，所以右指针左移
                    }
                }

            }
        }
        return ans;
    }
}
