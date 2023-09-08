import java.util.*;

/**
 * @author Yskysoar
 * @createTime 2023-04-25 18:18
 * @description 2418. 按身高排序
 *给你一个字符串数组 names ，和一个由 互不相同 的正整数组成的数组 heights 。两个数组的长度均为 n 。
 * 对于每个下标 i，names[i] 和 heights[i] 表示第 i 个人的名字和身高。
 * 请按身高 降序 顺序返回对应的名字数组 names 。
 * 示例 1：
 * 输入：names = ["Mary","John","Emma"], heights = [180,165,170]
 * 输出：["Mary","Emma","John"]
 * 解释：Mary 最高，接着是 Emma 和 John 。
 * 示例 2：
 * 输入：names = ["Alice","Bob","Bob"], heights = [155,185,150]
 * 输出：["Bob","Alice","Bob"]
 * 解释：第一个 Bob 最高，然后是 Alice 和第二个 Bob 。
 *
 */
public class Solution2418 {
    public static void main(String[] args) {
        Solution2418 solution2418 = new Solution2418();
        String[] ans = solution2418.sortPeople2(new String[]{"Mary","John","Emma"}, new int[]{180,165,170});
        System.out.println(Arrays.toString(ans));
    }

    /**
     * 暴力冒泡
     * @param names 名字集
     * @param heights 身高集
     * @return 按照身高降序的名字集
     */
    public String[] sortPeople1(String[] names, int[] heights) {
        for (int i = 1; i < heights.length; i++) {
            for (int j = 0; j < heights.length - i; j++) {
                if (heights[j] < heights[j + 1]) {
                    heights[j + 1] ^= heights[j];
                    heights[j] ^= heights[j + 1];
                    heights[j + 1] ^= heights[j];

                    String temp = names[j];
                    names[j] = names[j + 1];
                    names[j + 1] = temp;
                }
            }
        }
        return names;
    }

    /**
     * 哈希表定制排序
     * @param names 名字集
     * @param heights 身高集
     * @return 按照身高降序的名字集
     */
    public String[] sortPeople2(String[] names, int[] heights) {
        TreeMap<Integer, String> treeMap = new TreeMap<>((o1, o2) -> o1 < o2 ? 1 : -1);
        for (int i = 0; i < heights.length; i++) {
            treeMap.put(heights[i], names[i]);
            System.out.println(treeMap);
        }
        return treeMap.values().toArray(new String[names.length]);
    }
}
