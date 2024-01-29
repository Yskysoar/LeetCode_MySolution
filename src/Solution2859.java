import java.util.Arrays;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2024-01-25 14:22
 * @description 2859. 计算 K 置位下标对应元素的和
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * 请你用整数形式返回 nums 中的特定元素之 和 ，这些特定元素满足：其对应下标的二进制表示中恰存在 k 个置位。
 * 整数的二进制表示中的 1 就是这个整数的 置位 。
 * 例如，21 的二进制表示为 10101 ，其中有 3 个置位。
 * 示例 1：
 * 输入：nums = [5,10,1,5,2], k = 1
 * 输出：13
 * 解释：下标的二进制表示是：
 * 0 = 000
 * 1 = 001
 * 2 = 010
 * 3 = 011
 * 4 = 100
 * 下标 1、2 和 4 在其二进制表示中都存在 k = 1 个置位。
 * 因此，答案为 nums[1] + nums[2] + nums[4] = 13 。
 * 示例 2：
 * 输入：nums = [4,3,2,1], k = 2
 * 输出：1
 * 解释：下标的二进制表示是：
 * 0 = 00
 * 1 = 01
 * 2 = 10
 * 3 = 11
 * 只有下标 3 的二进制表示中存在 k = 2 个置位。
 * 因此，答案为 nums[3] = 1 。
 * 提示：
 * 1 <= nums.length <= 1000
 * 1 <= nums[i] <= 105
 * 0 <= k <= 10
 */
public class Solution2859 {
    public static void main(String[] args) {
        Solution2859 solution2859 = new Solution2859();
        int ans = solution2859.sumIndicesWithKSetBits(Arrays.asList(5, 10, 1, 5, 2), 0);
        System.out.println(ans);
    }

    /**
     * 暴力双层循环：第一层对应索引，第二层判断索引满不满足置位的个数
     * @param nums 数据集
     * @param k    置位数
     * @return K个置位的下标 对应元素的和
     */
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            String string = Integer.toString(i, 2);
            int num = 0;
            for (int j = 0; j < string.length(); j++) {
                if (string.charAt(j) - '0' == 1) num++;
            }
            ans += (k == num ? nums.get(i) : 0);
        }
        return ans;
    }
}
