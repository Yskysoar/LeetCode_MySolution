/**
 * @author Yskysoar
 * @createTime 2025-11-17 0:12
 * @description 1437. 是否所有 1 都至少相隔 k 个元素
 * 给你一个由若干 0 和 1 组成的数组 nums 以及整数 k。如果所有 1 都至少相隔 k 个元素，则返回 true ；否则，返回 false 。
 * 示例 1：
 * 输入：nums = [1,0,0,0,1,0,0,1], k = 2
 * 输出：true
 * 解释：每个 1 都至少相隔 2 个元素。
 * 示例 2：
 * 输入：nums = [1,0,0,1,0,1], k = 2
 * 输出：false
 * 解释：第二个 1 和第三个 1 之间只隔了 1 个元素。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 0 <= k <= nums.length
 * nums[i] 的值为 0 或 1
 */
public class Solution1437 {
    public static void main(String[] args) {
        Solution1437 solution1437 = new Solution1437();
        boolean ans = solution1437.kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2);
        System.out.println(ans);
    }

    public boolean kLengthApart(int[] nums, int k) {
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (index == -1) {
                    index = i;
                    continue;
                }
                if (i - index - 1 < k) return false;
                index = i;
            }
        }
        return true;
    }
}
