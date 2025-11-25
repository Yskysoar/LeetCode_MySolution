/**
 * @author Yskysoar
 * @createTime 2025-11-25 12:10
 * @description 1015. 可被 K 整除的最小整数
 * 给定正整数 k ，你需要找出可以被 k 整除的、仅包含数字 1 的最 小 正整数 n 的长度。
 * 返回 n 的长度。如果不存在这样的 n ，就返回-1。
 * 注意： n 可能不符合 64 位带符号整数。
 * 示例 1：
 * 输入：k = 1
 * 输出：1
 * 解释：最小的答案是 n = 1，其长度为 1。
 * 示例 2：
 * 输入：k = 2
 * 输出：-1
 * 解释：不存在可被 2 整除的正整数 n 。
 * 示例 3：
 * 输入：k = 3
 * 输出：3
 * 解释：最小的答案是 n = 111，其长度为 3。
 * 提示：
 * 1 <= k <= 10^5
 */
public class Solution1015 {
    public static void main(String[] args) {
        Solution1015 solution1015 = new Solution1015();
        int ans = solution1015.smallestRepunitDivByK(3);
        System.out.println(ans);
    }


    /**
     * 除留余数法 + 鸽巢原理
     * 鸽巢原理：模k的结果只有0~k-1共k种可能，循环k次后没有n%k=0，余数会出现重复，后续也不会再出现0，可判定不存在这样的n
     * @param k 除数
     * @return 最小的可以被整除的数
     */
    public int smallestRepunitDivByK(int k) {
        int length = 1;//记录长度
        int remainder = 1;//记录余数
        while (length <= k) {//一共循环k次
            if (remainder % k == 0) return length;
            remainder = (remainder * 10 + 1) % k;
            length++;
        }
        return -1;
    }
}
