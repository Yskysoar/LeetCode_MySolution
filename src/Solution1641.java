import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2023-03-29 12:43
 * @description 1641. 统计字典序元音字符串的数目
 * 给你一个整数 n，请返回长度为 n 、仅由元音 (a, e, i, o, u) 组成且按 字典序排列 的字符串数量。
 * 字符串 s 按 字典序排列 需要满足：对于所有有效的 i，s[i] 在字母表中的位置总是与 s[i+1] 相同或在 s[i+1] 之前。
 * 示例 1：
 * 输入：n = 1
 * 输出：5
 * 解释：仅由元音组成的 5 个字典序字符串为 ["a","e","i","o","u"]
 * 示例 2：
 * 输入：n = 2
 * 输出：15
 * 解释：仅由元音组成的 15 个字典序字符串为
 * ["aa","ae","ai","ao","au","ee","ei","eo","eu","ii","io","iu","oo","ou","uu"]
 * 注意，"ea" 不是符合题意的字符串，因为 'e' 在字母表中的位置比 'a' 靠后
 * 示例 3：
 * 输入：n = 33
 * 输出：66045
 */
public class Solution1641 {
    public static void main(String[] args) {
        Solution1641 solution1641 = new Solution1641();
        int ans = solution1641.countVowelStrings2(33);
        System.out.println(ans);
    }

    /*
        a:1   5   15  35  70
        e:1   4   10  20  35
        i:1   3   6   10  15
        o:1   2   3   4   5
        u:1   1   1   1   1
     */

    /**
     * 正向数学递归(a->e->i->o->u)
     * @param n 字符串长度
     * @return 字典序排列数目
     */
    public int countVowelStrings1(int n) {
        int ans;
        int[] sums = {1, 1, 1, 1, 1};
        int sum = Arrays.stream(sums).sum();
        while (n > 1) {
            int[] newSums = new int[5];
            newSums[0] = sum;
            for (int i = 1; i < newSums.length; i++) {
                newSums[i] = newSums[i - 1] - sums[i - 1];
            }
            n--;
            sum = Arrays.stream(newSums).sum();
            sums = Arrays.copyOf(newSums,5);
        }
        ans = Arrays.stream(sums).sum();
        return ans;
    }

    /**
     * 逆向数学递归(u->o->i->e->a)
     * @param n 字符串长度
     * @return 字典序排列数目
     */
    public int countVowelStrings2(int n) {
        int[] sums = {1, 1, 1, 1, 1};
        while (n > 1) {
            for (int i = 1; i < sums.length; i++) {
                sums[i] += sums[i - 1];
            }
            n--;
        }
        return Arrays.stream(sums).sum();
    }


}
