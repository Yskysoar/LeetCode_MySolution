/**
 * @author Yskysoar
 * @createTime 2025-09-05 0:23
 * @description 2749. 得到整数零需要执行的最少操作数
 * 给你两个整数：num1 和 num2 。
 * 在一步操作中，你需要从范围 [0, 60] 中选出一个整数 i ，并从 num1 减去 2i + num2 。
 * 请你计算，要想使 num1 等于 0 需要执行的最少操作数，并以整数形式返回。
 * 如果无法使 num1 等于 0 ，返回 -1 。
 * 示例 1：
 * 输入：num1 = 3, num2 = -2
 * 输出：3
 * 解释：可以执行下述步骤使 3 等于 0 ：
 * - 选择 i = 2 ，并从 3 减去 22 + (-2) ，num1 = 3 - (4 + (-2)) = 1 。
 * - 选择 i = 2 ，并从 1 减去 22 + (-2) ，num1 = 1 - (4 + (-2)) = -1 。
 * - 选择 i = 0 ，并从 -1 减去 20 + (-2) ，num1 = (-1) - (1 + (-2)) = 0 。
 * 可以证明 3 是需要执行的最少操作数。
 * 示例 2：
 * 输入：num1 = 5, num2 = 7
 * 输出：-1
 * 解释：可以证明，执行操作无法使 5 等于 0 。
 * 提示：
 * 1 <= num1 <= 10^9
 * -10^9 <= num2 <= 10^9
 */
public class Solution2749 {
    public static void main(String[] args) {
        Solution2749 solution2749 = new Solution2749();
        int ans = solution2749.makeTheIntegerZero(112577768, -501662198);
        System.out.println(ans);
    }

    /**
     * 枚举 + 二进制
     * 检查当前元素是否可以由n项可重复的2^k组成，每一个二进制位的1可以分解为两个下一个位置的二进制1 即10 = 01 + 01
     * 当前减去num2后的元素，二进制1的数目小于等于当前次数i且当前元素值足够大可以分解时，即满足要求
     * @param num1 待判断元素
     * @param num2 每轮减去的元素
     * @return 是否存在n，使得进行n轮操作后为0
     */
    public int makeTheIntegerZero(int num1, int num2) {
        if (num2 >= num1) return -1;
        long num = num1 - num2;//防止溢出
        for (int i = 1; i <= 60; i++, num -= num2) {//枚举所有情况
            if (num >= i && Long.bitCount(num) <= i) return i;//二进制1足够少且num足够大可以进行分解时
        }
        return -1;
        //先不管你每一轮减的2^i是多少，假设n轮后为0，检查（num1 - n * num2）是不是可以由n个可以重复的2^k组成即可
        //先看（num1 - n * num2）的二进制1是不是大于n（此时必定无解），然后就是看能不能分解二进制位凑齐需要的2^i个数（n个）
    }
}
