import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-11-23 0:11
 * @description 1262. 可被三整除的最大和
 * 给你一个整数数组 nums，请你找出并返回能被三整除的元素 最大和。
 * 示例 1：
 * 输入：nums = [3,6,5,1,8]
 * 输出：18
 * 解释：选出数字 3, 6, 1 和 8，它们的和是 18（可被 3 整除的最大和）。
 * 示例 2：
 * 输入：nums = [4]
 * 输出：0
 * 解释：4 不能被 3 整除，所以无法选出数字，返回 0。
 * 示例 3：
 * 输入：nums = [1,2,3,4,4]
 * 输出：12
 * 解释：选出数字 1, 3, 4 以及 4，它们的和是 12（可被 3 整除的最大和）。
 * 提示：
 * 1 <= nums.length <= 4 * 10^4
 * 1 <= nums[i] <= 10^4
 */
public class Solution1262 {
    public static void main(String[] args) {
        Solution1262 solution1262 = new Solution1262();
        int ans = solution1262.maxSumDivThree(new int[]{3, 6, 5, 1, 8});
        System.out.println(ans);
    }

    /**
     * 贪心
     * 全部求和并记录余数1和2对应的两个最小值
     * 若求和取余为1，可以选择去掉一个余数为1的值 or 去掉两个余数为2的值
     * 若求和取余为2，可以选择去掉一个余数为2的值 or 去掉两个余数为1的值
     * @param nums 数据数组
     * @return 可以被三整除的最大元素和
     */
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int[] num = new int[]{-1, -1, -1, -1};
        for (int i = 0, index1 = 0, index2 = 2; i < nums.length; i++) {
            ans += nums[i];
            if (nums[i] % 3 == 1 && index1 < 2) num[index1++] = nums[i];
            if (nums[i] % 3 == 2 && index2 < 4) num[index2++] = nums[i];
        }
        if (ans % 3 == 1) {
            if (num[0] != -1 && num[2] != -1 && num[3] != -1) {
                return Math.max(ans - num[0], ans - num[2] - num[3]);
            } else if (num[0] != -1) {
                return ans - num[0];
            } else if (num[2] != -1 && num[3] != -1) {
                return ans - num[2] - num[3];
            }
        }
        if (ans % 3 == 2) {
            if (num[0] != -1 && num[1] != -1 && num[2] != -1) {
                return Math.max(ans - num[0] - num[1], ans - num[2]);
            } else if (num[2] != -1) {
                return ans - num[2];
            } else if (num[0] != -1 && num[1] != -1) {
                return ans - num[0] - num[1];
            }
        }
        return ans;
    }
}
