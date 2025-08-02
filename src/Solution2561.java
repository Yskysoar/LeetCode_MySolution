import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Yskysoar
 * @createTime 2025-08-02 1:10
 * @description 2561. 重排水果
 * 你有两个果篮，每个果篮中有 n 个水果。给你两个下标从 0 开始的整数数组 basket1 和 basket2 ，用以表示两个果篮中每个水果的交换成本。你想要让两个果篮相等。为此，可以根据需要多次执行下述操作：
 * 选中两个下标 i 和 j ，并交换 basket1 中的第 i 个水果和 basket2 中的第 j 个水果。
 * 交换的成本是 min(basket1i,basket2j) 。
 * 根据果篮中水果的成本进行排序，如果排序后结果完全相同，则认为两个果篮相等。
 * 返回使两个果篮相等的最小交换成本，如果无法使两个果篮相等，则返回 -1 。
 * 示例 1：
 * 输入：basket1 = [4,2,2,2], basket2 = [1,4,1,2]
 * 输出：1
 * 解释：交换 basket1 中下标为 1 的水果和 basket2 中下标为 0 的水果，交换的成本为 1 。此时，basket1 = [4,1,2,2] 且 basket2 = [2,4,1,2] 。重排两个数组，发现二者相等。
 * 示例 2：
 * 输入：basket1 = [2,3,4,1], basket2 = [3,2,5,1]
 * 输出：-1
 * 解释：可以证明无法使两个果篮相等。
 * 提示：
 * basket1.length == basket2.length
 * 1 <= basket1.length <= 10^5
 * 1 <= basket1i,basket2i <= 10^9
 */
public class Solution2561 {
    public static void main(String[] args) {
        Solution2561 solution2561 = new Solution2561();
        long ans = solution2561.minCost(new int[]{4, 4, 4, 4, 3}, new int[]{5, 5, 5, 5, 3});
        System.out.println(ans);
    }

    /**
     * 贪心：最小成本即[整体最小值中转]和[直接交换]的较小成本
     * 先去掉公共部分得出需要需要处理的元素，然后记录各自需要换出的元素（A换出代表B换入）
     * 将两组互逆排序，一一贪心计算成本即可
     * @param basket1 数据数组1
     * @param basket2 数据数组2
     * @return 最小交换成本
     */
    public long minCost(int[] basket1, int[] basket2) {
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();
        HashMap<Integer, Integer> hashMapAll = new HashMap<>();
        for (int i = 0; i < basket1.length; i++) {//记录所有元素并记录各自最小值
            hashMap1.put(basket1[i], hashMap1.getOrDefault(basket1[i], 0) + 1);
            hashMap2.put(basket2[i], hashMap2.getOrDefault(basket2[i], 0) + 1);
            hashMapAll.put(basket1[i], hashMapAll.getOrDefault(basket1[i], 0) + 1);
            hashMapAll.put(basket2[i], hashMapAll.getOrDefault(basket2[i], 0) + 1);
            min1 = Math.min(min1, basket1[i]);
            min2 = Math.min(min2, basket2[i]);
        }
        int minKey = Math.min(min1, min2);//整体最小值中介
        //去掉重复元素（不影响两个集合的长度，始终保持相等）
        for (Integer key : hashMap1.keySet()) {
            if (hashMap2.containsKey(key)) {
                int delNum = Math.min(hashMap1.get(key), hashMap2.get(key));//需要减去公有元素的较小量
                hashMap1.put(key, hashMap1.get(key) - delNum);
                hashMap2.put(key, hashMap2.get(key) - delNum);
                hashMapAll.put(key, hashMapAll.get(key) - delNum * 2);//总体需要减去两倍
            }
        }
        //去掉所有的value为0的元素，方便后续操作
        hashMap1.entrySet().removeIf(entry -> entry.getValue() == 0);
        hashMap2.entrySet().removeIf(entry -> entry.getValue() == 0);
        hashMapAll.entrySet().removeIf(entry -> entry.getValue() == 0);
        //如果去重后长度为0，说明不需要重排
        if (hashMap1.size() == 0) return 0;
        //hashMapAll所有元素value减半就是两边需要平衡的结果
        for (Integer key : hashMapAll.keySet()) {
            if (hashMapAll.get(key) % 2 != 0) return -1;//剩余元素有奇数必定不可能有解
            hashMapAll.put(key, hashMapAll.get(key) / 2);
        }
        //记录需要换出的元素
        ArrayList<Integer> arrayList1 = new ArrayList<>();//需要换出的元素
        ArrayList<Integer> arrayList2 = new ArrayList<>();//需要换出的元素
        for (Integer key : hashMap1.keySet()) {
            for (int i = 0; i < (hashMap1.get(key) - hashMapAll.get(key)); i++) {//只有元素过多需要换出的时候才会进入循环
                arrayList1.add(key);
            }
        }
        for (Integer key : hashMap2.keySet()) {
            for (int i = 0; i < (hashMap2.get(key) - hashMapAll.get(key)); i++) {//只有元素过多需要换出的时候才会进入循环
                arrayList2.add(key);
            }
        }
        //一个升序一个降序，贪心选取较小成本
        long ans = 0;
        Collections.sort(arrayList1);
        arrayList2.sort(Collections.reverseOrder());
        for (int i = 0; i < arrayList1.size(); i++) {
            ans += Math.min(minKey * 2, Math.min(arrayList1.get(i), arrayList2.get(i)));//[整体最小值中转]和[直接交换]的较小成本
        }
        return ans;
    }
}
