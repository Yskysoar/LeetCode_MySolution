/**
 * @author Yskysoar
 * @createTime 2024-06-29 9:54
 * @description 2710. 移除字符串中的尾随零
 * 给你一个用字符串表示的正整数 num ，请你以字符串形式返回不含尾随零的整数 num 。
 * 示例 1：
 * 输入：num = "51230100"
 * 输出："512301"
 * 解释：整数 "51230100" 有 2 个尾随零，移除并返回整数 "512301" 。
 * 示例 2：
 * 输入：num = "123"
 * 输出："123"
 * 解释：整数 "123" 不含尾随零，返回整数 "123" 。
 * 提示：
 * 1 <= num.length <= 1000
 * num 仅由数字 0 到 9 组成
 * num 不含前导零
 */
public class Solution2710 {
    public static void main(String[] args) {
        Solution2710 solution2710 = new Solution2710();
        String ans = solution2710.removeTrailingZeros("51230100");
        System.out.println(ans);
    }

    /**
     * 从后向前遍历，找到第一个不是0的数，然后截断即可
     * @param num 数字字符串
     * @return 不含尾随0的字符串
     */
    public String removeTrailingZeros(String num) {
        for (int length = num.length() - 1; length >= 0; length--) {
            if (num.charAt(length) - '0' != 0) {
                num = num.substring(0, length + 1);
                break;
            }
        }
        return num;
    }
}
