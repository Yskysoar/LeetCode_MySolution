import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-09-28 11:05
 * @description 976. 三角形的最大周长
 * 给定由一些正数（代表长度）组成的数组 nums ，返回 由其中三个长度组成的、面积不为零的三角形的最大周长 。如果不能形成任何面积不为零的三角形，返回 0。
 * 示例 1：
 * 输入：nums = [2,1,2]
 * 输出：5
 * 解释：你可以用三个边长组成一个三角形:1 2 2。
 * 示例 2：
 * 输入：nums = [1,2,1,10]
 * 输出：0
 * 解释：
 * 你不能用边长 1,1,2 来组成三角形。
 * 不能用边长 1,1,10 来构成三角形。
 * 不能用边长 1、2 和 10 来构成三角形。
 * 因为我们不能用任何三条边长来构成一个非零面积的三角形，所以我们返回 0。
 * 提示：
 * 3 <= nums.length <= 10^4
 * 1 <= nums[i] <= 10^6
 */
public class Solution976 {

    /**
     * 排序 + 贪心
     * 排序后，从最大的边长找前两个边长，第一个符合要求的一定是最大周长
     * @param nums 边长集合
     * @return 最大周长
     */
    public int largestPerimeter1(int[] nums) {
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i - 2] + nums[i - 1] > nums[i]) {
                return nums[i - 2] + nums[i - 1] + nums[i];
            }
        }
        return 0;
    }

    //超时
    public int largestPerimeter2(int[] nums) {
        int ans = 0;
        Arrays.sort(nums);
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] + nums[i] + nums[i] < ans) break;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] + nums[j] + nums[i] < ans) break;
                for (int k = j - 1; k >= 0; k--) {
                    if (nums[k] + nums[j] + nums[i] < ans) break;
                    if (nums[k] + nums[j] > nums[i]) {
                        ans = Math.max(ans, nums[k] + nums[j] + nums[i]);
                        break;
                    }
                }
            }
        }
        return ans;
    }


}
