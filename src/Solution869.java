import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-08-10 0:14
 * @description 869. 重新排序得到 2 的幂
 * 给定正整数 n ，我们按任何顺序（包括原始顺序）将数字重新排序，注意其前导数字不能为零。
 * 如果我们可以通过上述方式得到 2 的幂，返回 true；否则，返回 false。
 * 示例 1：
 * 输入：n = 1
 * 输出：true
 * 示例 2：
 * 输入：n = 10
 * 输出：false
 * 提示：
 * 1 <= n <= 10^9
 */
public class Solution869 {
    public static void main(String[] args) {
        Solution869 solution869 = new Solution869();
        boolean ans = solution869.reorderedPowerOf2(23);
        System.out.println(ans);
    }

    public ArrayList<String> arrayList = calculate();

    public ArrayList<String> calculate() {
        ArrayList<String> arrayList = new ArrayList<>();
        long num = 1;
        while (num <= 1000000000) {
            char[] chars = String.valueOf(num).toCharArray();
            Arrays.sort(chars);
            arrayList.add(new String(chars));
            num *= 2;
        }//打表
        return arrayList;
    }

    /**
     * 重排字符 + 打表
     * 将数字先转换为字符数组并排序然后检查是否在表中即可
     * @param n 待重排数字
     * @return 重排后是否可以为2的幂
     */
    public boolean reorderedPowerOf2(int n) {
        char[] chars = String.valueOf(n).toCharArray();
        Arrays.sort(chars);
        return arrayList.contains(new String(chars));
    }
}
