import java.util.ArrayList;

/**
 * @author Yskysoar
 * @createTime 2025-10-28 9:48
 * @description 3354. 使数组元素等于零
 * 给你一个整数数组 nums 。
 * 开始时，选择一个满足 nums[curr] == 0 的起始位置 curr ，并选择一个移动 方向 ：向左或者向右。
 * 此后，你需要重复下面的过程：
 * 如果 curr 超过范围 [0, n - 1] ，过程结束。
 * 如果 nums[curr] == 0 ，沿当前方向继续移动：如果向右移，则 递增 curr ；如果向左移，则 递减 curr 。
 * 如果 nums[curr] > 0:
 * 将 nums[curr] 减 1 。
 * 反转 移动方向（向左变向右，反之亦然）。
 * 沿新方向移动一步。
 * 如果在结束整个过程后，nums 中的所有元素都变为 0 ，则认为选出的初始位置和移动方向 有效 。
 * 返回可能的有效选择方案数目。
 * 示例 1：
 * 输入：nums = [1,0,2,0,3]
 * 输出：2
 * 解释：
 * 可能的有效选择方案如下：
 * 选择 curr = 3 并向左移动。
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,1,0,3] -> [1,0,1,0,3] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,0,0,2] -> [1,0,0,0,2]
 * -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] -> [0,0,0,0,1] ->
 * [0,0,0,0,1] -> [0,0,0,0,0].
 * 选择 curr = 3 并向右移动。
 * [1,0,2,0,3] -> [1,0,2,0,3] -> [1,0,2,0,2] -> [1,0,2,0,2] -> [1,0,1,0,2] -> [1,0,1,0,2] -> [1,0,1,0,1] -> [1,0,1,0,1]
 * -> [1,0,0,0,1] -> [1,0,0,0,1] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [1,0,0,0,0] -> [0,0,0,0,0].
 * 示例 2：
 * 输入：nums = [2,3,4,0,4,1,0]
 * 输出：0
 * 解释：
 * 不存在有效的选择方案。
 * 提示：
 * 1 <= nums.length <= 100
 * 0 <= nums[i] <= 100
 * 至少存在一个元素 i 满足 nums[i] == 0 。
 */
public class Solution3354 {
    public static void main(String[] args) {
        Solution3354 solution3354 = new Solution3354();
        int ans = solution3354.countValidSelections(new int[]{16, 13, 10, 0, 0, 0, 10, 6, 7, 8, 7});
        System.out.println(ans);
    }

    /**
     * 前缀和
     * 从值为0的元素开始左右碰撞，被碰到的元素值减一
     * 值为0的元素为左右分界点，只要左右元素之和相同则两个方向都合法
     * 若左右元素之和的差值为1，则只有一个方向合法
     * @param nums 数据数组
     * @return 合法的方案数量
     */
    public int countValidSelections(int[] nums) {
        int ans = 0;
        ArrayList<Integer> arrayList = new ArrayList<>();
        long[] preSum = new long[nums.length + 1];//前缀和
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];//计算前缀和
            if (nums[i - 1] == 0) arrayList.add(i - 1);//顺便记录值为0的元素位置
        }
        for (Integer integer : arrayList) {
            if (2 * preSum[integer + 1] == preSum[preSum.length - 1]) {//左右相等，两个方向都合法
                ans += 2;
            } else if (Math.abs(preSum[preSum.length - 1] - 2 * preSum[integer + 1]) == 1) {//左右的差值为一，只有一个方向合法
                ans += 1;
            }
        }
        return ans;
    }
}
