import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yskysoar
 * @createTime 2023-10-19 8:20
 * @description 1726. 同积元组
 * 给你一个由 不同 正整数组成的数组 nums ，请你返回满足 a * b = c * d 的元组 (a, b, c, d) 的数量。
 * 其中 a、b、c 和 d 都是 nums 中的元素，且 a != b != c != d 。
 * 示例 1：
 * 输入：nums = [2,3,4,6]
 * 输出：8
 * 解释：存在 8 个满足题意的元组：
 * (2,6,3,4) , (2,6,4,3) , (6,2,3,4) , (6,2,4,3)
 * (3,4,2,6) , (4,3,2,6) , (3,4,6,2) , (4,3,6,2)
 * 示例 2：
 * 输入：nums = [1,2,4,5,10]
 * 输出：16
 * 解释：存在 16 个满足题意的元组：
 * (1,10,2,5) , (1,10,5,2) , (10,1,2,5) , (10,1,5,2)
 * (2,5,1,10) , (2,5,10,1) , (5,2,1,10) , (5,2,10,1)
 * (2,10,4,5) , (2,10,5,4) , (10,2,4,5) , (10,2,4,5)
 * (4,5,2,10) , (4,5,10,2) , (5,4,2,10) , (5,4,10,2)
 */
public class Solution1726 {
    /**
     * 解题关键：
     * 1.a * d = b * c -> a < b < c < d 即可以确定各个元素的大小关系
     * 2.一组同积元组可以衍生出8个组合
     */
    public static void main(String[] args) {
        Solution1726 solution1726 = new Solution1726();
        int ans1 = solution1726.tupleSameProduct1(new int[]{1, 2, 4, 5, 10});
        int ans2 = solution1726.tupleSameProduct2(new int[]{1, 2, 4, 5, 10});
        System.out.println(ans1);
        System.out.println(ans2);
    }

    /**
     * 暴力遍历
     * @param nums 数据数组
     * @return 返回同积元组的数量
     */
    public int tupleSameProduct1(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int multiply = nums[i] * nums[j];
                int left = i + 1;
                int right = j - 1;
                while (left < right) {
                    if (nums[left] * nums[right] == multiply) {
                        ans += 8;//每一种同积元组可以排列为8个(A22 * A22 * 2)
                        right--;
                        left++;
                    } else if (nums[left] * nums[right] > multiply) {
                        right--;
                    } else {
                        left++;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * 哈希表：利用哈希表保存所有的乘积的结果
     * @param nums 数据数组
     * @return 返回同积元组的数量
     */
    public int tupleSameProduct2(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                hashMap.put(nums[i] * nums[j], hashMap.getOrDefault(nums[i] * nums[j], 0) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getKey() > 1) ans += (entry.getValue() * (entry.getValue() - 1) / 2) * 8;//多个相同的乘积：Cn2
        }
        return ans;
    }
}
