import java.util.logging.Level;

/**
 * @author Yskysoar
 * @createTime 2023-03-15 21:51
 * @description 33. 搜索旋转排序数组
 *
 * 整数数组 nums 按升序排列，数组中的值 互不相同 。
 *
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。
 *
 * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。
 *
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 *
 *
 *
 * 示例 1：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 0
 * 输出：4
 * 示例 2：
 *
 * 输入：nums = [4,5,6,7,0,1,2], target = 3
 * 输出：-1
 * 示例 3：
 *
 * 输入：nums = [1], target = 0
 * 输出：-1
 */
public class Solution33 {
    public static void main(String[] args) {
        Solution33 solution33 = new Solution33();
        int ans = solution33.search2(new int[]{4,5,6,7,0,1,2}, 0);
        System.out.println(ans);
    }

    /**
     * 暴力循环：数据很少不会超时
     * @param nums 旋转数组
     * @param target 目标值
     * @return 目标值的索引
     */
    public int search1(int[] nums, int target) {
        int index = 0;
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                ans = i;
            }
        }
        return ans;
    }

    /**
     * 经典二分：先判断middle是在哪个区间，在判断target在middle左边还是右边
     * @param nums 旋转数组
     * @param target 目标值
     * @return 目标值的索引
     */
    public int search2(int[] nums, int target) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int middle = (end - start) / 2 + start;
            if (nums[middle] == target) {
                ans = middle;
                break;
            }
            if (nums[middle] >= nums[0]) {//左递增区间
                if (target > nums[middle] || target < nums[0]) {//当前值比目标值小 -> 目标值在剩余左递增区间 || 目标值比左递增区间起始值小 -> 在右递增区间
                    start = middle + 1;
                } else {
                    end = middle - 1;
                }
            } else {//右递增区间
                if (target < nums[middle] || target > nums[nums.length - 1]) {//当前值比目标值大 -> 目标值在之前右递增区间 || 目标值比右递增区间终止值大 -> 在左递增区间
                    end = middle - 1;
                } else {
                    start = middle + 1;
                }
            }
        }
        return ans;
    }
}
