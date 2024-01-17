/**
 * @author Yskysoar
 * @createTime 2023-07-23 22:28
 * @description 42.接雨水(本题难点在于怎么确定区间的边界)
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例 1：
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * ■
 * ■   ■■ ■
 * ■ ■■ ■■■■■■
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 * 示例 2：
 * 输入：height = [4,2,0,3,2,5]
 * 输出：9
 */
public class Solution42 {
    public static void main(String[] args) {
        Solution42 solution42 = new Solution42();
        int ansWA = solution42.trapWA(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
        int ans1 = solution42.trap1(new int[]{4, 0, 3, 2, 0, 1, 2, 1});
        System.out.println(ansWA);
        System.out.println(ans1);
    }

    /**
     * 数学分析法(WA：没有考虑{4,2,3}这种情况)：组成一个水坑需要满足边界left<=right(注意边界可共用)
     * 当一个位置的右边界找不到时候，移动到下一个位置开始判断有边界
     * @param height 柱子高度
     * @return 雨水数量
     */
    public int trapWA(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] == 0) continue;//高度0作为左边界一定没有满足要求的右边界
            int left = i;
            int right = 0;
            for (int j = i + 1; j < height.length; j++) {
                if (height[j] >= height[left]) {
                    right = j;
                    break;
                }//只需要找到第一个大于等于左边界的就满足，再高也取决于左边界
            }
            if (!(right == 0 || right == left + 1)) {//找到满足条件的右边界
                int area = (right - left + 1) * height[left] - 2 * height[left];
                for (int j = i + 1; j < right; j++) {
                    area -= height[j];
                }
                ans += area;
                i = right - 1;
            }
        }
        return ans;
    }

    /**
     * 数学分析法：只要找到两个边界，内部的数都小于两边即可形成一个坑
     * @param height 柱子高度
     * @return 雨水数量
     */
    public int trap1(int[] height) {
        int ans = 0;
        for (int i = 0; i < height.length - 2; i++) {
            if (height[i] == 0) continue;//高度0作为边界一定没有满足要求的另一个边界
            int left = i;
            int tempMax = height[i + 1];//区间内最大值，只要比它大都可以满足，反之只要小于它就以当前位置作为右边界
            int right = 0;
            //此for循环为解题核心
            for (int j = i + 2; j < height.length; j++) {//将当前位置当作左边界，右边界只要大于区间最大值就一定大于区间内所有数
                if (height[j] > tempMax && tempMax < height[left]) {//当前值严格大于区间最大值且小于左边界，就替换为新的最大值(严格大于是防止出现“ω”的情况)
                    right = j;
                    tempMax = height[right];
                } else if (tempMax >= height[left]) break;//若出现将第一个最大值大于左边界时，当前位置视为右边界
            }//若循环结束，则当前最大值位置就是右边界，和else if同一个理解，为了减少循环提前跳出
            if (right != 0) {//存在符合条件的右边界，开始计算面积
                int area = (right - left + 1) * Math.min(height[left], height[right]) - 2 * Math.min(height[left], height[right]);
                for (int j = i + 1; j < right; j++) {
                    area -= height[j];
                }
                ans += area;
                i = right - 1;
            }
        }
        return ans;
    }
}
