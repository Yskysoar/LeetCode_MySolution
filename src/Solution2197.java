import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author Yskysoar
 * @createTime 2025-09-16 14:51
 * @description 2197. 替换数组中的非互质数
 * 给你一个整数数组 nums 。请你对数组执行下述操作：
 * 从 nums 中找出 任意 两个 相邻 的 非互质 数。
 * 如果不存在这样的数，终止 这一过程。
 * 否则，删除这两个数，并 替换 为它们的 最小公倍数（Least Common Multiple，LCM）。
 * 只要还能找出两个相邻的非互质数就继续 重复 这一过程。
 * 返回修改后得到的 最终 数组。可以证明的是，以 任意 顺序替换相邻的非互质数都可以得到相同的结果。
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 10^8 。
 * 两个数字 x 和 y 满足 非互质数 的条件是：GCD(x, y) > 1 ，其中 GCD(x, y) 是 x 和 y 的 最大公约数 。
 * 示例 1 ：
 * 输入：nums = [6,4,3,2,7,6,2]
 * 输出：[12,7,6]
 * 解释：
 * - (6, 4) 是一组非互质数，且 LCM(6, 4) = 12 。得到 nums = [12,3,2,7,6,2] 。
 * - (12, 3) 是一组非互质数，且 LCM(12, 3) = 12 。得到 nums = [12,2,7,6,2] 。
 * - (12, 2) 是一组非互质数，且 LCM(12, 2) = 12 。得到 nums = [12,7,6,2] 。
 * - (6, 2) 是一组非互质数，且 LCM(6, 2) = 6 。得到 nums = [12,7,6] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [12,7,6] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 * 示例 2 ：
 * 输入：nums = [2,2,1,1,3,3,3]
 * 输出：[2,1,1,3]
 * 解释：
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3,3] 。
 * - (3, 3) 是一组非互质数，且 LCM(3, 3) = 3 。得到 nums = [2,2,1,1,3] 。
 * - (2, 2) 是一组非互质数，且 LCM(2, 2) = 2 。得到 nums = [2,1,1,3] 。
 * 现在，nums 中不存在相邻的非互质数。
 * 因此，修改后得到的最终数组是 [2,1,1,3] 。
 * 注意，存在其他方法可以获得相同的最终数组。
 * 提示：
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^5
 * 生成的测试用例可以保证最终数组中的值 小于或者等于 10^8 。
 */
public class Solution2197 {
    public static void main(String[] args) {
        Solution2197 solution2197 = new Solution2197();
        List<Integer> ans = solution2197.replaceNonCoprimes(new int[]{31, 97561, 97561, 97561, 97561, 97561, 97561, 97561, 97561});
        System.out.println(ans);
    }

    /**
     * 模拟 + 栈
     * @param nums 待处理数组
     * @return 合并结果
     */
    public List<Integer> replaceNonCoprimes(int[] nums) {
        if (nums.length == 1) return new ArrayList<>(List.of(nums[0]));
        Stack<Integer> ans = new Stack<>();
        Stack<Integer> numbers = new Stack<>();
        for (int i = nums.length - 1; i >= 0; i--) numbers.push(nums[i]);//压入栈中
        int numA = numbers.pop(), numB = numbers.pop();
        //初始化
        if (gcd(numA, numB) != 1) {
            ans.push(lcm(numA, numB));
        } else {
            ans.push(numA);
            ans.push(numB);
        }
        //判断是否需要生成新的公约数
        while (numbers.size() > 0) {
            numB = numbers.pop();
            while (ans.size() > 0 && gcd(ans.peek(), numB) != 1) {//新组成的元素是否和ans栈顶组成新的非互质数
                numB = lcm(ans.pop(), numB);
            }
            ans.push(numB);
        }
        return ans;
    }


    // 计算最大公约数（GCD）
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    // 计算最小公倍数（LCM）
    public static int lcm(int a, int b) {
        // 使用公式：LCM(a, b) = (a * b) / GCD(a, b)
        return a / gcd(a, b) * b;
    }
}
