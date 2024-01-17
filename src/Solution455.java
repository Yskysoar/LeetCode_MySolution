import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-02-14 16:31
 * @description 455. 分发饼干
 * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
 * 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。
 * 如果 s[j] >= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
 * 示例 1:
 * 输入: g = [1,2,3], s = [1,1]
 * 输出: 1
 * 解释:
 * 你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
 * 虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
 * 所以你应该输出1。
 * 示例 2:
 * 输入: g = [1,2], s = [1,2,3]
 * 输出: 2
 * 解释:
 * 你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
 * 你拥有的饼干数量和尺寸都足以让所有孩子满足。
 * 所以你应该输出2.
 * g和s的长度就是孩子和饼干的数量，尽可能多的分配给孩子就可以，一个饼干的最大价值就是分配给胃口刚好这么大的孩子
 */

public class Solution455 {
    public static void main(String[] args) {
        Solution455 solution455 = new Solution455();
        int res = solution455.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3});
        System.out.println(res);
    }

    /**
     * 双指针：当前饼干尺寸符合孩子胃口就记录并且都移动到下一个位置，否则当前饼干就失去价值且移动到下一个
     * @param g 孩子胃口
     * @param s 饼干尺寸
     * @return 满足的孩子最大数量
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gIndex = 0;
        int sIndex = 0;
        while (sIndex != s.length && gIndex != g.length) {
            if (g[gIndex] <= s[sIndex]) {
                gIndex++;
            }
            sIndex++;
        }
        return gIndex;
    }
}
