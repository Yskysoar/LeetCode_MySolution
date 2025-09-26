/**
 * @author Yskysoar
 * @createTime 2025-09-27 0:08
 * @description 812. 最大三角形面积
 * 给你一个由 X-Y 平面上的点组成的数组 points ，其中 points[i] = [xi, yi] 。从其中取任意三个不同的点组成三角形，返回能组成的最大三角形的面积。
 * 与真实值误差在 10-5 内的答案将会视为正确答案。
 * 示例 1：
 * 输入：points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
 * 输出：2.00000
 * 解释：输入中的 5 个点如上图所示，红色的三角形面积最大。
 * 示例 2：
 * 输入：points = [[1,0],[0,0],[0,1]]
 * 输出：0.50000
 * 提示：
 * 3 <= points.length <= 50
 * -50 <= xi, yi <= 50
 * 给出的所有点 互不相同
 */
public class Solution812 {
    public static void main(String[] args) {
        Solution812 solution812 = new Solution812();
        double ans = solution812.largestTriangleArea(new int[][]{{1, 0}, {0, 0}, {0, 1}});
        System.out.println(ans);
    }

    /**
     * 数学公式
     * (|a|^2 * |b|^2 - (a·b)^2)^2 / 2
     * @param points 点集
     * @return 最大的三角形面积
     */
    public double largestTriangleArea(int[][] points) {
        double ans = 0;
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {
                    int x1 = points[j][0] - points[i][0];
                    int y1 = points[j][1] - points[i][1];
                    int x2 = points[k][0] - points[i][0];
                    int y2 = points[k][1] - points[i][1];
                    ans = Math.max(ans, Math.pow((x1 * x1 + y1 * y1) * (x2 * x2 + y2 * y2) - (x1 * x2 + y1 * y2) * (x1 * x2 + y1 * y2), 0.5));
                }
            }
        }
        return ans / 2;
    }
}
