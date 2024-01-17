import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * @author Yskysoar
 * @createTime 2023-07-24 23:22
 * @description 771.宝石与石头
 * 给你一个字符串 jewels 代表石头中宝石的类型，另有一个字符串 stones 代表你拥有的石头。
 * stones 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * 字母区分大小写，因此 "a" 和 "A" 是不同类型的石头。
 * 示例 1：
 * 输入：jewels = "aA", stones = "aAAbbbb"
 * 输出：3
 * 示例 2：
 * 输入：jewels = "z", stones = "ZZ"
 * 输出：0
 */
public class Solution771 {
    public static void main(String[] args) {
        Solution771 solution771 = new Solution771();
        int ans1 = solution771.numJewelsInStones1("aA", "aAAbbbb");
        int ans2 = solution771.numJewelsInStones1("aA", "aAAbbbb");
        System.out.println(ans1);
        System.out.println(ans2);

    }

    /**
     * 哈希表：记录所有的宝石种类然后遍历石头即可
     * @param jewels 宝石种类(字符唯一)
     * @param stones 石头种类
     * @return 宝石数量
     */
    public int numJewelsInStones1(String jewels, String stones) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < jewels.length(); i++) {
            if (!hashMap.containsKey(jewels.charAt(i))) {//题目说了不会重复，为了规范还是用了判断
                hashMap.put(jewels.charAt(i), 0);
            }
//            hashMap.putIfAbsent(jewels.charAt(i), 0);//简化API
        }
        for (int i = 0; i < stones.length(); i++) {
            if (hashMap.containsKey(stones.charAt(i))) {
                hashMap.put(stones.charAt(i), hashMap.get(stones.charAt(i)) + 1);
            }
        }
        return (int) hashMap.values().stream().collect(Collectors.summarizingInt(Integer::intValue)).getSum();
    }

    /**
     * 替换法：将宝石的字符在石头中全部替换为空字符，原长度减去替换后长度即可
     * @param jewels 宝石种类(字符唯一)
     * @param stones 石头种类
     * @return 宝石数量
     */
    public int numJewelsInStones2(String jewels, String stones) {
        int length = stones.length();
        for (int i = 0; i < jewels.length(); i++) {
            stones = stones.replace(jewels.charAt(i) + "", "");
        }
        return length - stones.length();
    }

    /**
     * 对比法：直接检查石头是不是宝石即可(字符串查找)
     * @param jewels 宝石种类(字符唯一)
     * @param stones 石头种类
     * @return 宝石数量
     */
    public int numJewelsInStones3(String jewels, String stones) {
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.contains(stones.charAt(i) + "")) ans++;
        }
        return ans;
    }

    /**
     * 对比法：直接检查石头是不是宝石即可(索引查找)
     * @param jewels 宝石种类(字符唯一)
     * @param stones 石头种类
     * @return 宝石数量
     */
    public int numJewelsInStones4(String jewels, String stones) {
        int ans = 0;
        for (int i = 0; i < stones.length(); i++) {
            if (jewels.indexOf(stones.charAt(i)) >= 0) ans++;
        }
        return ans;
    }
}
