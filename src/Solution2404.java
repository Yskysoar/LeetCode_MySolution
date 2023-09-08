import java.util.HashMap;
import java.util.Map;

/**
 * @author Yskysoar
 * @createTime 2023-04-13 23:27
 * @description 2404. 出现最频繁的偶数元素
 * 给你一个整数数组 nums ，返回出现最频繁的偶数元素。
 * 如果存在多个满足条件的元素，只需要返回 最小 的一个。如果不存在这样的元素，返回 -1 。
 * 示例 1：
 * 输入：nums = [0,1,2,2,4,4,1]
 * 输出：2
 * 解释：
 * 数组中的偶数元素为 0、2 和 4 ，在这些元素中，2 和 4 出现次数最多。
 * 返回最小的那个，即返回 2 。
 * 示例 2：
 * 输入：nums = [4,4,4,9,2,4]
 * 输出：4
 * 解释：4 是出现最频繁的偶数元素。
 * 示例 3：
 * 输入：nums = [29,47,21,41,13,37,25,7]
 * 输出：-1
 * 解释：不存在偶数元素。
 */
public class Solution2404 {
    public static void main(String[] args) {
        Solution2404 solution2404 = new Solution2404();
        int ans = solution2404.mostFrequentEven(new int[]{0, 1, 2, 2, 4, 4, 1});
        System.out.println(ans);
    }

    public int mostFrequentEven(int[] nums) {
        int ans = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i : nums) {
            if (i % 2 == 0) hashMap.put(i, hashMap.getOrDefault(i, 0) + 1);
        }//遍历nums数组将偶数元素存在哈希表中
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (ans == -1 || entry.getValue() > count || entry.getValue() == count && ans > entry.getKey()) {
                ans = entry.getKey();
                count = entry.getValue();
            }
        }
        return ans;
    }
}
