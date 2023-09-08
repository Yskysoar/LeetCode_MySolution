import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2023-08-07 20:10
 * @description 15.三数之和
 * 给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请
 * 你返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 * 示例 1：
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 解释：
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
 * 不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
 * 注意，输出的顺序和三元组的顺序并不重要。
 * 示例 2：
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 解释：唯一可能的三元组和不为 0 。
 * 示例 3：
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 * 解释：唯一可能的三元组和为 0 。
 */
public class Solution15 {
    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        List<List<Integer>> lists = solution15.threeSum2(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }

    /**
     * 暴力遍历+逻辑简化(超时)：当第一层循环确定一个数后，后面两层循环其实变成了两数之和等于第一个数的倒数
     * @param nums 数据数组
     * @return 不重复的三数之和为0的三元组
     */
    public List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;//相同定位为重复解
            int twoSum = -nums[i];//此数为后两数之和
            HashMap<Integer, Integer> twoHashMap = new HashMap<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (twoHashMap.containsKey(twoSum - nums[j])) {
                    List<Integer> list = Arrays.asList(nums[i], nums[j], twoSum - nums[j]);
                    boolean isEquals = false;
                    for (List<Integer> integerList : ans) {
                        if (integerList.containsAll(list) && list.containsAll(integerList)) {
                            isEquals = true;
                            break;
                        }
                    }
                    if (!isEquals) {
                        ans.add(list);
                    }
                }
                twoHashMap.put(nums[j], j);//key：元素值    value：索引值
            }
        }
        return ans;
    }

    /**
     * 暴力遍历+逻辑简化(优化两数之和查找逻辑)：利用排序和双指针查找可以在判断重复的时候简化逻辑，二元组只需要确定一个元素即可
     * @param nums 数据数组
     * @return 不重复的三数之和为0的三元组
     */
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);//排序减少重复元素的判断
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if ((i > 0 && nums[i] == nums[i - 1]) || (nums[i] > 0)) continue;
            int twoSum = -nums[i];//此数为后两数之和
            int left = i + 1;
            int right = nums.length - 1;
            HashSet<Integer> hashSet = new HashSet<>();
            while (left < right) {
                if (hashSet.contains(nums[left])) {
                    left++;
                    continue;
                }//寻找到一个符合要求的二元组后不再重复寻找，二元组一旦确定一个值，另外一个也是确定的
                if (nums[left] + nums[right] == twoSum) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    hashSet.add(nums[left]);
                    left++;
                } else if (nums[left] + nums[right] < twoSum) {
                    left++;//因为数组进行排序了，只能是左元素偏小，所以左指针右移
                } else if (nums[left] + nums[right] > twoSum) {
                    right--;//因为数组进行排序了，只能是右元素偏大，所以右指针左移
                }
            }
        }
        return ans;
    }
}
