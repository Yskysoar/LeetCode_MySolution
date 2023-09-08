/**
 * @author Yskysoar
 * @createTime 2023-09-04 22:02
 * @description 11.盛最多水的容器
 * 给定一个长度为 n 的整数数组 height 。
 * 有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 * 说明：你不能倾斜容器。
 * 示例 1：
 * 输入：[1,8,6,2,5,4,8,3,7]
 * 输出：49
 * 解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。
 * 在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 * 示例 2：
 * 输入：height = [1,1]
 * 输出：1
 */
public class Solution11 {
    public static void main(String[] args) {
        Solution11 solution11 = new Solution11();
        int ans = solution11.maxArea(new int[]{1,8,6,2,5,4,8,3,7});
        System.out.println(ans);
    }

    /**
     * 双指针：每次移动更矮的指针即可，每次都需要比较当前面积和之前的最大面积谁更大
     * @param height 垂线高度
     * @return 能容纳的水最大值
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int ans = (right - left) * Math.min(height[left], height[right]);//初始状态
        while (left < right) {
            if (height[left] <= height[right]) {
                left++;
            } else if (height[left] > height[right]) {
                right--;
            }
            ans = Math.max(ans, (right - left) * Math.min(height[left], height[right]));
        }
        return ans;
    }
}
