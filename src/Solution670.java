/**
 * @author Yskysoar
 * @createTime 2024-01-22 20:06
 * @description 670. 最大交换
 * 给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。
 * 示例 1 :
 * 输入: 2736
 * 输出: 7236
 * 解释: 交换数字2和数字7。
 * 示例 2 :
 * 输入: 9973
 * 输出: 9973
 * 解释: 不需要交换。
 * 注意:
 * 给定数字的范围是 [0, 10^8]
 */
public class Solution670 {
    public static void main(String[] args) {
        Solution670 solution670 = new Solution670();
        int ans = solution670.maximumSwap1(9973);
        System.out.println(ans);
    }

    /**
     * 暴力(9*9)
     * @param num 非负整数
     * @return 交换后的最大值
     */
    public int maximumSwap1(int num) {
        StringBuilder strNum = new StringBuilder(String.valueOf(num));
        int ans = num;
        for (int i = 0; i < strNum.length(); i++) {
            for (int j = i + 1; j < strNum.length(); j++) {
                if (strNum.charAt(i) < strNum.charAt(j)) {
                    char temp = strNum.charAt(i);
                    strNum.setCharAt(i, strNum.charAt(j));
                    strNum.setCharAt(j, temp);
                    ans = Math.max(ans, Integer.parseInt(strNum.toString()));
                    strNum.setCharAt(j, strNum.charAt(i));
                    strNum.setCharAt(i, temp);
                }
            }
        }
        return ans;
    }

    /**
     * 贪心算法：靠近右侧的最大和靠近左侧最小交换(确定一边时，由于交换的一个位置确定，另外一边优先考虑数的大小，再考虑数的位置)
     * T1.x min |x max1 x max2 x
     * T2.max x left |right x x x
     * @param num 非负整数
     * @return 交换后的最大值
     */
    public int maximumSwap2(int num) {
        char[] charArray = String.valueOf(num).toCharArray();
        int left = -1;
        int right = -1;
        int max = charArray.length - 1;//记录右侧最大的数字索引
        for (int i = charArray.length - 1; i >= 0; i--) {
            if (charArray[i] > charArray[max]) {
                max = i;
            } else if (charArray[i] < charArray[max]) {
                left = i;
                right = max;
            }//等于不用考虑，因为仍然靠右
        }//left < right(left取左边最小，right右边最大)
        if (left >= 0) {//只有在数是降序排列的时候才会为-1
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            return Integer.parseInt(new String(charArray));
        } else {
            return num;
        }
    }
}
