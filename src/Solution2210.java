/**
 * @author Yskysoar
 * @createTime 2025-07-27 0:42
 * @description 2210. 统计数组中峰和谷的数量
 */
public class Solution2210 {

    /**
     * 贪心 + 遍历：首尾必不可能是峰/谷，先看是否连续元素都是相等（相当于合并），然后再找两侧的最近不相等邻居
     * @param nums 数据数组
     * @return 峰和谷的数量
     */
    public int countHillValley(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {//首尾不需要校验
            int right = i + 1;
            while (right < nums.length && nums[right] == nums[i]) right++;//判断是否存在连续元素连续，且index处是右边第一个不相等的元素
            if (right == nums.length) return ans;//说明当前元素右边都是相等的，不可能有峰/谷
            if ((nums[i - 1] > nums[i] && nums[i] < nums[right]) || (nums[i - 1] < nums[i] && nums[i] > nums[right])) {
                ans++;//是峰或谷
            }
            i = right - 1;//循环还会加一
        }
        return ans;
    }
}
