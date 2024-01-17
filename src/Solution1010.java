import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2023-05-07 13:44
 * @description 1010. 总持续时间可被 60 整除的歌曲
 * 在歌曲列表中，第 i 首歌曲的持续时间为 time[i] 秒。
 * 返回其总持续时间（以秒为单位）可被 60 整除的歌曲对的数量。
 * 形式上，我们希望下标数字 i 和 j 满足  i < j 且有 (time[i] + time[j]) % 60 == 0。
 * 示例 1：
 * 输入：time = [30,20,150,100,40]
 * 输出：3
 * 解释：这三对的总持续时间可被 60 整除：
 * (time[0] = 30, time[2] = 150): 总持续时间 180
 * (time[1] = 20, time[3] = 100): 总持续时间 120
 * (time[1] = 20, time[4] = 40): 总持续时间 60
 * 示例 2：
 * 输入：time = [60,60,60]
 * 输出：3
 * 解释：所有三对的总持续时间都是 120，可以被 60 整除。
 */
public class Solution1010 {
    public static void main(String[] args) {
        Solution1010 solution1010 = new Solution1010();
        int ans = solution1010.numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40});
        System.out.println(ans);
    }

    /**
     * 哈希表：将数据存入然后去遍历寻找符合要求的时间(可优化)
     * @param time 歌曲时间集合
     * @return 总持续时间（以秒为单位）可被 60 整除的歌曲对的数量
     */
    public int numPairsDivisibleBy60(int[] time) {
        int ans = 0;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < time.length; i++) {
            for (Integer j : hashMap.keySet()) {
                if ((time[i] + j) % 60 == 0) {
                    ans += hashMap.get(j);
                }
            }
            hashMap.put(time[i], hashMap.getOrDefault(time[i], 0) + 1);
        }
        System.out.println(hashMap);
        return ans;
    }
}
