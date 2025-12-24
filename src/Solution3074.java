import java.util.Arrays;

/**
 * @author Yskysoar
 * @createTime 2025-12-24 12:27
 * @description 3074. 重新分装苹果
 * 给你一个长度为 n 的数组 apple 和另一个长度为 m 的数组 capacity 。
 * 一共有 n 个包裹，其中第 i 个包裹中装着 apple[i] 个苹果。同时，还有 m 个箱子，第 i 个箱子的容量为 capacity[i] 个苹果。
 * 请你选择一些箱子来将这 n 个包裹中的苹果重新分装到箱子中，返回你需要选择的箱子的 最小 数量。
 * 注意，同一个包裹中的苹果可以分装到不同的箱子中。
 * 示例 1：
 * 输入：apple = [1,3,2], capacity = [4,3,1,5,2]
 * 输出：2
 * 解释：使用容量为 4 和 5 的箱子。
 * 总容量大于或等于苹果的总数，所以可以完成重新分装。
 * 示例 2：
 * 输入：apple = [5,5,5], capacity = [2,4,2,7]
 * 输出：4
 * 解释：需要使用所有箱子。
 * 提示：
 * 1 <= n == apple.length <= 50
 * 1 <= m == capacity.length <= 50
 * 1 <= apple[i], capacity[i] <= 50
 * 输入数据保证可以将包裹中的苹果重新分装到箱子中。
 */
public class Solution3074 {
    public static void main(String[] args) {
        Solution3074 solution3074 = new Solution3074();
        int ans = solution3074.minimumBoxes(new int[]{1, 3, 2}, new int[]{4, 3, 1, 5, 2});
        System.out.println(ans);
    }

    /**
     * 排序 + 暴力
     * @param apple    苹果数量
     * @param capacity 包裹容量
     * @return 需要使用的最少包裹数量
     */
    public int minimumBoxes(int[] apple, int[] capacity) {
        int ans = 0, sum = Arrays.stream(apple).sum();
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            ans++;
        }
        return ans;
    }
}
