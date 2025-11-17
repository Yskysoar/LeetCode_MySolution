/**
 * @author Yskysoar
 * @createTime 2025-11-18 0:38
 * @description 717. 1 比特与 2 比特字符
 * 有两种特殊字符：
 * 第一种字符可以用一比特 0 表示
 * 第二种字符可以用两比特（10 或 11）表示
 * 给你一个以 0 结尾的二进制数组 bits ，如果最后一个字符必须是一个一比特字符，则返回 true 。
 * 示例 1:
 * 输入: bits = [1, 0, 0]
 * 输出: true
 * 解释: 唯一的解码方式是将其解析为一个两比特字符和一个一比特字符。
 * 所以最后一个字符是一比特字符。
 * 示例 2:
 * 输入：bits = [1,1,1,0]
 * 输出：false
 * 解释：唯一的解码方式是将其解析为两比特字符和两比特字符。
 * 所以最后一个字符不是一比特字符。
 * 提示:
 * 1 <= bits.length <= 1000
 * bits[i] 为 0 或 1
 */
public class Solution717 {
    public static void main(String[] args) {
        Solution717 solution717 = new Solution717();
        boolean ans = solution717.isOneBitCharacter(new int[]{1, 1, 1, 0});
        System.out.println(ans);
    }

    /**
     * 编码原理
     * 遇到0不管，遇到1一定会多使用一个比特位，检查最后停留的位置是否为最后一个比特位
     * @param bits 比特数组
     * @return 最后一个字符是否为0
     */
    public boolean isOneBitCharacter(int[] bits) {
        int ans = 0;
        if (bits.length == 1 || bits[bits.length - 2] == 0) return true;
        while (ans < bits.length - 1) {//遇到0不管，遇到1一定会多使用一个比特位
            ans += (bits[ans] + 1);
        }
        return ans == bits.length - 1;//检查最后停留的位置是否为最后一个比特位
    }
}
