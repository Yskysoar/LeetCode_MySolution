import java.util.Arrays;
import java.util.HashSet;

/**
 * @author Yskysoar
 * @createTime 2023-03-30 15:58
 * @description 1637. 两点之间不包含任何点的最宽垂直区域给你 n 个二维平面上的点 points ，其中 points[i] = [xi, yi] ，请你返回两点之间内部不包含任何点的 最宽垂直区域 的宽度。
 * 垂直区域 的定义是固定宽度，而 y 轴上无限延伸的一块区域（也就是高度为无穷大）。 最宽垂直区域 为宽度最大的一个垂直区域。
 * 请注意，垂直区域 边上 的点 不在 区域内。
 * 示例 1：
 * 输入：points = [[8,7],[9,9],[7,4],[9,7]]
 * 输出：1
 * 解释：红色区域和蓝色区域都是最优区域。
 * 示例 2：
 * 输入：points = [[3,1],[9,0],[1,0],[1,4],[5,3],[8,8]]
 * 输出：3
 */
public class Solution1637 {
    public static void main(String[] args) {
        Solution1637 solution1637 = new Solution1637();
        int ans = solution1637.maxWidthOfVerticalArea1(new int[][]{{1, 5}, {1, 70}, {3, 1000}, {55, 700}, {999876789, 53}, {987853567, 12}});
        System.out.println(ans);
    }

    /**
     * 去重后取最大值，直接比较x即可
     * @param points 坐标图
     * @return 最宽垂直区域
     */
    public int maxWidthOfVerticalArea1(int[][] points) {
        HashSet<Integer> set = new HashSet<>();
        for (int[] point : points) {
            set.add(point[0]);
        }
        if (set.size() == 1) return 0;
        int[] num = new int[set.size()];
        int i = 0;
        for (Integer integer : set) {
            num[i++] = integer;
        }
        Arrays.sort(num);
        int ans = num[1] - num[0];
        for (int j = 0; j < num.length - 1; j++) {
            ans = Math.max(ans, num[j + 1] - num[j]);
        }
        return ans;
    }

    /**
     * 直接取最大值，直接比较x即可
     * @param points 坐标图
     * @return 最宽垂直区域
     */
    public int maxWidthOfVerticalArea2(int[][] points) {
        int[] num = new int[points.length];
        for (int i = 0; i < points.length; i++) {
            num[i] = points[i][0];
        }
        Arrays.sort(num);
        int ans = 0;
        for (int i = 0; i < num.length - 1; i++) {
            if (num[i] != num[i + 1]) {
                ans = Math.max(ans, num[i + 1] - num[i]);
            }
        }
        return ans;
    }
}
