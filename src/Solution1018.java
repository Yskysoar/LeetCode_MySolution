import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-11-24 11:35
 * @description 1018. 可被 5 整除的二进制前缀
 * 给定一个二进制数组 nums ( 索引从0开始 )。
 * 我们将xi 定义为其二进制表示形式为子数组 nums[0..i] (从最高有效位到最低有效位)。
 * 例如，如果 nums =[1,0,1] ，那么 x0 = 1, x1 = 2, 和 x2 = 5。
 * 返回布尔值列表 answer，只有当 xi 可以被 5 整除时，答案 answer[i] 为 true，否则为 false。
 * 示例 1：
 * 输入：nums = [0,1,1]
 * 输出：[true,false,false]
 * 解释：
 * 输入数字为 0, 01, 011；也就是十进制中的 0, 1, 3 。只有第一个数可以被 5 整除，因此 answer[0] 为 true 。
 * 示例 2：
 * 输入：nums = [1,1,1]
 * 输出：[false,false,false]
 * 提示：
 * 1 <= nums.length <= 10^5
 * nums[i] 仅为 0 或 1
 */
public class Solution1018 {
    public static void main(String[] args) {
        Solution1018 solution1018 = new Solution1018();
        List<Boolean> ans = solution1018.prefixesDivBy5(new int[]{0, 1, 1, 1, 1});
        System.out.println(ans);

    }

    /**
     * 余数前缀和
     * 最后的结果需要取模，所以只需要保留当前前缀和取模的部分
     * 每次遍历先整体左移一位再加上新的最低位的值，判断是否可以被整除
     * @param nums 二进制数组（高位到低位）
     * @return Xi是否可以被5整除
     */
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> ans = new ArrayList<>();
        int sum = 0;//记录余数的和
        for (int num : nums) {
            sum += num;
            ans.add(sum % 5 == 0);
            sum *= 2;//向左移位，整体乘二
            sum %= 5;//重新设置余数
        }
        return ans;
    }
}
