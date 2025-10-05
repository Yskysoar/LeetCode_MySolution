import java.util.ArrayList;
import java.util.List;

/**
 * @author Yskysoar
 * @createTime 2025-10-05 21:41
 * @description 417. 太平洋大西洋水流问题
 * 有一个 m × n 的矩形岛屿，与 太平洋 和 大西洋 相邻。 “太平洋” 处于大陆的左边界和上边界，而 “大西洋” 处于大陆的右边界和下边界。
 * 这个岛被分割成一个由若干方形单元格组成的网格。给定一个 m x n 的整数矩阵 heights ， heights[r][c] 表示坐标 (r, c) 上单元格 高于海平面的高度 。
 * 岛上雨水较多，如果相邻单元格的高度 小于或等于 当前单元格的高度，雨水可以直接向北、南、东、西流向相邻单元格。水可以从海洋附近的任何单元格流入海洋。
 * 返回网格坐标 result 的 2D 列表 ，其中 result[i] = [ri, ci] 表示雨水从单元格 (ri, ci) 流动 既可流向太平洋也可流向大西洋 。
 * 示例 1：
 * 输入: heights = [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
 * 输出: [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
 * 示例 2：
 * 输入: heights = [[2,1],[1,2]]
 * 输出: [[0,0],[0,1],[1,0],[1,1]]
 * 提示：
 * m == heights.length
 * n == heights[r].length
 * 1 <= m, n <= 200
 * 0 <= heights[r][c] <= 10^5
 */
public class Solution417WA {
    public static void main(String[] args) {
        Solution417WA solution417WA = new Solution417WA();
        List<List<Integer>> ans = solution417WA.pacificAtlantic(new int[][]{{1, 2, 3}, {8, 9, 4}, {7, 6, 5}});
        System.out.println(ans);
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean isExit = false;
        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[i].length; j++) {
                isExit = false;
                //左 上
                int left = j - 1;
                while (left >= 0 && heights[i][left] <= heights[i][j]) {
                    if (heights[i][left] < heights[i][j]) {
                        isExit = true;
                    } else if (isExit) break;
                    left--;
                }
                isExit = false;
                int top = i - 1;
                while (top >= 0 && heights[top][j] <= heights[i][j]) {
                    if (heights[top][j] < heights[i][j]) {
                        isExit = true;
                    } else if (isExit) break;
                    top--;
                }
                if (left >= 0 && top >= 0) continue;
                //右 下
                isExit = false;
                int right = j + 1;
                while (right < heights[i].length && heights[i][right] <= heights[i][j]) {
                    if (heights[i][right] < heights[i][j]) {
                        isExit = true;
                    } else if (isExit) break;
                    right++;
                }
                isExit = false;
                int bottom = i + 1;
                while (bottom < heights.length && heights[bottom][j] <= heights[i][j]) {
                    if (heights[bottom][j] < heights[i][j]) {
                        isExit = true;
                    } else if (isExit) break;
                    bottom++;
                }
                if (right < heights[i].length && bottom < heights.length) continue;
                ans.add(new ArrayList<>(List.of(i, j)));
            }
        }
        return ans;
    }
}
