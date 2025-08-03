import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2025-08-04 0:48
 * @description 904. 水果成篮
 * 你正在探访一家农场，农场从左到右种植了一排果树。这些树用一个整数数组 fruits 表示，其中 fruits[i] 是第 i 棵树上的水果 种类 。
 * 你想要尽可能多地收集水果。然而，农场的主人设定了一些严格的规矩，你必须按照要求采摘水果：
 * 你只有 两个 篮子，并且每个篮子只能装 单一类型 的水果。每个篮子能够装的水果总量没有限制。
 * 你可以选择任意一棵树开始采摘，你必须从 每棵 树（包括开始采摘的树）上 恰好摘一个水果 。采摘的水果应当符合篮子中的水果类型。每采摘一次，你将会向右移动到下一棵树，并继续采摘。
 * 一旦你走到某棵树前，但水果不符合篮子的水果类型，那么就必须停止采摘。
 * 给你一个整数数组 fruits ，返回你可以收集的水果的 最大 数目。
 * 示例 1：
 * 输入：fruits = [1,2,1]
 * 输出：3
 * 解释：可以采摘全部 3 棵树。
 * 示例 2：
 * 输入：fruits = [0,1,2,2]
 * 输出：3
 * 解释：可以采摘 [1,2,2] 这三棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [0,1] 这两棵树。
 * 示例 3：
 * 输入：fruits = [1,2,3,2,2]
 * 输出：4
 * 解释：可以采摘 [2,3,2,2] 这四棵树。
 * 如果从第一棵树开始采摘，则只能采摘 [1,2] 这两棵树。
 * 示例 4：
 * 输入：fruits = [3,3,3,1,2,1,1,2,3,3,4]
 * 输出：5
 * 解释：可以采摘 [1,2,1,1,2] 这五棵树。
 * 提示：
 * 1 <= fruits.length <= 10^5
 * 0 <= fruits[i] < fruits.length
 */
public class Solution904 {
    public static void main(String[] args) {
        Solution904 solution904 = new Solution904();
        int ans = solution904.totalFruit(new int[]{0, 1, 2, 2});
        System.out.println(ans);
    }

    /**
     * 滑动窗口 + 回溯
     * 题目可以抽象为寻找一个连续的区间，其中只包含两种元素，返回合法区间的最大长度
     * @param fruits 水果种类数组
     * @return 最大的可收集水果数量
     */
    public int totalFruit(int[] fruits) {
        int ans = Integer.MIN_VALUE;
        int left = 0, right = 0;//左右边界
        int index = 0;//用于回溯，标记上一种元素的连续且最远位置
        HashSet<Integer> hashSet = new HashSet<>();
        while (right < fruits.length) {
            if (hashSet.size() < 2) {//记录开头的元素，重复元素也不影响
                index = right;//标记一定会记录最新的元素
                hashSet.add(fruits[right++]);
                continue;
            }
            //此时set元素等于2，需要判断当前元素是否合法
            if (!hashSet.contains(fruits[right])) {//当前元素不在set中
                ans = Math.max(ans, right - left);
                left = index;
                hashSet.clear();//重置set并重新记录元素
                hashSet.add(fruits[left]);
                hashSet.add(fruits[right]);//此处不更新right是统一更新标记的操作，会重新校验此位置
            } else {//当前元素在set中，检查标记是否需要更新(与标记位置的元素不相等就更新标记)
                if (fruits[right] != fruits[index]) index = right;
                right++;
            }
        }
        return Math.max(ans, right - left);//到边界了需要补一次判断
    }
}
