import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-02-04 10:19
 * @description 922. 按奇偶排序数组 II
 * 给定一个非负整数数组 nums，  nums 中一半整数是 奇数 ，一半整数是 偶数 。
 * 对数组进行排序，以便当 nums[i] 为奇数时，i 也是 奇数 ；当 nums[i] 为偶数时， i 也是 偶数 。
 * 你可以返回 任何满足上述条件的数组作为答案 。
 * 示例 1：
 * 输入：nums = [4,2,5,7]
 * 输出：[4,5,2,7]
 * 解释：[4,7,2,5]，[2,5,4,7]，[2,7,4,5] 也会被接受。
 * 示例 2：
 * 输入：nums = [2,3]
 * 输出：[2,3]
 * 提示：
 * 2 <= nums.length <= 2 * 104
 * nums.length 是偶数
 * nums 中一半是偶数
 * 0 <= nums[i] <= 1000
 */
public class Solution922 {
    public static void main(String[] args) {
        Solution922 solution922 = new Solution922();
        int[] ans = solution922.sortArrayByParityII2(new int[]{1, 2, 3, 3, 2, 3, 0, 4});
        System.out.println(Arrays.toString(ans));
    }


    /**
     * 原地修改(其实可以直接正面设置记录两个指针去找奇偶，双方都不符合交换即可，详情见法2)
     * @param nums 数据数组
     * @return 奇偶排序结果
     */
    public int[] sortArrayByParityII1(int[] nums) {
        int even = (nums.length - 1) % 2 != 0 ? nums.length - 1 : nums.length - 2;//记录找偶数的索引
        int odd = (nums.length - 1) % 2 == 0 ? nums.length - 1 : nums.length - 2;//记录找奇数的索引
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0 ^ nums[i] % 2 == 0) {//奇偶不匹配
                if (i % 2 == 0) {//索引是偶数
                    while (even >= 0) {//从奇索引找
                        if (nums[even] % 2 == 0) {
                            nums[even] ^= nums[i];
                            nums[i] ^= nums[even];
                            nums[even] ^= nums[i];
                            break;
                        }
                        even -= 2;
                    }
                } else {//索引是奇数
                    while (odd >= 1) {
                        // 从偶索引找
                        if (nums[odd] % 2 != 0) {
                            nums[odd] ^= nums[i];
                            nums[i] ^= nums[odd];
                            nums[odd] ^= nums[i];
                            break;
                        }
                        odd -= 2;
                    }
                }
            }
        }
        return nums;
    }

    /**
     * 正向双指针原地修改
     * @param nums 数据数组
     * @return 奇偶排序结果
     */
    public int[] sortArrayByParityII2(int[] nums) {
        int even = 0;
        int odd = 1;
        while (true) {
            while (even < nums.length && (nums[even] & 1) == 0) even += 2;
            while (odd < nums.length && (nums[odd] & 1) == 1) odd += 2;
            if (even < nums.length && odd < nums.length) {
                nums[even] ^= nums[odd];
                nums[odd] ^= nums[even];
                nums[even] ^= nums[odd];
            } else {
                break;
            }
        }
        return nums;
    }
}

