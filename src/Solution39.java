import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2023-08-10 22:49
 * @description 39.组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target
 * 找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回
 * 你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取
 * 如果至少一个数字的被选数量不同，则两种组合是不同的。
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 * 示例 1：
 * 输入：candidates = [2,3,6,7], target = 7
 * 输出：[[2,2,3],[7]]
 * 解释：
 * 2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
 * 7 也是一个候选， 7 = 7 。
 * 仅有这两种组合。
 * 示例 2：
 * 输入: candidates = [2,3,5], target = 8
 * 输出: [[2,2,2,2],[2,3,3],[3,5]]
 * 示例 3：
 * 输入: candidates = [2], target = 1
 * 输出: []
 */
public class Solution39 {
    public static void main(String[] args) {
        Solution39 solution39 = new Solution39();
        List<List<Integer>> ans = solution39.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(ans);
    }

    /**
     * 深度优先搜索(回溯法)：类似全排列(n级遍历，如何挑选符合的部分)
     * @param candidates 无重复数据的整数数组(数据大小在2~40)
     * @param target 目标值
     * @return 返回一个内部和等于目标值的组的集合
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        dfs(ans, stack, candidates, target);
        Set<List<Integer>> set = new HashSet<>(ans);
        List<List<Integer>> finalAns = new ArrayList<>(set);
        return finalAns;
    }

    /**
     * 深度优先搜索
     * @param ans 结果集合
     * @param stack 临时存放栈
     * @param nums 数据集合
     * @param target 目标值
     */
    public void dfs(List<List<Integer>> ans, Stack<Integer> stack,  int[] nums, int target) {
        for (int num : nums) {
            int sum = stack.stream().mapToInt(Integer::intValue).sum();//获取当前栈中数据的和
            if (sum == target) {
                ArrayList<Integer> isEqualList = new ArrayList<>(stack);
                Collections.sort(isEqualList);//排序方便去重
                ans.add(isEqualList);
                return;
            } else if (sum < target) {
                stack.push(num);//入栈
                dfs(ans, stack, nums, target);
                stack.pop();
            } else {
                return;
            }
        }
    }
}
