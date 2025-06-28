import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Yskysoar
 * @createTime 2025-06-28 17:12
 * @description 2099. 找到和最大的长度为 K 的子序列
 * 给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。
 * 请你返回 任意 一个长度为 k 的整数子序列。
 * 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。
 * 示例 1：
 * 输入：nums = [2,1,3,3], k = 2
 * 输出：[3,3]
 * 解释：
 * 子序列有最大和：3 + 3 = 6 。
 * 示例 2：
 * 输入：nums = [-1,-2,3,4], k = 3
 * 输出：[-1,3,4]
 * 解释：
 * 子序列有最大和：-1 + 3 + 4 = 6 。
 * 示例 3：
 * 输入：nums = [3,4,3,3], k = 2
 * 输出：[3,4]
 * 解释：
 * 子序列有最大和：3 + 4 = 7 。
 * 另一个可行的子序列为 [4, 3] 。
 * 提示：
 * 1 <= nums.length <= 1000
 * -105 <= nums[i] <= 10^5
 * 1 <= k <= nums.length
 */
public class Solution2099 {
    public static void main(String[] args) {
        Solution2099 solution2099 = new Solution2099();
        int[] ans = solution2099.maxSubsequence2(new int[]{2, 1, 3, 3}, 2);
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 窗口 + 最小值
     * @param nums 数据数组
     * @param k    窗口长度
     * @return 窗口元素和
     */
    public int[] maxSubsequence1(int[] nums, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        int min = Integer.MAX_VALUE;//窗口内最小的元素值
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {//前k个元素直接进入窗口作为初始化
                ans.add(nums[i]);
                min = Math.min(min, ans.get(i));//记录窗口最小值
            } else {
                if (nums[i] > min) {//当前元素大于窗口最小值，进入窗口并重新记录最小值
                    ans.remove(ans.indexOf(min));
                    ans.add(nums[i]);//先添加，防止该元素成为最小值
                    min = Collections.min(ans);//寻找最小值
                }//当前元素小于窗口最小值则无需进入窗口直接丢弃
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }

    /**
     * 搜索最小值
     * @param nums 数据数组
     * @param k    窗口长度
     * @return 窗口元素和
     */
    public int[] maxSubsequence2(int[] nums, int k) {
        List<Integer> ans = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length - k; i++) {
            ans.remove(ans.indexOf(Collections.min(ans)));
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
