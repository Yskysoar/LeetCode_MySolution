import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2023-03-20 10:08
 * @description 1012. 至少有 1 位重复的数字
 *
 * 给定正整数 n，返回在 [1, n] 范围内具有 至少 1 位 重复数字的正整数的个数。
 * 示例 1：
 * 输入：n = 20
 * 输出：1
 * 解释：具有至少 1 位重复数字的正数（<= 20）只有 11 。
 *
 * 示例 2：
 *
 * 输入：n = 100
 * 输出：10
 * 解释：具有至少 1 位重复数字的正数（<= 100）有 11，22，33，44，55，66，77，88，99 和 100 。
 * 示例 3：
 *
 * 输入：n = 1000
 * 输出：262
 */
public class Solution1012 {
    public static void main(String[] args) {
        Solution1012 solution1012 = new Solution1012();
        int ans = solution1012.numDupDigitsAtMostN(10000);
        System.out.println(ans);
    }
    public int numDupDigitsAtMostN(int n) {
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (isEquals(i)) ans++;
        }
        return ans;
    }


    public boolean isEquals(int num) {
        String strNum = String.valueOf(num);
        int[] ints = strNum.chars().toArray();
        Integer[] integerArray = Arrays.stream(ints).boxed().toArray(Integer[]::new);
        List<Integer> list = Arrays.asList(integerArray);
        HashSet<Integer> set = new HashSet<>(list);
        return set.size() != strNum.length();
    }

    public boolean isEqual(int num) {
        String strNum = String.valueOf(num);
        char[] chars = strNum.toCharArray();
        HashSet<Character> set = new HashSet<>();
        int temp = 0;
        for (char c : chars) {
            set.add(c);
            if (set.size() == temp) {
                return true;
            }
            temp = set.size();
        }
        return false;
    }
}
