/**
 * @author Yskysoar
 * @createTime 2026-05-23 19:11
 * @description 1752. 检查数组是否经排序和轮转得到
 * 给你一个数组 nums 。nums 的源数组中，所有元素与 nums 相同，但按非递减顺序排列。
 * 如果 nums 能够由源数组轮转若干位置（包括 0 个位置）得到，则返回 true ；否则，返回 false 。
 * 源数组中可能存在 重复项 。
 * 注意：数组 A 在轮转 x 个位置后得到长度相同的数组 B ，使得对于每一个有效的下标 i，满足 B[i] == A[(i+x) % A.length]。
 * 示例 1：
 * 输入：nums = [3,4,5,1,2]
 * 输出：true
 * 解释：[1,2,3,4,5] 为有序的源数组。
 * 可以轮转 x = 2 个位置，使新数组从值为 3 的元素开始：[3,4,5,1,2] 。
 * 示例 2：
 * 输入：nums = [2,1,3,4]
 * 输出：false
 * 解释：源数组无法经轮转得到 nums 。
 * 示例 3：
 * 输入：nums = [1,2,3]
 * 输出：true
 * 解释：[1,2,3] 为有序的源数组。
 * 可以轮转 x = 0 个位置（即不轮转）得到 nums 。
 * 提示：
 * 1 <= nums.length <= 100
 * 1 <= nums[i] <= 100
 */
public class Solution1752 {
    public static void main(String[] args) {
        Solution1752 solution1752 = new Solution1752();
        boolean ans = solution1752.check(new int[]{1, 2, 3});
        System.out.println(ans);
    }

    /**
     * 遍历 + 排序
     * @param nums 数据数组
     * @return 原数组是否有序
     */
    public boolean check(int[] nums) {
        int len1 = 0, len2 = nums.length - 1;
        while (len1 < nums.length - 1 && nums[len1] <= nums[len1 + 1]) len1++;
        while (len2 > 1 && nums[len2] >= nums[len2 - 1]) len2--;
        if (nums[0] < nums[nums.length - 1] && len1 != nums.length - 1) return false;
        return len1 + 1 == len2 || len1 == nums.length - 1 || len2 == 0;
    }
}
    