/**
 * @author Yskysoar
 * @createTime 2023-02-27 11:22
 * @description 2566. 替换一个数字后的最大差值
 *
 * 给你一个整数 num 。你知道Danny会偷偷将 0 到 9 中的一个数字 替换 成另一个数字。
 * 请你返回将 num 中 恰好一个 数字进行替换后，得到的最大值和最小值的差位多少。
 * 当 Danny 将一个数字 d1 替换成另一个数字 d2 时，Danny 需要将 nums 中所有 d1 都替换成 d2 。
 * Danny 可以将一个数字替换成它自己，也就是说 num 可以不变。
 * Danny 可以将数字分别替换成两个不同的数字分别得到最大值和最小值。
 * 替换后得到的数字可以包含前导 0 。
 * 示例 1
 * 输入：num = 11891
 * 输出：99009
 * 解释：
 * 为了得到最大值，我们将数字 1 替换成数字 9 ，得到 99899 。
 * 为了得到最小值，我们将数字 1 替换成数字 0 ，得到 890 。
 * 两个数字的差值为 99009
 *
 * 示例2
 * 输入：num = 90
 * 输出：99
 * 解释：
 * 可以得到的最大值是 99（将 0 替换成 9），最小值是 0（将 9 替换成 0）。
 * 所以我们得到 99 。
 */
public class Solution2566 {
    public static void main(String[] args) {
        Solution2566 solution2566 = new Solution2566();
        int ans = solution2566.minMaxDifference(90919);
        System.out.println(ans);
    }

    /**
     * 寻找最大值和最小值的差值：将第一个非9的数改成9 - 将第一个非0的数改成0
     * @param num 需要查找差值的数
     * @return 差值
     */
    public int minMaxDifference(int num) {
        String strNum = String.valueOf(num);
        int maxNum = 0;
        int minNum = 0;
        //最大数：将第一个非零的数改为9，如果此数为9就走向下一个非9的数改为9
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) != '0' || i != 0) {
                if (strNum.charAt(i) != '9') {
                    maxNum = Integer.parseInt(strNum.replace(strNum.charAt(i), '9'));
                    break;
                }
            }
            maxNum = Integer.parseInt(strNum);//如果全部为9那么当前数就是最大值
        }
        //最小数：将第一个非0数改为0
        for (int i = 0; i < strNum.length(); i++) {
            if (strNum.charAt(i) != '0') {
                minNum = Integer.parseInt(strNum.replace(strNum.charAt(i), '0'));
                break;
            }
        }
        return maxNum - minNum;
    }
}
