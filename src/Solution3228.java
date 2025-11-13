/**
 * @author Yskysoar
 * @createTime 2025-11-13 12:10
 * @description
 */
public class Solution3228 {
    public static void main(String[] args) {
        Solution3228 solution3228 = new Solution3228();
        int ans = solution3228.maxOperations("10011010");
        System.out.println(ans);
    }

    /**
     * 贪心 + 遍历（类似滑动窗口的思路）
     * 要记录最大的操作次数，就必须尽可能的多移动
     * 遇到符合要求的10就可以把这之前的所有1都向右移动一轮
     * 不用管移动到哪，只需要考虑是否移动
     * @param s 二进制字符串
     * @return 最大的操作次数
     */
    public int maxOperations(String s) {
        int ans = 0, count = 0;//记录在当前位置之前出现过的"1"的个数
        boolean isFlag = false;//记录是否出现"10"
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                if (isFlag) {
                    ans += count;//有多少个"1"就可以操作几轮
                }
                count++;//记录当前位置的"1"
                if (i + 1 < s.length()) {
                    isFlag = s.charAt(i + 1) == '0';//检查后面是否是"0"
                }
            }
        }
        return s.charAt(s.length() - 1) == '0' ? ans + count : ans;//尾部如果是0需要特殊处理
    }
}
