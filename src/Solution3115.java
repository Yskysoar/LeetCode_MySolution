/**
 * @author Yskysoar
 * @createTime 2024-07-02 9:17
 * @description 3115. 质数的最大距离
 * 给你一个整数数组 nums。
 * 返回两个（不一定不同的）质数在 nums 中 下标 的 最大距离。
 * 示例 1：
 * 输入： nums = [4,2,9,5,3]
 * 输出： 3
 * 解释： nums[1]、nums[3] 和 nums[4] 是质数。因此答案是 |4 - 1| = 3。
 * 示例 2：
 * 输入： nums = [4,8,2,8]
 * 输出： 0
 * 解释： nums[2] 是质数。因为只有一个质数，所以答案是 |2 - 2| = 0。
 * 提示：
 * 1 <= nums.length <= 3 * 10^5
 * 1 <= nums[i] <= 100
 * 输入保证 nums 中至少有一个质数。
 */
public class Solution3115 {
    public static void main(String[] args) {
        Solution3115 solution3115 = new Solution3115();
        int ans = solution3115.maximumPrimeDifference(new int[]{1, 7});
        System.out.println(ans);
    }

    /**
     * 首尾遍历查找两个方向的第一个质数即可
     * @param nums 数据数组
     * @return 首尾质数的下标之差
     */
    public int maximumPrimeDifference(int[] nums) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < nums.length; i++) {
            if (isPrime(nums[i])) {
                start = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (isPrime(nums[i])) {
                end = i;
                break;
            }
        }
        return end - start;
    }

    public boolean isPrime(int num) {
        if (num == 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
