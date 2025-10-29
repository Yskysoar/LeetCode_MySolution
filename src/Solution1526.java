/**
 * @author Yskysoar
 * @createTime 2025-10-30 0:17
 * @description 1526. 形成目标数组的子数组最少增加次数
 * 给你一个整数数组 target 和一个数组 initial ，initial 数组与 target  数组有同样的维度，且一开始全部为 0 。
 * 请你返回从 initial 得到  target 的最少操作次数，每次操作需遵循以下规则：
 * 在 initial 中选择 任意 子数组，并将子数组中每个元素增加 1 。
 * 答案保证在 32 位有符号整数以内。
 * 示例 1：
 * 输入：target = [1,2,3,2,1]
 * 输出：3
 * 解释：我们需要至少 3 次操作从 intial 数组得到 target 数组。
 * [0,0,0,0,0] 将下标为 0 到 4 的元素（包含二者）加 1 。
 * [1,1,1,1,1] 将下标为 1 到 3 的元素（包含二者）加 1 。
 * [1,2,2,2,1] 将下表为 2 的元素增加 1 。
 * [1,2,3,2,1] 得到了目标数组。
 * 示例 2：
 * 输入：target = [3,1,1,2]
 * 输出：4
 * 解释：(initial)[0,0,0,0] -> [1,1,1,1] -> [1,1,1,2] -> [2,1,1,2] -> [3,1,1,2] (target) 。
 * 示例 3：
 * 输入：target = [3,1,5,4,2]
 * 输出：7
 * 解释：(initial)[0,0,0,0,0] -> [1,1,1,1,1] -> [2,1,1,1,1] -> [3,1,1,1,1]
 * -> [3,1,2,2,2] -> [3,1,3,3,2] -> [3,1,4,4,2] -> [3,1,5,4,2] (target)。
 * 示例 4：
 * 输入：target = [1,1,1,1]
 * 输出：1
 * 提示：
 * 1 <= target.length <= 10^5
 * 1 <= target[i] <= 10^5
 */
public class Solution1526 {
    public static void main(String[] args) {
        Solution1526 solution1526 = new Solution1526();
        int ans = solution1526.minNumberOperations1(new int[]{3, 4, 2, 5, 6});
        System.out.println(ans);
    }

    /**
     * 由于操作的子数组任选，所以当前元素比前一个元素大就代表着前一个元素消到0时，当前元素仍然需要target[i]-target[i - 1]次操作
     * 只需要记录首元素的值（对应的操作数），然后计算各个元素的前后正差值即可
     * @param target 数据数组
     * @return 最小的操作数
     */
    public int minNumberOperations1(int[] target) {
        int ans = target[0];
        for (int i = 1; i < target.length; i++) {
            if (target[i] > target[i - 1]) {
                ans += target[i] - target[i - 1];
            }
        }
        return ans;
    }


    //WA：超时
    public int minNumberOperations2(int[] target) {
        return minNumber(target, 0, target.length);
    }

    public int minNumber(int[] target, int left, int right) {
        if (right - left == 1) return target[left];
        int ans = 0, index = -1;//记录操作后为0的元素所索引
        int min = Integer.MAX_VALUE;
        for (int i = left; i < right; i++) {
            min = Math.min(min, target[i]);
        }
        ans += min;//加上对应的操作次数
        for (int i = left; i < right; i++) {
            target[i] -= min;
            if (target[i] == 0) {
                if (index != -1) {
                    if (i > index + 1) {
                        ans += minNumber(target, index + 1, i);
                    }
                } else if (i > left) {
                    ans += minNumber(target, left, i);
                }
                index = i;
            }
        }
        if (index + 1 < right) {
            ans += minNumber(target, index + 1, right);
        }
        return ans;
    }
}
