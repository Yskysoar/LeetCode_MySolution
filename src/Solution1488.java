import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeSet;

/**
 * @author Yskysoar
 * @createTime 2023-10-13 22:01
 * @description 1488.避免洪水泛滥
 * 你的国家有无数个湖泊，所有湖泊一开始都是空的。当第 n 个湖泊下雨前是空的，那么它就会装满水。
 * 如果第 n 个湖泊下雨前是 满的 ，这个湖泊会发生 洪水 。你的目标是避免任意一个湖泊发生洪水。
 * 给你一个整数数组 rains ，其中：
 * rains[i] > 0 表示第 i 天时，第 rains[i] 个湖泊会下雨。
 * rains[i] == 0 表示第 i 天没有湖泊会下雨，你可以选择 一个 湖泊并 抽干 这个湖泊的水。
 * 请返回一个数组 ans ，满足：
 * ans.length == rains.length
 * 如果 rains[i] > 0 ，那么ans[i] == -1 。
 * 如果 rains[i] == 0 ，ans[i] 是你第 i 天选择抽干的湖泊。
 * 如果有多种可行解，请返回它们中的 任意一个 。如果没办法阻止洪水，请返回一个 空的数组 。
 * 请注意，如果你选择抽干一个装满水的湖泊，它会变成一个空的湖泊。但如果你选择抽干一个空的湖泊，那么将无事发生。
 * 示例 1：
 * 输入：rains = [1,2,3,4]
 * 输出：[-1,-1,-1,-1]
 * 解释：第一天后，装满水的湖泊包括 [1]
 * 第二天后，装满水的湖泊包括 [1,2]
 * 第三天后，装满水的湖泊包括 [1,2,3]
 * 第四天后，装满水的湖泊包括 [1,2,3,4]
 * 没有哪一天你可以抽干任何湖泊的水，也没有湖泊会发生洪水。
 * 示例 2：
 * 输入：rains = [1,2,0,0,2,1]
 * 输出：[-1,-1,2,1,-1,-1]
 * 解释：第一天后，装满水的湖泊包括 [1]
 * 第二天后，装满水的湖泊包括 [1,2]
 * 第三天后，我们抽干湖泊 2 。所以剩下装满水的湖泊包括 [1]
 * 第四天后，我们抽干湖泊 1 。所以暂时没有装满水的湖泊了。
 * 第五天后，装满水的湖泊包括 [2]。
 * 第六天后，装满水的湖泊包括 [1,2]。
 * 可以看出，这个方案下不会有洪水发生。同时， [-1,-1,1,2,-1,-1] 也是另一个可行的没有洪水的方案。
 * 示例 3：
 * 输入：rains = [1,2,0,1,2]
 * 输出：[]
 * 解释：第二天后，装满水的湖泊包括 [1,2]。我们可以在第三天抽干一个湖泊的水。
 * 但第三天后，湖泊 1 和 2 都会再次下雨，所以不管我们第三天抽干哪个湖泊的水，另一个湖泊都会发生洪水。
 */
public class Solution1488 {
    public static void main(String[] args) {
        Solution1488 solution1488 = new Solution1488();
        int[] ans = solution1488.avoidFlood(new int[]{1, 0, 2, 0, 3, 0, 2, 0, 0, 0, 1, 2, 3});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 回溯：先将湖泊的情况和晴天的日期存储起来，当遇到发洪水的时候，在上一次下雨和这次下雨之间
     * 找一个最接近上次下雨的晴天，将它用于抽当前湖泊的水，然后将这个晴天移除并更新湖泊的情况
     * @param rains 下雨的湖泊
     * @return 抽水的选择集
     */
    public int[] avoidFlood(int[] rains) {
        int[] ans = new int[rains.length];
        Arrays.fill(ans, -1);//将所有元素初始化为-1
        HashMap<Integer, Integer> lakes = new HashMap<>();//存放湖泊情况(湖泊,日期)
        TreeSet<Integer> sun = new TreeSet<>();//记录晴天的日期
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {//晴天
                sun.add(i);
                ans[i] = 1;
            } else if (lakes.containsKey(rains[i])) {//rains[i]发洪水
                int lastRain = lakes.get(rains[i]);//上一次下雨的日期
                Integer resetDay = sun.higher(lastRain);
                if (resetDay == null) return new int[0];//找不到晴天，无法阻止洪水
                ans[resetDay] = rains[i];//将对应晴天设置为抽rains[i]湖泊的水
                sun.remove(resetDay);//从未操作晴天中去除
                lakes.put(rains[i], i);//更新湖泊情况
            } else {
                lakes.put(rains[i], i);//填满rains[i]
            }
        }
        return ans;
    }
}
