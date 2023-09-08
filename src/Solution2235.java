/**
 * @author Yskysoar
 * @createTime 2023-08-19 17:09
 * @description 2235.两整数相加
 * 给你两个整数 num1 和 num2，返回这两个整数的和。
 * 示例 1：
 * 输入：num1 = 12, num2 = 5
 * 输出：17
 * 解释：num1 是 12，num2 是 5 ，它们的和是 12 + 5 = 17 ，因此返回 17 。
 * 示例 2：
 * 输入：num1 = -10, num2 = 4
 * 输出：-6
 * 解释：num1 + num2 = -6 ，因此返回 -6 。
 */
public class Solution2235 {
    public static void main(String[] args) {
        Solution2235 solution2235 = new Solution2235();
        int ans1 = solution2235.sum1(1, 5);
        int ans2 = solution2235.sum2(1, 5);
        System.out.println(ans1);
        System.out.println(ans2);
    }

    /**
     * 直接运算
     * @param num1 整数一
     * @param num2 整数二
     * @return 两数之和
     */
    public int sum1(int num1, int num2) {
        return num1 + num2;
    }

    /**
     * 位运算
     * @param num1 整数一
     * @param num2 整数二
     * @return 两数之和
     */
    public int sum2(int num1, int num2) {
        while (num2 != 0) {
            int carry = (num1 & num2) << 1;
            num1 ^= num2;
            num2 = carry;
        }
        return num1;
    }
}
