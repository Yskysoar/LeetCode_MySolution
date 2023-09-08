import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Yskysoar
 * @createTime 2023-08-04 10:38
 * @description 137.只出现一次的数字II
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 * 你必须设计并实现线性时间复杂度的算法且不使用额外空间来解决此问题。
 * 示例 1：
 * 输入：nums = [2,2,3,2]
 * 输出：3
 * 示例 2：
 * 输入：nums = [0,1,0,1,0,1,99]
 * 输出：99
 */
public class Solution137 {
    public static void main(String[] args) {
        Solution137 solution137 = new Solution137();
        int ans = solution137.singleNumber3(new int[]{2, 2, 3, 2});
        System.out.println(ans);
    }

    /**
     * 暴力遍历(先排序)
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber1(int[] nums) {
        Arrays.sort(nums);
        int ans = nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i += 3) {
            if (nums[i] != nums[i + 1] && nums[i] != nums[i + 2]) {
                ans = nums[i];
                break;
            }
        }
        return ans;
    }

    /**
     * 暴力遍历(不排序)
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber2(int[] nums) {
        int ans = 0;
        for (int i : nums) {
            int num = 0;
            for (int k : nums) if (k == i) num++;
            if (num == 1) {
                ans = i;
                break;
            }
        }
        return ans;
    }

    /**
     * 哈希表
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber3(int[] nums) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : nums) {
            hashMap.put(num, hashMap.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() == 1) {
                ans = entry.getKey();
                break;
            }
        }
        return ans;
    }

    /**
     * 位运算：出现了三次的数字对应的每一位二进制位的值都是3/0，只出现了一次的数字对应的二进制位的值是1/0
     * 将所有元素的第i位二进制值相加取余3的结果就是只出现一次的数字对应的二进制位的值，将其移动到对应位置即可
     * @param nums 整数数组
     * @return 只出现一次的数字
     */
    public int singleNumber4(int[] nums) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {//int数据类型的长度为32位
            int total = 0;
            for (int num : nums) {
                total += ((num >> i) & 1);
            }//获取数组所有元素第i位的二进制数
            if (total % 3 != 0) {//非0即1
                ans |= (1 << i);//将第i位的二进制数置为1
            }
        }
        return ans;
    }
}
