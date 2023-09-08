import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-03-06 21:18
 * @description 2578. 最小和分割
 * 给你一个正整数 num ，请你将它分割成两个非负整数 num1 和 num2 ，满足：
 *
 * num1 和 num2 直接连起来，得到 num 各数位的一个排列。
 * 换句话说，num1 和 num2 中所有数字出现的次数之和等于 num 中所有数字出现的次数。
 * num1 和 num2 可以包含前导 0 。
 * 请你返回 num1 和 num2 可以得到的和的 最小 值。
 *
 * 注意：
 * num 保证没有前导 0 。
 * num1 和 num2 中数位顺序可以与 num 中数位顺序不同。
 * 示例 1：
 *
 * 输入：num = 4325
 * 输出：59
 * 解释：我们可以将 4325 分割成 num1 = 24 和 num2 = 35 ，和为 59 ，59 是最小和。
 * 示例 2：
 *
 * 输入：num = 687
 * 输出：75
 * 解释：我们可以将 687 分割成 num1 = 68 和 num2 = 7 ，和为最优值 75 。
 */
public class Solution2578 {
    public static void main(String[] args) {
        Solution2578 solution2578 = new Solution2578();
        int ans = solution2578.splitNum(687);
        System.out.println(ans);
    }

    /**
     * 贪心：奇偶位分别分配到num1和num2
     * @param num 正整数的排序
     * @return 最小和
     */
    public int splitNum(int num) {
        String strNum = String.valueOf(num);
        int length = strNum.length();
        int[] nums = new int[length];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = strNum.charAt(i) - '0';
        }
        Arrays.sort(nums);//记录num的每一个数并且从小到大排序
        StringBuilder num1 = new StringBuilder();
        StringBuilder num2 = new StringBuilder();
        for (int i = 0; i < length && i + 1 < length; i += 2) {
            num1.append(nums[i]);//奇数位存放
            num2.append(nums[i + 1]);//偶数位存放
        }
        if (length % 2 != 0) {
            num1.append(nums[length - 1]);//奇数位补充
        }
        return Integer.parseInt(num1.toString()) + Integer.parseInt(num2.toString());
    }
}
