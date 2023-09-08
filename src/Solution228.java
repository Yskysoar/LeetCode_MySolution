import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-08-27 0:01
 * @description 228.汇总区间
 * 给定一个  无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序区间范围列表
 * 也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 * 示例 1：
 * 输入：nums = [0,1,2,4,5,7]
 * 输出：["0->2","4->5","7"]
 * 解释：区间范围是：
 * [0,2] --> "0->2"
 * [4,5] --> "4->5"
 * [7,7] --> "7"
 * 示例 2：
 * 输入：nums = [0,2,3,4,6,8,9]
 * 输出：["0","2->4","6","8->9"]
 * 解释：区间范围是：
 * [0,0] --> "0"
 * [2,4] --> "2->4"
 * [6,6] --> "6"
 * [8,9] --> "8->9"
 */
public class Solution228 {
    public static void main(String[] args) {
        Solution228 solution228 = new Solution228();
        List<String> ans = solution228.summaryRanges(new int[]{0, 1, 2, 4, 5, 7});
        System.out.println(ans);
    }

    /**
     * 暴力遍历
     * @param nums 无重复元素的有序整数数组
     * @return 恰好覆盖数组中所有数字的最小有序区间范围列表
     */
    public List<String> summaryRanges(int[] nums) {
        List<String> ans = new ArrayList<>();
        int left = 0;//左边界
        int right = 0;//右边界
        for (int i = 1; i < nums.length; i++) {//逐个遍历
            if (nums[i] == nums[i - 1] + 1) {
                right++;
            } else {
                if (left == right) {//单一区间
                    ans.add(nums[left] + "");
                } else {
                    ans.add(nums[left] + "->" + nums[right]);
                }
                left = i;
                right = i;
            }
        }
        if (right == nums.length - 1) {//处理最后一个区间
            if (left == right) {
                ans.add(nums[nums.length - 1] + "");
            } else {
                ans.add(nums[left] + "->" + nums[right]);
            }
        }
        return ans;
    }
}
