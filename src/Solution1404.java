/**
 * @author Yskysoar
 * @createTime 2026-02-26 14:23
 * @description 1404. 将二进制表示减到 1 的步骤数
 * 给你一个以二进制形式表示的数字 s 。请你返回按下述规则将其减少到 1 所需要的步骤数：
 * 如果当前数字为偶数，则将其除以 2 。
 * 如果当前数字为奇数，则将其加上 1 。
 * 题目保证你总是可以按上述规则将测试用例变为 1 。
 * 示例 1：
 * 输入：s = "1101"
 * 输出：6
 * 解释："1101" 表示十进制数 13 。
 * Step 1) 13 是奇数，加 1 得到 14
 * Step 2) 14 是偶数，除 2 得到 7
 * Step 3) 7  是奇数，加 1 得到 8
 * Step 4) 8  是偶数，除 2 得到 4
 * Step 5) 4  是偶数，除 2 得到 2
 * Step 6) 2  是偶数，除 2 得到 1
 * 示例 2：
 * 输入：s = "10"
 * 输出：1
 * 解释："10" 表示十进制数 2 。
 * Step 1) 2 是偶数，除 2 得到 1
 * 示例 3：
 * 输入：s = "1"
 * 输出：0
 * 提示：
 * 1 <= s.length <= 500
 * s 由字符 '0' 或 '1' 组成。
 * s[0] == '1'
 */
public class Solution1404 {
    public static void main(String[] args) {
        Solution1404 solution1404 = new Solution1404();
        int ans = solution1404.numSteps("10");
        System.out.println(ans);
    }

    /**
     * 如果只有一个1，只需要除以s.size()-1次2就行
     * 如果有超过一个1，就一定会导致最高位进位，变成10000000..的格式
     * 只需要数从第一个1到最后一个1中间有n个0就需要加n+1次1（最高位进位）。一共需要s.size() + n+1次
     * @param s 二进制字符串
     * @return 操作次数
     */
    public int numSteps(String s) {
        int count = 0;
        if (s.lastIndexOf('1') == 0) {//只有1的时候可以开log
            return s.length() - 1;
        }
        for (int i = 0; i < s.lastIndexOf('1'); i++) {//第一个1和最后一个1之间有几个0，多一个0就需要一次进位（+1操作）
            if (s.charAt(i) == '0') count++;
        }
        return count + s.length() + 1;
    }
}
