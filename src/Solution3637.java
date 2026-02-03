/**
 * @author Yskysoar
 * @createTime 2026-02-03 12:26
 * @description 3637. 三段式数组 I
 * 给你一个长度为 n 的整数数组 nums。
 * 如果存在索引 0 < p < q < n − 1，使得数组满足以下条件，则称其为 三段式数组（trionic）：
 * nums[0...p] 严格 递增，
 * nums[p...q] 严格 递减，
 * nums[q...n − 1] 严格 递增。
 * 如果 nums 是三段式数组，返回 true；否则，返回 false。
 * 示例 1:
 * 输入: nums = [1,3,5,4,2,6]
 * 输出: true
 * 解释:
 * 选择 p = 2, q = 4：
 * nums[0...2] = [1, 3, 5] 严格递增 (1 < 3 < 5)。
 * nums[2...4] = [5, 4, 2] 严格递减 (5 > 4 > 2)。
 * nums[4...5] = [2, 6] 严格递增 (2 < 6)。
 * 示例 2:
 * 输入: nums = [2,1,3]
 * 输出: false
 * 解释:
 * 无法选出能使数组满足三段式要求的 p 和 q 。
 * 提示:
 * 3 <= n <= 100
 * -1000 <= nums[i] <= 1000
 */
public class Solution3637 {
    public static void main(String[] args) {
        Solution3637 solution3637 = new Solution3637();
        boolean ans = solution3637.isTrionic(new int[]{1, 6, 6, 3, 7});
        System.out.println(ans);
    }

    /**
     * 分段标记
     * 根据要求 + 严格 进行分段标记即可
     * @param nums 数据数组
     * @return 数组是否合法
     */
    public boolean isTrionic(int[] nums) {
        int p = -1, q = -1;
        if (nums[0] >= nums[1]) return false;//起始要是递增方向
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) return false;//严格 -> 有相同的元素一定不合法
            if (p == -1) {
                if (nums[i - 1] >= nums[i]) {
                    p = i - 1;
                }
            } else if (q == -1) {
                if (nums[i - 1] < nums[i]) {
                    q = i - 1;
                }
            } else {
                if (nums[i - 1] >= nums[i]) {
                    return false;
                }
            }
        }
        return p != -1 && q != -1;
    }
}
