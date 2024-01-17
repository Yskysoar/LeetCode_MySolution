import java.util.HashMap;
import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2023-03-31 13:33
 * @description 2367. 算术三元组的数目
 * 给你一个下标从 0 开始、严格递增 的整数数组 nums 和一个正整数 diff 。如果满足下述全部条件，则三元组 (i, j, k) 就是一个 算术三元组 ：
 * i < j < k ，
 * nums[j] - nums[i] == diff 且
 * nums[k] - nums[j] == diff
 * 返回不同 算术三元组 的数目。
 * 示例 1：
 * 输入：nums = [0,1,4,6,7,10], diff = 3
 * 输出：2
 * 解释：
 * (1, 2, 4) 是算术三元组：7 - 4 == 3 且 4 - 1 == 3 。
 * (2, 4, 5) 是算术三元组：10 - 7 == 3 且 7 - 4 == 3 。
 * 示例 2：
 * 输入：nums = [4,5,6,7,8,9], diff = 2
 * 输出：2
 * 解释：
 * (0, 2, 4) 是算术三元组：8 - 6 == 2 且 6 - 4 == 2 。
 * (1, 3, 5) 是算术三元组：9 - 7 == 2 且 7 - 5 == 2 。
 */
public class Solution2367 {
    public static void main(String[] args) {
        Solution2367 solution2367 = new Solution2367();
        int ans = solution2367.arithmeticTriplets2(new int[]{4, 5, 6, 7, 8, 9}, 2);
        System.out.println(ans);
    }

    /**
     * 暴力解法
     * @param nums 待查找数组
     * @param diff 公差
     * @return 算术三元组的数量
     */
    public int arithmeticTriplets1(int[] nums, int diff) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == nums[i] + diff) {
                    for (int l = j + 1; l < nums.length; l++) {
                        if (nums[l] == nums[j] + diff) ans++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 哈希表(map)查询
     * @param nums 待查找数组
     * @param diff 公差
     * @return 算术三元组的数量
     */
    public int arithmeticTriplets2(int[] nums, int diff) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            hashMap.put(i, nums[i]);
        }
        for (int num : nums) {
            if (hashMap.containsValue(num + diff) && hashMap.containsValue(num + 2 * diff)) ans++;
        }
        return ans;
    }

    /**
     * 哈希表(set)查询，因为是严格递增的，所以只记录一个数据即可
     * @param nums 待查找数组
     * @param diff 公差
     * @return 算术三元组的数量
     */
    public int arithmeticTriplets3(int[] nums, int diff) {
        int ans = 0;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            hashSet.add(i);
            if (hashSet.contains(i - diff) && hashSet.contains(i - 2 * diff)) ans++;

        }
        return ans;
    }


}





















