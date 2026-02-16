/**
 * @author Yskysoar
 * @createTime 2025-01-05 19:51
 * @description 67. 二进制求和
 * 给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * 示例 1：
 * 输入:a = "11", b = "1"
 * 输出："100"
 * 示例 2：
 * 输入：a = "1010", b = "1011"
 * 输出："10101"
 * 提示：
 * 1 <= a.length, b.length <= 104
 * a 和 b 仅由字符 '0' 或 '1' 组成
 * 字符串如果不是 "0" ，就不含前导零
 */
public class Solution67 {
    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        String ans = solution67.addBinary2("100", "110010");
        System.out.println(ans);
    }

    /**
     * 手算二进制加法
     * @param a 二进制字符a
     * @param b 二进制字符b
     * @return a+b的二进制结果
     */
    public String addBinary1(String a, String b) {
        int CF = 0;//进位
        StringBuilder ans = new StringBuilder();
        int length = Math.min(a.length(), b.length());
        int value = Math.max(a.length(), b.length()) - length;
        for (int i = length - 1; i >= 0; i--) {
            int a_key, b_key;
            if (a.length() >= b.length()) {
                b_key = Integer.parseInt(String.valueOf(b.charAt(i)));
                a_key = Integer.parseInt(String.valueOf(a.charAt(i + value)));
            } else {
                b_key = Integer.parseInt(String.valueOf(a.charAt(i)));
                a_key = Integer.parseInt(String.valueOf(b.charAt(i + value)));
            }
            //a_key + b_key + CF 的结果只有3，2，1，0四种结果
            if (a_key + b_key + CF > 1) {
                ans.append(a_key + b_key + CF - 2);
                CF = 1;
            } else {
                ans.append(a_key + b_key + CF);
                CF = 0;
            }
        }
        if (a.length() >= b.length()) {
            CF = getNextValue(a, CF, ans, value);
        } else {
            CF = getNextValue(b, CF, ans, value);
        }
        return CF == 1 ? ans.append(CF).reverse().toString() : ans.reverse().toString();
    }

    /**
     * 处理长字符串剩余的二进制数
     * @param str   长字符串
     * @param CF    低位进位
     * @param ans   二进制结果
     * @param value 起点
     * @return 高位的进位
     */
    public int getNextValue(String str, int CF, StringBuilder ans, int value) {
        for (int i = value - 1; i >= 0; i--) {
            int a_next = Integer.parseInt(String.valueOf(str.charAt(i)));
            if (a_next + CF > 1) {
                ans.append(a_next + CF - 2);
                CF = 1;
            } else {
                ans.append(a_next + CF);
                CF = 0;
            }
        }
        return CF;
    }


    public String addBinary2(String a, String b) {
        StringBuilder ans = new StringBuilder();
        int CF = 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            int num = (a.charAt(a.length() - 1 - i) - '0') + (b.charAt(b.length() - 1 - i) - '0') + CF;
            if (num > 1) {//num的可能取值只有0 1 2 3四种
                CF = 1;
                ans.append(num - 2);
            } else {
                CF = 0;
                ans.append(num);
            }
        }
        if (a.length() < b.length()) {
            for (int i = a.length(); i < b.length(); i++) {
                int num = b.charAt(b.length() - 1 - i) - '0' + CF;
                if (num > 1) {//num的可能取值只有0 1 2 3四种
                    CF = 1;
                    ans.append(num - 2);
                } else {
                    CF = 0;
                    ans.append(num);
                }
            }
        } else {
            for (int i = b.length(); i < a.length(); i++) {
                int num = a.charAt(a.length() - 1 - i) - '0' + CF;
                if (num > 1) {//num的可能取值只有0 1 2 3四种
                    CF = 1;
                    ans.append(num - 2);
                } else {
                    CF = 0;
                    ans.append(num);
                }
            }
        }
        if (CF == 1) ans.append(CF);
        return ans.reverse().toString();
    }
}
