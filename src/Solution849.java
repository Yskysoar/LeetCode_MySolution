/**
 * @author Yskysoar
 * @createTime 2023-08-22 22:10
 * @description 849.到最近的人的最大距离
 * 给你一个数组 seats 表示一排座位，其中 seats[i] = 1 代表有人坐在第 i 个座位上，seats[i] = 0 代表座位 i 上是空的（下标从 0 开始）。
 * 至少有一个空座位，且至少有一人已经坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * 示例 1：
 * 输入：seats = [1,0,0,0,1,0,1]* 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * 输入：seats = [1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 示例 3：
 * 输入：seats = [0,1]
 * 输出：1
 */
public class Solution849 {
    public static void main(String[] args) {
        Solution849 solution849 = new Solution849();
        int ans = solution849.maxDistToClosest(new int[]{0, 1, 1, 1, 0, 0, 1, 0, 0});
        System.out.println(ans);
    }

    /**
     * 暴力遍历：要寻找最近的人的最大距离只能是坐在这两个人中间，将坐最两端和两个人中间的情况全部比对即可
     * @param seats 座位情况，"1"代表坐人，"0"代表不坐人
     * @return 到最近的人的最大距离
     */
    public int maxDistToClosest(int[] seats) {
        int first = 0;//第一个人的位置
        while (seats[first] == 0) {
            first++;
        }//获取第一个人的位置(至少坐人所以索引不会越界)
        int maxLength = 0;
        int left = first;//左边界
        for (int i = first + 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                maxLength = Math.max(maxLength, (i - left) / 2);
                left = i;//重置左边界
            }
        }
        //比较左右距离和中间距离，选择最大值
        return Math.max(Math.max(first, seats.length - 1 - left), maxLength);
    }
}
