/**
 * @author Yskysoar
 * @createTime 2023-04-12 12:40
 * @description 1147. 段式回文
 * 你会得到一个字符串 text 。你应该把它分成 k 个子字符串 (subtext1, subtext2，…， subtextk) ，要求满足:
 * subtext i 是 非空 字符串
 * 所有子字符串的连接等于 text ( 即subtext1 + subtext2 + ... + subtextk == text )
 * 对于所有 i 的有效值( 即 1 <= i <= k ) ，subtexti == subtextk - i + 1 均成立
 * 返回k可能最大值。
 * 示例 1：
 * 输入：text = "ghiabcdefhelloadamhelloabcdefghi"
 * 输出：7
 * 解释：我们可以把字符串拆分成 "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)"。
 * 示例 2：
 * 输入：text = "merchant"
 * 输出：1
 * 解释：我们可以把字符串拆分成 "(merchant)"。
 * 示例 3：
 * 输入：text = "antaprezatepzapreanta"
 * 输出：11
 * 解释：我们可以把字符串拆分成 "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)"。
 */
public class Solution1147 {
    public static void main(String[] args) {
        Solution1147 solution1147 = new Solution1147();
        int ans = solution1147.longestDecomposition("aelvtoelvtoa");
        System.out.println(ans);
    }

    /**
     * 贪心+双指针：左右两边分别开始寻找，在右边寻找的时候将字符串翻转与左边对比即可
     * 要实现分组最多，策略为：能分必分，只要满足左右回文就直接将其分组，
     * @param text 待分组回文段
     * @return 最大可分组数
     */
    public int longestDecomposition(String text) {
        int ans = 1;
        int start = 0;
        int end = text.length() - 1;
        StringBuilder startStr = new StringBuilder();
        String endStr = "";
        while (start < end) {
            startStr.append(text.charAt(start));
            endStr += text.charAt(end);
            if (startStr.toString().equals(String.valueOf(new StringBuilder(endStr).reverse()))) {//能分必分
                ans += 2;
                startStr = new StringBuilder();
                endStr = "";
                if (start + 1 == end) ans--;//此时说明左右两边刚好回文，例如：elvtoelvto
            }
            start++;
            end--;
        }
        return ans;
    }
}
