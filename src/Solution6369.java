import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * @author Yskysoar
 * @createTime 2023-02-26 23:55
 * @description 6369. 左右元素和的差值
 *
 * 给你一个下标从 0 开始的整数数组 nums ，请你找出一个下标从 0 开始的整数数组 answer ，其中：
 *
 * answer.length == nums.length
 * answer[i] = |leftSum[i] - rightSum[i]|
 * 其中：
 * leftSum[i] 是数组 nums 中下标 i 左侧元素之和。如果不存在对应的元素，leftSum[i] = 0 。
 * rightSum[i] 是数组 nums 中下标 i 右侧元素之和。如果不存在对应的元素，rightSum[i] = 0 。
 * 返回数组 answer 。
 * 示例 1：
 * 输入：nums = [10,4,8,3]
 * 输出：[15,1,11,22]
 * 解释：数组 leftSum 为 [0,10,14,22] 且数组 rightSum 为 [15,11,3,0] 。
 * 数组 answer 为 [|0 - 15|,|10 - 11|,|14 - 3|,|22 - 0|] = [15,1,11,22]
 *
 * 示例 2：
 * 输入：nums = [1]
 * 输出：[0]
 * 解释：数组 leftSum 为 [0] 且数组 rightSum 为 [0] 。
 * 数组 answer 为 [|0 - 0|] = [0] 。
 */
public class Solution6369 {
    public static void main(String[] args) {
        Solution6369 solution6369 = new Solution6369();
        int[] ans = solution6369.leftRigthDifference3(new int[]{10,4,8,3});
        System.out.println(Arrays.toString(ans));
    }

    public int[] leftRigthDifference1(int[] nums) {
        IntStream stream = Arrays.stream(nums);
        int sum = stream.sum();//数组总和
        int[] ans = new int[nums.length];//创建存放结果数组

        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.abs(sum - getSum(i, nums) * 2 - nums[i]);
        }//此处可以优化，因为后缀和每次都在减少一个数，没必要每次都去调用，用原先的数据处理即可
        return ans;
    }

    public int getSum(int index, int[] nums) {
        int ans = 0;
        for (int i = index + 1; i < nums.length; i++) {
            ans += nums[i];
        }
        return ans;
    }

    public int[] leftRigthDifference2(int[] nums) {//记录后缀
        int sum = Arrays.stream(nums).sum();//数组和
        int[] ans = new int[nums.length];//创建存放结果数组
        int rSum = sum;//后缀和(包括本位)
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.abs((sum - rSum) - (rSum - nums[i]));//前缀 - 后缀
            rSum -= nums[i];
        }
        return ans;
    }


    public int[] leftRigthDifference3(int[] nums) {//记录前缀
        int sum = Arrays.stream(nums).sum();//数组和
        int[] ans = new int[nums.length];//创建存放结果数组
        int lSum = 0;//前缀和(不包括本位)
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Math.abs((sum -lSum - nums[i]) - lSum );//后缀 - 前缀
            lSum += nums[i];
        }
        return ans;
    }
}
