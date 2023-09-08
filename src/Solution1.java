import java.util.Arrays;
import java.util.HashMap;

public class Solution1 {
    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] resArr = solution1.twoSum2(new int[] {1,2,3,5,7}, 9);
        System.out.println(Arrays.toString(resArr));
    }
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            int res1 = target - nums[i];
            for(int m = i + 1; m < nums.length; m++) {
                if (res1 == nums[m]) {
                    return new int[] {i,m};
                }
            }
        }
        return null;
    }

    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();//key维护数字，value维护索引
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(target - nums[i])) {
                System.out.println(hashMap);
                return new int[] {hashMap.get(target - nums[i]), i};
            }
            hashMap.put(nums[i], i);
        }
        System.out.println(hashMap);
        return null;
    }
}
