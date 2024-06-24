import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2024-06-24 17:24
 * @description 503. 下一个更大元素 II
 * 给定一个循环数组 nums （ nums[nums.length - 1] 的下一个元素是 nums[0] ），返回 nums 中每个元素的 下一个更大元素 。
 * 数字 x 的 下一个更大的元素 是按数组遍历顺序，这个数字之后的第一个比它更大的数，这意味着你应该循环地搜索它的下一个更大的数。如果不存在，则输出 -1 。
 * 示例 1:
 * 输入: nums = [1,2,1]
 * 输出: [2,-1,2]
 * 解释: 第一个 1 的下一个更大的数是 2；
 * 数字 2 找不到下一个更大的数；
 * 第二个 1 的下一个最大的数需要循环搜索，结果也是 2。
 * 示例 2:
 * 输入: nums = [1,2,3,4,3]
 * 输出: [2,3,4,-1,4]
 * 提示:
 * 1 <= nums.length <= 10^4
 * -10^9 <= nums[i] <= 10^9
 */
public class Solution503 {
    public static void main(String[] args) {
        Solution503 solution503 = new Solution503();
        int[] ans = solution503.nextGreaterElements(new int[]{1, 8, -1, -100, -1, 222, 1111111, -111111});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 两次遍历就等于循环，要么找到，要么找不到
     * @param nums 数据数组
     * @return 下一个更大的元素
     */
    public int[] nextGreaterElements(int[] nums) {
        int[] ans = new int[nums.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.MAX_VALUE;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] > nums[i]) {
                    ans[i] = nums[j];
                    break;
                }
            }
            if (ans[i] == Integer.MAX_VALUE) {
                for (int j = 0; j < i; j++) {
                    if (nums[j] > nums[i]) {
                        ans[i] = nums[j];
                        break;
                    }
                }
            }
        }
        for (int i = 0; i < ans.length; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }
        return ans;
    }
}
